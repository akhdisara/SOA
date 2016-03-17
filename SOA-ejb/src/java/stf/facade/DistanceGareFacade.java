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
    
}
