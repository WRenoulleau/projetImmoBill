package com.example.projetimmobill.modele;


import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class VillaDAO {
    private static String base = "BD_ImmoBill";
    private static int version = 1;
    BD_SQLiteOpenHelper accesBD;

    public VillaDAO(Context ct) {
        accesBD = new BD_SQLiteOpenHelper(ct, base, null, version);
    }
                                                                                                                            // CONSULTER
    public Villa getVilla(int id) {
        Villa laVilla = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery("select * from Villa where id=" + id + ";", null);
        if (curseur.getCount() > 0) {
            curseur.moveToFirst();
            laVilla = new Villa(id,curseur.getString(1), curseur.getString(2));
        }
        return laVilla;
    }

    public ArrayList<Villa> getVilla() {
        Cursor curseur;
        String req = "select * from Villa";
        curseur = accesBD.getReadableDatabase().rawQuery(req, null);
        return cursorToVillaArrayList(curseur);
    }

    private ArrayList<Villa> cursorToVillaArrayList(Cursor curseur) {
        ArrayList<Villa> listeVilla = new ArrayList<Villa>();
        int id;
        String nom;
        String adresse;
        String description;
        String pieces;
        float surface;
        String anneeConstruction;
        String caution;
        String montant;

        curseur.moveToFirst();
        while (!curseur.isAfterLast()) {
            id = curseur.getInt(0);
            nom = curseur.getString(1);
            adresse = curseur.getString(2);
            description = curseur.getString(3);
            pieces = curseur.getString(4);
            surface = curseur.getFloat(5);
            anneeConstruction = curseur.getString(6);
            caution = curseur.getString(7);
            montant = curseur.getString(7);
            listeVilla.add(new Villa(id, nom, adresse, description, pieces, surface, anneeConstruction, caution, montant));
            curseur.moveToNext();
        }
        return listeVilla;
    }                                                                                                                                   //FIN CONSULER
}
