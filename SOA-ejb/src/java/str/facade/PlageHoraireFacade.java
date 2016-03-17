/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package str.facade;

import str.entity.FicheHoraire;
import str.entity.PlageHoraire;
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
public class PlageHoraireFacade extends AbstractFacade<PlageHoraire> implements PlageHoraireFacadeLocal {
    @PersistenceContext(unitName = "SOA-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlageHoraireFacade() {
        super(PlageHoraire.class);
    }
    
    @Override
    public List<PlageHoraire> RecherchePlagesHorairesParFicheHoraire(FicheHoraire ficheHoraire) {
        String txt = "SELECT p FROM PlageHoraire p WHERE p.ficheHoraire=:ficheHoraire";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("ficheHoraire", ficheHoraire);
        return req.getResultList();
    }
}
