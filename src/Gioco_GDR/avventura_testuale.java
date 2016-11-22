/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR;

import javax.swing.JOptionPane;
import jdk.nashorn.internal.objects.NativeString;

/**
 *
 * @author tss
 */
public class avventura_testuale {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JOptionPane.showMessageDialog(null, "Benvenuto in questa entusiasmate\n             avventura testuale");
        //tutti i parametri per gestire il gioco

        String input = "";
        boolean controllo = false;
        int i = 0, j = 0;

        input = JOptionPane.showInputDialog("Se desideri caricare un salvataggio digita 1,\n "
                + "altrimenti premi semplicemente invio");

        if (input.equals("1")) {

        } else {// crea una nuova partita

            SchedaPersonaggio scheda = new SchedaPersonaggio();
            System.out.println("Nome e Cognome personaggio:");

            CreaPersonaggio.inserisciNome_Cognome(scheda);
            CreaPersonaggio.scegliRazza(scheda);
            CreaPersonaggio.scegliClasse(scheda);
            CreaPersonaggio.impostaStatistiche(scheda);
            

            /*System.out.println("Nome personaggio: " + NomeCognome[0] + NomeCognome[1] + "\nCognome personaggio: " + NomeCognome[2] + "\n");
            Razza = scegliRazza();

            statistiche_valore = valoriRazza(statistiche_valore, Razza);
            System.out.println("razza personaggio: " + RazzaPersonaggio[Razza - 1] + "\n");

            for (i = 0; i < 10; i++) {
                System.out.println(statistiche[i] + " : " + statistiche_valore[i] + "\n");*/

            }//fine else nuova partita
            
        }
}
   