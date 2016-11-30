/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR;

import java.util.ArrayList;
/**
 *
 * @author tss
 */
public class SchedaPersonaggio {

    private String nome, secondonome, cognome;//stringa nome e cognome
    private int forza;
    private int difesa;
    private int intelligenza;
    private int agilità;
    private int costituzione;
    private int exp;
    private int punti_vita_max;
    private int punti_vita;//attuali
    private int cariche_magiche = 0;
    private int cariche_tecniche = 0;
    private int cariche_elementali = 0;
    //int danno_arma = Arma.dannoArma(dado);
    private int totale_armatura_base;// = difesa + agilità + bonus; // bonus razziali e altro
    private int valore_difesa_armatura;
    private int valore_difesa_elmo;
    private int valore_difesa_guanti;
    private int perforare = forza + intelligenza;
    //private int danno = Arma.dannoArma(Arma.dado) + forza - 7;
    private int portafoglio;

    private int classe;
    String classi[] = new String[]{"Armigero", "Magicante", "Shadow", "Elementalista"};//4

    //parametri per statistiche
    String statistiche[] = new String[]{"Forza", "Difesa", "Intelligenza", "Agilità", "Costituzione", "Mod. Exp.", "Punti Vita", "Perforare", "Cariche Magiche", "Cariche Elementali", "Totale Armatura", "Danno Arma"};//Cariche Tecnologiche
    //int statistiche_valore[] = new int[statistiche.length];

    //parametri per le razze
    private int razza;
    private String razzaPersonaggio[] = new String[]{"Umano", "Nano", "Elfo", "Dracolide", "Vergheuden"};//Faithy
    
    private int talentiAttivi;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*private ClasseGioco classe_pg = ClasseGiocop.ClasseArmigero.;

    public void setClasse_pg(ClasseGioco classe_pg) {
        this.classe_pg = classe_pg;
    }

    public ClasseGioco getClasse_pg() {
        return classe_pg;
    }*/

    

    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public SchedaPersonaggio() {
        this.razza = -1;
        this.classe = -1;
        this.forza = 0;
        this.difesa = 0;
        this.intelligenza = 0;
        this.agilità = 0;
        this.costituzione = 0;
        this.cariche_magiche = 1;
        this.cariche_tecniche = 1;
        this.cariche_elementali = 1;
        this.talentiAttivi = 1;
        this.totale_armatura_base = 0;
        this.portafoglio = 100;
    }

    public int getTalentiAttivi() {
        return talentiAttivi;
    }    
    
    public void setTalentiAttivi(int talentiAttivi) {
        this.talentiAttivi += talentiAttivi;
    }    
    
    public int getClasse() {
        return classe;
    }

    public void setClasse(int classe) {
        this.classe = classe;
    }

    public String getClassi() {
        return this.classi[this.classe];
    }

    public void setRazza(int razza) {
        this.razza = razza;
    }

    public int getRazza() {
        return razza;
    }

    public String getRazzaPersonaggio() {
        return this.razzaPersonaggio[this.razza];
    }

    public void setNomeCognome(String nome, String secondoNome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
        this.secondonome = secondoNome;
    }

    public String getNomeCognome() {

        String NomeCognome = "";
        NomeCognome += this.nome + "\n";
        if (!(this.secondonome.equalsIgnoreCase(""))) {
            NomeCognome += this.secondonome + "\n";
        }
        NomeCognome += this.cognome + "\n";

        return NomeCognome;
    }

    public int getTotale_armatura_base() {
        return totale_armatura_base;
    }

    public void setTotale_armatura_base(int totale_armatura_base) {
        this.totale_armatura_base += totale_armatura_base;
    }   

    public int getAgilità() {
        return agilità;
    }

    public void setAgilità(int agilità) {
        this.agilità += agilità;
    }

    public int getCostituzione() {
        return costituzione;
    }

    public void setCostituzione(int costituzione) {
        this.costituzione += costituzione;
    }

    public int getForza() {
        return forza;
    }

    public void setForza(int forza) {
        this.forza += forza;
    }

    public int getDifesa() {
        return difesa;
    }

    public void setDifesa(int difesa) {
        this.difesa += difesa;
    }

    public int getIntelligenza() {
        return intelligenza;
    }

    public void setIntelligenza(int intelligenza) {
        this.intelligenza += intelligenza;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp += exp;
    }

    /*public int getTotaleArmatura() {
        return totale_armatura;
    }

    public void setTotaleArmatura(int totale_armatura) {
        this.totale_armatura += totale_armatura;
    }*/
    public int getCaricheMagiche() {
        return cariche_magiche;
    }

    public void setCaricheMagiche(int cariche_magiche) {
        this.cariche_magiche += cariche_magiche;
    }

    public int getCaricheElementali() {
        return cariche_elementali;
    }

    public void setCaricheElementali(int cariche_elementali) {
        this.cariche_elementali += cariche_elementali;
    }

    public int getCaricheTecniche() {
        return cariche_tecniche;
    }

    public void setCaricheTecniche(int cariche_tecniche) {
        this.cariche_tecniche += cariche_tecniche;
    }

    public int getPunti_vita() {
        return punti_vita;
    }

    public void setPunti_vita(int punti_vita) {
        this.punti_vita = punti_vita;
    }
        
    public int getPunti_vita_max() {
        return punti_vita_max;
    }

    public void setPunti_vita_max(int punti_vita) {
        this.punti_vita_max += punti_vita;
    }
    
}
