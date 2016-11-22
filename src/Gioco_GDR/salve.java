/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public class salve {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Random random = new Random();
        int valori[] = new int[5];
        int j = 5;
        int input1 = 0, input2 = 0;
                        
        for (int i = 0; i < 5; i++) {
            int a = (random.nextInt(6) + 1) + 2;
            int b = (random.nextInt(6) + 1) + 2;
            b= 0;

            /*if(a > b)
                valori[i] = a;
            else 
                valori[i] = b;*/
            valori[i] = (a > b) ? a : b;
        }

        while (j > 0) {
            
            String report1 = "hai a disposizione i seguenti valori: ";
            //String report2 = "hai a disposizione i seguenti valori: ";

            for (int i = 0; i < j; i++) {
                report1 += "\n" + valori[i];
                //report1 += "\n" + valori[i];
            }
            
            input1 =Integer.parseInt(JOptionPane.showInputDialog(report1 + "\nQuale valore desideri utilizzare?"));
            report1 += "\nHai deciso di usare il valore " + input1;
            input2 =Integer.parseInt(JOptionPane.showInputDialog(report1 + "\nIn quale statistica desideri inserirlo?"));
            impostaParametro(input1, input2);
            //JOptionPane.showMessageDialog(null, report);
        }

    }

    static void impostaParametro(int input1, int input2) {
        SchedaPersonaggio scheda = new SchedaPersonaggio();
        switch(input2){
            case 1://inserisci il valore in forza, ecc
                scheda.forza = input1;
                break;
                
            case 2:
                scheda.difesa = input1;
                break;
                
            case 3:
                scheda.intelligenza = input1;
                break;
                
            case 4:
                scheda. = input1;
                break;
                
            case 5:    
                scheda.forza = input1;
                break;
        
        
        }
    }
        
    }
    

