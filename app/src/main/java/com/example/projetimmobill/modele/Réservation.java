package com.example.projetimmobill.modele;

import java.util.Date;

public class Réservation {

    private int id;
    private Date dateArrivee;
    private Date dateDepart;
    private int nbAdultes;
    private int nbEnfants;
    private Date dateResa;
    private String montant;
    private Boolean optionMenage;

    public Réservation(int id, Date dateArrivee, Date dateDepart, int nbAdultes, int nbEnfants, Date dateResa, String montant, Boolean optionMenage){
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

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
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

    public Date getDateResa() {
        return dateResa;
    }

    public void setDateResa(Date dateResa) {
        this.dateResa = dateResa;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant= montant;
    }

    public Boolean getOptionMenage() {
        return optionMenage;
    }

    public void setOptionMenage(Boolean optionMenage) {
        this.optionMenage = optionMenage;
    }

    public String toString(){
        return("id"+id+"dateArrivee"+dateArrivee+"dateDepart"+dateDepart+"nbAdults"+nbAdultes+"nbEnfants"+nbEnfants+"dateResa"+dateResa+"montant"+montant+"optionMenage"+optionMenage);
    }
}
