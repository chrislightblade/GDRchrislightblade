/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR.Classi;

import Gioco_GDR.SchedaPersonaggio;

/**
 *
 * @author Administrator
 */
public class ClasseGioco {

    //private ClasseGioco classe;
    /*private*/ String talenti[] = new String[5];
    /*private*/ int talentoAttivo[] = new int[]{0, 0, 0, 0, 0};

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
}
