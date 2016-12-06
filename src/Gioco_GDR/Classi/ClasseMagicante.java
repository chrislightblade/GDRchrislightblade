/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR.Classi;

import Gioco_GDR.SchedaPersonaggio;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public class ClasseMagicante extends ClasseGioco{
    
    ArrayList<Incantesimi> incantesimi;

    public ClasseMagicante(SchedaPersonaggio scheda) {
        this.talentoAttivo[0] = 1;
        this.talenti[0] = "Ricarica";
        this.talenti[1] = "Ottimizzazione";
        this.talenti[2] = "Doppio Lancio";
        this.talenti[3] = "Potenza Arcana";
        this.talenti[4] = "";
        ClasseMagicante classe = new ClasseMagicante(scheda);
        scheda.setClasse2(classe);        
        scheda.setIntelligenza(1);
        scheda.setCaricheMagiche(4);
        scheda.setCariche_magiche_max(4);
        this.incantesimi = new ArrayList<Incantesimi>();
        //String talenti[] = new String[]{"Assalto", "Colpo Vigoroso", "Incalzare", "Furia"};
        //int tabellaAssalto[][] = new int[][];
    }

    

    /*public int usaTalento(int i, SchedaPersonaggio scheda) {

        String frase = "Quale talento vuoi utilizzare?";
        //int z = 1;
        for (int k = 0; k < 5; k++) {// i talenti non ancora attivi e funzionanti hanno valore 0, mentre quelli attivi hanno valore 1. Stampo gli 1
            if (talentoAttivo[k] == 1) {
                frase += (k + 1) + "." + talenti[k] + "\n";
            }
        }

        
    }*/
    
    public void usaOttimizzazione(){
        
        
    }

    public void usaDoppioLancio(){
        
        
    }
    
    public void usaPotenzaArcana(){
        
        
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