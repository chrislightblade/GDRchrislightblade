/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR.Classi;

import Gioco_GDR.Personaggi.SchedaPersonaggio;
import Gioco_GDR.Utility_calcolo_valori;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public class ClasseArmigero implements ClasseGioco {

    //int talentoAttivo[] = {0, 0, 0, 0, 0};
    /*private String talenti[] = new String[5];
    private int uso[] = new int[]{0, 0, 0, 0, 0};
    private int uso_Max[] = new int[]{0, 0, 0, 0, 0};*/
    private int NumeroAttacchi = 1;
    private int bonusDannoAttacco = 0;
    int rangeCritico = 0;

    public int getRangeCritico() {
        return rangeCritico;
    }

    public void setRangeCritico() {
        this.rangeCritico += 1;
    }

    
    public ClasseArmigero(SchedaPersonaggio scheda) {
        //this.talenti[5] = "Assalto";
        this.talenti[1] = "Colpo Vigoroso";
        this.talenti[2] = "Incalzare";//passiva
        this.talenti[3] = "Furia";//influenza il numero di attacchi in  mischia per turno
        this.talenti[4] = "Rabbia";//influenza il colpire per l'attacco in mischia
        this.talenti[0] = "HealStrike";
        this.talenti[5] = "Violenza";//bonus al danno ca attacco in mischia pari al proprio livello
        this.talenti[6] = "Sferzata";
        //this.usoColpoVigoroso[1] = 1;
        //this.usoColpoVigoroso_Max[1] = 1;
        //ClasseArmigero classe = new ClasseArmigero(scheda);
        //scheda.setClasse1(classe);        
        scheda.setForza(2);
        scheda.setCostituzione(1);
        scheda.setPunti_vita_max(20 + (scheda.getCostituzione() - 4));//punti vita a creazione presonaggio
        scheda.setPunti_vita(20 + (scheda.getCostituzione() - 4));
        //String talenti[] = new String[]{"Assalto", "Colpo Vigoroso", "Incalzare", "Furia"};
        //int tabellaAssalto[][] = new int[][];
    }

    /*public int getUso(int index) {
        return this.uso[index];
    }

    public void setUso(int index, int numero) {
        this.uso[index] += numero;
    }

    public int getUso_Max(int index) {
        return this.uso_Max[index];
    }

    public void setUso_Max(int index) {
        this.uso_Max[index]++;
    }
    
    public void fullUso(int index){
        this.uso[index] = this.uso_Max[index];
    }*/
 /*public int getTalentoAttivo(int i) {
        return talentoAttivo[i];
    }

    public void setTalentoAttivo(int talentoAttivo) {
        this.talentoAttivo[talentoAttivo]++;
    }*/
    @Override
    public int colpireConArma(SchedaPersonaggio p1, ArrayList<SchedaPersonaggio> schedaMobs, ArrayList<SchedaPersonaggio> ordineBattaglia) {

        int morti = 0;
        for (int i = 1; i <= NumeroAttacchi; i++) {
            if (schedaMobs.size() == 0) {
                return morti;
            }
            int inputI = Utility_calcolo_valori.chiColpire(schedaMobs);//decidere chi colpire
            int colpire = 0;
            int lancioDado = Utility_calcolo_valori.lanciaD(12);
            colpire = p1.getForza() + p1.getIntelligenza() + lancioDado;
            if (talentoAttivo[4] != 0) {//bonus nel caso in cui il talento sia attivo
                colpire += p1.getLivello();
            }
            int difendere = schedaMobs.get(inputI).getTotaleArmatura() + Utility_calcolo_valori.lanciaD(12);

            if (colpire >= difendere) {

                int danno = p1.getManoDestra().dannoArma(p1.getForza());
                if(talentoAttivo[5] == 1){
                    danno += p1.getLivello();
                }
                if (Utility_calcolo_valori.controlloCritico(rangeCritico, lancioDado)) {
                    danno += danno;
                }
                //if (p1.getManoDestra().getAttributo() != 12) {
                //}
                schedaMobs.get(inputI).setPunti_vita(-danno);
                if(talentoAttivo[0] == 1){
                talentoHealStrike(p1);
                }
                System.out.println("\nColpito! Danno inferto " + danno + " da " + p1.getNome() + " a " + schedaMobs.get(inputI).getNome() + "\nPunti vita residui " + schedaMobs.get(inputI).getPunti_vita() + "\n");

            } else {
                System.out.println("\nMancato!");
            }
        }

        if (Utility_calcolo_valori.checkSopravvivenzaMob(schedaMobs, ordineBattaglia) > 0) {//se uccide un nemico, va in incalzare
            morti++;
            morti += usaIncalzare(p1, schedaMobs, ordineBattaglia);
            return morti;
        } else {
            morti++;
            return morti;
        }
    }

    @Override
    public String getTalenti(int i) {
        return ClasseGioco.super.getTalenti(i); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTalentoAttivo(int i) {
        return ClasseGioco.super.getTalentoAttivo(i); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTalentoAttivo(int talentoAttivo) {
        ClasseGioco.super.setTalentoAttivo(talentoAttivo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getUso(int index) {
        return ClasseGioco.super.getUso(index); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUso(int index, int numero) {
        ClasseGioco.super.setUso(index, numero); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getUso_Max(int index) {
        return ClasseGioco.super.getUso_Max(index); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUso_Max(int index) {
        ClasseGioco.super.setUso_Max(index); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fullUso(int index) {
        ClasseGioco.super.fullUso(index); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int usaTalento(SchedaPersonaggio scheda1, ArrayList<SchedaPersonaggio> schedaMobs, ArrayList<SchedaPersonaggio> ordineBattaglia) {
        int scegli = ClasseGioco.super.usaTalento(scheda1, schedaMobs, ordineBattaglia);
        int danno = 0;

        switch (scegli) {

            case 1:
                int lancioDado = Utility_calcolo_valori.lanciaD(12);
                danno = scheda1.getManoDestra().dannoArma(scheda1.getForza());
                if(talentoAttivo[5] == 1){
                    danno += scheda1.getLivello();
                }
                if (Utility_calcolo_valori.controlloCritico(rangeCritico, lancioDado)) {
                    danno += danno;
                }     
                
                for (int i = 0; i < schedaMobs.size(); i++) {
                    schedaMobs.get(i).setPunti_vita(-danno);
                }
                Utility_calcolo_valori.checkSopravvivenzaMob(schedaMobs, ordineBattaglia);
                scheda1.getClasses().setUso(1, -1);
                return 1;

            case 2:
                //int bonus = scheda.getClasse1().usaAssalto(scheda);//ClasseArmigero.usaAssalto(scheda);
                int inputI = Utility_calcolo_valori.chiColpire(schedaMobs);
                danno = colpoVigoroso(scheda1);
                schedaMobs.get(inputI).setPunti_vita(-danno);
                setUso(scegli - 1, -1);
                System.out.println("\nColpito! Danno inferto " + danno + " da " + scheda1.getNome() + " a " + schedaMobs.get(inputI).getNome() + "\nPunti vita residui " + schedaMobs.get(inputI).getPunti_vita() + "\n");
                Utility_calcolo_valori.checkSopravvivenzaMob(schedaMobs, ordineBattaglia);
                return 2;

            case 3:

            case 4:

            case 5:

        }
        return 0;
    }

    /*void applicaBonus(SchedaPersonaggio scheda) {
        scheda.setForza(2);
    }*/
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    public int usaAssalto(SchedaPersonaggio scheda) {
        int forza = scheda.getAgilità();
        int agilità = scheda.getForza();
        int danno = (forza + agilità) / 3;
        return 1;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////

    public int colpoVigoroso(SchedaPersonaggio scheda) {//COLPO PORTATO CON ENORME POTENZA
        int danno = scheda.getManoDestra().dannoArma(scheda.getForza());
        danno = danno * (scheda.getForza() - 4);
        return danno;
    }

    public int usaIncalzare(SchedaPersonaggio p1, ArrayList<SchedaPersonaggio> schedaMobs, ArrayList<SchedaPersonaggio> ordineBattaglia) {
        int morti = 0;
        boolean control = true;
        while (control == true) {//resta in incalzare fintanto che uccide almeno un nemico con l'attacco in mischia
            if (schedaMobs.size() == 0) {
                return morti;
            }
            int inputI = Utility_calcolo_valori.chiColpire(schedaMobs);//decidere chi colpire
            int colpire = 0;
            int lanciodado = Utility_calcolo_valori.lanciaD(12);
            colpire = p1.getForza() + p1.getIntelligenza() + lanciodado;
            if (talentoAttivo[4] != 0) {//bonus nel caso in cui il talento sia attivo
                colpire += p1.getLivello();
            }

            int difendere = schedaMobs.get(inputI).getTotaleArmatura() + Utility_calcolo_valori.lanciaD(12);

            if (colpire >= difendere) {

                int danno = p1.getManoDestra().dannoArma(p1.getForza());
                if (lanciodado == 12) {//se ha fatto critico, cioè max col dado
                    danno += danno;
                }
                //if (p1.getManoDestra().getAttributo() != 12) {
                //}
                schedaMobs.get(inputI).setPunti_vita(-danno);
                System.out.println("\nColpito! Danno inferto " + danno + " da " + p1.getNome() + " a " + schedaMobs.get(inputI).getNome() + "\nPunti vita residui " + schedaMobs.get(inputI).getPunti_vita() + "\n");

            } else {
                System.out.println("\nMancato!");
            }

            if (Utility_calcolo_valori.checkSopravvivenzaMob(schedaMobs, ordineBattaglia) > 0) {
                morti++;
            } else {
                control = false;
            }
        }
        return morti;
    }

    /*public void talentoRabbia() {
        bonusDannoAttacco++;
    }*/
    public void talentoFuria() {
        NumeroAttacchi++;
    }
    
    public void talentoHealStrike(SchedaPersonaggio scheda){
        scheda.setPunti_vita(scheda.getLivello());
        System.out.println("Lo HealStrike ha curato al giocatore " + scheda.getLivello());
    }
    
    public int usaSferzata

}
