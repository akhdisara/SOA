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
import stf.entity.Horaire;
import stf.entity.Ligne;

/**
 *
 * @author 5150796
 */
@Stateless
public class HoraireFacade extends AbstractFacade<Horaire> implements HoraireFacadeLocal {
    @PersistenceContext(unitName = "SOA-ejbPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HoraireFacade() {
        super(Horaire.class);
    }
    
    @Override
    public List<Horaire> RechercherHoraireParLigne(Ligne ligne) {
        List<Horaire> listeH;
        Horaire h = null;
        String txt = "SELECT h FROM Horaire as h WHERE h.laLigne=:laLigne order by h.dateHoraire ASC";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("laLigne", ligne);
        listeH = req.getResultList();
        return listeH;
    }
}
