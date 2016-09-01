/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Sonja
 */
@Entity
@Table(name = "bestelling")
@NamedQueries({
    @NamedQuery(name = "Bestelling.findAll", query = "SELECT b FROM Bestelling b"),
    @NamedQuery(name = "Bestelling.findByBestellingId", query = "SELECT b FROM Bestelling b WHERE b.bestellingId = :bestellingId")})
public class Bestelling implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bestelling_id")
    private Integer bestellingId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bestelling")
    private Collection<BesteldArtikel> besteldArtikelCollection;
    
    @JoinColumn(name = "klant_idklant", referencedColumnName = "klant_id")
    @ManyToOne(optional = false)
    private Klant klantIdklant;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bestellingIdbestelling")
    private Collection<Factuur> factuurCollection;

    public Bestelling() {
    }

    public Bestelling(Integer bestellingId) {
        this.bestellingId = bestellingId;
    }

    public Integer getBestellingId() {
        return bestellingId;
    }

    public void setBestellingId(Integer bestellingId) {
        this.bestellingId = bestellingId;
    }

    public Collection<BesteldArtikel> getBesteldArtikelCollection() {
        return besteldArtikelCollection;
    }

    public void setBesteldArtikelCollection(Collection<BesteldArtikel> besteldArtikelCollection) {
        this.besteldArtikelCollection = besteldArtikelCollection;
    }

    public Klant getKlantIdklant() {
        return klantIdklant;
    }

    public void setKlantIdklant(Klant klantIdklant) {
        this.klantIdklant = klantIdklant;
    }

    public Collection<Factuur> getFactuurCollection() {
        return factuurCollection;
    }

    public void setFactuurCollection(Collection<Factuur> factuurCollection) {
        this.factuurCollection = factuurCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bestellingId != null ? bestellingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bestelling)) {
            return false;
        }
        Bestelling other = (Bestelling) object;
        if ((this.bestellingId == null && other.bestellingId != null) || (this.bestellingId != null && !this.bestellingId.equals(other.bestellingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Bestelling[ bestellingId=" + bestellingId + " ]";
    }
    
}
