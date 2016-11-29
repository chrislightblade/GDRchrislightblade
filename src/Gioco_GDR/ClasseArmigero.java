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
public class ClasseArmigero extends ClasseGioco {

    public ClasseArmigero(SchedaPersonaggio scheda){
    this.talenti[0] = "Assalto";
    this.talenti[1] = "Colpo Vigoroso";
    this.talenti[2] = "Incalzare";
    this.talenti[3] = "Furia";
    scheda.setForza(2);
    //String talenti[] = new String[]{"Assalto", "Colpo Vigoroso", "Incalzare", "Furia"};
    //int tabellaAssalto[][] = new int[][];
        }
    /*void applicaBonus(SchedaPersonaggio scheda) {
        scheda.setForza(2);
    }*/

    /*int usaAssalto(SchedaPersonaggio scheda ) {
        int danno = 
        return 1;
    }*/
}
