/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR;

import java.util.Random;

/**
 *
 * @author Administrator
 */
public class Utility_calcolo_valori {
    
    // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
    //-4-3-2-1 0 1 2 3 4 5  6  7  8  9 10 11
    
    public static int lanciaD(int dado){//Utility_calcolo_valori.lanciaD(int dado);
        Random random = new Random();
        int valore = random.nextInt(dado) + 1;
        return valore;
    }
    
    public static int lanciaD2(int dado){
        int valore = (int) Math.floor(Math.random() * dado);
        return valore;
        
    }
}
