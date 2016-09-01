/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Sonja
 */

@Entity
@Table(name = "besteld_artikel")
@NamedQueries({
    @NamedQuery(name = "BesteldArtikel.findAll", query = "SELECT b FROM BesteldArtikel b"),
    @NamedQuery(name = "BesteldArtikel.findByBesteldArtikelid", query = "SELECT b FROM BesteldArtikel b WHERE b.besteldArtikelId = :besteldArtikelId"),
    @NamedQuery(name = "BesteldArtikel.findByBestellingIdbestelling", query = "SELECT b FROM BesteldArtikel b WHERE b.bestelling.bestellingId = :bestellingId")})
public class BesteldArtikel implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional=false)
    @Column(name = "besteld_artikelid")
    private Integer besteldArtikelId;
    
    @Column(name = "aantal")
    private Integer aantal;
    
    @JoinColumn(name = "artikel_idartikel", referencedColumnName = "artikel_id")
    @ManyToOne(optional = false)
    private Artikel artikel;
    
    @JoinColumn(name = "bestelling_idbestelling", referencedColumnName = "bestelling_id")
    @ManyToOne(optional = false)
    private Bestelling bestelling;

    public BesteldArtikel() {
    }

    public BesteldArtikel(Integer besteldArtikelId) {
        this.besteldArtikelId = besteldArtikelId;
    }

    public BesteldArtikel(Integer besteldArtikelId, int aantal) {
        this.besteldArtikelId = besteldArtikelId;
        this.aantal = aantal;
    }
    
    public Integer getBesteldArtikelId() {
        return besteldArtikelId;
    }

    public void setBesteldArtikelId(Integer besteldArtikelId) {
        this.besteldArtikelId = besteldArtikelId;
    }

    public Integer getAantal() {
        return aantal;
    }

    public void setAantal(Integer aantal) {
        this.aantal = aantal;
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public Bestelling getBestelling() {
        return bestelling;
    }

    public void setBestelling(Bestelling bestelling) {
        this.bestelling = bestelling;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (besteldArtikelId != null ? besteldArtikelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BesteldArtikel)) {
            return false;
        }
        BesteldArtikel other = (BesteldArtikel) object;
        if ((this.besteldArtikelId == null && other.besteldArtikelId != null) || (this.besteldArtikelId != null && !this.besteldArtikelId.equals(other.besteldArtikelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.BesteldArtikel[ besteldArtikelId=" + besteldArtikelId + " ]";
    }
    
}
