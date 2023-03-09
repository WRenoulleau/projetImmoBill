package com.example.projetimmobill.modele;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class TypeVillaDAO {
    private static String base = "BD_ImmoBill";
    private static int version = 1;
    BD_SQLiteOpenHelper accesBD;

    public TypeVillaDAO(Context ct) {
        accesBD = new BD_SQLiteOpenHelper(ct, base, null, version);
    }

    // CONSULTER

    public TypeVilla getTypeVilla(int id) {
        TypeVilla leTypeVilla = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery("select * from TypeVilla where id=" + id + ";", null);
        if (curseur.getCount() > 0) {
            curseur.moveToFirst();
            leTypeVilla = new TypeVilla(id,curseur.getString(1), curseur.getInt(2));
        }
        return leTypeVilla;
    }

    public ArrayList<TypeVilla> getTypeVilla() {
        Cursor curseur;
        String req = "select * from TypeVilla";
        curseur = accesBD.getReadableDatabase().rawQuery(req, null);
        return cursorToTypeVillaArrayList(curseur);
    }

    private ArrayList<TypeVilla> cursorToTypeVillaArrayList(Cursor curseur) {
        ArrayList<TypeVilla> listeTypeVilla = new ArrayList<TypeVilla>();
        int id;
        String nom;
        int nbCouchages;


        curseur.moveToFirst();
        while (!curseur.isAfterLast()) {
            id = curseur.getInt(0);
            nom = curseur.getString(1);
            nbCouchages = curseur.getInt(2);
            listeTypeVilla.add(new TypeVilla(id, nom, nbCouchages));
            curseur.moveToNext();
        }
        return listeTypeVilla;
    }
}
