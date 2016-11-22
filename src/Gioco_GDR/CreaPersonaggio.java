/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public class CreaPersonaggio {

    static void inserisciNome_Cognome(SchedaPersonaggio scheda) {

        for (int i = 0; i < 3; i++) {
            //scheda.NomeCognome[i] = CreaPersonaggio.inserisciNome_Cognome(i);

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
        String Classe1 = "";
        scheda.Classe = 0;//definisco la classe

        do {//ciclo per visualizzare le informazioni sulle razze

            if (scheda.Razza == 0) {
                Classe1 = JOptionPane.showInputDialog(" Prego inserisci la classe del tuo personaggio:\n puoi scegliere:\nDigita 1 se desideri essere 'Umano'\n" + "Digita 2 se desideri essere 'Nano'\n"
                        + "Digita 3 se desideri essere 'Elfo'\n" + "Digita 4 se desideri essere 'Dracolide'\n" + "Digita 5 se desideri essere 'Vergheuden'\n "
                        + "Se desideri invece informazioni sulle razze, digita 6.\n");

                scheda.Razza = Integer.parseInt(Classe1);
                if (scheda.Razza == 6) {
                    spiegaRazza(scheda);
                }
            }//if razza
        } while (scheda.Razza == 0);//while per visualizzare info sulle razze

        valoriClasse(scheda);//inserisco i bonus e i malus delle razze nella scheda

    }//fine scegliRazza()

    static void spiegaRazza(SchedaPersonaggio scheda) {//switch per aver espiegazioni sulle razze

        while (scheda.Razza < 7 && scheda.Razza != 0) {

            String frase = "Hai inserito un valore non valido";//output nel caso in cui meta un valore non accettabile != 0

            String choice1 = JOptionPane.showInputDialog("Digitare:\n.1 per avere informazioni su 'Umano' \n.2 per avere infomazioni su 'Elfo'\n"
                    + ".3 per avere informazioni su 'Nano'\n.4 per avere informazioni su 'Dracolo'\n.5 per avere infomazioni su 'Vergheuden'\n"
                    + "altrimenti digitare 0.");

            int choice = Integer.parseInt(choice1);
            switch (choice) {
                case 1:
                    frase = "Seppur non sia la razza più forte fisicamente,\npossiede grandi capacità adattive e di apprendimento";
                    frase += "La razza Umano offre un bonus all'esperienza del 10% e consente \ndi scegliere un secondo talento.\n";
                    break;

                case 2:
                    frase = "Creature molto sensibili alla natura e dalla gracile costituzione,\npossiedono un'agilità senza pari.";
                    frase += "La razza Elfo offre un bonus all'agilità pari a +1 e un malus alla costituzione di -1, ma \nconsente di avere bonus con le armi leggere e quelle da tiro.\n";
                    break;

                case 3:
                    frase = "Creature basse, corpulente e devote alla terra,\nfanno degli avi e il loro corpo il loro tesoro più prezioso";
                    frase += "La razza Nano offre un bonus alla costituzione di +1 e un malus all'agilità di -1 \n ma consente di avere un bonus con le armi pesanti e con le armi da lancio.\n";
                    break;

                case 4:
                    frase = "Discendenti dei draghi, con ali e coda,\nvivono nell'attesa del risveglio del loro soffio elementale";
                    frase += "La razza Dracolo offre un bonus alla forza e alla CA di +2 \ne hanno il danno a mani nude aumentato di una unità.\n";
                    break;

                case 5:
                    frase = "Razza misteriosa, dall'aspetto metallico e minaccioso,\npossono rivelare sorprese inaspettate";
                    frase += "La razza Vergheuden offre un bonus alla CA di +3 e consente \ndi usare 'Stridore', tecnica che stordisce il nemico per 2 turni.\n";
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
                scheda.agilità += 1;
                scheda.costituzione -= 1;

            case 3://nano
                scheda.costituzione += 1;
                scheda.agilità -= 1;

            case 4://dracolide
                scheda.forza += 1;
                scheda.totale_armatura += 2;

            case 5://vergheuden
                scheda.totale_armatura += 3;

            //case 6: //Faithy    
        }//fine switch

    }// fine valorizzaRazza

    static void scegliClasse(SchedaPersonaggio scheda) {
        String Classe1 = "";
        scheda.Classe = 0;//definisco la classe

        do {//ciclo per visualizzare le informazioni sulle classi

            if (scheda.Classe == 0) {
                Classe1 = JOptionPane.showInputDialog(" Prego inserisci la razza del tuo personaggio:\n puoi scegliere:\nDigita 1 se desideri essere 'Umano'\n" + "Digita 2 se desideri essere 'Nano'\n"
                        + "Digita 3 se desideri essere 'Elfo'\n" + "Digita 4 se desideri essere 'Dracolide'\n" + "Digita 5 se desideri essere 'Vergheuden'\n "
                        + "Se desideri invece informazioni sulle razze, digita 6.\n");

                scheda.Classe = Integer.parseInt(Classe1);
                if (scheda.Classe == 6) {
                    spiegaClasse(scheda);
                }
            }//if classe
        } while (scheda.Classe == 0);//while per visualizzare info sulle classi

        valoriClasse(scheda);//inserisco i bonus e i malus delle classe nella scheda

    }//fine scegliClasse()

    static void spiegaClasse(SchedaPersonaggio scheda) {//switch per aver espiegazioni sulle razze

        while (scheda.Classe < 5 && scheda.Classe != 0) {

            String frase = "Hai inserito un valore non valido";//output nel caso in cui meta un valore non accettabile != 0

            String choice1 = JOptionPane.showInputDialog("Digitare:\n.1 per avere informazioni su 'Armigero' \n.2 per avere infomazioni su 'Magicante'\n"
                    + ".3 per avere informazioni su 'Shadow'\n.4 per avere informazioni su 'Elementalista'\naltrimenti digitare 0.");// .5 per avere infomazioni su 'Vergheuden'\n"+ "altrimenti digitare 0.");

            int choice = Integer.parseInt(choice1);
            switch (choice) {
                case 1://Armigero
                    frase = "";
                    frase += ".\n";
                    break;

                case 2://Magicante
                    frase = ".";
                    frase += "\n.\n";
                    break;

                case 3://Shadow
                    frase = "";
                    frase += "\n.\n";
                    break;

                case 4:
                    frase = "";
                    frase += "\n.\n";
                    break;

                /*case 5:
                    frase = "Razza misteriosa, dall'aspetto metallico e minaccioso,\npossono rivelare sorprese inaspettate";
                    frase += "La razza Vergheuden offre un bonus alla CA di +3 e consente \ndi usare 'Stridore', tecnica che stordisce il nemico per 2 turni.\n";
                    break;*/
                case 0:
                    scheda.Classe = 0;

            }//switch descrizione razze            

            if (scheda.Classe != 0) {
                JOptionPane.showMessageDialog(null, frase);
            }
        }

        scheda.Classe = 0;

    }

    static void valoriClasse(SchedaPersonaggio scheda) {

        switch (scheda.Razza) {
            case 1://umano               
                scheda.exp += 10;

            case 2://elfo
                scheda.agilità += 1;
                scheda.costituzione -= 1;

            case 3://nano
                scheda.costituzione += 1;
                scheda.agilità -= 1;

            case 4://dracolide
                scheda.forza += 1;
                scheda.totale_armatura += 2;

            case 5://vergheuden
                scheda.totale_armatura += 3;

            //case 6: //Faithy    
        }//fine switch

    }// fine valorizzaRazza

    static void impostaStatistiche(SchedaPersonaggio scheda) {
        Random random = new Random();
        int valori[] = new int[5];

        for (int i = 0; i < 5; i++) {
            int a = (random.nextInt(6) + 1) + 2;
            int b = (random.nextInt(6) + 1) + 2;

            /*if(a > b)
                valori[i] = a;
            else 
                valori[i] = b;*/
            valori[i] = (a > b) ? a : b;
        }

        int j = 5;

        while (j > 0) {
            
            String report = "hai a disposizione i seguenti valori: ";

            for (int i = 0; i < j; i++) {
                report = "\n" + valori[i];
            }
            
            JOptionPane.showMessageDialog(null, report);
        }

    }
}
