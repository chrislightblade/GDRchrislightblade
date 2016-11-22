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

    //rivedere che stampa una riga vuota
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
        String Razza1 = "";
        scheda.Razza = 0;//definisco la razza

        do {//ciclo per visualizzare le informazioni sulle razze

            if (scheda.Razza == 0) {
                Razza1 = JOptionPane.showInputDialog("Prego inserisci la razza del tuo personaggio:\npuoi scegliere:\nDigita 1 se desideri essere 'Umano'\n" + "Digita 2 se desideri essere 'Nano'\n"
                        + "Digita 3 se desideri essere 'Elfo'\n" + "Digita 4 se desideri essere 'Dracolide'\n" + "Digita 5 se desideri essere 'Vergheuden'\n"
                        + "Se desideri invece informazioni sulle razze, digita 6.\n");

                scheda.Razza = Integer.parseInt(Razza1);
                if (scheda.Razza == 6) {
                    spiegaRazza(scheda);
                }
            }//if razza
        } while (scheda.Razza == 0);//while per visualizzare info sulle razze

        valoriRazza(scheda);//inserisco i bonus e i malus delle razze nella scheda

    }//fine scegliRazza()

    static void spiegaRazza(SchedaPersonaggio scheda) {//switch per aver espiegazioni sulle razze

        while (scheda.Razza < 7 && scheda.Razza != 0) {

            String frase = "Hai inserito un valore non valido";//output nel caso in cui meta un valore non accettabile != 0

            String choice1 = JOptionPane.showInputDialog("Digitare:\n1 per avere informazioni su 'Umano' \n2 per avere infomazioni su 'Elfo'\n"
                    + "3 per avere informazioni su 'Nano'\n4 per avere informazioni su 'Dracolo'\n5 per avere infomazioni su 'Vergheuden'\n"
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

        switch (scheda.Razza) {// a seconda della razza scelta implementa dei parametri specifici
            case 1://umano               
                scheda.exp += 10;

            case 2://nano
                scheda.costituzione += 1;
                scheda.agilità -= 1;

            case 3://elfo
                scheda.agilità += 1;
                scheda.costituzione -= 1;

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

    /*static void valoriClasse(SchedaPersonaggio scheda) {// a seconda della razza scelta implementa dei parametri specifici

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

    }// fine valorizzaRazza*/
    static void impostaStatistiche(SchedaPersonaggio scheda) {
        Random random = new Random();
        int valori[] = new int[5];//array che ospiterà i miei 2 valori da mettere in scheda
        int j = 5;
        int input1 = 0, input2 = 0;//input che userò per inserire il valore, con riferimento *valore* e *razza*
        String statistiche[] = new String[]{"forza", "difesa", "intelligenza", "agilità", "costituzione"}; //stringa e array con gli ordinali per fare le scelte
        int statistiche_n[] = new int[]{1, 2, 3, 4, 5};
        for (int i = 0; i < 5; i++) {//sputa fuori i valori da mettere nelle stat sopra
            int a = (random.nextInt(6) + 1) + 2;//2 lanci su un d6 e tengo il migliore
            int b = (random.nextInt(6) + 1) + 2;
            b = 0;

            /*if(a > b)
                valori[i] = a;
            else 
                valori[i] = b;*/
            valori[i] = (a > b) ? a : b;
        }

        String report3 = "";
        int z = 0;

        while (j > 0) {

            String report1 = "hai a disposizione i seguenti valori: ";
            String report2 = "";

            for (int i = 0; i < 5; i++) {//stampo i valori residui
                if (valori[i] != 0) {
                    report1 += "\n" + valori[i];
                } else {
                    continue;
                }
                //report1 += "\n" + valori[i];
            }

            for (int i = 0; i < 5; i++) {//stampo le stat che non hanno ancora ricevuto un input
                if (statistiche_n[i] != 0) {
                    report2 += "\n" + statistiche_n[i] + ". " + statistiche[i];
                } else {
                    continue;
                }
                //report1 += "\n" + valori[i];
            }

            input1 = Integer.parseInt(JOptionPane.showInputDialog(report1 + "\nQuale valore desideri utilizzare?\n" + report3));
            report1 += "\nHai deciso di usare il valore " + input1;
            input2 = Integer.parseInt(JOptionPane.showInputDialog(report1 + "\nIn quale statistica desideri inserirlo?" + report2 + "\n" + report3));
            z = impostaParametro(scheda, input1, input2, statistiche[input2 - 1]);
            //for che cancella valore usato
            for (int i = 0; i < 5; i++) {//stampo i valori residui
                if (valori[i] != input1) {
                    continue;
                } else {
                    valori[i] = 0;
                    break;
                }
                //report1 += "\n" + valori[i];
            }
            statistiche_n[input2 - 1] = 0;
            if (report3.equalsIgnoreCase("")) {
                report3 = "\nI tuoi parametri attualmente sono:\n";
            }
            report3 += statistiche[input2 - 1] + " = " + z + "\n";
            //JOptionPane.showMessageDialog(null, report);
        }

    }

    static int impostaParametro(SchedaPersonaggio scheda, int input1, int input2, String statistiche) {

        switch (input2) {
            case 1://inserisci il valore in forza, ecc
                if (scheda.forza != 0) {
                    scheda.forza += input1;
                    JOptionPane.showMessageDialog(null, "il tuo parametro di " + statistiche + " è " + scheda.forza + " poichè sei " + scheda.Razza);
                    return scheda.forza;

                } else {
                    scheda.forza += input1;
                    return scheda.forza;
                }

            case 2:
                if (scheda.difesa != 0) {
                    scheda.difesa += input1;
                    JOptionPane.showMessageDialog(null, "il tuo parametro di " + statistiche + " è " + scheda.forza + " poichè sei " + scheda.Razza);
                    return scheda.difesa;
                } else {
                    scheda.difesa += input1;
                    return scheda.difesa;
                }
            case 3:
                if (scheda.intelligenza != 0) {
                    scheda.intelligenza += input1;
                    JOptionPane.showMessageDialog(null, "il tuo parametro di " + statistiche + " è " + scheda.forza + " poichè sei " + scheda.Razza);
                    return scheda.intelligenza;
                } else {
                    scheda.intelligenza += input1;
                    return scheda.intelligenza;
                }
            case 4:
                if (scheda.agilità != 0) {
                    scheda.agilità += input1;
                    JOptionPane.showMessageDialog(null, "il tuo parametro di " + statistiche + " è " + scheda.forza + " poichè sei " + scheda.Razza);
                    return scheda.agilità;
                } else {
                    scheda.agilità += input1;
                    return scheda.agilità;
                }
            case 5:
                if (scheda.costituzione != 0) {
                    scheda.costituzione += input1;
                    JOptionPane.showMessageDialog(null, "il tuo parametro di " + statistiche + " è " + scheda.forza + " poichè sei " + scheda.Razza);
                    return scheda.costituzione;
                } else {
                    scheda.costituzione += input1;
                    return scheda.costituzione;
                }
        }
    }

}
