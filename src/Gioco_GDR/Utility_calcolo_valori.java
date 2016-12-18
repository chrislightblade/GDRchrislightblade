/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR;

import Gioco_GDR.Personaggi.SchedaPersonaggio;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class Utility_calcolo_valori {

    // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
    //-4-3-2-1 0 1 2 3 4 5  6  7  8  9 10 11
    public static int lanciaD(int dado) {//Utility_calcolo_valori.lanciaD(int dado);
        Random random = new Random();
        int valore = random.nextInt(dado) + 1;
        return valore;
    }

    public static int lanciaD2(int dado) {
        int valore = (int) Math.floor(Math.random() * dado) + 1;
        return valore;

    }

    public static boolean controlloCritico(int range, int lancioDado) {//Utility_calcolo_valori.controlloCritico(range, lancioDado)
        if (lancioDado >= (20 - range)) {
            return true;
        }
        return false;
    }

    public static boolean toccaA_PG(ArrayList<SchedaPersonaggio> schedaPgs, String nome) {//Utility_calcolo_valori.toccaA_PG(schedaPgs, String nome)

        for (int j = 0; j < schedaPgs.size(); j++) {
            if (nome.equalsIgnoreCase(schedaPgs.get(j).getNome())) {
                return true;
            }
        }
        return false;
    }

    //metodo per decidere chi colpire dei nemici
    public static int chiColpire(ArrayList<SchedaPersonaggio> schedaMobs) {//int inputI = Utility_calcolo_valori.chiColpire(schedaMobs);
        String report = "";

        for (int j = 0; j < schedaMobs.size(); j++) {//stampa una String con i nomi dei nemici tra cui scegliere
            report += (j + 1) + "." + schedaMobs.get(j).getNome() + "\n";
        }
        int inputI = 0;
        boolean verifica = false;
        while (verifica == false) {

            String input = JOptionPane.showInputDialog("\nChi desideri colpire?\n" + report);

            try {
                inputI = Integer.parseInt(input) - 1;
                if (inputI < schedaMobs.size() && inputI >= 0) {
                    verifica = true;
                }
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "non hai inserito dei valori validi");
            }
        }//fine while controllo inserimento

        return inputI;
    }

    /*
    @Override//per avere un memo della versione originale
    public void colpireConArma(SchedaPersonaggio p1, ArrayList<SchedaPersonaggio> schedaMobs) {

        int inputI = Utility_calcolo_valori.chiColpire(schedaMobs);

        int colpire = p1.getForza() + p1.getIntelligenza() + Utility_calcolo_valori.lanciaD(12);
        int difendere = schedaMobs.get(inputI).getTotaleArmatura() + Utility_calcolo_valori.lanciaD(12);

        if (colpire >= difendere) {

            int danno = p1.getManoDestra().dannoArma(p1.getForza());
            //if (p1.getManoDestra().getAttributo() != 12) {
            //}
            schedaMobs.get(inputI).setPunti_vita(-danno);
            System.out.println("\nColpito! Danno inferto " + danno + " da " + p1.getNome() + " a " + schedaMobs.get(inputI).getNome() + "\nPunti vita residui " + schedaMobs.get(inputI).getPunti_vita() + "\n");

        } else {
            System.out.println("\nMancato!");
        }
    }
     */
    //metodo che verifica se un nemico è ancora vivo, o un presonaggio
    //ritorna quanti ne  sono morti, per ridurre il range dei mob nel metodo combattimento
    public static int checkSopravvivenzaMob(ArrayList<SchedaPersonaggio> schedaMobs, ArrayList<SchedaPersonaggio> ordineBattaglia) {//Utility_calcolo_valori.checkSopravvivenzaMob(schedaMobs, ordineBattaglia)

        int morti = 0;
        /*int pv = p2.getPunti_vita();
        if (pv <= 0) {
            System.out.println(p2.getNome() + " è esausto\n");*/
        int j = 0;
        for (j = 0; j < schedaMobs.size(); j++) {
            if (schedaMobs.get(j).getPunti_vita() <= 0) {
                System.out.println(schedaMobs.get(j).getNome() + " è esausto\n");
                for (int i = 0; i < ordineBattaglia.size(); i++) {
                    if (schedaMobs.get(j).getNome().equalsIgnoreCase(ordineBattaglia.get(i).getNome())) {
                        ordineBattaglia.remove(j);
                        schedaMobs.remove(j);
                        morti++;
                    }//if conclusivo
                }//for per togliere da ordinebattaglia
            }//if se trova un mob esausto
        }//for per cercare un mob esausto
        return morti;
    }

    public static boolean checkSopravvivenzaPG(ArrayList<SchedaPersonaggio> schedaPgs, ArrayList<SchedaPersonaggio> ordineBattaglia) {//Utility_calcolo_valori.checkSopravvivenzaPG(schedaPgs, ordineBattaglia)

        /*int pv = p2.getPunti_vita();
        if (pv <= 0) {
            System.out.println(p2.getNome() + " è esausto\n");*/
        int j = 0;
        for (j = 0; j < schedaPgs.size(); j++) {
            if (schedaPgs.get(j).getPunti_vita() <= 0) {
                System.out.println(schedaPgs.get(j).getNome() + " è esausto\n");
                for (int i = 0; i < ordineBattaglia.size(); i++) {
                    if (schedaPgs.get(j).getNome().equalsIgnoreCase(ordineBattaglia.get(i).getNome())) {
                        ordineBattaglia.remove(j);
                        schedaPgs.remove(j);
                        return true;
                    }//if conclusivo
                }//for per togliere da ordinebattaglia
            }//if se trova un mob esausto
        }//for per cercare un mob esausto
        return false;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //versione originale check sopravvivenza, ma per tutti, sia mob che pg
    /*int pv = p2.getPunti_vita();
        if (pv <= 0) {
            System.out.println(p2.getNome() + " è esausto\n");
            int j = 0;
            for (j = 0; j < ordineBattaglia.size(); j++) {
                if (p2.getNome().equalsIgnoreCase(ordineBattaglia.get(j).getNome())) {
                    //ordineBattaglia.remove(j);
                    for (int i = 0; i < schedaMobs.size(); i++) {
                        if (p2.getNome().equalsIgnoreCase(schedaMobs.get(i).getNome())) {
                            schedaMobs.remove(i);
                            return true;
                        }//if
                    }//for
                    for (int i = 0; i < schedaPgs.size(); i++) {
                        if (p2.getNome().equalsIgnoreCase(schedaPgs.get(i).getNome())) {
                            schedaPgs.remove(i);
                            return true;
                        }//if
                    }//for

                }//if grande
            }
        }
        return false;
    }*/
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
