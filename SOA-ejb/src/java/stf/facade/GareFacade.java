/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stf.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import stf.entity.Gare;

/**
 *
 * @author 5150796
 */
@Stateless
public class GareFacade extends AbstractFacade<Gare> implements GareFacadeLocal {
    @PersistenceContext(unitName = "SOA-ejbPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GareFacade() {
        super(Gare.class);
    }
    
    @Override
    public List<Gare> RetournerGares() {
        List<Gare> listeG;
        Gare g = null;
        String txt = "SELECT g FROM Gare as g";
        Query req = getEntityManager().createQuery(txt);
        listeG = req.getResultList();
        return listeG;
    }
}
