/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.BesteldArtikel;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sonja
 */
@Stateless
public class BesteldArtikelFacade extends AbstractFacade<BesteldArtikel> {

    @PersistenceContext(unitName = "com.mycompany_DeMummiefabriek_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BesteldArtikelFacade() {
        super(BesteldArtikel.class);
    }
    
    public List<BesteldArtikel>findBesteldeArtikelen(int bestellingId){
        Query query = em.createNamedQuery("BesteldArtikel.findByBestellingId", BesteldArtikel.class);
        query.setParameter("bestelling_id", bestellingId);
        
        return query.getResultList();
    }
    
}
