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

        //String NomeCognome = "";
        
        
        for(int i = 0; i < 3; i++){
        //scheda.NomeCognome[i] = creaPersonaggio.inserisciNome_Cognome(i);
        if(scheda.NomeCognome[i] == "")
            continue;
        
        switch (i) {
            case 0:
                //NomeCognome = JOptionPane.showInputDialog("Prego inserisci il nome del personaggio (solo il primo nome):");//inserimento nome pg
                scheda.NomeCognome[i] = "Chris";
                break;

            case 1:
                String selezione = "no";//JOptionPane.showInputDialog("Desideri inserire un secondo nome? Si o No");
                if (selezione.toLowerCase() == "si") //{
                    scheda.NomeCognome[i] = JOptionPane.showInputDialog("Prego inserisci il secondo nome del personaggio:");//inserimento secondo nome pg
                    
                    else
                        scheda.NomeCognome[i] = "";
                        
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
        
        //System.out.println(scheda.NomeCognome[i] + " ");
        }
        
        return;
    }//fine inserisciNome_Cognome
    
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
}
}
