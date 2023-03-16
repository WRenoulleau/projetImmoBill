package com.example.projetimmobill.modele;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class LocataireDAO {
    private static String base = "BD_ImmoBill";
    private static int version = 1;
    BD_SQLiteOpenHelper accesBD;

    public LocataireDAO(Context ct) {
        accesBD = new BD_SQLiteOpenHelper(ct, base, null, version);
    }

    // CONSULTER

    public Locataire getLocataire(int id) {
        Locataire leLocataire = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery("select * from Locataire where id=" + id + ";", null);
        if (curseur.getCount() > 0) {
            curseur.moveToFirst();
            leLocataire = new Locataire(id,curseur.getString(1), curseur.getString(2),curseur.getString(3), curseur.getString(4),curseur.getString(5), curseur.getString(6));
        }
        return leLocataire;
    }

    public ArrayList<Locataire> getLocataire() {
        Cursor curseur;
        String req = "select * from Locataire";
        curseur = accesBD.getReadableDatabase().rawQuery(req, null);
        return cursorToLocataireArrayList(curseur);
    }

    private ArrayList<Locataire> cursorToLocataireArrayList(Cursor curseur) {
        ArrayList<Locataire> listeLocataires = new ArrayList<Locataire>();
        int id;
        String nom;
        String prenom;
        String adresse;
        String tel;
        String email;
        String commentaire;


        curseur.moveToFirst();
        while (!curseur.isAfterLast()) {
            id = curseur.getInt(0);
            nom = curseur.getString(1);
            prenom = curseur.getString(2);
            adresse = curseur.getString(3);
            tel = curseur.getString(4);
            email = curseur.getString(5);
            commentaire = curseur.getString(6);
            listeLocataires.add(new Locataire(id, nom, prenom, adresse, tel, email, commentaire));
            curseur.moveToNext();
        }
        return listeLocataires;
    }

    // AJOUTER
    public long addLocataire(Locataire unLocataire) {
        long ret;
        SQLiteDatabase bd = accesBD.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put("id", unLocataire.getId());
        value.put("nom", unLocataire.getNom());
        value.put("prenom", unLocataire.getPrenom());
        value.put("adresse", unLocataire.getAdresse());
        value.put("tel", unLocataire.getTel());
        value.put("email", unLocataire.getEmail());
        value.put("commentaire", unLocataire.getCommentaire());
        ret = bd.insert("Villa", null, value);

        return ret;
    } //FIN AJOUTER

    //Modifier--------------------------------------------------------------------------------------
    public int modifierLocataire(Locataire nvLocataire, Locataire ancLocataire){
        int ret;
        SQLiteDatabase bd = accesBD.getWritableDatabase();
        ContentValues value = new ContentValues();

        value.put("id",nvLocataire.getId());
        value.put("nom", nvLocataire.getNom());
        value.put("prenom", nvLocataire.getPrenom());
        value.put("adresse",nvLocataire.getAdresse());
        value.put("tel",nvLocataire.getTel());
        value.put("email",nvLocataire.getEmail());
        value.put("commentaire", nvLocataire.getCommentaire());


        String condition = "nom ='"+ancLocataire.getNom()+"' AND adresse='"+ancLocataire.getAdresse()+"'AND prenom='"+ancLocataire.getPrenom()+"'AND tel='"+ancLocataire.getTel()+
                "'AND email='"+ancLocataire.getEmail()+"'AND commentaire='"+ancLocataire.getCommentaire()+"'";

        ret = bd.update("villa", value, condition ,null);
        return ret;
    }//Fin Modifier---------------------------------------------------------------------------------

    //SUPPRIMER-------------------------------------------------------------------------------------
    public long supprimerLocataire(Locataire unLocataire){
        long ret;
        SQLiteDatabase bd = accesBD.getWritableDatabase();
        String condition = "nom ='"+unLocataire.getNom()+"' AND prenom='"+unLocataire.getPrenom()+"'";
        Log.d("Locataire supprime", condition);
        ret = bd.delete("Locataire", condition ,null);
        return ret;
    }//Fin SUPPRIMER--------------------------------------------------------------------------------
}
