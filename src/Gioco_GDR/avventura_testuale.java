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
    

    static int scegliRazza() {
        String razza = "";
        int Razza = 0;//definisco la razza

        do {//ciclo per visualizzare le informazioni sulle razze

            if (Razza == 0) {
                String Razza1 = JOptionPane.showInputDialog(" Prego inserisci la razza del tuo personaggio:\n puoi scegliere:\nDigita 1 se desideri essere 'Umano'\n" + "Digita 2 se desideri essere 'Nano'\n"
                        + "Digita 3 se desideri essere 'Elfo'\n" + "Digita 4 se desideri essere 'Dracolide'\n" + "Digita 5 se desideri essere 'Vergheuden'\n "
                        + "Se desideri invece informazioni sulle razze, digita 6.\n");

                Razza = Integer.parseInt(Razza1);
                if (Razza == 6) {
                    Razza = spiega_razza(Razza);
                }
            }//if razza
        } while (Razza == 0);//while per visualizzare info sulle razze

        return Razza;
    }//fine scegliRazza()

    static Integer spiega_razza(int Razza) {//switch per aver espiegazioni sulle razze

        while (Razza < 7 && Razza != 0) {

            String frase = "Hai inserito un valore non valido";

            String choice1 = JOptionPane.showInputDialog("Digitare:\n .1 per avere informazioni su 'Umano' \n .2 per avere infomazioni su 'Elfo'\n"
                    + " .3 per avere informazioni su 'Nano'\n .4 per avere informazioni su 'Dracolo'\n .5 per avere infomazioni su 'Vergheuden'\n"
                    + "altrimenti digitare 0.");

            int choice = Integer.parseInt(choice1);
            switch (choice) {
                case 1:
                    frase = "La razza Umano offre un bonus all'esperienza del 10% e consente \ndi scegliere un secondo talento.\n";
                    frase += "Seppur non sia la razza più forte fisicamente\n, possiede grandi capacità adattive e di apprendimento";
                    break;

                case 2:
                    frase = "La razza Elfo offre un bonus all'agilità pari a +1 e un malus alla costituzione di -1, ma \nconsente di avere bonus con le armi leggere e quelle da tiro.\n";
                    frase += "Creature molto sensibili alla natura e dalla gracile costituzione,\npossiedono un'agilità senza pari.";
                    break;

                case 3:
                    frase = "La razza Nano offre un bonus alla costituzione di +1 e un malus all'agilità di -1 \n ma consente di avere un bonus con le armi pesanti e con le armi da lancio.\n";
                    frase += "Creature basse, corpulente e devote alla terra,\nfanno degli avi e il loro corpo il loro tesoro più prezioso";
                    break;

                case 4:
                    frase = "La razza Dracolo offre un bonus alla forza e alla CA di +2 \n e hanno il danno a mani nude aumentato di una unità.\n";
                    frase += "Discendenti dei draghi, con ali e coda,\nvivono nell'attesa del risveglio del loro soffio elementale";
                    break;

                case 5:
                    frase = "La razza Vergheuden offre un bonus alla CA di +3 e consente \ndi usare 'Stridore', tecnica che stordisce il nemico per 2 turni.\n";
                    frase += "Razza misteriosa, dall'aspetto metallico e minaccioso,\npossono rivelare sorprese inaspettate";
                    break;

                case 0:
                    Razza = 0;
                    return Razza;

            }//switch descrizione razze            

            JOptionPane.showMessageDialog(null, frase);
        }

        Razza = 0;
        return Razza;

    }

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
