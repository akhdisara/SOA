/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package str.facade;

import str.entity.Car;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sara
 */
@Stateless
public class CarFacade extends AbstractFacade<Car> implements CarFacadeLocal {
    @PersistenceContext(unitName = "SOA-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarFacade() {
        super(Car.class);
    }
    
}
