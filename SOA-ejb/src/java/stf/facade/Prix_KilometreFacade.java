/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stf.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import stf.entity.Prix_Kilometre;

/**
 *
 * @author 5150796
 */
@Stateless
public class Prix_KilometreFacade extends AbstractFacade<Prix_Kilometre> implements Prix_KilometreFacadeLocal {
    @PersistenceContext(unitName = "SOA-ejbPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Prix_KilometreFacade() {
        super(Prix_Kilometre.class);
    }
    
}
