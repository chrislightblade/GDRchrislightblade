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
public class ClasseArmigero implements ClasseGioco{

    
    
    /*private String talenti[] = new String[5];
    private int uso[] = new int[]{0, 0, 0, 0, 0};
    private int uso_Max[] = new int[]{0, 0, 0, 0, 0};*/
    
    public ClasseArmigero(SchedaPersonaggio scheda) {
        this.talenti[0] = "Assalto";
        this.talenti[1] = "Colpo Vigoroso";
        this.talenti[2] = "Incalzare";//passiva
        this.talenti[3] = "Furia";
        this.talenti[4] = "";
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
    public void colpireConArma(SchedaPersonaggio p1, SchedaPersonaggio p2) {
        int colpire = p1.getForza() + p1.getIntelligenza() + Utility_calcolo_valori.lanciaD(12);
        int difendere = p2.getTotaleArmatura() + Utility_calcolo_valori.lanciaD(12);

        if (colpire >= difendere) {

            int danno = p1.getManoDestra().dannoArma(p1.getForza());
            //if (p1.getManoDestra().getAttributo() != 12) {
            //}
            p2.setPunti_vita(-danno);
            System.out.println("\nColpito! Danno inferto " + danno + " da " + p1.getNome() + " a " + p2.getNome() + "\nPunti vita residui " + p2.getPunti_vita() + "\n");

        } else {
            System.out.println("\nMancato!");
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
    public int usaTalento(SchedaPersonaggio scheda1, ArrayList<SchedaPersonaggio> schedaMobs) {
        int scegli = ClasseGioco.super.usaTalento(scheda1, schedaMobs);
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
        
        switch (scegli) {
                
                case 1:
                    
                case 2:
                    //int bonus = scheda.getClasse1().usaAssalto(scheda);//ClasseArmigero.usaAssalto(scheda);
                    int danno = colpoVigoroso(scheda1);
                    schedaMobs.get(inputI).setPunti_vita(-danno);
                    setUso(scegli - 1, -1);
                    System.out.println("\nColpito! Danno inferto " + danno + " da " + scheda1.getNome() + " a " + schedaMobs.get(inputI).getNome() + "\nPunti vita residui " + schedaMobs.get(inputI).getPunti_vita() + "\n");
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
    
    
    
    public int colpoVigoroso (SchedaPersonaggio scheda){
        int danno = scheda.getManoDestra().dannoArma(scheda.getForza());
        danno = danno * (scheda.getForza() - 4);        
        return danno;
    }
    
    public void usaIncalzarePassiva(){        
        
    }
    
    public void usaFuria(){        
        
    }

    

}