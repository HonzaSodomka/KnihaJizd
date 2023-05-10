/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package knihajizd;

/**
 *
 * @author hsodo
 */
public class Journey {
    int[] date;
    String driver;
    int startingMileage;
    int finalMileage;
    boolean refueling;
    int refuelingPrice;
    int refuelingRange;
    String note;
    public Journey (int[] date, String driver, int startingMileage, int finalMileage, int refuelingPrice, int refuelingRange, String note){
    this.date = date;
    this.driver = driver;
    this.startingMileage = startingMileage;
    this.finalMileage = finalMileage;
    this.refuelingPrice = refuelingPrice;
    this.refuelingRange = refuelingRange;
    this.note = note;
    }

    public int getStartingMileage() {
        return startingMileage;
    }

    public int getDate0() {
        return date[0];
    }
    
    public int getDate1() {
        return date[1];
    }
    
    public int getDate2() {
        return date[2];
    }

    public String getDriver() {
        return driver;
    }

    public int getFinalMileage() {
        return finalMileage;
    }

    public boolean isRefueling() {
        return refueling;
    }

    public int getRefuelingPrice() {
        return refuelingPrice;
    }

    public int getRefuelingRange() {
        return refuelingRange;
    }

    public String getNote() {
        return note;
    }
    
    
}
