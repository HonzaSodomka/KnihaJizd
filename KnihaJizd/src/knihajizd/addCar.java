/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package knihajizd;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hsodo
 */
public class addCar {
    public static Scanner sc = new Scanner(System.in);

    public static void addCar(ArrayList<Car> cars) {
        System.out.println("Zadejte značku:");
        String brand = sc.nextLine();
        if(brand.equals("Škoda"))
        {brand = "Skoda";}
        System.out.println("Zadejte model:");   
        String model = sc.nextLine();
        System.out.println("Zadejte SPZ:");
        String SPZ = sc.nextLine();
        Car car = new Car(brand, model, SPZ);
        cars.add(car);

        File actualDir = new File(".");
        File newFile = new File(actualDir, SPZ + ".txt");
        boolean fileCreated = true;
        try {
            fileCreated = newFile.createNewFile();
        } catch (IOException ex) {
            System.out.println("Při vytváření souboru došlo k chybě");
        }
        if (fileCreated) {
            try ( FileWriter writer = new FileWriter("cars.txt", true)) {
                String[] pole = {brand, model, SPZ};
                String radek = String.join(";", pole);
                writer.write(radek + "\n");
            } catch (IOException ex) {
                System.out.println("Při zápisu došlo k chybě");
            }

        }
        if (!fileCreated) {
        System.out.println("Vozidlo s SPZ: " + SPZ + " již existuje");
        }
    }
}
