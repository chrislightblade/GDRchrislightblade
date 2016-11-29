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
public class ClasseMagicante extends ClasseGioco {

    public ClasseMagicante(SchedaPersonaggio scheda) {
        this.talenti[0] = "Ricarica";
        this.talenti[1] = "Ottimizzazione";
        this.talenti[2] = "Doppio Lancio";
        this.talenti[3] = "Potenza Arcana";
        scheda.setIntelligenza(1);
        scheda.setCaricheMagiche(4);
        //String talenti[] = new String[]{"Assalto", "Colpo Vigoroso", "Incalzare", "Furia"};
        //int tabellaAssalto[][] = new int[][];
    }
    
}
