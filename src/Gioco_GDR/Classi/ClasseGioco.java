/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR.Classi;

import Gioco_GDR.Personaggi.SchedaPersonaggio;

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
        if(scheda.getClasse() == 0){

        switch (i) {
            case 1:
                //int bonus = scheda.getClasse1().usaAssalto(scheda);//ClasseArmigero.usaAssalto(scheda);
                return scheda.getClasse1().colpoVigoroso (scheda, scheda.getManoDestra().dannoArma(scheda.getForza()));

            case 2:

            case 3:

            case 4:

            case 5:

        }
        
    }
}
