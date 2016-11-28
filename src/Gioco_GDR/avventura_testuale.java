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
 * cose da fare: implementare nella scelta stat la possibilità di ridistribuire
 * i parametri (gli stessi, salvare gli array in altri array) usare intelligenza
 * nel colpire se si ha competenza nell'arma ( il bonus agilità è solo
 * "modificatore"
 *
 * @author tss
 */
public class avventura_testuale {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //JOptionPane.showMessageDialog(null, "Benvenuto in questa entusiasmate\n             avventura testuale");
        //tutti i parametri per gestire il gioco

        String input = "";
        boolean controllo = false;
        int i = 0, j = 0;

        /*input = JOptionPane.showInputDialog("Se desideri caricare un salvataggio digita 1,\n "
                + "altrimenti premi semplicemente invio");

        if (input.equals("1")) {

        } else {// crea una nuova partita*/
        SchedaPersonaggio scheda = new SchedaPersonaggio();
        System.out.println("Nome e Cognome personaggio:");

        CreaPersonaggio.inserisciNome_Cognome(scheda);
        System.out.println(scheda.getNomeCognome());
        
        CreaPersonaggio.scegliRazza(scheda);
        CreaPersonaggio.impostaStatistiche(scheda);
        CreaPersonaggio.scegliClasse(scheda);
        String statistiche[] = new String[]{"Forza", "Difesa", "Intelligenza", "Agilità", "Costituzione"};
        System.out.println(statistiche[0] + ": " + scheda.getForza());
        System.out.println(statistiche[1] + ": " + scheda.getDifesa());
        System.out.println(statistiche[2] + ": " + scheda.getIntelligenza());
        System.out.println(statistiche[3] + ": " + scheda.getAgilità());
        System.out.println(statistiche[4] + ": " + scheda.getCostituzione());
        


        /*System.out.println("Nome personaggio: " + NomeCognome[0] + NomeCognome[1] + "\nCognome personaggio: " + NomeCognome[2] + "\n");
            Razza = scegliRazza();

            statistiche_valore = valoriRazza(statistiche_valore, Razza);
            System.out.println("razza personaggio: " + RazzaPersonaggio[Razza - 1] + "\n");

            for (i = 0; i < 10; i++) {
                System.out.println(statistiche[i] + " : " + statistiche_valore[i] + "\n");*/
        // }//fine else nuova partita
    }
}
