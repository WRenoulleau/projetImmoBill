package com.example.projetimmobill.modele;

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

    public Reservation(int id, String dateArrivee, String dateDepart, int nbAdultes, int nbEnfants, String dateResa, String montant, String optionMenage,int idVilla,int idLocataire){
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
        return("id"+id+"dateArrivee"+dateArrivee+"dateDepart"+dateDepart+"nbAdults"+nbAdultes+"nbEnfants"+nbEnfants+"dateResa"+dateResa+"montant"+montant+"optionMenage"+optionMenage);
    }
}
