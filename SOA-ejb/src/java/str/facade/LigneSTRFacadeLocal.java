/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package str.facade;

import java.util.List;
import javax.ejb.Local;
import str.entity.LigneSTR;

/**
 *
 * @author 5150796
 */
@Local
public interface LigneSTRFacadeLocal {

    void create(LigneSTR ligneSTR);

    void edit(LigneSTR ligneSTR);

    void remove(LigneSTR ligneSTR);

    LigneSTR find(Object id);

    List<LigneSTR> findAll();

    List<LigneSTR> findRange(int[] range);

    int count();

    List<LigneSTR> afficherListeLigne();

    LigneSTR RechercheLigne(String Identifiant);

    LigneSTR RechercheLigneParId(Long id);

}
