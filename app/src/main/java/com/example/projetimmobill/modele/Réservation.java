package com.example.projetimmobill.modele;

import java.util.Date;

public class Réservation {

    private int id;
    private String dateArrivee;
    private String dateDepart;
    private int nbAdultes;
    private int nbEnfants;
    private String dateResa;
    private String montant;
    private int optionMenage;

    public Réservation(int id, String dateArrivee, String dateDepart, int nbAdultes, int nbEnfants, String dateResa, String montant, int optionMenage){
        this.id=id;
        this.dateArrivee=dateArrivee;
        this.dateDepart=dateDepart;
        this.nbAdultes=nbAdultes;
        this.nbEnfants=nbEnfants;
        this.dateResa=dateResa;
        this.montant=montant;
        this.optionMenage=optionMenage;
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

    public int getOptionMenage() {
        return optionMenage;
    }

    public void setOptionMenage(int optionMenage) {
        this.optionMenage = optionMenage;
    }

    public String toString(){
        return("id"+id+"dateArrivee"+dateArrivee+"dateDepart"+dateDepart+"nbAdults"+nbAdultes+"nbEnfants"+nbEnfants+"dateResa"+dateResa+"montant"+montant+"optionMenage"+optionMenage);
    }
}
