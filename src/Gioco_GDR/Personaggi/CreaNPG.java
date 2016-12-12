/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR.Personaggi;

import Gioco_GDR.Classi.ClasseArmigero;
import static Gioco_GDR.Personaggi.CreaPersonaggio.valoriRazza;

/**
 *
 * @author Administrator
 */
public class CreaNPG {

    public static SchedaPersonaggio creaChris_Armigero() {
        SchedaPersonaggio chris = new SchedaPersonaggio("Chris");
        valoriRazza(chris);
        ClasseArmigero armigero = new ClasseArmigero(chris);
        chris.setClasse1(armigero);
        chris.getClasse1().setTalentoAttivo(1);
        chris.getClasse1().setTalentoAttivo(2);
        //chris.setPunti_vita(100);
        //chris.setPunti_vita_max(100);
        return chris;
    }

    public void creaNPG_Armigero() {

    }

}
