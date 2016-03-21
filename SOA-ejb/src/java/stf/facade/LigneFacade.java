/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stf.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import stf.entity.Ligne;
import str.entity.LigneSTR;

/**
 *
 * @author 5150796
 */
@Stateless
public class LigneFacade extends AbstractFacade<Ligne> implements LigneFacadeLocal {

    @PersistenceContext(unitName = "SOA-ejbPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LigneFacade() {
        super(Ligne.class);
    }

    @Override
    public List<Ligne> RetournerLignes() {
        List<Ligne> listeL;
        String txt = "SELECT l FROM Ligne as l order by l.numLigne ASC";
        Query req = getEntityManager().createQuery(txt);
        listeL = req.getResultList();
        return listeL;
    }

    @Override
    public Ligne RechercherLigneParId(long id) {
        Ligne l;
        String txt = "SELECT l FROM Ligne AS l WHERE l.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("id", id);
        l = (Ligne) req.getSingleResult();
        return l;
    }

    @Override
    public Ligne RechercherLigneParNum(int numLigne) {
        try {
            Ligne l;
            String txt = "SELECT l FROM Ligne AS l WHERE l.numLigne=:numLigne";
            Query req = getEntityManager().createQuery(txt);
            req = req.setParameter("numLigne", numLigne);
            l = (Ligne) req.getSingleResult();
            return l;
        } catch (NoResultException e) {
            return null;
        }
    }
}
