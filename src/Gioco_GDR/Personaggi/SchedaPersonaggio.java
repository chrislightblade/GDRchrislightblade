/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR.Personaggi;

import Gioco_GDR.Classi.ClasseArmigero;

import Gioco_GDR.Classi.ClasseMagicante;
import Gioco_GDR.Classi.ClasseMagoTemporale;
import Gioco_GDR.Oggetti.Armi.ClasseArma;
import Gioco_GDR.Oggetti.ClasseOggetto;
import java.util.ArrayList;
/**
 *
 * @author tss
 */
public class SchedaPersonaggio {

    public SchedaPersonaggio(String nome) {
        this.nome = nome;
        this.cognome = "LightBlade";
        this.secondonome = "Legeth";        
        //this.ClasseArma[0] = ClasseArma.manoVuota();// = new ClasseArma();
        //this.ClasseArma[1] = ClasseArma.manoVuota();
        this.livello = 1;
        this.razza = 0;
        this.classe = 1;
        this.forza = 7;
        this.difesa = 7;
        this.intelligenza = 7;
        this.agilità = 7;
        this.costituzione = 7;
        this.cariche_magiche = 1;
        this.cariche_tecniche = 1;
        this.cariche_elementali = 1;
        this.cariche_magiche_max = 1;
        this.cariche_tecniche_max = 1;
        this.cariche_elementali_max = 1;
        this.talentiAttivi = 1;
        this.totale_armatura_base = 0;
        //this.classe_armatura = 0; 
        this.portafoglio = 100;
        this.elemento_personaggio = 12;
        //this.zaino = new int[30];//ArrayList<Oggetti>();
    }   
    
    public SchedaPersonaggio() {
        //this.ClasseArma[2];// = new ClasseArma[2];
        //this.ClasseArma[0] = ClasseArma[0].manoVuota();// = new ClasseArma();
        //this.ClasseArma[1] = ClasseArma[1].manoVuota();
        this.livello = 1;
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
        this.cariche_magiche_max = 1;
        this.cariche_tecniche_max = 1;
        this.cariche_elementali_max = 1;
        this.talentiAttivi = 1;
        this.totale_armatura_base = 0;
        //this.classe_armatura = 0; 
        this.portafoglio = 100;
        this.elemento_personaggio = 12;
        //this.zaino = new int[30];//ArrayList<Oggetti>();
    }
    
    private int livello;    
    
    public int getLivello() {
        return livello;
    }

    public void setLivello(int livello) {
        this.livello += livello;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private String nome, secondonome, cognome;//stringa nome e cognome
    private String sesso;
    
    public void setNomeCognome(String nome, String secondoNome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
        this.secondonome = secondoNome;
    }

    public String getNome() {
        return nome;
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
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private int forza;
    private int difesa;
    private int intelligenza;
    private int agilità;
    private int costituzione;
    private int exp;
    private int punti_vita_max;
    private int punti_vita;//attuali
    private int cariche_magiche_max = 0;
    private int cariche_tecniche_max = 0;
    private int cariche_elementali_max = 0;
    private int cariche_magiche = 0;
    private int cariche_tecniche = 0;
    private int cariche_elementali = 0;    
    //int danno_arma = Arma.dannoArma(dado);
    //private int classe_armatura;
    private int totale_armatura_base;// bonus razziali e altro
    //private int valore_difesa_armatura;
    //private int valore_difesa_elmo;
    //private int valore_difesa_guanti;
    private int perforare = forza + intelligenza;
    //private int danno = Arma.dannoArma(Arma.dado) + forza - 7;
        
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

    public int getTotaleArmatura() {
        int classe_armatura;
        classe_armatura = totale_armatura_base + agilità + difesa;
        return classe_armatura;
    }

    /*public void setTotaleArmatura() {
        int classe_armatura;
        classe_armatura = totale_armatura_base + agilità + difesa;        
        this.classe_armatura = classe_armatura;
    }*/
    
    public int getCaricheMagiche() {
        return cariche_magiche;
    }

    public void setCaricheMagiche(int cariche_magiche) {
        this.cariche_magiche += cariche_magiche;
    }

    public int getCariche_magiche_max() {
        return cariche_magiche_max;
    }

    public void setCariche_magiche_max(int cariche_magiche_max) {
        this.cariche_magiche_max += cariche_magiche_max;
    }

    public int getCariche_elementali_max() {
        return cariche_elementali_max;
    }

    public void setCariche_elementali_max(int cariche_elementali_max) {
        this.cariche_elementali_max += cariche_elementali_max;
    }

    public int getCariche_tecniche_max() {
        return cariche_tecniche_max;
    }

    public void setCariche_tecniche_max(int cariche_tecniche_max) {
        this.cariche_tecniche_max += cariche_tecniche_max;
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
        this.punti_vita += punti_vita;
    }
    
    public void fullPunti_vita(){
        this.punti_vita = punti_vita_max;
    }
        
    public int getPunti_vita_max() {
        return punti_vita_max;
    }

    public void setPunti_vita_max(int punti_vita) {
        this.punti_vita_max += punti_vita;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////
    //parametri per statistiche
    String statistiche[] = new String[]{"Forza", "Difesa", "Intelligenza", "Agilità", "Costituzione", "Mod. Exp.", "Punti Vita", "Perforare", "Cariche Magiche", "Cariche Elementali", "Totale Armatura", "Danno Arma"};//Cariche Tecnologiche
    //int statistiche_valore[] = new int[statistiche.length];

    private int elemento_personaggio;
    private String elementi_personaggio[] = new String[]{"Fuoco", "Acqua", "Terra", "Aria", "Luce", "Ombra", "Ghiaccio", "Fulmine", "Metallo", "Legno", "Arcano", "Vuoto", "Nessuno"};
    
    public int getElemento_personaggio() {
        return elemento_personaggio;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    //parametri per le razze
    private int razza;
    private String razzaPersonaggio[] = new String[]{"Umano", "Nano", "Elfo", "Dracolide", "Vergheuden"};//Faithy
    
    public void setRazza(int razza) {
        this.razza = razza;
    }

    public int getRazza() {
        return razza;
    }

    public String getRazzaPersonaggio() {
        return this.razzaPersonaggio[this.razza];
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private int talentiAttivi;
    
    public int getTalentiAttivi() {
        return talentiAttivi;
    }    
    
    public void setTalentiAttivi(int talentiAttivi) {
        this.talentiAttivi += talentiAttivi;
    }
    
    private ArrayList<ClasseOggetto> zaino;    
    private ClasseArma manoDestra = new ClasseArma(0, 1, "mano", 1, "nessuno", 12);// = new ClasseArma[2];
    private ClasseArma manoSinistra = new ClasseArma(0, 1, "mano", 1, "nessuno", 12);
    //private ClasseElmo ClasseElmo;// = new ClasseElmo();
    //private ClasseGuanti ClasseGuanti;// = new ClasseGuanti();
    //private ClasseScudo ClasseScudo;// = new ClasseScudo();
    //private ClasseArma ClasseArma;// = new ClasseArma();
    //private ClasseArma ClasseArma;// = new ClasseArma();    
    private int portafoglio;

    public void setManoDestra(ClasseArma manoDestra) {
        this.manoDestra = manoDestra;
    }

    public void setManoSinistra(ClasseArma manoSinistra) {
        this.manoSinistra = manoSinistra;
    }    
    
    public ClasseArma getManoDestra() {
        return manoDestra;
    }

    public ClasseArma getManoSinistra() {
        return manoSinistra;
    }
    
    

    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    private int classe;
    String classi[] = new String[]{"Armigero", "Magicante", "Shadow", "Elementalista"};//4
    private ClasseArmigero classe1;
    private ClasseMagicante classe2;
    private ClasseMagoTemporale classe3;
    
    //private ClasseGioco classe_pg;
    
    public int getClasse() {
        return classe;
    }

    public void setClasse(int classe) {
        this.classe = classe;
    }

    public String getClassi() {
        return this.classi[this.classe];
    }

    public ClasseArmigero getClasse1() {
        return classe1;
    }

    public ClasseMagicante getClasse2() {
        return classe2;
    }

    public ClasseMagoTemporale getClasse3() {
        return classe3;
    }

    public void setClasse3(ClasseMagoTemporale classe3) {
        this.classe3 = classe3;
    }    

    public void setClasse1(ClasseArmigero classe1) {
        this.classe1 = classe1;
    }

    public void setClasse2(ClasseMagicante classe2) {
        this.classe2 = classe2;
    }

    /*public void setClasse_pg(ClasseGioco classe_pg) {
        this.classe_pg = (ClasseGioco)classe_pg;
    }

    public ClasseGioco getClasse_pg() {
        return classe_pg;
    }*/

    

    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    
     
}
