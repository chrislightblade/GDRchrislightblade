/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR;

import Gioco_GDR.Personaggi.SchedaPersonaggio;
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
        int valori[] = new int[5];//array che ospiterà i miei 2 valori da mettere in scheda
        int j = 5;
        int input1 = 0, input2 = 0;//input che userò per inserire il valore, con riferimento *valore* e *razza*
        String statistiche[] = new String[]{"forza", "difesa", "intelligenza", "agilità", "costituzione"}; //stringa e array con gli ordinali per fare le scelte
        int statistiche_n[] = new int[]{1, 2, 3, 4, 5};
        for (int i = 0; i < 5; i++) {//sputa fuori i valori da mettere nelle stat sopra
            int a = (random.nextInt(6) + 1) + 2;//2 lanci su un d6 e tengo il migliore
            int b = (random.nextInt(6) + 1) + 2;
            b = 0;

            /*if(a > b)
                valori[i] = a;
            else 
                valori[i] = b;*/
            valori[i] = (a > b) ? a : b;
        }
        
        String report3 = "";

        while (j > 0) {

            String report1 = "hai a disposizione i seguenti valori: ";
            String report2 = "";

            for (int i = 0; i < 5; i++) {//stampo i valori residui
                if (valori[i] != 0) {
                    report1 += "\n" + valori[i];
                } else {
                    continue;
                }
                //report1 += "\n" + valori[i];
            }

            for (int i = 0; i < 5; i++) {//stampo le stat che non hanno ancora ricevuto un input
                if (statistiche_n[i] != 0) {
                    report2 += "\n" + statistiche_n[i] + ". " + statistiche[i];
                } else {
                    continue;
                }
                //report1 += "\n" + valori[i];
            }

            input1 = Integer.parseInt(JOptionPane.showInputDialog(report1 + "\nQuale valore desideri utilizzare?\n" + report3));
            report1 += "\nHai deciso di usare il valore " + input1;
            input2 = Integer.parseInt(JOptionPane.showInputDialog(report1 + "\nIn quale statistica desideri inserirlo?" + report2 + "\n" + report3));
            impostaParametro(input1, input2);
            //for che cancella valore usato
            for (int i = 0; i < 5; i++) {//stampo i valori residui
                if (valori[i] != input1) {
                    continue;
                } else {
                    valori[i] = 0;                
                    break;
                }
                //report1 += "\n" + valori[i];
            }
            statistiche_n[input2 - 1] = 0;
            if(report3.equalsIgnoreCase(""))
                report3 = "\nI tuoi parametri attualmente sono:\n";
            report3 += statistiche[input2 - 1] + " = " + input1 + "\n";
            //JOptionPane.showMessageDialog(null, report);
        }

    }

    static void impostaParametro(int input1, int input2) {
        SchedaPersonaggio scheda = new SchedaPersonaggio();
        switch (input2) {
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
                scheda.agilità = input1;
                break;

            case 5:
                scheda.costituzione = input1;
                break;

        }
    }

}
