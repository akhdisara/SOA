/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package str.facade;

import str.entity.Arret;
import str.entity.LigneSTR;
import str.entity.Trajet;
import java.util.ArrayList;
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
public class TrajetFacade extends AbstractFacade<Trajet> implements TrajetFacadeLocal {
    @PersistenceContext(unitName = "SOA-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrajetFacade() {
        super(Trajet.class);
    }
    
    @Override
    public List<Trajet> RechercheTrajetParLigne(LigneSTR ligne) {
        List T = new ArrayList<Trajet>();
        String txt = "SELECT T FROM Trajet T WHERE T.ligne=:ligne";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("ligne", ligne);
        return  req.getResultList();
    }
    @Override
    public double TarifBaseParArrets(LigneSTR ligne, Arret debut, Arret arrivee) {
        String txt = "SELECT T FROM Trajet T WHERE T.Debut=:Debut and T.Fin=:Fin and T.ligne=:ligne";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("Debut", debut);        
        req.setParameter("Fin", arrivee);        
        req.setParameter("ligne", ligne);   
        Trajet t = (Trajet)req.getResultList().get(0);
        return t.getTarifBase() ;
    }
    
    @Override
    public double TarifMensuelParArrets(LigneSTR ligne, Arret debut, Arret arrivee) {
        String txt = "SELECT T FROM Trajet T WHERE T.Debut=:Debut and T.Fin=:Fin and T.ligne=:ligne";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("Debut", debut);        
        req.setParameter("Fin", arrivee);        
        req.setParameter("ligne", ligne);   
        Trajet t = (Trajet)req.getResultList().get(0);
        return t.getTarifMensuel();
    }
    
    @Override
    public double TarifHebdomadaireParArrets(LigneSTR ligne, Arret debut, Arret arrivee) {
        String txt = "SELECT T FROM Trajet T WHERE T.Debut=:Debut and T.Fin=:Fin and T.ligne=:ligne";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("Debut", debut);        
        req.setParameter("Fin", arrivee);        
        req.setParameter("ligne", ligne);   
        Trajet t = (Trajet)req.getResultList().get(0);
        return t.getTarifHebdomadaire();
    }
}
