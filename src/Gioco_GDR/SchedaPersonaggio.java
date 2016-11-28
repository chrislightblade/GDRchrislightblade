/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR;

/**
 *
 * @author tss
 */
public class SchedaPersonaggio {

    private String NomeCognome[] = new String[3];//stringa nome e cognome

    private int forza = 0;
    private int difesa = 0;
    private int intelligenza = 0;
    private int agilità = 0;
    private int costituzione = 0;
    private int exp = 0;
    private int punti_vita;
    private int cariche_magiche = 0;
    private int cariche_tecniche = 0;
    private int cariche_elementali = 0;
    //int danno_arma = Arma.dannoArma(dado);
    private int totale_armatura = difesa + agilità;
    private int perforare = forza + intelligenza;
    //private int danno = Arma.dannoArma(Arma.dado) + forza - 7;

    private int Classe;
    String Classi[] = new String[]{"Armigero", "Magicante", "Shadow", "Elementalista"};//4

    //parametri per statistiche
    String Statistiche[] = new String[]{"Forza", "Difesa", "Intelligenza", "Agilità", "Costituzione", "Mod. Exp.", "Punti Vita", "Perforare", "Cariche Magiche", "Cariche Elementali", "Totale Armatura", "Danno Arma"};//Cariche Tecnologiche
    //int statistiche_valore[] = new int[statistiche.length];

    //parametri per le razze
    private int Razza;
    String RazzaPersonaggio[] = new String[]{"Umano", "Nano", "Elfo", "Dracolide", "Vergheuden"};//Faithy

    public SchedaPersonaggio() {
    }

    public SchedaPersonaggio(String[] NomeCognome) {
        this.NomeCognome = NomeCognome;
    }

    
    
    public String getNomeCognome() {

        String NomeCognome = "";
        for (int i = 0; i < 3; i++) {
            NomeCognome += this.NomeCognome[i] + "\n";
        }
        return NomeCognome;
    }

}
