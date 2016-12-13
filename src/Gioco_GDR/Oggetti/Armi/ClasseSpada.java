/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR.Oggetti.Armi;

/**
 *
 * @author Administrator
 */
public class ClasseSpada extends ClasseArma{

    public ClasseSpada(int modificatore, int dado, String categoria, int maniOccupate, String potere) {
        super(modificatore, dado, categoria, maniOccupate, potere, 12);
    }
       
    public static ClasseArma creaSpadaSemplice(int modificatore){
        ClasseArma spadaSemplice = new ClasseSpada(modificatore, 6 + modificatore, "Spada", 1, "Nessuno");
        return spadaSemplice;
    }
    
}
