/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webService;

import str.entity.Arret;
import str.entity.FicheHoraire;
import str.entity.LigneSTR;
import str.entity.Periode;
import str.entity.PlageHoraire;
import str.entity.PositionArretLigne;
import str.entity.Trajet;
import str.facade.FicheHoraireFacadeLocal;
import str.facade.PlageHoraireFacadeLocal;
import str.facade.PositionArretLigneFacadeLocal;
import str.facade.TrajetFacadeLocal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import stf.facade.HoraireFacadeLocal;
import str.entity.Reduction;
import str.facade.ArretFacadeLocal;
import str.facade.LigneSTRFacadeLocal;
import str.facade.ReductionFacadeLocal;

/**
 *
 * @author Sara
 */
@WebService(serviceName = "webServiceSTR")
@Stateless()
public class WebServicesSTR {
    @EJB
    private ArretFacadeLocal arretFacade;
    @EJB
    private HoraireFacadeLocal horaireFacade;
    @EJB
    private ReductionFacadeLocal reductionFacade;
    
    @EJB
    private LigneSTRFacadeLocal ligneSTRFacade;

    @EJB
    private PlageHoraireFacadeLocal plageHoraireFacade;
    @EJB
    private FicheHoraireFacadeLocal ficheHoraireFacade;

    @EJB
    private TrajetFacadeLocal trajetFacade;
    @EJB
    private PositionArretLigneFacadeLocal positionArretLigneFacade;



    @WebMethod(operationName = "RechercheLigneParId")
    public LigneSTR RechercheLigneParId(@WebParam(name = "id") Long id) {
        return ligneSTRFacade.RechercheLigneParId(id);
    }

    @WebMethod(operationName = "RecherchePositionParLigne")
    public List RecherchePositionParLigne(@WebParam(name = "ligne") LigneSTR ligne) {
        return positionArretLigneFacade.RecherchePositionParLigne(ligne);
    }

    /*@WebMethod(operationName = "ArretLignePosition")
     public List ArretLignePosition() {
     List result = new ArrayList();
     List<PositionArretLigne> listReturn = positionArretLigneFacade.RecherchePositionParLigne();
     System.out.println("--->"+listReturn);
     for (int i = 0; i < 20; ++i) {
     PositionArretLigne DataObject = new PositionArretLigne();
     DataObject.setId(listReturn.get(0).getId());
     DataObject.setLigne(listReturn.get(0).getLigne());
     DataObject.setArret(listReturn.get(0).getArret());
     DataObject.setPosition(listReturn.get(0).getPosition());
     result.add(DataObject);
     }
     return result;
     } */
    @WebMethod(operationName = "listeLignesSTR")
    public List listeLignesSTR() {
        List<LigneSTR> listReturn = ligneSTRFacade.afficherListeLigne();
        return listReturn;
    }

    @WebMethod(operationName = "InvokePositionArretLigne")
    public PositionArretLigne InvokePositionArretLigne() {
        return null;
    }

    @WebMethod(operationName = "InvokeTrajet")
    public Trajet InvokeTrajet() {
        return null;
    }

    @WebMethod(operationName = "InvokeLigne")
    public LigneSTR InvokeLigne() {
        return null;
    }

    @WebMethod(operationName = "InvokePlageHoraire")
    public PlageHoraire InvokePlageHoraire() {
        return null;
    }

    @WebMethod(operationName = "InvokeFicheHoraire")
    public FicheHoraire InvokeFicheHoraire() {
        return null;
    }

    @WebMethod(operationName = "InvokeReduction")
    public Reduction InvokeReduction() {
        return null;
    }
    
    @WebMethod(operationName = "RechercheTrajetParLigne")
    public List RechercheTrajetParLigne(@WebParam(name = "ligne") LigneSTR ligne) {
        List result = new ArrayList();
        List<Trajet> listReturn = trajetFacade.RechercheTrajetParLigne(ligne);
        for (int i = 0; i < listReturn.size(); i++) {
            Trajet DataObject = new Trajet();
            DataObject.setId(listReturn.get(i).getId());
            DataObject.setDebut(listReturn.get(i).getDebut());
            DataObject.setFin(listReturn.get(i).getFin());
            DataObject.setTarifBase(listReturn.get(i).getTarifBase());
            DataObject.setTarifHebdomadaire(listReturn.get(i).getTarifHebdomadaire());
            DataObject.setTarifMensuel(listReturn.get(i).getTarifMensuel());
            result.add(DataObject);
        }
        return result;
    }

    @WebMethod(operationName = "RechercheTrajetParLigneID")
    public List RechercheTrajetParLigneID(@WebParam(name = "id") Long id) {
        List result = new ArrayList();
        LigneSTR ligne = ligneSTRFacade.RechercheLigneParId(id);
        List<Trajet> listReturn = trajetFacade.RechercheTrajetParLigne(ligne);
        for (int i = 0; i < listReturn.size(); i++) {
            Trajet DataObject = new Trajet();
            DataObject.setId(listReturn.get(i).getId());
            DataObject.setDebut(listReturn.get(i).getDebut());
            DataObject.setFin(listReturn.get(i).getFin());
            DataObject.setTarifBase(listReturn.get(i).getTarifBase());
            DataObject.setTarifHebdomadaire(listReturn.get(i).getTarifHebdomadaire());
            DataObject.setTarifMensuel(listReturn.get(i).getTarifMensuel());
            result.add(DataObject);
        }
        return result;
    }

    @WebMethod(operationName = "TarifBaseParArrets")
    public double TarifBaseParArrets(@WebParam(name = "ligne") LigneSTR ligne, @WebParam(name = "debut") Arret debut, @WebParam(name = "arrivee") Arret arrivee) {
        return trajetFacade.TarifBaseParArrets(ligne, debut, arrivee);
    }

    @WebMethod(operationName = "TarifHebdomadaireParArrets")
    public double TarifHebdomadaireParArrets(@WebParam(name = "ligne") LigneSTR ligne, @WebParam(name = "debut") Arret debut, @WebParam(name = "arrivee") Arret arrivee) {
        return trajetFacade.TarifHebdomadaireParArrets(ligne, debut, arrivee);
    }

    @WebMethod(operationName = "TarifMensuelParArrets")
    public double TarifMensuelParArrets(@WebParam(name = "ligne") LigneSTR ligne, @WebParam(name = "debut") Arret debut, @WebParam(name = "arrivee") Arret arrivee) {
        return trajetFacade.TarifMensuelParArrets(ligne, debut, arrivee);
    }

    @WebMethod(operationName = "RechercheFicheHoraireParLignePeriode")
    public List RechercheFicheHoraireParLignePeriode(@WebParam(name = "ligne") LigneSTR ligne,@WebParam(name = "periode") Periode periode) {
        List result = new ArrayList();      
        List<FicheHoraire> listReturn = ficheHoraireFacade.RechercheFicheHoraireParLignePeriode(ligne,periode);
        for (int i = 0; i < listReturn.size(); i++) {
            FicheHoraire DataObject = new FicheHoraire();
            DataObject.setId(listReturn.get(i).getId());
            DataObject.setLigne(listReturn.get(i).getLigne());
            result.add(DataObject);
        }
        return result;
    }
    
    @WebMethod(operationName = "RecherchePlagesHorairesParFicheHoraire")
    public List RecherchePlagesHorairesParFicheHoraire(@WebParam(name = "ficheHoraire") FicheHoraire ficheHoraire) {     
        List<PlageHoraire> listReturn = plageHoraireFacade.RecherchePlagesHorairesParFicheHoraire(ficheHoraire);
        return listReturn;
    }
    
    @WebMethod(operationName = "afficherListeReductions")
    public Collection afficherListeReductions() {     
        Collection<Reduction> listReturn = reductionFacade.afficherListeReductions();
        return listReturn;
    }
    
    @WebMethod(operationName = "RechercheLigneSTRParIdentifiant")
    public LigneSTR RechercheLigneSTRParIdentifiant(String Identifiant) {     
        return ligneSTRFacade.RechercheLigne(Identifiant);
    }
    
    @WebMethod(operationName = "afficherListeArretsSTR")
    public List<Arret> afficherListeArretsSTR() {     
        return arretFacade.afficherListeArrets();
    }

}
