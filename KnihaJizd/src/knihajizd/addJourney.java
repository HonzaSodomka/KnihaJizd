/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package knihajizd;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hsodo
 */
public class addJourney {
    public static Scanner sc = new Scanner(System.in);

    public static void addJourney() {
        
        String SPZ;
        String nazevSouboru;
        File soubor;
        System.out.println("Zadejte SPZ vozu:");
        while (true) {
            
            String spz = sc.nextLine();
            SPZ = spz.replace(" ", "");
            nazevSouboru = SPZ + ".txt";
            soubor = new File(nazevSouboru);

            if (soubor.exists()) {
                
                break;
            }
                else {System.out.println("SPZ není v systému nebo je chybně zapsána");}
            
        }

            System.out.println("Zadejte datum jízdy ve formátu DD.MM.YYYY:");
            String datum = sc.nextLine();
            String[] dates = datum.split("\\.");
            int[] date = new int[3];
            date[0] = Integer.parseInt(dates[0]);
            date[1] = Integer.parseInt(dates[1]);
            date[2] = Integer.parseInt(dates[2]);
            System.out.println("Zadejte jméno řidiče:");
            String driver = sc.nextLine();
            System.out.println("Zadejte počáteční nájezd:");
            int startingMileage = sc.nextInt();
            System.out.println("Zadejte konečný nájezd:");
            int finalMileage = sc.nextInt();
            System.out.println("Tankování: Ano/Ne");
            String refuel = sc.nextLine();
            boolean condition = false;
            int refuelingPrice = 0;
            int refuelingRange = 0;
            do {
                refuel = sc.nextLine();
                if (refuel.equals("Ano")) {
                    System.out.println("Zadejte částku v Kč:");
                    refuelingPrice = sc.nextInt();
                    System.out.println("Zadejte nájezd při tankování:");
                    refuelingRange = sc.nextInt();
                    condition = true;
                    break;
                } else if (refuel.equals("Ne")) {
                    refuelingPrice = 0;
                    refuelingRange = 0;
                    condition = true;
                    break;
                } else {
                    System.out.println("Zkuste to znova...");
                }
            } while (condition == false);
            sc.nextLine();
            System.out.println("Chcete přidat poznámku?: Ano/Ne");
            String note = "";
            boolean cond = false;
            do {
                String addNote = sc.nextLine();
                if (addNote.equals("Ano")) {
                    System.out.println("Napište poznámku:");
                    note = sc.nextLine();
                    cond = true;
                    break;
                } else if (addNote.equals("Ne")) {
                    note = "X";
                    cond = true;
                    break;
                } else {
                    System.out.println("Zkuste to znova...");
                }
            } while (cond == false);

            try ( BufferedWriter writer = new BufferedWriter(new FileWriter (SPZ + ".txt", StandardCharsets.UTF_8, true))) {
                String[] pole = {String.valueOf(date[0]), String.valueOf(date[1]), String.valueOf(date[2]), driver, String.valueOf(startingMileage),
                    String.valueOf(finalMileage), String.valueOf(refuelingPrice), String.valueOf(refuelingRange), note};
                String radek = String.join(";", pole);
                writer.write(radek + "\n");
            } catch (IOException ex) {
                System.out.println("Při zápisu došlo k chybě");
            }
        }
    }
