package com.example.projetimmobill.modele;

import com.example.projetimmobill.controleur.UserConsultReservationsActivity;
import com.google.android.material.progressindicator.AnimatorDurationScaleProvider;

import java.util.Date;


public class Reservation {

    private int id;
    private String dateArrivee;
    private String dateDepart;
    private int nbAdultes;
    private int nbEnfants;
    private String dateResa;
    private String montant;
    private String optionMenage;
    private int idVilla;
    private int idLocataire;

    public Reservation(int id, String dateArrivee, String dateDepart, int nbAdultes, int nbEnfants, String dateResa, String montant, String optionMenage,int idLocataire,int idVilla){
        this.id=id;
        this.dateArrivee=dateArrivee;
        this.dateDepart=dateDepart;
        this.nbAdultes=nbAdultes;
        this.nbEnfants=nbEnfants;
        this.dateResa=dateResa;
        this.montant=montant;
        this.optionMenage=optionMenage;
        this.idVilla=idVilla;
        this.idLocataire=idLocataire;
    }

    public int getIdV() {
        return idVilla;
    }

    public void setIdV(int typeV) {
        this.idVilla = typeV;
    }

    public int getIdLocataire() {
        return idLocataire;
    }

    public void setIdLocataire(int idLocataire) {
        this.idLocataire = idLocataire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(String dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public String getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(String dateDepart) {
        this.dateDepart = dateDepart;
    }

    public int getNbAdultes() {
        return nbAdultes;
    }

    public void setNbAdultes(int nbAdultes) {
        this.nbAdultes = nbAdultes;
    }

    public int getNbEnfants() {
        return nbEnfants;
    }

    public void setNbEnfants(int nbEnfants) {
        this.nbEnfants = nbEnfants;
    }

    public String getDateResa() {
        return dateResa;
    }

    public void setDateResa(String dateResa) {
        this.dateResa = dateResa;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant= montant;
    }

    public String getOptionMenage() {
        return optionMenage;
    }

    public void setOptionMenage(String optionMenage) {
        this.optionMenage = optionMenage;
    }

    public String toString(){
        return("Code de la Réservation : " +id+ " \n"+
                "Code de la Villa : " + idVilla+ " \n"+
                "Du : "+dateArrivee+ " au "+dateDepart+ " \n"+
                "Nombre d'adultes : "+nbAdultes+ " ; Nombre d'enfants : "+nbEnfants+ " \n"+
                "Option ménage : "+optionMenage+ " \n"+
                "Montant à regler : "+montant);
    }



    public int getIdVilla() {
        return idVilla;
    }

    public void setIdVilla(int idVilla) {
        this.idVilla = idVilla;
    }
}
