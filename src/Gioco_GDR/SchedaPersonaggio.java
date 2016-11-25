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

    String NomeCognome[] = new String[3];//stringa nome e cognome

    int forza = 0;    
    int difesa = 0;
    int intelligenza = 0;
    int agilità = 0;
    int costituzione = 0;    
    int exp = 0;
    int punti_vita;
    int cariche_magiche = 0;
    int cariche_tecniche = 0;
    int cariche_elementali = 0;
    int danno_arma = 1;
    int totale_armatura = difesa + agilità;
    int perforare = forza + intelligenza;

    int Classe;
    String Classi[] = new String[]{"Armigero", "Magicante", "Shadow", "Elementalista"};//4

    //parametri per statistiche
    String Statistiche[] = new String[]{"Forza", "Difesa", "Intelligenza", "Agilità", "Costituzione", "Mod. Exp.", "Punti Vita", "Perforare", "Cariche Magiche", "Cariche Elementali", "Totale Armatura", "Danno Arma"};//Cariche Tecnologiche
    //int statistiche_valore[] = new int[statistiche.length];

    //parametri per le razze
    int Razza;
    String RazzaPersonaggio[] = new String[]{"Umano", "Nano", "Elfo", "Dracolide", "Vergheuden"};//Faithy
    

    
}
