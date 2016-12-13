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
 * @author Administrator
 */
public class ClasseGioco {

    //private ClasseGioco classe;
    String talenti[];// = new String[5];
    int talentoAttivo[];// = new int[]{0, 0, 0, 0, 0};

    public ClasseGioco() {
        this.talenti = new String[5];
        this.talentoAttivo = new int[]{0, 0, 0, 0, 0};
    }

    /*public ClasseGioco(int i, SchedaPersonaggio scheda) {
        if(i == 1)
          ClasseGioco.ClasseArmigero a = new ClasseGioco.ClasseArmigero(scheda);  
    }*/
 /*public ClasseGioco getClasse() {
        return classe;
    }

    public void setClasse(ClasseGioco classe) {
        this.classe = classe;
    }*/
    public String getTalenti(int i) {
        return talenti[i];
    }
    
    public int getTalentoAttivo(int i) {
        return talentoAttivo[i];
    }

    public void setTalentoAttivo(int talentoAttivo) {
        this.talentoAttivo[talentoAttivo]++;
    }

    public void usaTalento(SchedaPersonaggio scheda1, ArrayList<SchedaPersonaggio> schedaMobs) {

        ClasseArmigero classe = (ClasseArmigero) scheda1.getClasses();//casting iniziale per poter usare i talenti della classe
        //ClasseMagicante classe1 = (ClasseMagicante) scheda1.getClasses();//casting iniziale per poter usare i talenti della classe
        String report = "";
        String frase = "Quale talento vuoi utilizzare?\n";
        //int z = 1;
        for (int k = 0; k < 5; k++) {// i talenti non ancora attivi e funzionanti hanno valore 0, mentre quelli attivi hanno valore 1. Stampo gli 1
            if (talentoAttivo[k] == 1) {
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

        for (int j = 0; j < schedaMobs.size(); j++) {//stampa una String con i nomi dei nemici tra cui scegliere
            report += (j + 1) + "." + schedaMobs.get(j).getNome() + "\n";
        }
        int inputI = 0;
        verifica = false;
        while (verifica == false) {

            String input = JOptionPane.showInputDialog("\nChi desideri colpire?\n" + report);

            try {
                inputI = Integer.parseInt(input) - 1;
                if (inputI < schedaMobs.size() && inputI >= 0) {
                    verifica = true;
                }
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "non hai inserito dei valori validi");
            }
        }//fine while controllo inserimento

        if (scheda1.getClasse() == 0) {

            switch (scegli) {
                
                case 1:
                    
                case 2:
                    //int bonus = scheda.getClasse1().usaAssalto(scheda);//ClasseArmigero.usaAssalto(scheda);
                    int danno = classe.colpoVigoroso(scheda1);
                    schedaMobs.get(inputI).setPunti_vita(-danno);
                    System.out.println("\nColpito! Danno inferto " + danno + " da " + scheda1.getNome() + " a " + schedaMobs.get(inputI).getNome() + "\nPunti vita residui " + schedaMobs.get(inputI).getPunti_vita() + "\n");
                    break;
                
                case 3:

                case 4:

                case 5:

            }

        }
    }
}
