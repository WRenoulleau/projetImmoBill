package com.example.projetimmobill.modele;

import androidx.dynamicanimation.animation.SpringAnimation;

public class Villa {

    private int id;
    private String nom;
    private String adresse;
    private String description;
    private String pieces;
    private float surface;
    private String anneeConstruction;
    private String caution;
    private String montant;


    public Villa(int id, String nom, String adresse,String description, String pieces, float surface, String anneeConstruction, String caution, String montant){
    this.id=id;
    this.nom=nom;
    this.adresse=adresse;
    this.description=description;
    this.pieces=pieces;
    this.surface=surface;
    this.anneeConstruction=anneeConstruction;
    this.caution=caution;
    this.montant=montant;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPieces() {
        return pieces;
    }

    public void setPieces(String pieces) {
        this.pieces = pieces;
    }

    public float getSurface() {
        return surface;
    }

    public void setSurface(float surface) {
        this.surface = surface;
    }

    public String getAnneeConstruction() {
        return anneeConstruction;
    }

    public void setAnneeConstruction(String anneeConstruction) {
        this.anneeConstruction = anneeConstruction;
    }

    public String getCaution() {
        return caution;
    }

    public void setCaution(String caution) {
        this.caution = caution;
    }
    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public String toString(){
        return("id"+id+"nom"+nom+"adresse"+adresse+"description"+description+"pieces"+pieces+"surface"+surface+"anneeConstruction"+anneeConstruction+"caution"+caution+"montant"+montant);
    }
}
