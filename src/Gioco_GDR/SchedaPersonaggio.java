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

    int forza;
    int intelligenza;
    int difesa;
    int agilità;
    int costituzione;
    int punti_vita;
    int exp;
    int cariche_magiche;
    int cariche_tecniche;
    int cariche_elementali;
    int danno_arma;
    int totale_armatura;
    int perforare;

    int Classe;
    String classi[] = new String[]{"Armigero", "Magicante", "Shadow", "Elementalista"};//4

    //parametri per statistiche
    String statistiche[] = new String[]{"Forza", "Difesa", "Costituzione", "Intelligenza", "Agilità", "Mod. Exp.", "Punti Vita", "Totale Armatura", "Cariche Magiche", "Cariche Elementali"};//Cariche Tecnologiche
    int statistiche_valore[] = new int[statistiche.length];

    //parametri per le razze
    int Razza = 0;
    String RazzaPersonaggio[] = new String[]{"Umano", "Nano", "Elfo", "Dracolide", "Vergheuden"};//Faithy

    
}
