package com.example.projetimmobill.modele;

public class Locataire {

    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private String tel;
    private String email;
    private String commentaire;

    public Locataire(int id, String nom, String prenom, String adresse, String tel, String email, String commentaire){
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.adresse=adresse;
        this.tel=tel;
        this.email=email;
        this.commentaire=commentaire;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom= prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String toString(){
        return(id+" "+nom+" "+prenom+", "+adresse+" , "+tel+" , "+email+"   commentaire:"+commentaire);
    }
}
