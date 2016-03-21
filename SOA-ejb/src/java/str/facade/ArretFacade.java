/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package str.facade;

import java.util.List;
import str.entity.Arret;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
    
    @Override
    public Arret RechercheArretParNom(String nom) {
        try {
            String txt = "SELECT Ar FROM Arret Ar WHERE Ar.Nom=:nom";
            Query req = getEntityManager().createQuery(txt);
            req.setParameter("nom", nom);
            return (Arret) req.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
