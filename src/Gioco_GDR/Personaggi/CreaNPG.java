/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR.Personaggi;

import Gioco_GDR.Classi.ClasseArmigero;
import Gioco_GDR.Oggetti.Armi.ClasseArma;
import Gioco_GDR.Oggetti.Armi.ClasseSpada;
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
        chris.setClasses(/*(ClasseGioco) */armigero);
        chris.getClasses().setTalentoAttivo(1);
        chris.getClasses().setTalentoAttivo(2);
        chris.setManoDestra(ClasseSpada.creaSpadaSemplice(1));
        //chris.setPunti_vita(100);
        //chris.setPunti_vita_max(100);
        return chris;
    }

    public void creaNPG_Armigero() {

    }

}
