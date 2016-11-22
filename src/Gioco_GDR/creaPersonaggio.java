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

    static void inserisciNome_Cognome(SchedaPersonaggio scheda) {

        for (int i = 0; i < 3; i++) {
            //scheda.NomeCognome[i] = creaPersonaggio.inserisciNome_Cognome(i);

            scheda.NomeCognome[i] = "";
            switch (i) {
                case 0:
                    //NomeCognome = JOptionPane.showInputDialog("Prego inserisci il nome del personaggio (solo il primo nome):");//inserimento nome pg
                    scheda.NomeCognome[i] = "Chris";
                    break;

                case 1:
                    String selezione = "no";//JOptionPane.showInputDialog("Desideri inserire un secondo nome? Si o No");
                    if (selezione.toLowerCase() == "si") {
                        scheda.NomeCognome[i] = JOptionPane.showInputDialog("Prego inserisci il secondo nome del personaggio:");//inserimento secondo nome pg          

                    } else {
                        scheda.NomeCognome[i] = "";
                    }

                    break;

                /*} else {
                    scheda.NomeCognome = "";
                    return NomeCognome;
                }*/
                case 2:
                    scheda.NomeCognome[i] = "Lightblade";//JOptionPane.showInputDialog("Prego inserisci il Cognome del personaggio (ed eventuale secondo nome):\n");//inserimento cognome e secondo nome
                    break;
                //return NomeCognome;

                /*default:
                
                return NomeCognome;*/
            }//fine switch

            if (scheda.NomeCognome[i] == "") {
                continue;
            } else {
                System.out.println(scheda.NomeCognome[i] + "\n");

            }

        }

    }//fine inserisciNome_Cognome

    static void scegliRazza(SchedaPersonaggio scheda) {
        String Razza1 = "";
        scheda.Razza = 0;//definisco la razza

        do {//ciclo per visualizzare le informazioni sulle razze

            if (scheda.Razza == 0) {
                Razza1 = JOptionPane.showInputDialog(" Prego inserisci la razza del tuo personaggio:\n puoi scegliere:\nDigita 1 se desideri essere 'Umano'\n" + "Digita 2 se desideri essere 'Nano'\n"
                        + "Digita 3 se desideri essere 'Elfo'\n" + "Digita 4 se desideri essere 'Dracolide'\n" + "Digita 5 se desideri essere 'Vergheuden'\n "
                        + "Se desideri invece informazioni sulle razze, digita 6.\n");

                scheda.Razza = Integer.parseInt(Razza1);
                if (scheda.Razza == 6) {
                    spiegaRazza(scheda);
                }
            }//if razza
        } while (scheda.Razza == 0);//while per visualizzare info sulle razze

    }//fine scegliRazza()

    static void spiegaRazza(SchedaPersonaggio scheda) {//switch per aver espiegazioni sulle razze

        while (scheda.Razza < 7 && scheda.Razza != 0) {

            String frase = "Hai inserito un valore non valido";

            String choice1 = JOptionPane.showInputDialog("Digitare:\n .1 per avere informazioni su 'Umano' \n .2 per avere infomazioni su 'Elfo'\n"
                    + " .3 per avere informazioni su 'Nano'\n .4 per avere informazioni su 'Dracolo'\n .5 per avere infomazioni su 'Vergheuden'\n"
                    + "altrimenti digitare 0.");

            int choice = Integer.parseInt(choice1);
            switch (choice) {
                case 1:
                    frase = "Seppur non sia la razza più forte fisicamente\n, possiede grandi capacità adattive e di apprendimento";
                    frase += "La razza Umano offre un bonus all'esperienza del 10% e consente \ndi scegliere un secondo talento.\n";
                    break;

                case 2:
                    frase = "Creature molto sensibili alla natura e dalla gracile costituzione,\npossiedono un'agilità senza pari.";
                    frase += "La razza Elfo offre un bonus all'agilità pari a +1 e un malus alla costituzione di -1, ma \nconsente di avere bonus con le armi leggere e quelle da tiro.\n";                    
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
                    scheda.Razza = 0;

            }//switch descrizione razze            

            if (scheda.Razza != 0) {
                JOptionPane.showMessageDialog(null, frase);
            }
        }

        scheda.Razza = 0;

    }

    static void valoriRazza(SchedaPersonaggio scheda) {

        switch (scheda.Razza) {
            case 1://umano
                scheda.exp += 10;

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
}
