/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR;

/**
 *
 * @author Administrator
 */
public class Arma {
    
    int modificatore;
    int Dado;
    //int DannoArma = dannoArma(dado);//vedi tipi dadi
    String Categoria = "";
    String Potere = "";
    
    static Arma(int Modificatore, int Dado, String Categoria, String Potere){
        this.Modificatore = Modificatore;
        this.Dado = Dado;
        this.Categoria = Categoria;
        this.Potere = Potere;
                
        
    }
    
    static int dannoArma(){//Arma.dannoArma(int dado);
        int danno = Utility_calcolo_valori.lanciaD(Dado) + Modificatore;
        return danno;
    }
}
