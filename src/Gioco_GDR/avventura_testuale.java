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
        
        SchedaPersonaggio scheda = new SchedaPersonaggio();
        System.out.println("Nome e Cognome personaggio:");
        
        creaPersonaggio.inserisciNome_Cognome(scheda);

        input = JOptionPane.showInputDialog("Se desideri caricare un salvataggio digita 1,\n "
                + "altrimenti premi semplicemente invio");

        if (input.equals("1")) {

        } else {// crea una nuova partita

            while (i < 3) {
                scheda.inserisciNome_Cognome(i);
                i++;
            }//fine while inserimento nome e cognome

            System.out.println("Nome personaggio: " + NomeCognome[0] + NomeCognome[1] + "\nCognome personaggio: " + NomeCognome[2] + "\n");
            Razza = scegliRazza();

            statistiche_valore = valoriRazza(statistiche_valore, Razza);
            System.out.println("razza personaggio: " + RazzaPersonaggio[Razza - 1] + "\n");

            for (i = 0; i < 10; i++) {
                System.out.println(statistiche[i] + " : " + statistiche_valore[i] + "\n");

            }
            //scegliClasse();
            //definisciStatistiche(statistiche[]);
        }//fine else nuova partita
    }

    //static caricaPartita(){}
    

    

    static int[] valoriRazza(int[] statistiche_valore, int Razza) {

        switch (Razza) {
            case 1://umano
                for (int i = 0; i < 10; i++) {
                    statistiche_valore[i] = 0;
                    if (i == 5) {
                        statistiche_valore[i] += 10;
                    }
                }

                return statistiche_valore;

            case 2://elfo

                for (int i = 0; i < 10; i++) {
                    statistiche_valore[i] = 0;
                    if (i == 4) {//bonus agilità
                        statistiche_valore[i] += 1;
                    }
                    if (i == 2) {//malus costituzione
                        statistiche_valore[i] -= 1;
                    }
                }

                return statistiche_valore;

            case 3://nano

                for (int i = 0; i < 10; i++) {
                    statistiche_valore[i] = 0;
                    if (i == 4) {//malus agilità
                        statistiche_valore[i] -= 1;
                    }
                    if (i == 2) {//bonus costituzione
                        statistiche_valore[i] += 1;
                    }
                }

                return statistiche_valore;

            case 4://dracolide

                for (int i = 0; i < 10; i++) {
                    statistiche_valore[i] = 0;
                    if (i == 0) {//bonus forza
                        statistiche_valore[i] += 1;
                    }
                    if (i == 7) {//bonus totale armatura
                        statistiche_valore[i] += 2;
                    }
                }

                return statistiche_valore;

            case 5://vergheuden

                for (int i = 0; i < 10; i++) {
                    statistiche_valore[i] = 0;
                    if (i == 7) {//bonus totale armatura
                        statistiche_valore[i] += 3;
                    }
                }

                return statistiche_valore;

        }//fine switch

        return statistiche_valore;

    }// fine valorizzaRazza

}//fine main

/*static int definisciStatistiche(int statistiche[]) {

        String input;
        input = JOptionPane.showInputDialog(
    }

}

/*public scegli_classe_con_cui_giocare (){
        
    }
    }*/
