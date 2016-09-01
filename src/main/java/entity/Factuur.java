/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Sonja
 */
@Entity
@Table(name = "factuur")
@NamedQueries({
    @NamedQuery(name = "Factuur.findAll", query = "SELECT f FROM Factuur f"),
    @NamedQuery(name = "Factuur.findByFactuurId", query = "SELECT f FROM Factuur f WHERE f.factuurId = :factuurId"),
    @NamedQuery(name = "Factuur.findByFactuurdatum", query = "SELECT f FROM Factuur f WHERE f.factuurdatum = :factuurdatum")})
public class Factuur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "factuur_id")
    private Integer factuurId;
    @Column(name = "factuurdatum")
    @Temporal(TemporalType.DATE)
    private Date factuurdatum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factuurIdfactuur")
    private Collection<Betaling> betalingCollection;
    @JoinColumn(name = "bestelling_idbestelling", referencedColumnName = "bestelling_id")
    @ManyToOne(optional = false)
    private Bestelling bestellingIdbestelling;

    public Factuur() {
    }

    public Factuur(Integer factuurId) {
        this.factuurId = factuurId;
    }

    public Integer getFactuurId() {
        return factuurId;
    }

    public void setFactuurId(Integer factuurId) {
        this.factuurId = factuurId;
    }

    public Date getFactuurdatum() {
        return factuurdatum;
    }

    public void setFactuurdatum(Date factuurdatum) {
        this.factuurdatum = factuurdatum;
    }

    public Collection<Betaling> getBetalingCollection() {
        return betalingCollection;
    }

    public void setBetalingCollection(Collection<Betaling> betalingCollection) {
        this.betalingCollection = betalingCollection;
    }

    public Bestelling getBestellingIdbestelling() {
        return bestellingIdbestelling;
    }

    public void setBestellingIdbestelling(Bestelling bestellingIdbestelling) {
        this.bestellingIdbestelling = bestellingIdbestelling;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (factuurId != null ? factuurId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factuur)) {
            return false;
        }
        Factuur other = (Factuur) object;
        if ((this.factuurId == null && other.factuurId != null) || (this.factuurId != null && !this.factuurId.equals(other.factuurId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Factuur[ factuurId=" + factuurId + " ]";
    }
    
}
