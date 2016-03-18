/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stf.facade;

import java.util.List;
import javax.ejb.Local;
import stf.entity.Gare;

/**
 *
 * @author 5150796
 */
@Local
public interface GareFacadeLocal {

    void create(Gare gare);

    void edit(Gare gare);

    void remove(Gare gare);

    Gare find(Object id);

    List<Gare> findAll();

    List<Gare> findRange(int[] range);

    int count();
    
    List<Gare> RetournerGares();
    
    Gare RechercherGareParNom(String nomGare);
}
