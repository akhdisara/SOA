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
import stf.entity.DistanceGare;
import stf.entity.Gare;
import stf.entity.Ligne;

/**
 *
 * @author 5150796
 */
@Stateless
public class DistanceGareFacade extends AbstractFacade<DistanceGare> implements DistanceGareFacadeLocal {
    @PersistenceContext(unitName = "SOA-ejbPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DistanceGareFacade() {
        super(DistanceGare.class);
    }
    
    @Override
    public List<DistanceGare> RetournerDistanceGareParLigne(Ligne laLigne) {
        List<DistanceGare> listeG;
        String txt = "SELECT g FROM DistanceGare as g WHERE g.laLigne=:laLigne";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("laLigne", laLigne);
        listeG = req.getResultList();
        return listeG;
    }
    
    @Override
    public List<DistanceGare> RetournerDistanceGareParGare(Gare laGare) {
        List<DistanceGare> listeG;
        String txt = "SELECT g FROM DistanceGare as g WHERE g.laGare=:laGare";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("laGare", laGare);
        listeG = req.getResultList();
        return listeG;
    }
    
    @Override
    public double RetournerDistanceLigneGare(Ligne laLigne , Gare laGare) {
        String txt = "SELECT g.distanceGare FROM DistanceGare as g WHERE g.laGare=:laGare and g.laLigne=:laLigne";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("laGare", laGare);
        req = req.setParameter("laLigne", laLigne);       
        return (double) req.getSingleResult();
    }
    
    
}
