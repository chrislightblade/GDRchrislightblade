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
        scheda.Razza = -1;//definisco la razza

        do {//ciclo per visualizzare le informazioni sulle razze

            boolean verifica = false;
            while (verifica == false) {

                Razza1 = JOptionPane.showInputDialog("Prego inserisci la razza del tuo personaggio:\npuoi scegliere:\nDigita 1 se desideri essere 'Umano'\n" + "Digita 2 se desideri essere 'Nano'\n"
                        + "Digita 3 se desideri essere 'Elfo'\n" + "Digita 4 se desideri essere 'Dracolide'\n" + "Digita 5 se desideri essere 'Vergheuden'\n"
                        + "Se desideri invece informazioni sulle razze, digita 6.\n");

                try {

                    if (Razza1.equalsIgnoreCase("")) {// se fai solo invio vai alle spiegazioni
                        scheda.Razza = 5;
                    } else {//altrimenti prova il parseInt
                        scheda.Razza = (Integer.parseInt(Razza1) - 1);
                    }

                    if (scheda.Razza == 5) {// al 5 vai alle spiegazioni
                        spiegaRazza(scheda);
                    } else {
                        if (scheda.Razza >= 0 && scheda.Razza < 6) {// sono valori validi
                            verifica = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "non hai inserito dei valori validi");//altrimenti hai messo un numero non accettabile
                            scheda.Razza = -1;
                        }
                    }
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(null, "non hai inserito dei valori validi");
                    scheda.Razza = -1;
                }

            }//fine while controllo inserimento

        } while (scheda.Razza == -1);//while per visualizzare info sulle razze

        valoriRazza(scheda);//inserisco i bonus e i malus delle razze nella scheda
        System.out.println("Razza personaggio: " + scheda.RazzaPersonaggio[scheda.Razza] + "\n");
    }//fine scegliRazza()

    static void spiegaRazza(SchedaPersonaggio scheda) {//switch per aver espiegazioni sulle razze

        while (scheda.Razza < 7 && scheda.Razza != -1) {

            String frase = "Hai inserito un valore non valido";//output nel caso in cui meta un valore non accettabile != 0

            int choice;
            String choice1 = JOptionPane.showInputDialog("Digitare:\n1 per avere informazioni su 'Umano' \n2 per avere infomazioni su 'Elfo'\n"
                    + "3 per avere informazioni su 'Nano'\n4 per avere informazioni su 'Dracolo'\n5 per avere infomazioni su 'Vergheuden'\n"
                    + "altrimenti digitare 0.");

            if (choice1.equalsIgnoreCase("")) {
                choice = 0;
            } else {
                choice = Integer.parseInt(choice1);
            }

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
                    scheda.Razza = -1;

            }//switch descrizione razze            

            if (scheda.Razza != -1) {
                JOptionPane.showMessageDialog(null, frase);
            }
        }

        scheda.Razza = -1;

    }

    static void valoriRazza(SchedaPersonaggio scheda) {

        switch (scheda.Razza) {// a seconda della razza scelta implementa dei parametri specifici
            case 0://umano               
                scheda.exp += 10;
                break;

            case 1://nano
                scheda.costituzione += 1;
                scheda.agilità -= 1;
                break;

            case 2://elfo
                scheda.agilità += 1;
                scheda.costituzione -= 1;
                break;

            case 3://dracolide
                scheda.forza += 1;
                scheda.totale_armatura += 2;
                break;

            case 4://vergheuden
                scheda.totale_armatura += 3;
                break;

            //case 5: //Faithy    
        }//fine switch

    }// fine valorizzaRazza

    static void scegliClasse(SchedaPersonaggio scheda) {
        String Classe1 = "";
        scheda.Classe = 0;//definisco la classe

        do {//ciclo per visualizzare le informazioni sulle classi

            boolean verifica = false;
            while (verifica == false) {

                Classe1 = JOptionPane.showInputDialog(" Prego inserisci la classe del tuo personaggio:\n puoi scegliere:\nDigita 1 se desideri essere 'Armigero'\n" + "Digita 2 se desideri essere 'Magicante'\n"
                        //+ "Digita 3 se desideri essere 'Shadow'\n" + "Digita 4 se desideri essere 'Elementalista'\n" + "Digita 5 se desideri essere 'Feral'\n "
                        + "Se desideri invece informazioni sulle classi, digita 6.\n");

                try {

                    if (Classe1.equalsIgnoreCase("")) {// se fai solo invio vai alle spiegazioni
                        scheda.Classe = 5;
                    } else {//altrimenti prova il parseInt
                        scheda.Classe = (Integer.parseInt(Classe1) - 1);
                    }

                    if (scheda.Classe == 5) {// al 5 vai alle spiegazioni
                        spiegaClasse(scheda);
                    } else {
                        if (scheda.Classe >= 0 && scheda.Classe < 2) {// sono valori validi
                            verifica = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "non hai inserito dei valori validi");//altrimenti hai messo un numero non accettabile
                            scheda.Classe = -1;
                        }
                    }
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(null, "non hai inserito dei valori validi");
                    scheda.Classe = -1;
                }

            }// fine while controllo inserimento

        } while (scheda.Classe == -1);//while per visualizzare info sulle classi

        valoriClasse(scheda);//inserisco i bonus e i malus delle classe nella scheda
        System.out.println("Classe Personaggio: " + scheda.Classi[scheda.Classe] + "\n");
    }//fine scegliClasse()

    static void spiegaClasse(SchedaPersonaggio scheda) {//switch per aver espiegazioni sulle razze

        while (scheda.Classe < 5 && scheda.Classe != 0) {

            String frase = "Hai inserito un valore non valido";//output nel caso in cui meta un valore non accettabile != 0

            String choice1 = JOptionPane.showInputDialog("Digitare:\n.1 per avere informazioni su 'Armigero' \n.2 per avere infomazioni su 'Magicante'");//\n"
            //+ ".3 per avere informazioni su 'Shadow'\n.4 per avere informazioni su 'Elementalista'\naltrimenti digitare 0.");// .5 per avere infomazioni su 'Vergheuden'\n"+ "altrimenti digitare 0.");

            int choice = Integer.parseInt(choice1);
            switch (choice) {
                case 1://Armigero
                    frase = "Classe dedita al combattimento corpo a corpo, usa la forza, la velocità e l'istinto\nper afforntare i più temibili nemici.";
                    frase += "Scegliere questa claasse offre un bonus immediato di +2 alla forza,\nseguito ovviamente dalla scelta dei talenti annessi.\n";
                    break;

                case 2://Magicante
                    frase = "Classe specializzata nell'uso della magia e di tutte le sue sfaccettature,\nil talento e la riflessione sono i suoi migliori amici.";
                    frase += "Scegliere questa claasse offre un bonus immediato di +2 alle cariche magiche,\nseguito ovviamente dalla scelta dei talenti annessi.\n";
                    break;

                /*case 3://Shadow
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

    static void valoriClasse(SchedaPersonaggio scheda) {// a seconda della razza scelta implementa dei parametri specifici

        switch (scheda.Classe) {
            case 1://umano               
                Armigero.applicaBonus(scheda);
                break;

            case 2://elfo
                Magicante.applicaBonus(scheda);
                break;

            /*case 3://nano
                scheda.costituzione += 1;
                scheda.agilità -= 1;

            case 4://dracolide
                scheda.forza += 1;
                scheda.totale_armatura += 2;

            //case 5://vergheuden
                //scheda.totale_armatura += 3;

            //case 6: //Faithy*/
        }//fine switch

    }// fine valoriClasse

    static void impostaStatistiche(SchedaPersonaggio scheda) {

        int valori[] = new int[5];//array che ospiterà i miei 2 valori da mettere in scheda
        int input1 = 0, input2 = 0;//input che userò per inserire il valore, con riferimento *valore* e *razza*
        String statistiche[] = new String[]{"forza", "difesa", "intelligenza", "agilità", "costituzione"}; //stringa e array con gli ordinali per fare le scelte
        int statistiche_n[] = new int[]{1, 2, 3, 4, 5};
        boolean ok = false;//controlli per i cicli while
        String report1 = "hai a disposizione i seguenti valori: ";//inizializzo stringa per stampare le stat
        String report2 = "";
        int i = 0;

        report1 = "hai a disposizione i seguenti valori: ";//inizializzo stringa per stampare le stat
        for (i = 0; i < 5; i++) {//sputa fuori i valori da mettere nelle stat sopra
            int a = Utility_calcolo_valori.lanciaD(6) + 2;//2 lanci su un d6 e tengo il migliore
            int b = Utility_calcolo_valori.lanciaD(6) + 2;

            /*if(a > b)
                valori[i] = a;
            else 
                valori[i] = b;*/
            valori[i] = (a > b) ? a : b;
        }

        for (i = 0; i < 5; i++) {//stampo i valori residui
            report1 += "\n" + valori[i];
        }

        boolean verifica = false;
        while (verifica == false) {

            report2 = JOptionPane.showInputDialog(report1 + "\nSono stati estratti questi valori, vanno bene?\nSe si, premi semplicemente 'invio',"
                    + " altrimenti dimmi quanti valori desideri cambiare\ned effettuerò un unico e secondo rialncio dei valori che desideri cambiare.");

            try {
                if (report2.equalsIgnoreCase("")) {
                    input2 = 0;
                    verifica = true;
                } else {
                    input2 = Integer.parseInt(report2);
                    verifica = true;
                }
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "non hai inserito dei valori validi");
            }
        }//fine while controllo inserimento

        if (input2 > 0 && input2 < 5) {
            int stat_da_cambiare[] = new int[input2];//inizializzo
            for (int k = 0; k < stat_da_cambiare.length; k++) {

                verifica = false;
                while (verifica == false) {

                    report2 = JOptionPane.showInputDialog(report1 + "\nquale valore desideri cambiare?\nInserisci il valore del " + (k + 1) + "° numero da cambiare");

                    try {
                        stat_da_cambiare[k] = Integer.parseInt(report2);

                        if (stat_da_cambiare[k] > 0 && stat_da_cambiare[k] < 9) {
                            for (i = 0; i < 5; i++) {
                                if (stat_da_cambiare[k] == valori[i]) {// ok se trova il valore inserito
                                    verifica = true;
                                    break;
                                }
                            }
                            if (i == 5) {// non ha trovato il valore
                                JOptionPane.showMessageDialog(null, "non hai inserito dei valori validi");
                            }
                        } else {//se è un numero al di fuore del range
                            JOptionPane.showMessageDialog(null, "non hai inserito dei valori validi");
                        }

                    } catch (Exception error) {//se ha iinserito porcheria
                        JOptionPane.showMessageDialog(null, "non hai inserito dei valori validi");
                    }
                }//fine while controllo inserimento

                report1 = "";
                for (i = 0; i < 5; i++) {//stampo i valori residui
                    if (valori[i] != stat_da_cambiare[k]) {
                        if (valori[i] != 0) {
                            report1 += "\n" + valori[i];
                        } else {
                            continue;
                        }
                    } else {
                        valori[i] = 0;
                        stat_da_cambiare[k] = 99;
                        continue;
                    }
                }
            }//fine for cambio stat

            for (int k = 0; k < stat_da_cambiare.length; k++) {
                for (i = 0; i < 5; i++) {//stampo i valori residui
                    if (valori[i] != 0) {
                        continue;
                    } else {
                        int a = Utility_calcolo_valori.lanciaD(6) + 2;//2 lanci su un d6 e tengo il migliore
                        int b = Utility_calcolo_valori.lanciaD(6) + 2;
                        valori[i] = (a > b) ? a : b;
                        break;
                    }
                }
            }

        } else {//fine unico if per cambio stat
            if (input2 == 5) {
                for (i = 0; i < 5; i++) {//sputa fuori i valori da mettere nelle stat sopra
                    int a = Utility_calcolo_valori.lanciaD(6) + 2;//2 lanci su un d6 e tengo il migliore
                    int b = Utility_calcolo_valori.lanciaD(6) + 2;
                    valori[i] = (a > b) ? a : b;
                }
            }
        }

        String report = "";
        ok = false;
        int tmp[] = new int[5];//stringhe per salvare i valori randomici per settare le stat e per salvare le stat prima dell'evento di settaggio
        tmp = valori;
        int tmp2[] = new int[5];
        tmp2[0] = scheda.forza;
        tmp2[1] = scheda.difesa;
        tmp2[2] = scheda.intelligenza;
        tmp2[3] = scheda.agilità;
        tmp2[4] = scheda.costituzione;
        int j = 5;

        while (ok == false) { // per distribuzione punti statistica
            String report3 = "";//le stat attualmente settate
            //report2 = "";//le stat che non hanno ancora ricevuto un input
            int z = 0;

            while (j > 0) {
                report1 = "hai a disposizione i seguenti valori: ";//inizializzo stringa per stampare le stat
                report2 = "";//le stat che non hanno ancora ricevuto un input

                for (i = 0; i < 5; i++) {//stampo i valori residui
                    if (valori[i] != 0) {
                        report1 += "\n" + valori[i];
                    } else {
                        continue;
                    }
                    //report1 += "\n" + valori[i];
                }

                for (i = 0; i < 5; i++) {//stampo le stat che non hanno ancora ricevuto un input
                    if (statistiche_n[i] != 0) {
                        report2 += "\n" + statistiche_n[i] + ". " + statistiche[i];
                    } else {
                        continue;
                    }
                    //report1 += "\n" + valori[i];
                }

                verifica = false;
                while (verifica == false) {

                    try {
                        input1 = Integer.parseInt(JOptionPane.showInputDialog(report1 + "\nOra devi distribuire i valori nelle tue statistiche\nQuale valore desideri utilizzare?\n" + report3));

                        if (input1 > 0 && input1 < 9) {
                            for (i = 0; i < 5; i++) {
                                if (input1 == valori[i]) {// ok se trova il valore inserito
                                    verifica = true;
                                    break;
                                }
                            }
                            if (i == 5) {// non ha trovato il valore
                                JOptionPane.showMessageDialog(null, "non hai inserito dei valori validi");
                            }
                        } else {//se è un numero al di fuore del range
                            JOptionPane.showMessageDialog(null, "non hai inserito dei valori validi");
                        }

                    } catch (Exception error) {//se ha iinserito porcheria
                        JOptionPane.showMessageDialog(null, "non hai inserito dei valori validi");
                    }
                }//fine while controllo inserimento

                report1 += "\nHai deciso di usare il valore " + input1;

                verifica = false;
                while (verifica == false) {

                    try {
                        input2 = Integer.parseInt(JOptionPane.showInputDialog(report1 + "\nIn quale statistica desideri inserirlo?" + report2 + "\n" + report3));

                        if (input2 > 0 && input2 < 6) {
                            for (i = 0; i < 5; i++) {
                                if (input2 == statistiche_n[i]) {// ok se trova il valore inserito
                                    verifica = true;
                                    break;
                                }
                            }
                            if (i == 5) {// non ha trovato il valore
                                JOptionPane.showMessageDialog(null, "non hai inserito dei valori validi");
                            }
                        } else {//se è un numero al di fuore del range
                            JOptionPane.showMessageDialog(null, "non hai inserito dei valori validi");
                        }

                    } catch (Exception error) {//se ha iinserito porcheria
                        JOptionPane.showMessageDialog(null, "non hai inserito dei valori validi");
                    }
                }//fine while controllo inserimento

                z = impostaParametro(scheda, input1, input2, statistiche[input2 - 1]);
                //for che cancella valore usato
                for (i = 0; i < 5; i++) {//stampo i valori residui
                    if (valori[i] != input1) {
                        continue;
                    } else {
                        valori[i] = 0;
                        break;
                    }
                    //report1 += "\n" + valori[i];
                }
                statistiche_n[input2 - 1] = 0;
                if (report3.equalsIgnoreCase("")) {//prima stampa in report3
                    report3 = "\nI tuoi parametri attualmente sono:\n";
                }
                report3 += statistiche[input2 - 1] + " = " + z + "\n";
                //JOptionPane.showMessageDialog(null, report);
                j--;
            }

            report3 = JOptionPane.showInputDialog(report3 + "Sei soddisfatto della distribuzione dei punti statistica?\nScrivere Si o No");
            if (report3.equalsIgnoreCase("si")) {
                ok = true;
            } else {
                JOptionPane.showMessageDialog(null, "Ok, allora ridistribuisci le statistiche");
                scheda.forza = tmp2[0];
                scheda.difesa = tmp2[1];
                scheda.intelligenza = tmp2[2];
                scheda.agilità = tmp2[3];
                scheda.costituzione = tmp2[4];
                j = 5;
            }

            // FINIRE IL WHILE per benino
        }// fine while == false

    }

    static int impostaParametro(SchedaPersonaggio scheda, int input1, int input2, String statistiche) {

        switch (input2) {
            case 1://inserisci il valore in forza, ecc
                if (scheda.forza != 0) {
                    scheda.forza += input1;
                    JOptionPane.showMessageDialog(null, "il tuo parametro di " + statistiche + " è " + scheda.forza + " poichè sei " + scheda.RazzaPersonaggio[scheda.Razza]);
                    return scheda.forza;

                } else {
                    scheda.forza += input1;
                    return scheda.forza;
                }

            case 2:
                if (scheda.difesa != 0) {
                    scheda.difesa += input1;
                    JOptionPane.showMessageDialog(null, "il tuo parametro di " + statistiche + " è " + scheda.difesa + " poichè sei " + scheda.RazzaPersonaggio[scheda.Razza]);
                    return scheda.difesa;
                } else {
                    scheda.difesa += input1;
                    return scheda.difesa;
                }
            case 3:
                if (scheda.intelligenza != 0) {
                    scheda.intelligenza += input1;
                    JOptionPane.showMessageDialog(null, "il tuo parametro di " + statistiche + " è " + scheda.intelligenza + " poichè sei " + scheda.RazzaPersonaggio[scheda.Razza]);
                    return scheda.intelligenza;
                } else {
                    scheda.intelligenza += input1;
                    return scheda.intelligenza;
                }
            case 4:
                if (scheda.agilità != 0) {
                    scheda.agilità += input1;
                    JOptionPane.showMessageDialog(null, "il tuo parametro di " + statistiche + " è " + scheda.agilità + " poichè sei " + scheda.RazzaPersonaggio[scheda.Razza]);
                    return scheda.agilità;
                } else {
                    scheda.agilità += input1;
                    return scheda.agilità;
                }
            case 5:
                if (scheda.costituzione != 0) {
                    scheda.costituzione += input1;
                    JOptionPane.showMessageDialog(null, "il tuo parametro di " + statistiche + " è " + scheda.costituzione + " poichè sei " + scheda.RazzaPersonaggio[scheda.Razza]);
                    return scheda.costituzione;
                } else {
                    scheda.costituzione += input1;
                    return scheda.costituzione;
                }
        }

        return 1;
    }

}
