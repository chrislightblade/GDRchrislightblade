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
public class ClasseArma {
    
    int modificatore;
    int dado;
    //int DannoArma = dannoArma(dado);//vedi tipi dadi
    String categoria = "";
    String potere = "";
    
    public ClasseArma(int Modificatore, int Dado, String Categoria, String Potere){
        this.modificatore = Modificatore;
        this.dado = Dado;
        this.categoria = Categoria;
        this.potere = Potere;
                
        
    }
    
    public int dannoArma(){//Arma.dannoArma(int dado);
        int danno = Utility_calcolo_valori.lanciaD(dado) + modificatore;
        return danno;
    }
}
