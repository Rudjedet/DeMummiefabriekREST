/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Artikel;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import session.ArtikelFacade;

/**
 *
 * @author Sonja
 */

@Stateless
@Dependent
@Named
public class ArtikelBean {
    
     private Artikel ditArtikel;
     private List<Artikel> artikelLijst;
     
     @EJB
     private ArtikelFacade arFacade;
     
     public ArtikelBean() {
         ditArtikel = new Artikel();
     }

    @PostConstruct
    public void init() {
        artikelLijst = new ArrayList<>();
        leesAlleArtikelen();
    }
     
    /*
    * CRUD methodes
    */ 
    public String maakNieuwArtikel() {
        arFacade.create(ditArtikel);
        artikelLijst.add(ditArtikel);

        return "succes";
    } 
     
    public void leesAlleArtikelen() {
        setArtikelLijst(arFacade.findAll());
    }
    
    public String editArtikel() {
        arFacade.edit(ditArtikel);
        ditArtikel = new Artikel();
        
        return "succes.xhtml?faces-redirect=true";
    }
    
    public String gaNaarEditArtikel(Artikel artikel) {
        setDitArtikel(artikel);
        return "editartikel.xhtml?faces-redirect=true";
    }
      
    public String verwijderArtikel(Artikel artikel) {
        //arFacade.remove(ditArtikel);
        //artikelLijst.remove(ditArtikel);
        
        int aLSize = artikelLijst.size();
        int index = -1;
        
        for (int i = 0; i < aLSize; i++) {
            if(Objects.equals(artikelLijst.get(i).getArtikelId(), artikel.getArtikelId())) {
                index = i;
            }
        }
        if (index != 1) {
            arFacade.remove(artikelLijst.get(index));
            artikelLijst.remove(index);
        }
        return "succes";
    }
     
    /*
    * Getters & Setters
    */    
    public List<Artikel> getArtikelLijst() {
        return artikelLijst;
    }

    public void setArtikelLijst(List<Artikel> artikelLijst) {
        this.artikelLijst = artikelLijst;
    }
    
    public Artikel getDitArtikel() {
        return ditArtikel;
    }

    public void setDitArtikel(Artikel ditArtikel) {
        this.ditArtikel = ditArtikel;
    }
}
