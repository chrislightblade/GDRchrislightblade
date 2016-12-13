/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR.Classi;

import Gioco_GDR.Personaggi.SchedaPersonaggio;

/**
 *
 * @author tss
 */
public class ClasseArmigero extends ClasseGioco{

    //private String talenti[] = new String[5];
    
    public ClasseArmigero(SchedaPersonaggio scheda) {
        this.talenti[0] = "Assalto";
        this.talenti[1] = "Colpo Vigoroso";
        this.talenti[2] = "Incalzare";//passiva
        this.talenti[3] = "Furia";
        this.talenti[4] = "";
        //ClasseArmigero classe = new ClasseArmigero(scheda);
        //scheda.setClasse1(classe);        
        scheda.setForza(2);
        scheda.setCostituzione(1);
        scheda.setPunti_vita_max(20 + (scheda.getCostituzione() - 4));//punti vita a creazione presonaggio
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

    

    /*void applicaBonus(SchedaPersonaggio scheda) {
        scheda.setForza(2);
    }*/
    public int usaAssalto(SchedaPersonaggio scheda) {
        int forza = scheda.getAgilità();
        int agilità = scheda.getForza();
        int danno = (forza + agilità) / 3;
        return 1;
    }
    
    public int colpoVigoroso (SchedaPersonaggio scheda){
        int danno = scheda.getManoDestra().dannoArma(scheda.getForza());
        danno = danno * (scheda.getForza() - 4);        
        return danno;
    }
    
    public void usaIncalzarePassiva(){        
        
    }
    
    public void usaFuria(){        
        
    }

    

}