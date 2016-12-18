/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR.Classi;

import Gioco_GDR.Personaggi.SchedaPersonaggio;
import Gioco_GDR.Utility_calcolo_valori;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public interface ClasseGioco {

    //private String talenti[] = new String[5];
    int uso[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int uso_Max[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    String talenti[] = new String[10];
    int talentoAttivo[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    

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

    public default void fullUso(int index) {
        this.uso[index] = this.uso_Max[index];
    }

    //perte comune a tutti i metodi per sceglier eun talento, cioè proprio la sua scelta
    //la seconda parte è specifica per ogni classe e si occupa del lancio del talento
    public default int usaTalento(SchedaPersonaggio scheda1, ArrayList<SchedaPersonaggio> schedaMobs, ArrayList<SchedaPersonaggio> ordineBattaglia) {
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

    public default int colpireConArma(SchedaPersonaggio p1, ArrayList<SchedaPersonaggio> schedaMobs, ArrayList<SchedaPersonaggio> ordineBattaglia) {

        int inputI = 0;
        int indexLowLife = 0;
        int sceltaBersaglio = Utility_calcolo_valori.lanciaD(4);//decider ese attaccare il bersaglio con meno vita o un bersaglio casuale
        if (sceltaBersaglio % 2 == 0) {
            inputI = Utility_calcolo_valori.lanciaD(schedaMobs.size());
        } else {
            int lowLife = schedaMobs.get(0).getPunti_vita();
            for (int i = 0; i < schedaMobs.size(); i++) {
                if (lowLife > schedaMobs.get(i).getPunti_vita()) {
                    lowLife = schedaMobs.get(i).getPunti_vita();
                    indexLowLife = i;
                }
            }
            inputI = indexLowLife;
        }
        int lancioDado = Utility_calcolo_valori.lanciaD(12);

        int colpire = p1.getForza() + p1.getIntelligenza() + lancioDado;
        int difendere = schedaMobs.get(inputI).getTotaleArmatura() + Utility_calcolo_valori.lanciaD(12);

        if (colpire >= difendere) {
            int danno = p1.getManoDestra().dannoArma(p1.getForza());
            if (Utility_calcolo_valori.controlloCritico(0, lancioDado)) {
                    danno += danno;
                }
            //if (p1.getManoDestra().getAttributo() != 12) {
            //}
            schedaMobs.get(inputI).setPunti_vita(-danno);
            System.out.println("\nColpito! Danno inferto " + danno + " da " + p1.getNome() + " a " + schedaMobs.get(inputI).getNome() + "\nPunti vita residui " + schedaMobs.get(inputI).getPunti_vita() + "\n");

        } else {
            System.out.println("\nMancato!");
        }
        return 1;
    }
}
