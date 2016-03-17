/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stf.facade;

import java.util.List;
import javax.ejb.Local;
import stf.entity.Abonnement;

/**
 *
 * @author 5150796
 */
@Local
public interface AbonnementFacadeLocal {

    void create(Abonnement abonnement);

    void edit(Abonnement abonnement);

    void remove(Abonnement abonnement);

    Abonnement find(Object id);

    List<Abonnement> findAll();

    List<Abonnement> findRange(int[] range);

    int count();
    
    List <Abonnement> RetournerAbonnement();
}
