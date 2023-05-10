/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package knihajizd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author hsodo
 */
public class carHistory {

    public static Scanner sc = new Scanner(System.in);

    public static void chooseCar() {
        System.out.println("Vyberte značku vozu:");
        ArrayList<String> brands = new ArrayList<>();
        ArrayList<String> models = new ArrayList<>();
        ArrayList<String> SPZs = new ArrayList<>();
        int option;
        try ( BufferedReader reader1 = new BufferedReader(new FileReader("cars.txt"))) {
            String line;
            while ((line = reader1.readLine()) != null) {
                String[] pole = line.split(";");
                brands.add(pole[0]);
            }
        } catch (IOException e) {
            System.out.println("Soubor s auty nenalezen");
        }

        ArrayList<String> uniqBrands = brands.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
        for (int i = 0; i < uniqBrands.size(); i++) {
            System.out.println(i + 1 + " - " + uniqBrands.get(i));
        }
        option = sc.nextInt();
        String chosenBrand = uniqBrands.get(option - 1);

        System.out.println("Vyberte model vozu:");
        try ( BufferedReader reader2 = new BufferedReader(new FileReader("cars.txt"))) {
            String line;
            while ((line = reader2.readLine()) != null) {
                String[] pole = line.split(";");
                if (pole[0].equals(chosenBrand)) {
                    models.add(pole[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Soubor s auty nenalezen");
        }

        ArrayList<String> uniqModels = models.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
        for (int i = 0; i < uniqModels.size(); i++) {
            System.out.println(i + 1 + " - " + uniqModels.get(i));
        }
        option = sc.nextInt();
        String chosenModel = uniqModels.get(option - 1);

        System.out.println("Vyberte SPZ vozu:");
        try ( BufferedReader reader3 = new BufferedReader(new FileReader("cars.txt"))) {
            String line;
            while ((line = reader3.readLine()) != null) {
                String[] pole = line.split(";");
                if (pole[0].equals(chosenBrand) && pole[1].equals(chosenModel)) {
                    SPZs.add(pole[2]);
                }
            }
        } catch (IOException e) {
            System.out.println("Soubor s auty nenalezen");
        }

        for (int i = 0; i < SPZs.size(); i++) {
            System.out.println(i + 1 + " - " + SPZs.get(i));
        }
        option = sc.nextInt();
        String chosenSPZ = SPZs.get(option - 1);

        System.out.println("Vybrané vozidlo: " + chosenBrand + " " + chosenModel + " s poznávací značkou: " + chosenSPZ);

        writeOutHistory(chosenSPZ);
    }

    public static String writeOutHistory(String SPZ) {
        String history = "";
        ArrayList<Journey> journeys = new ArrayList<>();
        try ( BufferedReader reader = new BufferedReader(new FileReader(SPZ + ".txt", StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String pole[] = line.split(";");
                int[] date = new int[3];
                date[0] = Integer.parseInt(pole[0]);
                date[1] = Integer.parseInt(pole[1]);
                date[2] = Integer.parseInt(pole[2]);
                Journey journey = new Journey(date, pole[3], Integer.parseInt(pole[4]), Integer.parseInt(pole[5]), Integer.parseInt(pole[6]), Integer.parseInt(pole[7]), pole[8]);
                journeys.add(journey);
            }
            Collections.sort(journeys, Comparator.comparingInt(Journey::getStartingMileage));
            for (Journey journey : journeys) {
                history = history + journey.getDate0() + "." + journey.getDate1() + "." + journey.getDate2() + ". řidič: "+journey.getDriver() + " nájezd: "+ journey.getStartingMileage()+ "km až " + journey.getFinalMileage() + "km";
                if (journey.getRefuelingPrice()!=0) {
                    history = history + ", tankováno za " + journey.getRefuelingPrice() + "Kč při nájezdu " + journey.getRefuelingRange() + "km";
                } else {
                    history = history + ", bez tankování";
                }
                if (journey.getNote().equals("X")) {
                    history = history + "\n";
                } else {
                    history = history + ", poznámka: " + journey.getNote() + "\n";
                }
            }
        } catch (IOException e) {
            System.out.println("Při čtení souboru došlo k chybě.");
        }

        System.out.println(history);
        return history;
    }
}
