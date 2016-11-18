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
        String NomeCognome[] = new String[3];
        boolean controllo = false;
        int i = 0, j = 0;
        int Razza = 0;
        String RazzaPersonaggio[] = new String[] {"Umano", "Nano", "Elfo", "Dracolide", "Vergheuden" };
        
        while (i < 3) {
            NomeCognome[i] = inserisciNome_Cognome(i);
            i++;
        }//fine while inserimento nome e cognome

        System.out.println("Nome personaggio: " + NomeCognome[0] + NomeCognome[1] + "\nCognome personaggio: " + NomeCognome[2] + "\n");

        Razza = scegliRazza();
        
        System.out.println("razza personaggio: " + RazzaPersonaggio[Razza - 1] + "\n");
        
    }

    
    static String inserisciNome_Cognome(int i) {

        String NomeCognome = "";
        NomeCognome = "Chris";

        switch (i) {
            case 0:
                //NomeCognome = JOptionPane.showInputDialog("Prego inserisci il nome del personaggio (solo il primo nome):");//inserimento nome pg
                return NomeCognome;

            case 1:
                String selezione = "no";//JOptionPane.showInputDialog("Desideri inserire un secondo nome? Si o No");
                if (selezione.toLowerCase() == "si") {
                    NomeCognome = JOptionPane.showInputDialog("Prego inserisci il secondo nome del personaggio:");//inserimento secondo nome pg
                    return NomeCognome;

                } else {
                    NomeCognome = "";
                    return NomeCognome;

                }

            case 2:
                NomeCognome = "Lightblade";//JOptionPane.showInputDialog("Prego inserisci il Cognome del personaggio (ed eventuale secondo nome):\n");//inserimento cognome e secondo nome
                return NomeCognome;

        }//fine switch
        return NomeCognome;

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
    }//fine metodo scegliRazza()

    static Integer spiega_razza(int Razza) {
        if (Razza == 6) {
            String choice1 = JOptionPane.showInputDialog("Digitare:\n .1 per avere informazioni su 'Umano' \n .2 per avere infomazioni su 'Elfo'\n"
                    + " .3 per avere informazioni su 'Nano'\n .4 per avere informazioni su 'Dracolo'\n .5 per avere infomazioni su 'Vergheuden'\n"
                    + "altrimenti digitare 0.");

            int choice = Integer.parseInt(choice1);
            switch (choice) {
                case 1:
                    JOptionPane.showMessageDialog(null, "La razza Umano offre un bonus all'esperienza del 10% e consente \ndi scegliere un secondo talento");
                    JOptionPane.showMessageDialog(null, "Seppur non sia la razza più forte fisicamente\n, possiede grandi capacità adattive e di apprendimento");
                    Razza = 0;
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "La razza Elfo offre un bonus all'agilità pari a +1 e un malus alla costituzione di -1, ma \nconsente di avere bonus con le armi leggere e quelle da tiro\n");
                    JOptionPane.showMessageDialog(null, "Creature molto sensibili alla natura e dalla gracile costituzione,\npossiedono un'agilità senza pari.");
                    Razza = 0;
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "La razza Nano offre un bonus alla costituzione di +1 e un malus all'agilità di -1 \n ma consente di avere un bonus con le armi pesanti e con le armi da lancio\n");
                    JOptionPane.showMessageDialog(null, "Creature basse, corpulente e devote alla terra,\nfanno degli avi e il loro corpo il loro tesoro più prezioso");
                    Razza = 0;
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "La razza Dracolo offre un bonus alla forza e alla CA di +1 \n e hanno il danno a mani nude aumentato di una unità");
                    JOptionPane.showMessageDialog(null, "Discendenti dei draghi, con ali e coda,\nvivono nell'attesa del risveglio del loro soffio elementale");
                    Razza = 0;
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "La razza Vergheuden offre un bonus alla CA di +3 e consente \ndi usare 'Stridore', tecnica che stordisce il nemico per 2 turni");
                    JOptionPane.showMessageDialog(null, "Razza misteriosa, dall'aspetto metallico e minaccioso,\npossono rivelare sorprese inaspettate");
                    Razza = 0;
                    break;
                case 0:
                    Razza = 0;
                    break;

            }//switch descrizione razze
        }//if x andare in switch

        return Razza;

    }
    
}

/*public scegli_classe_con_cui_giocare (){
        
    }
    }*/
