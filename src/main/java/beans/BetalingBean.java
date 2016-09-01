/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Betaalwijze;
import entity.Betaling;
import entity.Factuur;
import entity.Klant;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author Sonja
 */

@Stateless
@Dependent
@Named
public class BetalingBean {
    private Betaling betaling;
    private Betaalwijze betaalwijze;
    private Factuur factuur;
    private Klant klant;
    
    public BetalingBean() {
        betaling = new Betaling();
        betaalwijze = new Betaalwijze();
        factuur = new Factuur();
        klant = new Klant();
    }        

    public Betaling getBetaling() {
        return betaling;
    }

    public void setBetaling(Betaling betaling) {
        this.betaling = betaling;
    }

    public Betaalwijze getBetaalwijze() {
        return betaalwijze;
    }

    public void setBetaalwijze(Betaalwijze betaalwijze) {
        this.betaalwijze = betaalwijze;
    }

    public Factuur getFactuur() {
        return factuur;
    }

    public void setFactuur(Factuur factuur) {
        this.factuur = factuur;
    }
}
