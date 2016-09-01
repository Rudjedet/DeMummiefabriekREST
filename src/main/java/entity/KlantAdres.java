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
@Table(name = "klant_adres")
@NamedQueries({
    @NamedQuery(name = "KlantAdres.findAll", query = "SELECT k FROM KlantAdres k"),
    @NamedQuery(name = "KlantAdres.findByKlantAdresid", query = "SELECT k FROM KlantAdres k WHERE k.klantAdresId = :klantAdresId"),
    @NamedQuery(name = "KlantAdres.findByKlantIdklant", query = "SELECT k FROM KlantAdres k WHERE k.klant.klantId = :klantId"), //k.klant = :klant
    @NamedQuery(name = "KlantAdres.findByAdresIdadres", query = "SELECT k FROM KlantAdres k WHERE k.adres.adresId = :adresId")}) //k.adres = :adres

public class KlantAdres implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional=false)
    @Column(name = "klant_adresid")
    private Integer klantAdresId;
    
    @JoinColumn(name = "adres_idadres", referencedColumnName = "adres_id")
    @ManyToOne(optional = false)
    private Adres adres;
    
    @JoinColumn(name = "adrestype_idadrestype", referencedColumnName = "adrestype_id")
    @ManyToOne(optional = true)
    private AdresType adrestypeIdadrestype;
    
    @JoinColumn(name = "klant_idklant", referencedColumnName = "klant_id")
    @ManyToOne(optional = false)
    private Klant klant;

    public KlantAdres() {
    }

    public KlantAdres(Integer klantAdresId) {
        this.klantAdresId = klantAdresId;
    }

    public int getKlantAdresId() {
        return klantAdresId;
    }

    public void setKlantAdresId(int klantAdresId) {
        this.klantAdresId = klantAdresId;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
 
    public AdresType getAdrestypeIdadrestype() {
        return adrestypeIdadrestype;
    }

    public void setAdrestypeIdadrestype(AdresType adrestypeIdadrestype) {
        this.adrestypeIdadrestype = adrestypeIdadrestype;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (klantAdresId != null ? klantAdresId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof KlantAdres)) {
            return false;
        }
        KlantAdres other = (KlantAdres) object;
        if ((this.klantAdresId == null && other.klantAdresId != null) || (this.klantAdresId != null && !this.klantAdresId.equals(other.klantAdresId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.KlantAdres[ klantAdresId=" + klantAdresId + " ]";
    }
    
}
