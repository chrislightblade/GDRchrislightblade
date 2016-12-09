/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR.Oggetti;

/**
 *
 * @author tss
 */
public class ClasseArmatura {
    
    private int modificatore;
    private String categoria;//cuoio, anelli, placche, piastre, completa
                             // +1      +2      +3       +4        +5
    private int bonus_armatura;
    private String potere;
    private int maniOccupate;

    public ClasseArmatura(int modificatore, String categoria, int bonus_armatura, String potere, int maniOccupate) {
        this.modificatore = modificatore;    
        this.categoria = categoria;
        this.bonus_armatura = bonus_armatura;
        this.potere = potere;
        this.maniOccupate = maniOccupate;
    }
    
    public ClasseArmatura creaArmaturaSemplice(int modificatore){
        ClasseArmatura armaturaSemplice = new ClasseArmatura(modificatore, "Placche", 3, "Nessuno", 1);
        return armaturaSemplice;
    }

    public int getModificatore() {
        return modificatore;
    }

    public void setModificatore(int modificatore) {
        this.modificatore = modificatore;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getBonus_armatura() {
        return bonus_armatura;
    }

    public void setBonus_armatura(int bonus_armatura) {
        this.bonus_armatura = bonus_armatura;
    }

    public String getPotere() {
        return potere;
    }

    public void setPotere(String potere) {
        this.potere = potere;
    }

    public int getManiOccupate() {
        return maniOccupate;
    }

    public void setManiOccupate(int maniOccupate) {
        this.maniOccupate = maniOccupate;
    }
    
    
}
