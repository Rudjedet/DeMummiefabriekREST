/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Sonja
 */
@Entity
@Table(name = "artikel")
@NamedQueries({
    @NamedQuery(name = "Artikel.findAll", query = "SELECT a FROM Artikel a"),
    @NamedQuery(name = "Artikel.findByArtikelId", query = "SELECT a FROM Artikel a WHERE a.artikelId = :artikelId"),
    @NamedQuery(name = "Artikel.findByArtikelnaam", query = "SELECT a FROM Artikel a WHERE a.artikelnaam = :artikelnaam")})
    //@NamedQuery(name = "Artikel.findByArtikelprijs", query = "SELECT a FROM Artikel a WHERE a.artikelprijs = :artikelprijs"),
    //@NamedQuery(name = "Artikel.findByArtikelvoorraad", query = "SELECT a FROM Artikel a WHERE a.artikelvoorraad = :artikelvoorraad")})
public class Artikel implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "artikel_id")
    private Integer artikelId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "artikelnaam")
    private String artikelnaam;
   
    @Basic(optional = false)
    @NotNull
    @Column(name = "artikelprijs")
    private BigDecimal artikelprijs;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "artikelvoorraad")
    private int artikelvoorraad;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artikel")
    private Collection<BesteldArtikel> besteldArtikelCollection;

    public Artikel() {
    }

    public Artikel(Integer artikelId) {
        this.artikelId = artikelId;
    }

    public Artikel(Integer artikelId, String artikelnaam, BigDecimal artikelprijs, int artikelvoorraad) {
        this.artikelId = artikelId;
        this.artikelnaam = artikelnaam;
        this.artikelprijs = artikelprijs;
        this.artikelvoorraad = artikelvoorraad;
    }

    public Integer getArtikelId() {
        return artikelId;
    }

    public void setArtikelId(Integer artikelId) {
        this.artikelId = artikelId;
    }

    public String getArtikelnaam() {
        return artikelnaam;
    }

    public void setArtikelnaam(String artikelnaam) {
        this.artikelnaam = artikelnaam;
    }

    public BigDecimal getArtikelprijs() {
        return artikelprijs;
    }

    public void setArtikelprijs(BigDecimal artikelprijs) {
        this.artikelprijs = artikelprijs;
    }

    public int getArtikelvoorraad() {
        return artikelvoorraad;
    }

    public void setArtikelvoorraad(int artikelvoorraad) {
        this.artikelvoorraad = artikelvoorraad;
    }

    public Collection<BesteldArtikel> getBesteldArtikelCollection() {
        return besteldArtikelCollection;
    }

    public void setBesteldArtikelCollection(Collection<BesteldArtikel> besteldArtikelCollection) {
        this.besteldArtikelCollection = besteldArtikelCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artikelId != null ? artikelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artikel)) {
            return false;
        }
        Artikel other = (Artikel) object;
        if ((this.artikelId == null && other.artikelId != null) || (this.artikelId != null && !this.artikelId.equals(other.artikelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Artikel[ artikelId=" + artikelId + " ]";
    }
    
}
