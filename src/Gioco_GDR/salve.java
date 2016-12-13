/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR;

import Gioco_GDR.Personaggi.CreaNPG;
import Gioco_GDR.Personaggi.SchedaMostro;
import Gioco_GDR.Personaggi.SchedaPersonaggio;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public class salve {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SchedaPersonaggio scheda = CreaNPG.creaChris_Armigero();
        Combattimenti combat = new Combattimenti();
        combat.setSchedaPgs(scheda);
        SchedaPersonaggio scheda1 = SchedaMostro.creaGoblin(1, 1);
        SchedaPersonaggio scheda2 = SchedaMostro.creaGoblin(1, 2);
        SchedaPersonaggio scheda3 = SchedaMostro.creaGoblin(1, 3);        
        combat.setSchedaMobs(scheda1);
        combat.setSchedaMobs(scheda2);
        combat.setSchedaMobs(scheda3);
        combat.battaglia();
    }
}
