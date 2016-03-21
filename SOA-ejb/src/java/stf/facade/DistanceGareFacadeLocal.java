/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stf.facade;

import java.util.List;
import javax.ejb.Local;
import stf.entity.DistanceGare;
import stf.entity.Gare;
import stf.entity.Ligne;

/**
 *
 * @author 5150796
 */
@Local
public interface DistanceGareFacadeLocal {

    void create(DistanceGare distanceGare);

    void edit(DistanceGare distanceGare);

    void remove(DistanceGare distanceGare);

    DistanceGare find(Object id);

    List<DistanceGare> findAll();

    List<DistanceGare> findRange(int[] range);

    int count();
    
    List<DistanceGare> RetournerDistanceGareParLigne(Ligne laLigne);
    
    List<DistanceGare> RetournerDistanceGareParGare(Gare laGare);
    
    double RetournerDistanceLigneGare(Ligne laLigne , Gare laGare);
}
