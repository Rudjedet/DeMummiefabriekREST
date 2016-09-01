/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Adres;
import entity.AdresType;
import entity.Klant;
import entity.KlantAdres;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import session.AdresFacade;
import session.AdresTypeFacade;
import session.KlantAdresFacade;
import session.KlantFacade;

/**
 *
 * @author Sonja
 */

@Stateless
@Dependent
@Named
public class AdresBean {
    
    private Adres ditAdres;
    private Klant dezeKlant;
    private AdresType hetAdrestype;
    private List<Adres> adresGegevens;
    private KlantAdres klantAdres;
    private List<KlantAdres> klantadressen;
    
    @EJB
    private AdresFacade adFacade;
    //@EJB
    //private AdresTypeFacade atFacade;
    @EJB
    private KlantFacade kFacade;
    @EJB
    private KlantAdresFacade kaFacade;
    
    public AdresBean() {
        ditAdres = new Adres();
        dezeKlant = new Klant();
        //hetAdrestype = new AdresType();
    }
    
    @PostConstruct
    public void init() {
        adresGegevens = new ArrayList<>();
        leesAlleAdressen();
    }
    
    /*
    * CRUD methodes
    */
    public String maakNieuwAdres() {
        adFacade.create(ditAdres);
        adresGegevens.add(ditAdres);
        //voegAdresToeAanKlant(ditAdres); 
        
        return "registratieGeslaagd.xhtml?faces-redirect=true";
    }
    
    public String voegAdresToeAanKlant(Adres adres) {
        KlantAdres kA = new KlantAdres();
        kA.setAdres(adres);
        setDezeKlant(kFacade.find(dezeKlant.getKlantId())); //Nu geeft dit weer een null PK terug??
        kA.setKlant(dezeKlant);
        
        kaFacade.create(kA);
        klantadressen.add(kA); 
        ditAdres = new Adres();
        
        return "registratieGeslaagd.xhtml?faces-redirect=true";
    }
    
    public void leesAlleAdressen() {
        setAdresGegevens(adFacade.findAll());
    }
    
    public String gaNaarEditAdres(Adres adres) {
        setDitAdres(adres);
        
        return "editadres.xhtml?faces-redirect=true";
    }
    
    public String editAdres() {
        adFacade.edit(ditAdres);
        ditAdres = new Adres();
        
        return "succes.xhtml?faces-redirect=true";
    }
    
//    public String gaNaarEditAdresGegevens(Adres adres) {
//        setDitAdres(adres);
//        return "editadres";
//    }
    
    public String verwijderAdres(Adres adres) {
        adFacade.remove(adres);
        adresGegevens.remove(adres);
        
        return "succes.xhtml?faces-redirect=true";
    }

    /*
    * Getters & Setters
    */
    public Adres getDitAdres() {
        return ditAdres;
    }

    public void setDitAdres(Adres ditAdres) {
        this.ditAdres = ditAdres;
    }

    public Klant getDezeKlant() {
        return dezeKlant;
    }

    public void setDezeKlant(Klant dezeKlant) {
        this.dezeKlant = dezeKlant;
    }

    public List<Adres> getAdresGegevens() {
        return adresGegevens;
    }

    public void setAdresGegevens(List<Adres> adresGegevens) {
        this.adresGegevens = adresGegevens;
    }

    public KlantAdres getKlantAdres() {
        return klantAdres;
    }

    public void setKlantAdres(KlantAdres klantAdres) {
        this.klantAdres = klantAdres;
    }

    public List<KlantAdres> getKlantadressen() {
        return klantadressen;
    }

    public void setKlantadressen(List<KlantAdres> klantadressen) {
        this.klantadressen = klantadressen;
    }

    public AdresType getHetAdrestype() {
        return hetAdrestype;
    }

    public void setHetAdrestype(AdresType hetAdrestype) {
        this.hetAdrestype = hetAdrestype;
    }
}
  

