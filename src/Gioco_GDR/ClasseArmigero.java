/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR;

/**
 *
 * @author tss
 */
public class ClasseArmigero {

    private String talenti[] = new String[5];
    private int talentoAttivo[] = new int[]{0, 0, 0, 0, 0};
    

    public ClasseArmigero(SchedaPersonaggio scheda) {
        this.talenti[0] = "Assalto";
        this.talenti[1] = "Colpo Vigoroso";
        this.talenti[2] = "Incalzare";
        this.talenti[3] = "Furia";
        this.talenti[4] = "";
        scheda.setForza(2);
        //String talenti[] = new String[]{"Assalto", "Colpo Vigoroso", "Incalzare", "Furia"};
        //int tabellaAssalto[][] = new int[][];
    }

    public int getTalentoAttivo(int i) {
        return talentoAttivo[i];
    }

    public void setTalentoAttivo(int talentoAttivo) {
        this.talentoAttivo[talentoAttivo]++;
    }
    
    
    
    public int usaTalento(int i, SchedaPersonaggio scheda){
        switch(i){
            case 1:
                int bonus = usaAssalto(scheda);
                return bonus;
             
            case 2:
                
            case 3:
                
            case 4:
                
            case 5:   
            
        }
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

    public String getTalenti(int i) {
        return talenti[i];
    }

}
