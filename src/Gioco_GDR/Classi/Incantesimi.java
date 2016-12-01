/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR.Classi;

/**
 *
 * @author tss
 */
public class Incantesimi {

    private int danno;
    private int tipo;

    public Incantesimi(int danno, int tipo) {
        this.danno = (int) Math.floor(Math.random() * danno);
        this.tipo = tipo;
    }

    public int getDanno() {
        return danno;
    }

    public int getTipo() {
        return tipo;
    }

    public double efficaciaDanno(int tipo1, int tipo2) {//sarà più comodo fare una tabella array con i singoli valori specificati (per gli 8 lementi tabulati, per ombra e luce è un discorso a parte
        if(tipo1 == 10){
            return 3;
            
        } else {
        if ((tipo1 == 4 && tipo2 == 5) || (tipo1 == 5 && tipo2 == 4)) {
            return 2;
            
        } else {//inizia if 4 elementi + 4 elementi
            if (tipo1 < 4 && tipo2 < 4) {//if primi 4 elementi
                if ((tipo1 == 0 && tipo2 == 1) || (tipo1 == 1 && tipo2 == 0)) {//se fuoco e eacqua
                    if (tipo1 > tipo2) {
                        return 2;
                    } else {
                        return 0.5;
                    }
                }// fine primo if
                else {//altrimenti è terra e aria
//                    if ((tipo1 == 2 && tipo2 == 3) || (tipo1 == 3 && tipo2 == 2)) {
//                }                    
                        if (tipo1 > tipo2) {
                            return 2;
                        } else {
                            return 0.5;
                        }                   

                }
                //fine if 4 elementi
            } else {// altrimenti sono gli altri 4 elementi
                if (tipo1 > 5 && tipo2 > 5) {//if ghiaccio e fulmine
                    if ((tipo1 == 6 && tipo2 == 7) || (tipo1 == 7 && tipo2 == 6)) {
                        if (tipo1 > tipo2) {
                            return 2;
                        } else {
                            return 0.5;
                        }
                    }// fine primo if
                    else {//altrimenti legno e metallo
 //                       if ((tipo1 == 8 && tipo2 == 9) || (tipo1 == 9 && tipo2 == 8)) {
                            if (tipo1 > tipo2) {
                                return 2;
                            } else {
                                return 0.5;
                            }
//                        }
                    }

                }//fine if altri 4 elementi
            }//fine else gli altri 4 elementi
        }//fine else 4 elementi + 4 elementi
        
        }// fine else tipo1 == 10

        return 1;//in tutti gli altri casi
            // tipi incantesimi: 
            // fuoco, acqua, terra, aria, luce, ombra, ghiaccio, fulmine, metallo, legno, arcano//
            //   0      1      2      3     4     5        6        7        8       9      10
        }
}
