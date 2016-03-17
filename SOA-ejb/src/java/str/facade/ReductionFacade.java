/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package str.facade;

import java.util.Collection;
import str.entity.Reduction;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sara
 */
@Stateless
public class ReductionFacade extends AbstractFacade<Reduction> implements ReductionFacadeLocal {
    @PersistenceContext(unitName = "SOA-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReductionFacade() {
        super(Reduction.class);
    }
    
    @Override
    public Collection<Reduction> afficherListeReductions() {
        String txt = "SELECT r FROM Reduction AS r";
        Query req = getEntityManager().createQuery(txt);
        return req.getResultList();
    }
    
}
