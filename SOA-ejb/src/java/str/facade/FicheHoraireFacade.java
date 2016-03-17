/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package str.facade;

import str.entity.FicheHoraire;
import str.entity.LigneSTR;
import str.entity.Periode;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sara
 */
@Stateless
public class FicheHoraireFacade extends AbstractFacade<FicheHoraire> implements FicheHoraireFacadeLocal {
    @PersistenceContext(unitName = "SOA-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FicheHoraireFacade() {
        super(FicheHoraire.class);
    }
    
    
    @Override
    public List<FicheHoraire> RechercheFicheHoraireParLignePeriode(LigneSTR ligne , Periode periode) {
        String txt = "SELECT p FROM FicheHoraire p WHERE p.periode=:periode and p.ligne=:ligne ";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("periode", periode);
        req.setParameter("ligne", ligne);
        return req.getResultList();
    }
}
