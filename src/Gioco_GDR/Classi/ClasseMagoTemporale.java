/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR.Classi;

import Gioco_GDR.SchedaPersonaggio;
import java.util.ArrayList;

/**
 *
 * @author tss
 */
public class ClasseMagoTemporale extends ClasseGioco{
    
    public ClasseMagoTemporale(SchedaPersonaggio scheda) {
        this.talentoAttivo[0] = 1;
        this.talenti[0] = "Ricarica";
        this.talenti[1] = "Percussione";//danno e rallenta l'avversario spostando in avanti il turno
        this.talenti[2] = "Quick";//a fine turno, ha una certa probabilità di far svolgere un turno addizionale a se stesso o a un compagno di squadra
        this.talenti[3] = "Stretch";//danno magico arcano in base ai turni di battaglia
        this.talenti[4] = "";
        ClasseMagoTemporale classe = new ClasseMagoTemporale(scheda);
        scheda.setClasse3(classe);        
        scheda.setIntelligenza(1);
        scheda.setCaricheMagiche(4);
        scheda.setCariche_magiche_max(4);
        //this.incantesimi = new ArrayList<Incantesimi>();
        //String talenti[] = new String[]{"Assalto", "Colpo Vigoroso", "Incalzare", "Furia"};
        //int tabellaAssalto[][] = new int[][];
    }
    
}
