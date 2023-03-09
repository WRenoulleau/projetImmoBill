package com.example.projetimmobill.modele;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;

public class RéservationDAO {
    private static String base = "BD_ImmoBill";
    private static int version = 1;
    BD_SQLiteOpenHelper accesBD;

    public RéservationDAO(Context ct) {
        accesBD = new BD_SQLiteOpenHelper(ct, base, null, version);
    }
    // CONSULTER
    public Réservation getRéservation(int id) {
        Réservation laRéservation = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery("select * from Réservation where id=" + id + ";", null);
        if (curseur.getCount() > 0) {
            curseur.moveToFirst();
            laRéservation = new Réservation(id,curseur.getString(1), curseur.getString(2), curseur.getInt(3), curseur.getInt(4), curseur.getString(5), curseur.getString(6), curseur.getString(7));
        }
        return laRéservation;
    }

    public ArrayList<Réservation> getVilla() {
        Cursor curseur;
        String req = "select * from Réservation";
        curseur = accesBD.getReadableDatabase().rawQuery(req, null);
        return cursorToRéservationArrayList(curseur);
    }

    private ArrayList<Réservation> cursorToRéservationArrayList(Cursor curseur) {
        ArrayList<Réservation> listeRéservation = new ArrayList<Réservation>();
        int id;
        String dateArrivee;
        String dateDepart;
        int nbAdultes;
        int nbEnfants;
        String dateResa;
        String montant;
        String optionMenage;

        curseur.moveToFirst();
        while (!curseur.isAfterLast()) {
            id = curseur.getInt(0);
            dateArrivee = curseur.getString(1);
            dateDepart = curseur.getString(2);
            nbAdultes = curseur.getInt(3);
            nbEnfants = curseur.getInt(4);
            dateResa = curseur.getString(5);
            montant = curseur.getString(6);
            optionMenage = curseur.getString(7);

            listeRéservation.add(new Réservation(id, dateArrivee, dateDepart, nbAdultes, nbEnfants, dateResa, montant, optionMenage));
            curseur.moveToNext();
        }
        return listeRéservation;
    }

    // AJOUTER
    public long addRéservation(Réservation uneRéservation) {
        long ret;
        SQLiteDatabase bd = accesBD.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put("id", uneRéservation.getId());
        value.put("dateArrivee", uneRéservation.getDateArrivee());
        value.put("dateDepard", uneRéservation.getDateDepart());
        value.put("nbAdultes", uneRéservation.getNbAdultes());
        value.put("nbEnfants", uneRéservation.getNbEnfants());
        value.put("dateResa", uneRéservation.getDateResa());
        value.put("montant", uneRéservation.getMontant());
        value.put("optionMenage", uneRéservation.getOptionMenage());
        ret = bd.insert("Réservation", null, value);

        return ret;
    }
}
