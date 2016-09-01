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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sonja
 */
@Entity
@Table(name = "klant")
@NamedQueries({
    @NamedQuery(name = "Klant.findAll", query = "SELECT k FROM Klant k"),
    @NamedQuery(name = "Klant.findByKlantId", query = "SELECT k FROM Klant k WHERE k.klantId = :klantId"),
    @NamedQuery(name = "Klant.findByVoornaam", query = "SELECT k FROM Klant k WHERE k.voornaam = :voornaam"),
    @NamedQuery(name = "Klant.findByAchternaam", query = "SELECT k FROM Klant k WHERE k.achternaam = :achternaam"),
    @NamedQuery(name = "Klant.findByEmailadres", query = "SELECT k FROM Klant k WHERE k.emailadres = :emailadres")})
@XmlRootElement
public class Klant implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "klant_id")
    private Integer klantId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "voornaam")
    private String voornaam;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "achternaam")
    private String achternaam;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "emailadres")
    private String emailadres;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "klantIdklant")
    private Collection<Betaling> betalingCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "klant")
    private Collection<KlantAdres> klantAdresCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "klantIdklant")
    private Collection<Bestelling> bestellingCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "klantIdklant")
    private Collection<Account> accountCollection;

    public Klant() {
    }

    public Klant(Integer klantId) {
        this.klantId = klantId;
    }

    public Klant(Integer klantId, String voornaam, String achternaam, String emailadres) {
        this.klantId = klantId;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.emailadres = emailadres;
    }

    public Integer getKlantId() {
        return klantId;
    }

    public void setKlantId(Integer klantId) {
        this.klantId = klantId;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getEmailadres() {
        return emailadres;
    }

    public void setEmailadres(String emailadres) {
        this.emailadres = emailadres;
    }

    @XmlTransient
    public Collection<Betaling> getBetalingCollection() {
        return betalingCollection;
    }

    public void setBetalingCollection(Collection<Betaling> betalingCollection) {
        this.betalingCollection = betalingCollection;
    }

    @XmlTransient
    public Collection<KlantAdres> getKlantAdresCollection() {
        return klantAdresCollection;
    }

    public void setKlantAdresCollection(Collection<KlantAdres> klantAdresCollection) {
        this.klantAdresCollection = klantAdresCollection;
    }

    @XmlTransient
    public Collection<Bestelling> getBestellingCollection() {
        return bestellingCollection;
    }

    public void setBestellingCollection(Collection<Bestelling> bestellingCollection) {
        this.bestellingCollection = bestellingCollection;
    }

    @XmlTransient
    public Collection<Account> getAccountCollection() {
        return accountCollection;
    }

    public void setAccountCollection(Collection<Account> accountCollection) {
        this.accountCollection = accountCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (klantId != null ? klantId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klant)) {
            return false;
        }
        Klant other = (Klant) object;
        if ((this.klantId == null && other.klantId != null) || (this.klantId != null && !this.klantId.equals(other.klantId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Klant[ klantId=" + klantId + " ]";
    }
    
}
