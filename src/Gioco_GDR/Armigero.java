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
public class Armigero{
    
    String talenti[] = new String[]{"Assalto", "Colpo Vigoroso", "Incalze", "Furia"};
    
    
    static void applicaBonus(SchedaPersonaggio scheda){
        scheda.forza += 2;
    }
    
}