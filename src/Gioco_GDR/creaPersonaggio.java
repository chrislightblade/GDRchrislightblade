/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR;

import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public class creaPersonaggio {
    
    static String inserisciNome_Cognome(int i) {

        String NomeCognome = "";
        NomeCognome = "Chris";

        switch (i) {
            case 0:
                //NomeCognome = JOptionPane.showInputDialog("Prego inserisci il nome del personaggio (solo il primo nome):");//inserimento nome pg
                return NomeCognome;

            case 1:
                String selezione = "no";//JOptionPane.showInputDialog("Desideri inserire un secondo nome? Si o No");
                if (selezione.toLowerCase() == "si") {
                    NomeCognome = JOptionPane.showInputDialog("Prego inserisci il secondo nome del personaggio:");//inserimento secondo nome pg
                    return NomeCognome;

                } else {
                    NomeCognome = "";
                    return NomeCognome;
                }

            case 2:
                NomeCognome = "Lightblade";//JOptionPane.showInputDialog("Prego inserisci il Cognome del personaggio (ed eventuale secondo nome):\n");//inserimento cognome e secondo nome
                return NomeCognome;

            default:
                return NomeCognome;

        }//fine switch

    }//fine inserisciNome_Cognome
    
}
