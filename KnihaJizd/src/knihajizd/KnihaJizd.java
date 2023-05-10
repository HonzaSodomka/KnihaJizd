/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package knihajizd;

import java.util.ArrayList;
import java.util.Scanner;
import static knihajizd.addCar.addCar;
import static knihajizd.addJourney.addJourney;

/**
 *
 * @author hsodo
 */
public class KnihaJizd {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int option=-1;
        System.out.println("*****KNIHA JÍZD*****");
        do{
        loadCars loading = new loadCars();
        ArrayList<Car> cars = loading.getCars();

        System.out.println("Zvolte možnost:\n"
                + "1 - Zapsat nový vůz\n"
                + "2 - Zapsat jízdu\n"
                + "3 - Vypsat historii vozu\n"
                + "0 - Ukončit program");
        boolean condition = false;
        while(!condition){
        while (!sc.hasNextInt()) {
            System.out.println("Neplatný vstup.");
            sc.next();
        }
        option = sc.nextInt();
        if (option<0||option>3) {
            System.out.println("Neplatný vstup.");
        }
        else {condition = true;
        sc.nextLine();}
        }
        switch (option) {
            case 0:
                System.out.println("Konec programu");
                break;
            case 1:
                addCar(cars);
                break;
            case 2:
                addJourney();
                break;
            case 3:
                carHistory.chooseCar();
        }
        }
        while (option!=0);

    }

}
