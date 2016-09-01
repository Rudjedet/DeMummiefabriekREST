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
@Table(name = "betaling")
@NamedQueries({
    @NamedQuery(name = "Betaling.findAll", query = "SELECT b FROM Betaling b"),
    @NamedQuery(name = "Betaling.findByBetalingId", query = "SELECT b FROM Betaling b WHERE b.betalingId = :betalingId")})
public class Betaling implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "betaling_id")
    private Integer betalingId;
    @JoinColumn(name = "betaalwijze_idbw", referencedColumnName = "betaalwijze_id")
    @ManyToOne(optional = false)
    private Betaalwijze betaalwijzeIdbw;
    @JoinColumn(name = "factuur_idfactuur", referencedColumnName = "factuur_id")
    @ManyToOne(optional = false)
    private Factuur factuurIdfactuur;
    @JoinColumn(name = "klant_idklant", referencedColumnName = "klant_id")
    @ManyToOne(optional = false)
    private Klant klantIdklant;

    public Betaling() {
    }

    public Betaling(Integer betalingId) {
        this.betalingId = betalingId;
    }

    public Integer getBetalingId() {
        return betalingId;
    }

    public void setBetalingId(Integer betalingId) {
        this.betalingId = betalingId;
    }

    public Betaalwijze getBetaalwijzeIdbw() {
        return betaalwijzeIdbw;
    }

    public void setBetaalwijzeIdbw(Betaalwijze betaalwijzeIdbw) {
        this.betaalwijzeIdbw = betaalwijzeIdbw;
    }

    public Factuur getFactuurIdfactuur() {
        return factuurIdfactuur;
    }

    public void setFactuurIdfactuur(Factuur factuurIdfactuur) {
        this.factuurIdfactuur = factuurIdfactuur;
    }

    public Klant getKlantIdklant() {
        return klantIdklant;
    }

    public void setKlantIdklant(Klant klantIdklant) {
        this.klantIdklant = klantIdklant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (betalingId != null ? betalingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Betaling)) {
            return false;
        }
        Betaling other = (Betaling) object;
        if ((this.betalingId == null && other.betalingId != null) || (this.betalingId != null && !this.betalingId.equals(other.betalingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Betaling[ betalingId=" + betalingId + " ]";
    }
    
}
