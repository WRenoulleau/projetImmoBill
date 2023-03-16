package com.example.projetimmobill.modele;

public class TypeVilla {

    private int id;
    private String nom;
    private int nbCouchages;


    public TypeVilla(int id, String nom, int nbCouchages){
        this.id=id;
        this.nom=nom;
        this.nbCouchages=nbCouchages;
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

    public int getNbCouchages() {
        return nbCouchages;
    }

    public void setNbCouchages(int nbCouchages) {
        this.nbCouchages = nbCouchages;
    }

    public String toString(){
        return(nom) ;
    }
}
