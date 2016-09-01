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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Sonja
 */
@Entity
@Table(name = "adres_type")
@NamedQueries({
    @NamedQuery(name = "AdresType.findAll", query = "SELECT a FROM AdresType a"),
    @NamedQuery(name = "AdresType.findByAdrestypeId", query = "SELECT a FROM AdresType a WHERE a.adrestypeId = :adrestypeId")})
public class AdresType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "adrestype_id")
    private Integer adrestypeId;
    
    @Basic(optional = true)
    @Column(name = "adrestype_naam")
    private String adrestypeNaam;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adrestypeIdadrestype")
    private Collection<KlantAdres> klantAdresCollection;

    public AdresType() {
    }

    public AdresType(Integer adrestypeId) {
        this.adrestypeId = adrestypeId;
    }

    public Integer getAdrestypeId() {
        return adrestypeId;
    }

    public void setAdrestypeId(Integer adrestypeId) {
        this.adrestypeId = adrestypeId;
    }

    public Collection<KlantAdres> getKlantAdresCollection() {
        return klantAdresCollection;
    }

    public void setKlantAdresCollection(Collection<KlantAdres> klantAdresCollection) {
        this.klantAdresCollection = klantAdresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adrestypeId != null ? adrestypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdresType)) {
            return false;
        }
        AdresType other = (AdresType) object;
        if ((this.adrestypeId == null && other.adrestypeId != null) || (this.adrestypeId != null && !this.adrestypeId.equals(other.adrestypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AdresType[ adrestypeId=" + adrestypeId + " ]";
    }
    
}
