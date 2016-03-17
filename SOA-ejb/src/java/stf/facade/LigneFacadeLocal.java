/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stf.facade;

import java.util.List;
import javax.ejb.Local;
import stf.entity.Ligne;

/**
 *
 * @author 5150796
 */
@Local
public interface LigneFacadeLocal {

    void create(Ligne ligne);

    void edit(Ligne ligne);

    void remove(Ligne ligne);

    Ligne find(Object id);

    List<Ligne> findAll();

    List<Ligne> findRange(int[] range);

    int count();
    
    List<Ligne> RetournerLignes();
    
    Ligne RechercherLigneParId(long id);
    
    Ligne RechercherLigneParNum(int numLigne);
}
