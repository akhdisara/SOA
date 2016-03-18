/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package str.facade;

import str.entity.LigneSTR;
import str.entity.PositionArretLigne;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import str.entity.Arret;

/**
 *
 * @author Sara
 */
@Stateless
public class PositionArretLigneFacade extends AbstractFacade<PositionArretLigne> implements PositionArretLigneFacadeLocal {
    @PersistenceContext(unitName = "SOA-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PositionArretLigneFacade() {
        super(PositionArretLigne.class);
    }
    
    @Override
    public List<PositionArretLigne> RecherchePositionParLigne(LigneSTR ligne) {
        String txt = "SELECT p FROM PositionArretLigne p WHERE p.ligne=:ligne";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("ligne", ligne);
        return req.getResultList();
    }
    
    @Override
    public List<PositionArretLigne> RecherchePositionParArret(Arret arret) {
        String txt = "SELECT p FROM PositionArretLigne p WHERE p.arret=:arret";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("arret", arret);
        return req.getResultList();
    }
}
