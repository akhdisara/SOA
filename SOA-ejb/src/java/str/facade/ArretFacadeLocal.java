/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package str.facade;

import str.entity.Arret;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sara
 */
@Local
public interface ArretFacadeLocal {

    void create(Arret arret);

    void edit(Arret arret);

    void remove(Arret arret);

    Arret find(Object id);

    List<Arret> findAll();

    List<Arret> findRange(int[] range);

    int count();
    
    List<Arret> afficherListeArrets();
    
    Arret RechercheArretParNom(String nom);
}
