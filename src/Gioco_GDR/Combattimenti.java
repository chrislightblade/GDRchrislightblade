/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR;

import Gioco_GDR.Personaggi.SchedaPersonaggio;
import Gioco_GDR.Personaggi.SchedaMostro;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * creare un metodo che tenga dell'attributo elementale dell'arma usata creare
 * metodo che colpisce con incantesimo
 *
 * @author Administrator
 */
public class Combattimenti {

    //private int valori[] = new int[]{-4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
    //-4-3-2-1 0 1 2 3 4 5  6  7  8  9 10 11
    private ArrayList<SchedaPersonaggio> schedaPgs = new ArrayList<SchedaPersonaggio>();
    private ArrayList<SchedaPersonaggio> schedaMobs = new ArrayList<SchedaPersonaggio>();
    private ArrayList<SchedaPersonaggio> ordineBattaglia = new ArrayList<SchedaPersonaggio>();

    public void setSchedaPgs(SchedaPersonaggio scheda) {
        schedaPgs.add(scheda);
    }

    public void setSchedaMobs(SchedaPersonaggio scheda) {
        schedaMobs.add(scheda);
    }

    /*public void battagliaCasuale() {   

        boolean control = true;
        int i = 0;//per estrarre in ordine i personaggi dall'arraylist dei turni
        int dado = schedaMobs.size();//dado che consente di sceglier eun nemico casuale per il simulatore casuale
        while (control == true) {
            ordineBattaglia();
            String report = "E' il turno di " + ordineBattaglia.get(i).getNome();
            //JOptionPane.showMessageDialog(null, report);
            System.out.println(report);
            if (ordineBattaglia.get(i).getNome().equalsIgnoreCase("chris")) {
                int valore = Utility_calcolo_valori.lanciaD(dado) - 1;
                ordineBattaglia.get(i).getClasses().colpireConArma(ordineBattaglia.get(i), schedaMobs);
                if (Utility_calcolo_valori.checkSopravvivenzaMob(schedaMobs, ordineBattaglia)) {
                    dado--;
                    if (dado == 0) {
                        control = false;
                    }
                }

            } else {
                ordineBattaglia.get(i).getClasses().colpireConArma(ordineBattaglia.get(i), schedaMobs);
                if (Utility_calcolo_valori.checkSopravvivenzaPG(schedaPgs, ordineBattaglia)) {
                    control = false;
                }
            }
            i++;
            if (i == ordineBattaglia.size()) {
                i = 0;
            }
        }
        if (schedaPgs.get(0).getPunti_vita() > 0) {
            System.out.println("Hai vinto!");
        } else {
            System.out.println("Hai peros!");
        }
    }*/

    public void battaglia() {

        int pgAttivi = schedaPgs.size();
        boolean control = true;
        int inputI = 0;        
        int i = 0;//per estrarre in ordine i personaggi dall'arraylist dei turni
        int dado = schedaMobs.size();//dado che consente di sceglier eun nemico casuale per il simulatore casuale
        while (control == true) {
            String report2 = ordineBattaglia();
            String report = "E' il turno di " + ordineBattaglia.get(i).getNome();
            //JOptionPane.showMessageDialog(null, report);
            System.out.println(report);
            if (Utility_calcolo_valori.toccaA_PG(schedaPgs, ordineBattaglia.get(i).getNome())) {//se tocca al giocatore attivo
                //int valore = Utility_calcolo_valori.lanciaD(dado) - 1;
                report = "";
                for (int j = 0; j < schedaMobs.size(); j++) {//stampa una String con i nomi dei nemici tra cui scegliere
                    report += (j + 1) + "." + schedaMobs.get(j).getNome() + "\n";
                }

                String input2 = JOptionPane.showInputDialog("\nCon cosa desideri colpire?\nCon 1 attacco semplice, con 2 usi un talento");
                inputI = Integer.parseInt(input2) - 1;
                int morti = 0;
                if (inputI == 0) {//se hai scelto attacco base
                    morti = ordineBattaglia.get(i).getClasses().colpireConArma(ordineBattaglia.get(i), schedaMobs, ordineBattaglia);
                } else {
                    ordineBattaglia.get(i).getClasses().usaTalento(ordineBattaglia.get(i), schedaMobs);
                    morti = Utility_calcolo_valori.checkSopravvivenzaMob(schedaMobs, ordineBattaglia);
                }
                
                if (morti >0) {
                    dado -= morti;
                    if (dado == 0) {
                        control = false;
                    }
                }
            } else {
                ordineBattaglia.get(i).getClasses().colpireConArma(ordineBattaglia.get(i), schedaPgs, ordineBattaglia);
                if (Utility_calcolo_valori.checkSopravvivenzaPG(schedaPgs, ordineBattaglia)) {
                    pgAttivi--;
                    if(pgAttivi == 0){
                    control = false;
                    }
                }
            }
            i++;
            if (i == ordineBattaglia.size()) {
                i = 0;
            }
        }
        if (schedaPgs.get(0).getPunti_vita() > 0) {
            System.out.println("Hai vinto!");
        } else {
            System.out.println("Hai peros!");
        }

    }
    
    public String ordineBattaglia() {//metodo che definisce l'ordine dei turni in base all'agilità dei personaggi
        ordineBattaglia.clear();
        ArrayList<SchedaPersonaggio> scheda_tmp = new ArrayList<SchedaPersonaggio>();
        //ArrayList<SchedaPersonaggio> schedaMobs_tmp = new ArrayList<SchedaPersonaggio>();
        String report = "\nL'ordine di battaglia è: \n";
        for (int i = 0; i < schedaPgs.size(); i++) {
            scheda_tmp.add(schedaPgs.get(i));
        }
        for (int i = 0; i < schedaMobs.size(); i++) {
            scheda_tmp.add(schedaMobs.get(i));
        }
        int index;
        int durata = scheda_tmp.size();
        for (int i = 0; i < durata; i++) {
            index = 0;
            for (int j = 0; j < scheda_tmp.size(); j++) {
                if (scheda_tmp.get(index).getAgilità() < scheda_tmp.get(j).getAgilità()) {//uso l'index per creare l'arraylist dell'ordine turno
                    index = j;                                                            //prendo il più veloce, lo tolgo dal tmp e lo metto nell'ordine e passo ai restanti
                }
            }
            ordineBattaglia.add(scheda_tmp.get(index));
            report += ordineBattaglia.get(i).getNome() + "\n";
            scheda_tmp.remove(index);
        }
        return report;
    }

    public void colpireConIncantesimo(SchedaPersonaggio p1, SchedaPersonaggio p2) {

    }

    /*private void colpiredelNemico(SchedaPersonaggio scheda) {

        int difendere = valoreTotaleArmaturapg(scheda) + (random.nextInt(20) + 1);
        int colpire = forza_mostro[0] + intelligenza_mostro[0] + bonus_colpire_mostro[0] + (random.nextInt(20) + 1);

        if (colpire > difendere) {
            int danno = danno_arma_mostro[0] + forza_mostro[0] - 4;
            punti_vitapg -= danno;
        }
    }*/
}
