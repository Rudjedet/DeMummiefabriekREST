/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Artikel;
import entity.BesteldArtikel;
import entity.Bestelling;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.OneToMany;
import session.BesteldArtikelFacade;
import session.BestellingFacade;

/**
 *
 * @author Sonja
 */

@Stateless
@Dependent
@Named
public class BestellingBean {
    
    private Bestelling dezeBestelling;
    private Integer klantId;
    private List<Bestelling> alleBestellingen;
    private List<BesteldArtikel> besteldeArtikelen;
    private Double totaalBedrag;
    
    @EJB
    private BestellingFacade bFacade;
    @EJB
    private BesteldArtikelFacade baFacade;
    
    public BestellingBean() {
        dezeBestelling = new Bestelling();
        totaalBedrag = new Double(0);
    }
    
    @PostConstruct
    public void init() {
        alleBestellingen = new ArrayList<>();
        leesAlleBestellingen();
    }    
    
    /*
    * CRUD methodes
    */
    public void maakNieuweBestelling() {
        bFacade.create(dezeBestelling);
        alleBestellingen.add(dezeBestelling);
    }
    
    public String voegArtikelToeAanBestelling(Artikel artikel) {
        BesteldArtikel bA = new BesteldArtikel();
        bA.setAantal(1);
        bA.setArtikel(artikel);
        bA.setBestelling(dezeBestelling);
        setDezeBestelling(bFacade.find(dezeBestelling.getBestellingId()));
        //baFacade.create(bA);
        //besteldeArtikelen.add(bA);
        //dezeBestelling = new Bestelling();
        maakNieuweBestelling();
        
        return "succes.xhtml?faces-redirect=true";
    }
    
    public void verwijderUitBesteldeArtikelen(BesteldArtikel bar) {
        baFacade.remove(bar);
        setBesteldeArtikelen(baFacade.findBesteldeArtikelen(dezeBestelling.getBestellingId()));
    }
    
    public void verwijderArtikelUitBestelling(BesteldArtikel bestArtikel) {
        verwijderUitBesteldeArtikelen(bestArtikel);
    }
    
    public void leesAlleBestellingen() {
        setAlleBestellingen(bFacade.findAll());
    }
    
    public String gaNaarEditDezeBestelling(Bestelling bestelling) {
        setDezeBestelling(bestelling);
                
        return "editbestelling.xhtml?faces-redirect=true";        
    }
    
    //TODO: leesBestellingByKlantId() {
    //    setKlantId(klantId);
    //    setAlleBestellingen(bFacade.findBestellingByKlantId)
    //}
    
    //TODO: public void leesBesteldeArtikelenInBestelling() {}
    //methode die alle artikelen in een bestelling weergeeft als een lijst 
    //die vervolgens in servlet gebruikt wordt
    
    public void editBestelling() {
        bFacade.edit(dezeBestelling);
        dezeBestelling = new Bestelling();
    }
    
    public void verwijderBestelling(Bestelling bestelling) {
        bFacade.remove(dezeBestelling);
        alleBestellingen.remove(dezeBestelling);
    }
    
    public void berekenTotaalBedrag() {
        List<BesteldArtikel> artikelenInDezeBestelling = getBesteldeArtikelen();
        double bedrag = 0;
        
        for(BesteldArtikel bA : artikelenInDezeBestelling) {
            //totaalBedrag += bA.getBesteldArtikelId().(ditArtikel.getArtikelprijs()) * bA.getAantal();
            //^cannot find getArtikelprijs methode???
        }
        
        setTotaalBedrag(bedrag);
    }
    
    /*
    * Getters & Setters
    */
    public Bestelling getDezeBestelling() {
        return dezeBestelling;
    }

    public void setDezeBestelling(Bestelling dezeBestelling) {
        this.dezeBestelling = dezeBestelling;
    }

    public List<Bestelling> getAlleBestellingen() {
        return alleBestellingen;
    }

    public void setAlleBestellingen(List<Bestelling> alleBestellingen) {
        this.alleBestellingen = alleBestellingen;
    }

    public List<BesteldArtikel> getBesteldeArtikelen() {
        return besteldeArtikelen;
    }

    public void setBesteldeArtikelen(List<BesteldArtikel> besteldeArtikelen) {
        this.besteldeArtikelen = besteldeArtikelen;
    }

    public Double getTotaalBedrag() {
        return totaalBedrag;
    }

    public void setTotaalBedrag(Double totaalBedrag) {
        this.totaalBedrag = totaalBedrag;
    }

    public Integer getKlantId() {
        return klantId;
    }

    public void setKlantId(Integer klantId) {
        this.klantId = klantId;
    }
}
