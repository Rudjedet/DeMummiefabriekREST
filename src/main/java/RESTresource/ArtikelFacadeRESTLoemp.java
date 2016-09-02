/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RESTresource;

import entity.Artikel;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Sonja
 */
@Stateless
@Path("entity.artikel")
public class ArtikelFacadeRESTLoemp {

    @PersistenceContext(unitName = "com.mycompany_DeMummiefabriek_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public ArtikelFacadeRESTLoemp() {
    }
    
    private Class<Artikel> artikelEntity;

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Artikel artikel) {
        getEntityManager().persist(artikel);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Artikel artikel) {
        getEntityManager().merge(artikel);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id, Artikel artikel) {
        getEntityManager().remove(getEntityManager().merge(artikel));
        getEntityManager().find(artikelEntity, id);
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Artikel findArtikel(@PathParam("id") Integer id) {
        return getEntityManager().find(artikelEntity, id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Artikel> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(artikelEntity));
        return getEntityManager().createQuery(cq).getResultList();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Artikel> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return rangeFinder(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(count());
    }

    protected EntityManager getEntityManager() {
        return em;
    }
    
    public Artikel find(Integer id) {
        return getEntityManager().find(artikelEntity, id);
    }
    
    public List<Artikel> rangeFinder(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(artikelEntity));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }
    
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<Artikel> rt = cq.from(artikelEntity);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
}
