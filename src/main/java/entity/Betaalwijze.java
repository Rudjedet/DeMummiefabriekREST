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

/**
 *
 * @author Sonja
 */
@Entity
@Table(name = "betaalwijze")
@NamedQueries({
    @NamedQuery(name = "Betaalwijze.findAll", query = "SELECT b FROM Betaalwijze b"),
    @NamedQuery(name = "Betaalwijze.findByBetaalwijzeId", query = "SELECT b FROM Betaalwijze b WHERE b.betaalwijzeId = :betaalwijzeId")})
public class Betaalwijze implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "betaalwijze_id")
    private Integer betaalwijzeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "betaalwijzeIdbw")
    private Collection<Betaling> betalingCollection;

    public Betaalwijze() {
    }

    public Betaalwijze(Integer betaalwijzeId) {
        this.betaalwijzeId = betaalwijzeId;
    }

    public Integer getBetaalwijzeId() {
        return betaalwijzeId;
    }

    public void setBetaalwijzeId(Integer betaalwijzeId) {
        this.betaalwijzeId = betaalwijzeId;
    }

    public Collection<Betaling> getBetalingCollection() {
        return betalingCollection;
    }

    public void setBetalingCollection(Collection<Betaling> betalingCollection) {
        this.betalingCollection = betalingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (betaalwijzeId != null ? betaalwijzeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Betaalwijze)) {
            return false;
        }
        Betaalwijze other = (Betaalwijze) object;
        if ((this.betaalwijzeId == null && other.betaalwijzeId != null) || (this.betaalwijzeId != null && !this.betaalwijzeId.equals(other.betaalwijzeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Betaalwijze[ betaalwijzeId=" + betaalwijzeId + " ]";
    }
    
}
