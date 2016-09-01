/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Klant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import session.KlantFacade;

/**
 *
 * @author Sonja
 */

@Stateless
@Dependent
@Named
public class KlantBean implements Serializable {
    
    private Klant dezeKlant;
    private List<Klant> klantGegevens;
    
    @EJB
    private KlantFacade kFacade;
    
    public KlantBean() {
        dezeKlant = new Klant();
    }
    
    @PostConstruct
    public void init() {
        klantGegevens = new ArrayList<>();
        leesAlleKlanten();
    }        
    
    /*
    * CRUD methodes
    */
    public String maakNieuweKlant() {
        kFacade.create(dezeKlant);
        klantGegevens.add(dezeKlant);
        
        return "adresregistratie.xhtml?faces-redirect=true";
    }
    
    public void leesAlleKlanten() {
        setKlantGegevens(kFacade.findAll());
    }
    
    public String editKlant() {
        kFacade.edit(dezeKlant);
        dezeKlant = new Klant();
        
        return "succes.xhtml?faces-redirect=true";
    }
    
    public String gaNaarEditKlantGegevens(Klant klant) {
        setDezeKlant(klant);
        return "editklant.xhtml?faces-redirect=true";
    }
    

    public String verwijderKlant(Klant klant) {
        kFacade.remove(klant);
        klantGegevens.remove(klant);
        
//        int kGSize = klantGegevens.size();
//        int index = -1;
//        
//        for (int i = 0; i < kGSize; i++) {
//            if(Objects.equals(klantGegevens.get(i).getKlantId(), klant.getKlantId())) {
//                index = i;
//            }
//        }
//        if (index != 1) {
//            kFacade.remove(klantGegevens.get(index));
//            klantGegevens.remove(index);
//        }
        
        return "succes.xhtml?faces-redirect=true";
    } 
    
    /*
    * Getters & Setters
    */
    public Klant getDezeKlant() {
        return dezeKlant;
    }

    public void setDezeKlant(Klant dezeKlant) {
        this.dezeKlant = dezeKlant;
    }

    public List<Klant> getKlantGegevens() {
        return klantGegevens;
    }

    public void setKlantGegevens(List<Klant> klantGegevens) {
        this.klantGegevens = klantGegevens;
    }
}
