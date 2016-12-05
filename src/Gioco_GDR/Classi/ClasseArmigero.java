/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR.Classi;

import Gioco_GDR.SchedaPersonaggio;

/**
 *
 * @author tss
 */
public class ClasseArmigero extends ClasseGioco{

    //private String talenti[] = new String[5];
    private int talentoAttivo[] = new int[]{0, 0, 0, 0, 0};

    public ClasseArmigero(SchedaPersonaggio scheda) {
        this.talenti[0] = "Assalto";
        this.talenti[1] = "Colpo Vigoroso";
        this.talenti[2] = "Incalzare";//passiva
        this.talenti[3] = "Furia";
        this.talenti[4] = "";
        scheda.setForza(2);
        scheda.setCostituzione(1);
        scheda.setPunti_vita_max(20 + (scheda.getCostituzione() - 4));
        scheda.setPunti_vita(20 + (scheda.getCostituzione() - 4));
        //String talenti[] = new String[]{"Assalto", "Colpo Vigoroso", "Incalzare", "Furia"};
        //int tabellaAssalto[][] = new int[][];
    }

    /*public int getTalentoAttivo(int i) {
        return talentoAttivo[i];
    }

    public void setTalentoAttivo(int talentoAttivo) {
        this.talentoAttivo[talentoAttivo]++;
    }*/

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
                int bonus = usaAssalto(scheda);
                return bonus;

            case 2:

            case 3:

            case 4:

            case 5:

        }
        return 1;
    }

    /*void applicaBonus(SchedaPersonaggio scheda) {
        scheda.setForza(2);
    }*/
    public int usaAssalto(SchedaPersonaggio scheda) {
        int forza = scheda.getAgilità();
        int agilità = scheda.getForza();

        int danno = (forza + agilità) / 3;
        return 1;
    }
    
    public int colpoVigoroso (SchedaPersonaggio scheda, int dannoattacco){
        int danno = 0;
        danno = dannoattacco * (scheda.getForza() - 4);        
        return danno;
    }
    
    public void usaIncalzarePassiva(){        
        
    }
    
    public void usaFuria(){        
        
    }

    public String getTalenti(int i) {
        return talenti[i];
    }

}