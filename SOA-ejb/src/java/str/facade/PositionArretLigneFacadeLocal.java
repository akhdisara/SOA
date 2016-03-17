/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package str.facade;

import str.entity.LigneSTR;
import str.entity.PositionArretLigne;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sara
 */
@Local
public interface PositionArretLigneFacadeLocal {

    void create(PositionArretLigne positionArretLigne);

    void edit(PositionArretLigne positionArretLigne);

    void remove(PositionArretLigne positionArretLigne);

    PositionArretLigne find(Object id);

    List<PositionArretLigne> findAll();

    List<PositionArretLigne> findRange(int[] range);

    int count();
    
    List<PositionArretLigne> RecherchePositionParLigne(LigneSTR ligne);
    
}
