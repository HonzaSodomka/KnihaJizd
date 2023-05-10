/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package knihajizd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author hsodo
 */
public class loadCars {
    ArrayList<Car> cars = new ArrayList<>();
    public loadCars (){
        try 
            (BufferedReader reader = new BufferedReader (new FileReader("cars.txt")))
            {
            String line;
            while((line = reader.readLine()) != null) {
            String[] pole = line.split(";");
            Car car = new Car (pole[0], pole[1], pole[2]);
            cars.add(car);
            }
            }
            catch (IOException e) {
            System.out.println("Soubor s auty nenalezen");
        }
    }
    public ArrayList<Car> getCars(){
    return cars;
    }
    
}
