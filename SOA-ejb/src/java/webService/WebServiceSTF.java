/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webService;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import stf.entity.Abonnement;
import stf.entity.DistanceGare;
import stf.entity.Gare;
import stf.entity.Horaire;
import stf.entity.Ligne;
import stf.entity.Prix_Kilometre;
import stf.facade.AbonnementFacadeLocal;
import stf.facade.DistanceGareFacadeLocal;
import stf.facade.GareFacadeLocal;
import stf.facade.HoraireFacadeLocal;
import stf.facade.LigneFacadeLocal;

/**
 *
 * @author 5150796
 */
@WebService(serviceName = "WebServiceSTF")
@Stateless()
public class WebServiceSTF {
    @EJB
    private HoraireFacadeLocal horaireFacade;
    @EJB
    private GareFacadeLocal gareFacade;

    @EJB
    private AbonnementFacadeLocal abonnementFacade;
    @EJB
    private DistanceGareFacadeLocal distanceGareFacade;

    @EJB
    private LigneFacadeLocal ligneFacade;

    @WebMethod(operationName = "RetournerLignesSTF")
    public List RetournerLignesSTF() {
        List<Ligne> listReturn = ligneFacade.RetournerLignes();
        return listReturn;
    }

    @WebMethod(operationName = "RetournerDistanceGareParLigne")
    public List<DistanceGare> RetournerDistanceGareParLigne(@WebParam(name = "ligne") Ligne ligne) {
        List<DistanceGare> listReturn = distanceGareFacade.RetournerDistanceGareParLigne(ligne);
        return listReturn;
    }
    
    @WebMethod(operationName = "RetournerDistanceGareParGare")
    public List<DistanceGare> RetournerDistanceGareParGare(@WebParam(name = "gare") Gare gare) {
        List<DistanceGare> listReturn = distanceGareFacade.RetournerDistanceGareParGare(gare);
        return listReturn;
    }

    @WebMethod(operationName = "RechercherLigneSTFParId")
    public Ligne RechercherLigneSTFParId(@WebParam(name = "id") Long id) {
        return ligneFacade.RechercherLigneParId(id);
    }

    @WebMethod(operationName = "InvokeLigneSTF")
    public Ligne InvokeLigneSTF() {
        return null;
    }

    @WebMethod(operationName = "InvokeDistanceGare")
    public DistanceGare InvokeDistanceGare() {
        return null;
    }

    @WebMethod(operationName = "InvokePrix_Kilometre")
    public Prix_Kilometre InvokePrix_Kilometre() {
        return null;
    }

    @WebMethod(operationName = "InvokeGare")
    public Gare InvokeGare() {
        return null;
    }

    @WebMethod(operationName = "InvokeHoraire")
    public Horaire InvokeHoraire() {
        return null;
    }

    @WebMethod(operationName = "GetPrixilometre")
    public double GetPrixilometre() {
        return new Prix_Kilometre().getPrixKilometre();
    }

    @WebMethod(operationName = "InvokeAbonnement")
    public Abonnement InvokeAbonnement() {
        return null;
    }

    @WebMethod(operationName = "RetournerAbonnementSTF")
    public List<Abonnement> RetournerAbonnementSTF() {
        return abonnementFacade.RetournerAbonnement();
    }

    @WebMethod(operationName = "RetournerGaresSTF")
    public List<Gare> RetournerGaresSTF() {
        return  gareFacade.RetournerGares();
    }
    
    @WebMethod(operationName = "RechercherHoraireSTFParLigne")
    public List<Horaire> RechercherHoraireSTFParLigne(@WebParam(name = "ligne") Ligne ligne) {
        List<Horaire> listReturn = horaireFacade.RechercherHoraireParLigne(ligne);
        return listReturn;
    }
    
    @WebMethod(operationName = "RechercherLigneSTFParNum")
    public Ligne RechercherLigneSTFParNum(@WebParam(name = "numLigne") int numLigne) {
        return ligneFacade.RechercherLigneParNum(numLigne);
    }
    
    @WebMethod(operationName = "RechercherGareParNom")
    public Gare RechercherGareParNom(@WebParam(name = "nom") String nom) {
        return  gareFacade.RechercherGareParNom(nom);
    }
}
