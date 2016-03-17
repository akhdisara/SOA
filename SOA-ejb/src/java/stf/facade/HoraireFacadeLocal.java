/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stf.facade;

import java.util.List;
import javax.ejb.Local;
import stf.entity.Horaire;
import stf.entity.Ligne;

/**
 *
 * @author 5150796
 */
@Local
public interface HoraireFacadeLocal {

    void create(Horaire horaire);

    void edit(Horaire horaire);

    void remove(Horaire horaire);

    Horaire find(Object id);

    List<Horaire> findAll();

    List<Horaire> findRange(int[] range);

    int count();
    
    List<Horaire> RechercherHoraireParLigne(Ligne ligne);
}
