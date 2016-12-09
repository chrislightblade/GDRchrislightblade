/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR.Oggetti;

import Gioco_GDR.Utility_calcolo_valori;

/**
 *
 * @author Administrator
 */
public class ClasseOggetto {
    
    private int modificatore;
    private int dado;
    //int DannoArma = dannoArma(dado);//vedi tipi dadi
    private String categoria;
    private String potere;
    
    public ClasseOggetto(/*int Modificatore, int Dado, String Categoria, String Potere*/){
        //this.modificatore = Modificatore;
        this.dado = 1;
        this.categoria = "";
        this.potere = "";       
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
