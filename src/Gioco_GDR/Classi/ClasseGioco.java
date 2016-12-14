/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR.Classi;

import Gioco_GDR.Personaggi.SchedaPersonaggio;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public interface ClasseGioco {
    
    //private String talenti[] = new String[5];
    int uso[] = {0, 0, 0, 0, 0};
    int uso_Max[] = {0, 0, 0, 0, 0};
    String talenti[] = new String[5];
    int talentoAttivo[] = {0, 0, 0, 0, 0};
    
    public default String getTalenti(int i) {
        return talenti[i];
    }
    
    public default int getTalentoAttivo(int i) {
        return talentoAttivo[i];
    }

    public default void setTalentoAttivo(int talentoAttivo) {
        this.talentoAttivo[talentoAttivo]++;
    }

    public default int getUso(int index) {
        return this.uso[index];
    }

    public default void setUso(int index, int numero) {
        this.uso[index] += numero;
    }

    public default int getUso_Max(int index) {
        return this.uso_Max[index];
    }

    public default void setUso_Max(int index) {
        this.uso_Max[index]++;
    }
    
    public default void fullUso(int index){
        this.uso[index] = this.uso_Max[index];
    }
    
    public default int usaTalento(SchedaPersonaggio scheda1, ArrayList<SchedaPersonaggio> schedaMobs) {
        String report = "";
        String frase = "Quale talento vuoi utilizzare?\n";
        //int z = 1;
        for (int k = 0; k < 5; k++) {// i talenti non ancora attivi e funzionanti hanno valore 0, mentre quelli attivi hanno valore 1. Stampo gli 1
            if (talentoAttivo[k] == 1 && getUso(k) > 0) {
                frase += (k + 1) + "." + talenti[k] + "\n";
            }
        }

        
        int scegli = 0;

        boolean verifica = false;
        while (verifica == false) {

            report = JOptionPane.showInputDialog(frase);

            try {
                scegli = Integer.parseInt(report);
                if (scegli < 6 && scegli > 0) {
                    verifica = true;
                }

            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "non hai inserito dei valori validi");
            }
        }//fine while controllo inserimento
       
        return scegli;
    }
    
}
