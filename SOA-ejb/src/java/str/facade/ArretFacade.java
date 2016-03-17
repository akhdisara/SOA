/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package str.facade;

import java.util.Collection;
import java.util.List;
import str.entity.Arret;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sara
 */
@Stateless
public class ArretFacade extends AbstractFacade<Arret> implements ArretFacadeLocal {
    @PersistenceContext(unitName = "SOA-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArretFacade() {
        super(Arret.class);
    }
    
    @Override
    public List<Arret> afficherListeArrets() {
        List Ar;
        String txt = "SELECT Ar FROM Arret AS Ar";
        Query req = getEntityManager().createQuery(txt);
        Ar = req.getResultList();
        return Ar;

    }
}
