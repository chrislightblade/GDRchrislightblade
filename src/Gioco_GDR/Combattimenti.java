/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR;

import java.util.Random;

/**
 *
 * @author Administrator
 */
public class Combattimenti {

    private int valori[] = new int[]{-4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
    //-4-3-2-1 0 1 2 3 4 5  6  7  8  9 10 11
    private int forzapg;
    private int agilitàpg;
    private int difesapg;
    private int intelligenzapg;
    private int costituzionepg;
    private int punti_vitapg;
    private int cariche_magichepg;
    private int cariche_tecnichepg;
    private int cariche_elementalipg;
    //private int perforarepg = personaggio.perforare;
    private int bonus_colpirepg;
    private int danno_armapg;
    private int totale_armaturapg;

    private int forza_mostro[] = new int[10];
    private int agilità_mostro[] = new int[10];
    private int difesa_mostro[] = new int[10];
    private int intelligenza_mostro[] = new int[10];
    private int costituzione_mostro[] = new int[10];
    private int punti_vita_mostro[] = new int[10];
    private int cariche_magiche_mostro[] = new int[10];
    private int cariche_tecniche_mostro[] = new int[10];
    private int cariche_elementali_mostro[] = new int[10];
    private int bonus_colpire_mostro[] = new int[10];
    private int totale_armatura_mostro[] = new int[10];
    private int danno_arma_mostro[] = new int[10];

    Random random = new Random();//uso un dado

    public Combattimenti(SchedaPersonaggio scheda) {
        this.forzapg = scheda.getForza();
        this.agilitàpg = scheda.getAgilità();
        this.difesapg = scheda.getDifesa();
        this.intelligenzapg = scheda.getIntelligenza();
        this.costituzionepg = scheda.getCostituzione();
        this.punti_vitapg = scheda.getPunti_vita();
    }

    public int valoreTotaleArmaturapg(SchedaPersonaggio scheda){
        int armatura;
        armatura = scheda.getTotale_armatura_base() + scheda.get
        return armatura;
    }
    
    public void colpireilNemico() {

        int colpire = forzapg + agilitàpg + bonus_colpirepg + (random.nextInt(12) + 1);
        int difendere = difesa_mostro[0] + agilità_mostro[0] + totale_armatura_mostro[0] + (random.nextInt(12) + 1);

        if (colpire > difendere) {
            int danno = danno_armapg + (forzapg - 4);
            punti_vita_mostro -= danno;
        }
    }

    private void colpiredelNemico() {

        int difendere = forzapg + intelligenzapg + totale_armaturapg + (random.nextInt(20) + 1);
        int colpire = forza_mostro[] + intelligenza_mostro[] + bonus_colpire_mostro[] + (random.nextInt(20) + 1);

        if (colpire > difendere) {
            int danno = danno_arma_mostro[] + forza_mostro[] - 7;
            punti_vitapg -= danno;
        }
    }

}
