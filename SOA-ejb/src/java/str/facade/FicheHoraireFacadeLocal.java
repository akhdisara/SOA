/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package str.facade;

import str.entity.FicheHoraire;
import str.entity.LigneSTR;
import str.entity.Periode;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sara
 */
@Local
public interface FicheHoraireFacadeLocal {

    void create(FicheHoraire ficheHoraire);

    void edit(FicheHoraire ficheHoraire);

    void remove(FicheHoraire ficheHoraire);

    FicheHoraire find(Object id);

    List<FicheHoraire> findAll();

    List<FicheHoraire> findRange(int[] range);

    int count();
    
    List<FicheHoraire> RechercheFicheHoraireParLignePeriode(LigneSTR ligne , Periode periode);
    
}
