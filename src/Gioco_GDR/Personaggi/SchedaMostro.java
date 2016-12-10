/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gioco_GDR.Personaggi;

/**
 *
 * @author tss
 */
public class SchedaMostro extends SchedaPersonaggio {

    public void creaGoblin(int livello){
        SchedaPersonaggio goblin = new SchedaPersonaggio();
        goblin.setLivello(livello);
        goblin.setForza(6 + (livello%2));
        goblin.setCostituzione(5 + livello);
        goblin.setIntelligenza(2);
        goblin.setAgilità(6 + (livello%3) );
        goblin.setDifesa(5 + livello);
        goblin.setTotale_armatura_base(2);
        goblin.setTotaleArmatura();
                
    }
}
