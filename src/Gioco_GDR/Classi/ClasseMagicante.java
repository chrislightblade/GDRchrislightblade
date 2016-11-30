/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR.Classi;

import Gioco_GDR.SchedaPersonaggio;
import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public class ClasseMagicante {

    String talenti[] = new String[5];
    private int talentoAttivo[] = new int[]{1, 0, 0, 0, 0};

    public ClasseMagicante(SchedaPersonaggio scheda) {
        this.talenti[0] = "Ricarica";
        this.talenti[1] = "Ottimizzazione";
        this.talenti[2] = "Doppio Lancio";
        this.talenti[3] = "Potenza Arcana";
        this.talenti[4] = "";
        scheda.setIntelligenza(1);
        scheda.setCaricheMagiche(4);
        //String talenti[] = new String[]{"Assalto", "Colpo Vigoroso", "Incalzare", "Furia"};
        //int tabellaAssalto[][] = new int[][];
    }

    public int getTalentoAttivo(int i) {
        return talentoAttivo[i];
    }

    public void setTalentoAttivo(int talentoAttivo) {
        this.talentoAttivo[talentoAttivo]++;
    }

    public int usaTalento(int i, SchedaPersonaggio scheda) {

        String frase = "Quale talento vuoi utilizzare?";
        //int z = 1;
        for (int k = 0; k < 5; k++) {// i talenti non ancora attivi e funzionanti hanno valore 0, mentre quelli attivi hanno valore 1. Stampo gli 1
            if (talentoAttivo[k] == 1) {
                frase += (k + 1) + "." + talenti[k] + "\n";
            }
        }

        switch (i) {
            case 1:
                int bonus = (scheda);
                return bonus;

            case 2:

            case 3:

            case 4:

            case 5:

        }
        return 1;
    }

    public void lanciaIncantesimo() {

        boolean verifica = false;
        while (verifica == false) {

            String frase = "quale incantesimo desideri lanciare?\n";
            int input;
            frase = JOptionPane.showInputDialog(frase);

            try {
                if (frase.equalsIgnoreCase("")) {
                    input = 0;
                    verifica = true;
                } else {
                    input = Integer.parseInt(frase);
                    verifica = true;
                }
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "non hai inserito dei valori validi");
            }
        }//fine while controllo inserimento

    }

    /*void applicaBonus(SchedaPersonaggio scheda) {
        scheda.setForza(2);
    }
    public int usaAssalto(SchedaPersonaggio scheda) {
        int forza = scheda.getAgilità();
        int agilità = scheda.getForza();

        int danno = (forza + agilità) / 3;
        return 1;
    }*/
    public String getTalenti(int i) {
        return talenti[i];
    }

}