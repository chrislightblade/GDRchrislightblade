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
public class ClasseGioco {
    
    String bonus = "";
    static String talenti[] = new String[5];
    
    
    
    /*void applicaBonus(SchedaPersonaggio scheda){
        
    }*/
    

    public static void setTalenti(String[] talenti) {
        
        ClasseGioco.talenti = talenti;
    }

    public String getTalenti() {
        String frase = "";
        for(int i = 0; i < this.talenti.length; i++){
            frase += this.talenti[i] + "\n";
        }
        return frase;
    }
    
}
