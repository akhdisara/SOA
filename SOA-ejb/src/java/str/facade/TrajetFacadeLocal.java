/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package str.facade;

import str.entity.Arret;
import str.entity.LigneSTR;
import str.entity.Trajet;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sara
 */
@Local
public interface TrajetFacadeLocal {

    void create(Trajet trajet);

    void edit(Trajet trajet);

    void remove(Trajet trajet);

    Trajet find(Object id);

    List<Trajet> findAll();

    List<Trajet> findRange(int[] range);

    int count();

    List<Trajet> RechercheTrajetParLigne(LigneSTR ligne);

    double TarifBaseParArrets(LigneSTR l, Arret debut, Arret arrivee);

    double TarifMensuelParArrets(LigneSTR ligne, Arret debut, Arret arrivee);

    double TarifHebdomadaireParArrets(LigneSTR ligne, Arret debut, Arret arrivee);
}
