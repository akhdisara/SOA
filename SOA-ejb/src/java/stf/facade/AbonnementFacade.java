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
import stf.entity.Abonnement;

/**
 *
 * @author 5150796
 */
@Stateless
public class AbonnementFacade extends AbstractFacade<Abonnement> implements AbonnementFacadeLocal {
    @PersistenceContext(unitName = "SOA-ejbPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AbonnementFacade() {
        super(Abonnement.class);
    }
    
     @Override
    public List <Abonnement> RetournerAbonnement() {
        List <Abonnement> listeA;
        Abonnement g = null;
        String txt = "SELECT g FROM Abonnement as g order by g.type ASC";
        Query req = getEntityManager().createQuery(txt);
        listeA = req.getResultList();
        return listeA;
    }
}
