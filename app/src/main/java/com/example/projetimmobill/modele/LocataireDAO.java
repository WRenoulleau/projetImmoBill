package com.example.projetimmobill.modele;

import android.content.Context;
import android.database.Cursor;

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
}
