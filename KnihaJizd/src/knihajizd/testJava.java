/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package knihajizd;

import static knihajizd.KnihaJizd.sc;

/**
 *
 * @author hsodo
 */
public class testJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      System.out.println("Chcete přidat poznámku?: Ano/Ne");
        String addNote = sc.nextLine();
        String note = "";
        boolean cond = false;
        do {

            if (addNote.equals("Ano")) {
                System.out.println("Napište poznámku:");
                note = sc.nextLine();
                cond = true;
                break;
            } else if (addNote.equals("Ne")) {
                note = "";
                cond = true;
                break;
            } else {
                System.out.println("Zkuste to znova...");
            }
        } while (cond == false);
    }
    
}
