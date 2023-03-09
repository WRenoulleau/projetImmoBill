package com.example.projetimmobill.modele;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;

public class ReservationDAO {
    private static String base = "BD_ImmoBill";
    private static int version = 1;
    BD_SQLiteOpenHelper accesBD;

    public ReservationDAO(Context ct) {
        accesBD = new BD_SQLiteOpenHelper(ct, base, null, version);
    }
    // CONSULTER
    public Reservation getReservation(int id) {
        Reservation laReservation = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery("select * from Reservation where id=" + id + ";", null);
        if (curseur.getCount() > 0) {
            curseur.moveToFirst();
            laReservation = new Reservation(id,curseur.getString(1), curseur.getString(2), curseur.getInt(3), curseur.getInt(4), curseur.getString(5), curseur.getString(6), curseur.getInt(7));
        }
        return laReservation;
    }

    public ArrayList<Reservation> getVilla() {
        Cursor curseur;
        String req = "select * from Réservation";
        curseur = accesBD.getReadableDatabase().rawQuery(req, null);
        return cursorToReservationArrayList(curseur);
    }

    private ArrayList<Reservation> cursorToReservationArrayList(Cursor curseur) {
        ArrayList<Reservation> listeReservation = new ArrayList<Reservation>();
        int id;
        String dateArrivee;
        String dateDepart;
        int nbAdultes;
        int nbEnfants;
        String dateResa;
        String montant;
        int optionMenage;

        curseur.moveToFirst();
        while (!curseur.isAfterLast()) {
            id = curseur.getInt(0);
            dateArrivee = curseur.getString(1);
            dateDepart = curseur.getString(2);
            nbAdultes = curseur.getInt(3);
            nbEnfants = curseur.getInt(4);
            dateResa = curseur.getString(5);
            montant = curseur.getString(6);
            optionMenage = curseur.getInt(7);

            listeReservation.add(new Reservation(id, dateArrivee, dateDepart, nbAdultes, nbEnfants, dateResa, montant, optionMenage));
            curseur.moveToNext();
        }
        return listeReservation;
    }

    // AJOUTER
    public long addReservation(Reservation uneReservation) {
        long ret;
        SQLiteDatabase bd = accesBD.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put("id", uneReservation.getId());
        value.put("dateArrivee", uneReservation.getDateArrivee());
        value.put("dateDepard", uneReservation.getDateDepart());
        value.put("nbAdultes", uneReservation.getNbAdultes());
        value.put("nbEnfants", uneReservation.getNbEnfants());
        value.put("dateResa", uneReservation.getDateResa());
        value.put("montant", uneReservation.getMontant());
        value.put("optionMenage", uneReservation.getOptionMenage());
        ret = bd.insert("Reservation", null, value);

        return ret;
    }
}
