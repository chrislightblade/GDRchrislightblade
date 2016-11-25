/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR;

/**
 *
 * @author Administrator
 */
public class Magicante {
    
    String talenti[] = new String[]{"Ricarica", "Ottimizzazione", "Doppio Lancio", "Potenza Arcana"};
    
    static void applicaBonus(SchedaPersonaggio scheda){
        scheda.cariche_magiche += 2;
    }
}
