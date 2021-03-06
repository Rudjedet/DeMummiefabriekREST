/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.KlantAdres;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sonja
 */
@Stateless
public class KlantAdresFacade extends AbstractFacade<KlantAdres> {

    @PersistenceContext(unitName = "com.mycompany_DeMummiefabriek_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KlantAdresFacade() {
        super(KlantAdres.class);
    }
    
}
