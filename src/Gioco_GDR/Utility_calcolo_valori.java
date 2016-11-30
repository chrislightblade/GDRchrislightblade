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
    
    
    
    public static int lanciaD(int dado){//Utility_calcolo_valori.lanciaD(int dado);
        Random random = new Random();
        int valore = random.nextInt(dado) + 1;
        return valore;
    }
}
