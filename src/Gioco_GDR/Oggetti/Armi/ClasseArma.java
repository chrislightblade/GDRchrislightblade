/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR.Oggetti.Armi;

import Gioco_GDR.Oggetti.ClasseOggetto;
import Gioco_GDR.Personaggi.SchedaMostro;
import Gioco_GDR.Personaggi.SchedaPersonaggio;
import Gioco_GDR.Utility_calcolo_valori;

/**
 *
 * il dannoArma nel bisogno si fa un @override per specificarlo a seconda dell'arma
 * 
 * @author Administrator
 */
public class ClasseArma{
    
    private int modificatore;//danno base arma
    private int dado;
    //int DannoArma = dannoArma(dado);//vedi tipi dadi
    private String categoria;//spada, spadone, martello, martello pesante, ascia, ascia pesante, arco, arco lungo, coltello, daga / verga, bastone da mago
    private int maniOccupate;
    private String potere;
    private int attributo;
    
    public ClasseArma(int modificatore, int dado, String categoria, int maniOccupate, String potere, int attributo){
        this.modificatore = modificatore;
        this.dado = dado + (modificatore * 2);
        this.categoria = categoria;
        this.maniOccupate = maniOccupate;
        this.potere = potere;       
        this.attributo = attributo;
    }
    
    public ClasseArma manoVuota(){
        
       ClasseArma manovuota = new ClasseArma(0, 1, "mano", 1, "nessuno", );
       return manovuota;
        
    }
    
    public int dannoArma(int forza){//Arma.dannoArma(int dado);
        int danno = Utility_calcolo_valori.lanciaD(getDado()) + modificatore  + (forza - 4);
        return danno;
    }

    public int getAttributo() {
        return attributo;
    }

    public void setAttributo(int attributo) {
        this.attributo = attributo;
    }    
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getManiOccupate() {
        return maniOccupate;
    }

    public void setManiOccupate(int maniOccupate) {
        this.maniOccupate = maniOccupate;
    }

    public String getPotere() {
        return potere;
    }

    public void setPotere(String potere) {
        this.potere = potere;
    }
    
    public int getModificatore() {
        return modificatore;
    }

    public void setModificatore(int modificatore) {
        this.modificatore = modificatore;
    }

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }
    
    
}
