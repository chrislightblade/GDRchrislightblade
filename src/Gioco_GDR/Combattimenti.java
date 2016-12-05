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
    private int cariche_magiche_maxpg;
    private int cariche_tecniche_maxpg;
    private int cariche_elementali_maxpg;

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
        this.cariche_magichepg = scheda.getCaricheMagiche();
        this.cariche_tecnichepg = scheda.getCaricheTecniche();
        this.cariche_elementalipg = scheda.getCaricheMagiche();
        this.cariche_magiche_maxpg = scheda.getCariche_magiche_max();
        this.cariche_tecniche_maxpg = scheda.getCariche_tecniche_max();
        this.cariche_elementali_maxpg = scheda.getCariche_magiche_max();
    }

    public int valoreTotaleArmaturapg(SchedaPersonaggio scheda) {
        int armatura;
        armatura = scheda.getTotale_armatura_base() + agilitàpg + difesapg;
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

    private void colpiredelNemico(SchedaPersonaggio scheda) {

        int difendere = valoreTotaleArmaturapg(scheda) + (random.nextInt(20) + 1);
        int colpire = forza_mostro[0] + intelligenza_mostro[0] + bonus_colpire_mostro[0] + (random.nextInt(20) + 1);

        if (colpire > difendere) {
            int danno = danno_arma_mostro[0] + forza_mostro[0] - 4;
            punti_vitapg -= danno;
        }
    }

}
