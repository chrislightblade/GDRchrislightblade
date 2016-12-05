/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR;

import Gioco_GDR.Classi.ClasseMagicante;
import Gioco_GDR.Classi.ClasseArmigero;
import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public class CreaPersonaggio {

    public static void inserisciNome_Cognome(SchedaPersonaggio scheda) {
        //ClasseArmigero armigero = new ClasseArmigero(scheda);
        //armigero.
        

        String nome = "Chris";
        //nome = JOptionPane.showInputDialog("Prego inserisci il nome del personaggio (solo il primo nome):");//inserimento nome pg
        String secondoNome = "si";//JOptionPane.showInputDialog("Desideri inserire un secondo nome? Si o No");
        if (secondoNome.toLowerCase() == "si") {
            secondoNome = "Legeth";//secondoNome = JOptionPane.showInputDialog("Prego inserisci il secondo nome del personaggio:");//inserimento secondo nome pg          

        } else {
            secondoNome = "";
        }
        String cognome = "Lightblade";//JOptionPane.showInputDialog("Prego inserisci il Cognome del personaggio:\n");//inserimento cognome

        scheda.setNomeCognome(nome, secondoNome, cognome);

    }//fine inserisciNome_Cognome

    public static void scegliRazza(SchedaPersonaggio scheda) {
        String Razza1 = "";

        do {//ciclo per visualizzare le informazioni sulle razze

            boolean verifica = false;
            while (verifica == false) {

                Razza1 = JOptionPane.showInputDialog("Prego inserisci la razza del tuo personaggio:\npuoi scegliere:\nDigita 1 se desideri essere 'Umano'\n" + "Digita 2 se desideri essere 'Nano'\n"
                        + "Digita 3 se desideri essere 'Elfo'\n" + "Digita 4 se desideri essere 'Dracolide'\n" + "Digita 5 se desideri essere 'Vergheuden'\n"
                        + "Se desideri invece informazioni sulle razze, digita 6.\n");

                try {

                    if (Razza1.equalsIgnoreCase("")) {// se fai solo invio vai alle spiegazioni
                        scheda.setRazza(5);
                    } else {//altrimenti prova il parseInt
                        scheda.setRazza((Integer.parseInt(Razza1) - 1));
                    }

                    if (scheda.getRazza() == 5) {// al 5 vai alle spiegazioni
                        spiegaRazza(scheda);
                    } else {
                        if (scheda.getRazza() >= 0 && scheda.getRazza() < 6) {// sono valori validi
                            verifica = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "non hai inserito dei valori validi");//altrimenti hai messo un numero non accettabile
                            scheda.setRazza(-1);
                        }
                    }
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(null, "non hai inserito dei valori validi");
                    scheda.setRazza(-1);
                }

            }//fine while controllo inserimento

        } while (scheda.getRazza() == -1);//while per visualizzare info sulle razze

        valoriRazza(scheda);//inserisco i bonus e i malus delle razze nella scheda
        System.out.println("Razza personaggio: " + scheda.getRazzaPersonaggio() + "\n");
    }//fine scegliRazza()

    public static void spiegaRazza(SchedaPersonaggio scheda) {//switch per aver espiegazioni sulle razze

        while (scheda.getRazza() != -1) {

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
                    scheda.setRazza(-1);

            }//switch descrizione razze            

            if (scheda.getRazza() != -1) {
                JOptionPane.showMessageDialog(null, frase);
            }
        }

        scheda.setRazza(-1);

    }

    public static void valoriRazza(SchedaPersonaggio scheda) {

        switch (scheda.getRazza()) {// a seconda della razza scelta implementa dei parametri specifici
            case 0://umano               
                scheda.setExp(10);
                scheda.setTalentiAttivi(1);
                break;

            case 1://nano
                scheda.setCostituzione(1);
                scheda.setAgilità(-1);
                break;

            case 2://elfo
                scheda.setAgilità(1);
                scheda.setCostituzione(-1);
                break;

            case 3://dracolide
                scheda.setForza(1);
                scheda.setTotaleArmatura(2);
                break;

            case 4://vergheuden
                scheda.setTotaleArmatura(3);
                break;

            //case 5: //Faithy    
        }//fine switch

    }// fine valorizzaRazza

    public static void scegliClasse(SchedaPersonaggio scheda) {
        String Classe1 = "";

        do {//ciclo per visualizzare le informazioni sulle classi

            boolean verifica = false;
            while (verifica == false) {

                Classe1 = JOptionPane.showInputDialog(" Prego inserisci la classe del tuo personaggio:\n puoi scegliere:\nDigita 1 se desideri essere 'Armigero'\n" + "Digita 2 se desideri essere 'Magicante'\n"
                        //+ "Digita 3 se desideri essere 'Shadow'\n" + "Digita 4 se desideri essere 'Elementalista'\n" + "Digita 5 se desideri essere 'Feral'\n "
                        + "Se desideri invece informazioni sulle classi, digita 6.\n");

                try {

                    if (Classe1.equalsIgnoreCase("")) {// se fai solo invio vai alle spiegazioni
                        scheda.setClasse(5);
                    } else {//altrimenti prova il parseInt
                        scheda.setClasse((Integer.parseInt(Classe1) - 1));
                    }

                    if (scheda.getClasse() == 5) {// al 5 vai alle spiegazioni
                        spiegaClasse(scheda);
                    } else {
                        if (scheda.getClasse() >= 0 && scheda.getClasse() < 2) {// sono valori validi
                            verifica = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "non hai inserito dei valori validi");//altrimenti hai messo un numero non accettabile
                            scheda.setClasse(-1);
                        }
                    }
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(null, "non hai inserito dei valori validi");
                    scheda.setClasse(-1);
                }

            }// fine while controllo inserimento

        } while (scheda.getClasse() == -1);//while per visualizzare info sulle classi

        //creaClasse(scheda.getClasse(), scheda);//creo la variabile della classe relativa nella scheda per richiamare le techniche e altre cose;
        System.out.println("Classe Personaggio: " + scheda.getClassi() + "\n");
    }//fine scegliClasse()

    public static void spiegaClasse(SchedaPersonaggio scheda) {//switch per aver espiegazioni sulle razze

        while (scheda.getClasse() != -1) {

            String frase = "Hai inserito un valore non valido";//output nel caso in cui meta un valore non accettabile != 0

            String choice1 = JOptionPane.showInputDialog("Digitare:\n1 per avere informazioni su 'Armigero' \n2 per avere infomazioni su 'Magicante'"
                    +//\n"
                    /*+ ".3 per avere informazioni su 'Shadow'\n.4 per avere informazioni su 'Elementalista'*/ "\naltrimenti digitare 0.");// .5 per avere infomazioni su 'Vergheuden'\n"+ "altrimenti digitare 0.");

            int choice;
            if (choice1.equalsIgnoreCase("")) {
                choice = 0;
            } else {
                choice = Integer.parseInt(choice1);
            }
            switch (choice) {
                case 1://Armigero
                    frase = "Classe dedita al combattimento corpo a corpo, usa la forza, la velocità e l'istinto\nper afforntare i più temibili nemici.";
                    frase += "Scegliere questa claasse offre un bonus immediato di +2 alla Forza e +1 alla Costituzione,\nseguito ovviamente dalla scelta dei talenti annessi.\n";
                    break;

                case 2://Magicante
                    frase = "Classe specializzata nell'uso della magia e di tutte le sue sfaccettature,\nil talento e la riflessione sono i suoi migliori amici.";
                    frase += "Scegliere questa claasse offre un bonus immediato di +4 alle cariche magiche,\nseguito ovviamente dalla scelta dei talenti annessi.\n";
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
                    scheda.setClasse(-1);
                    break;

            }//switch descrizione razze            

            if (scheda.getClasse() != -1) {
                JOptionPane.showMessageDialog(null, frase);
            }
        }

        scheda.setClasse(-1);

    }

    /*public static void creaClasse(int classe, SchedaPersonaggio scheda) {

        switch (classe) {
            case 0:
                ClasseArmigero classepg = new ClasseArmigero(scheda);
                scheda.setClasse_pg(classepg);
                break;

            case 1:
                ClasseMagicante classepg2 = new ClasseMagicante(scheda);
                scheda.setClasse_pg(classepg2);
                break;

        }
        
    }*/
    public static void scegliTalentiClasseArmigero(SchedaPersonaggio scheda, ClasseArmigero classe_pg) {
        int j = 0;
        while (j < scheda.getTalentiAttivi()) {//1 giro normalmente, 2 se umano
            String frase;
            frase = "Puoi scegliere " + scheda.getTalentiAttivi() + " talento/i di classe.\n";

            for (int i = 0; i < 4; i++) {// i talenti non ancora attivi e funzionanti hanno valore 0, mentre quelli attivi hanno valore 1. Stampo gli 0.
                if (classe_pg.getTalentoAttivo(i) == 0) {
                    frase += (i + 1) + "." + classe_pg.getTalenti(i) + "\n";
                }
            }

            boolean verifica = false;
            while (verifica == false) {

                String report2 = JOptionPane.showInputDialog("Quale talento desideri attivare?\nPer informazioni, digitare 6.\n" + frase);

                try {
                    if (report2.equals("")) {
                        spiegaTalentiArmigero();                        
                    }

                    int input2 = Integer.parseInt(report2);
                    if (input2 > 0 && input2 < 6) {
                        classe_pg.setTalentoAttivo(input2 - 1);
                        verifica = true;
                        j++;
                    } else {
                        if (input2 == 6) {
                            spiegaTalentiArmigero();
                            input2 = 0;
                        }

                    }
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(null, "non hai inserito dei valori validi");
                }
            }//fine while controllo inserimento
        }
    }

    public static void spiegaTalentiArmigero() {//switch per aver espiegazioni sulle razze

        int choice = -1;
        while (choice != 0) {
            choice = -1;

            String frase = "Hai inserito un valore non valido";//output nel caso in cui meta un valore non accettabile != 0

            String choice1 = JOptionPane.showInputDialog("Digitare:\n1 per avere informazioni su 'Assalto' \n2 per avere infomazioni su 'Colpo Vigoroso'"
                    + "\n3 per avere informazioni su 'Incalzare'\n4 per avere informazioni su 'Furia'\naltrimenti digitare 0.");// .5 per avere infomazioni su 'Vergheuden'\n"+ "altrimenti digitare 0.");

            if (choice1.equalsIgnoreCase("")) {
                choice = 0;
            } else {
                choice = Integer.parseInt(choice1);
            }
            switch (choice) {
                case 1://assalto
                    frase = "Questo talento consente all'armigero di sferrare una attacco fisico con colpire automatico\nche infligge un danno proporzionale alla forza e alla agilità.";
                    frase += ",\n.\n";
                    break;

                case 2://colpo vigoro
                    frase = "Un colpo fisico tremendamente violento utilizzabile alcune volte in battaglia\nche basa la sua potenza sulla forza fissica del personaggio.";
                    frase += ",\n.\n";
                    break;

                case 3://incalzare
                    frase = "Durante lo scontro, nel caso in cui si sferri un colpo mortale,\nquesto talento consente di sferrare un attaco aggiuntivo,\nsenza attender il prossimo turno.";
                    frase += "\n.\n";
                    break;

                case 4://furia
                    frase = ",\n.";
                    frase += "\n.\n";
                    break;

                /*case 5:
                    frase = "Razza misteriosa, dall'aspetto metallico e minaccioso,\npossono rivelare sorprese inaspettate";
                    frase += "La razza Vergheuden offre un bonus alla CA di +3 e consente \ndi usare 'Stridore', tecnica che stordisce il nemico per 2 turni.\n";
                    break;*/
                case 0:
                    break;

            }//switch descrizione razze            

            if (choice != 0) {
                JOptionPane.showMessageDialog(null, frase);
            }
        }
    }

    public static void scegliTalentiClasseMagicante(SchedaPersonaggio scheda, ClasseMagicante classe_pg) {
        int j = 0;
        while (j < scheda.getTalentiAttivi()) {//1 giro normalmente, 2 se umano
            String frase;
            frase = "Puoi scegliere " + scheda.getTalentiAttivi() + " talento/i di classe.\nIl talento 'Ricarica' è già attivo";

            for (int i = 0; i < 4; i++) {// i talenti non ancora attivi e funzionanti hanno valore 0, mentre quelli attivi hanno valore 1. Stampo gli 0.
                if (classe_pg.getTalentoAttivo(i) == 0) {
                    frase += (i + 1) + "." + classe_pg.getTalenti(i) + "\n";
                }
            }

            boolean verifica = false;
            while (verifica == false) {

                String report2 = JOptionPane.showInputDialog("Quale talento desideri attivare?\nPer informazioni, digitare 6.\n" + frase);

                try {
                    if (report2.equals("")) {
                        spiegaTalentiMagicante();                        
                    }

                    int input2 = Integer.parseInt(report2);
                    if (input2 > 0 && input2 < 6) {
                        classe_pg.setTalentoAttivo(input2 - 1);
                        verifica = true;
                        j++;
                    } else {
                        if (input2 == 6) {
                            spiegaTalentiMagicante();
                            input2 = 0;
                        }

                    }
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(null, "non hai inserito dei valori validi");
                }
            }//fine while controllo inserimento
        }
    }

    public static void spiegaTalentiMagicante() {//switch per aver espiegazioni sulle razze

        int choice = -1;
        while (choice != 0) {
            choice = -1;

            String frase = "Hai inserito un valore non valido";//output nel caso in cui meta un valore non accettabile != 0

            String choice1 = JOptionPane.showInputDialog("Digitare:\n1 per avere informazioni su 'Ricarica' \n2 per avere infomazioni su 'Ottimizzazione'"
                    + "\n3 per avere informazioni su 'Doppio Lancio'\n.4 per avere informazioni su 'Potenza Arcana'\naltrimenti digitare 0.");// .5 per avere infomazioni su 'Vergheuden'\n"+ "altrimenti digitare 0.");

            if (choice1.equalsIgnoreCase("")) {
                choice = 0;
            } else {
                choice = Integer.parseInt(choice1);
            }
            switch (choice) {
                case 1://Ricarica
                    frase = "Ottieni la capacità di spendere Cariche Elementali per ricaricare le Cariche Magiche,\ne lo puoi fare anche durante uno scontro.";
                    frase += "Inizialmente puoi spendere una C.E. per ricaricare 3 C.M,\npoi il valore ricaricato cresce col livello del personaggio.";
                    break;

                case 2://Ottimizzazione
                    frase = ",\n.";
                    frase += ",\n.\n";
                    break;

                case 3://Doppio Lancio
                    frase = "Questo talento ti consente di lanciare 2 incantesimi nello stesso turno,\nma per farlo il prossimo incantesimo costerà una C.M. in più.";
                    frase += "\n.\n";
                    break;

                case 4://Potenza Arcana
                    frase = "Questo talento consente di spendere un certo ammontare di C.M, C.E. o C.T.\nper aumentare la potenza degli incantesimi"; //o aggiungere effetti a questi ultimi";
                    frase += "\n.\n";
                    break;

                /*case 5:
                    frase = "Razza misteriosa, dall'aspetto metallico e minaccioso,\npossono rivelare sorprese inaspettate";
                    frase += "La razza Vergheuden offre un bonus alla CA di +3 e consente \ndi usare 'Stridore', tecnica che stordisce il nemico per 2 turni.\n";
                    break;*/
                case 0:
                    break;

            }//switch descrizione razze            

            if (choice == -1) {
                JOptionPane.showMessageDialog(null, frase);
            }
        }
    }

    public static void impostaStatistiche(SchedaPersonaggio scheda) {

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
                    if (input2 >= 0 && input2 <= 5) {
                        verifica = true;
                    }

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

        for (int k = 0; k < 5; k++) {
            tmp[k] = valori[k];
        }

        int tmp2[] = new int[5];
        tmp2[0] = scheda.getForza();
        tmp2[1] = scheda.getDifesa();
        tmp2[2] = scheda.getIntelligenza();
        tmp2[3] = scheda.getAgilità();
        tmp2[4] = scheda.getCostituzione();
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

            if (report3.equalsIgnoreCase("si") || report3.equalsIgnoreCase("")) {
                ok = true;
            } else {
                if (report3.equalsIgnoreCase("no")) {
                    JOptionPane.showMessageDialog(null, "Ok, allora ridistribuisci le statistiche");//azzera le modifiche e riporta a valore di inizio
                    j = scheda.getForza();
                    scheda.setForza(-j);
                    scheda.setForza(tmp2[0]);

                    j = scheda.getDifesa();
                    scheda.setDifesa(-j);
                    scheda.setDifesa(tmp2[1]);

                    j = scheda.getIntelligenza();
                    scheda.setIntelligenza(-j);
                    scheda.setForza(tmp2[2]);

                    j = scheda.getAgilità();
                    scheda.setAgilità(-j);
                    scheda.setAgilità(tmp2[3]);

                    j = scheda.getCostituzione();
                    scheda.setCostituzione(-j);
                    scheda.setCostituzione(tmp2[4]);

                    j = 5;

                    for (int k = 0; k < 5; k++) {
                        valori[k] = tmp[k];
                    }

                    for (int k = 0; k < 5; k++) {
                        statistiche_n[k] = (k + 1);
                    }
                }//if equals no
            }//else equals si

        }// fine while ok == false

    }

    public static int impostaParametro(SchedaPersonaggio scheda, int input1, int input2, String statistiche) {

        switch (input2) {
            case 1://inserisci il valore in forza, ecc
                if (scheda.getForza() != 0) {
                    scheda.setForza(input1);
                    JOptionPane.showMessageDialog(null, "il tuo parametro di " + statistiche + " è " + scheda.getForza() + " poichè sei " + scheda.getRazzaPersonaggio());
                    return scheda.getForza();

                } else {
                    scheda.setForza(input1);
                    return scheda.getForza();
                }

            case 2:
                if (scheda.getDifesa() != 0) {
                    scheda.setDifesa(input1);
                    JOptionPane.showMessageDialog(null, "il tuo parametro di " + statistiche + " è " + scheda.getDifesa() + " poichè sei " + scheda.getRazzaPersonaggio());
                    return scheda.getDifesa();
                } else {
                    scheda.setDifesa(input1);
                    return scheda.getDifesa();
                }
            case 3:
                if (scheda.getIntelligenza() != 0) {
                    scheda.setIntelligenza(input1);
                    JOptionPane.showMessageDialog(null, "il tuo parametro di " + statistiche + " è " + scheda.getIntelligenza() + " poichè sei " + scheda.getRazzaPersonaggio());
                    return scheda.getIntelligenza();
                } else {
                    scheda.setIntelligenza(input1);
                    return scheda.getIntelligenza();
                }
            case 4:
                if (scheda.getAgilità() != 0) {
                    scheda.setAgilità(input1);
                    JOptionPane.showMessageDialog(null, "il tuo parametro di " + statistiche + " è " + scheda.getAgilità() + " poichè sei " + scheda.getRazzaPersonaggio());
                    return scheda.getAgilità();
                } else {
                    scheda.setAgilità(input1);
                    return scheda.getAgilità();
                }
            case 5:
                if (scheda.getCostituzione() != 0) {
                    scheda.setCostituzione(input1);
                    JOptionPane.showMessageDialog(null, "il tuo parametro di " + statistiche + " è " + scheda.getCostituzione() + " poichè sei " + scheda.getRazzaPersonaggio());
                    return scheda.getCostituzione();
                } else {
                    scheda.setCostituzione(input1);
                    return scheda.getCostituzione();
                }
        }

        return 1;
    }

}
