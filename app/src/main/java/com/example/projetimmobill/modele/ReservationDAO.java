package com.example.projetimmobill.modele;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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
            laReservation = new Reservation(id,curseur.getString(1), curseur.getString(2), curseur.getInt(3), curseur.getInt(4), curseur.getString(5), curseur.getString(6), curseur.getString(7),curseur.getInt(8),curseur.getInt(9));
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
        String optionMenage;
        int idLocataire;
        int idVilla;

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
            idLocataire = curseur.getInt(8);
            idVilla = curseur.getInt(9);

            listeReservation.add(new Reservation(id, dateArrivee, dateDepart, nbAdultes, nbEnfants, dateResa, montant, optionMenage,idLocataire,idVilla));
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
        value.put("id_Locataire", uneReservation.getOptionMenage());
        value.put("id_Villa", uneReservation.getOptionMenage());
        ret = bd.insert("Reservation", null, value);

        return ret;
    }//Fin Ajouter

    //Modifier--------------------------------------------------------------------------------------
    public int modifierReservation(Reservation nvReservation, Reservation ancReservation){
        int ret;
        SQLiteDatabase bd = accesBD.getWritableDatabase();
        ContentValues value = new ContentValues();

        value.put("id",nvReservation.getId());
        value.put("dateArrivee", nvReservation.getDateArrivee());
        value.put("dateDepart",nvReservation.getDateDepart());
        value.put("nbAdultes",nvReservation.getNbAdultes());
        value.put("nbEnfants",nvReservation.getNbEnfants());
        value.put("dateResa", nvReservation.getDateResa());
        value.put("montant",nvReservation.getMontant());
        value.put("optionMenage", nvReservation.getOptionMenage());


        String condition = "dateArrivee ='"+ancReservation.getDateArrivee()+"' AND dateDepart='"+ancReservation.getDateDepart()+"'AND nbAdultes='"+ancReservation.getNbAdultes()+"'AND nbEnfants='"+ancReservation.getNbEnfants()+
                "'AND dateResa='"+ancReservation.getDateResa()+"'AND optionMenage='"+ancReservation.getOptionMenage()+"'AND montant='"+ancReservation.getMontant()+"'";
        String condition2 = "dateArrivee ='"+nvReservation.getDateArrivee()+"' AND dateDepart='"+nvReservation.getDateDepart()+"'AND nbAdultes='"+nvReservation.getNbAdultes()+"'ANDnbEnfants='"+nvReservation.getNbEnfants()+
                "'AND dateResa='"+nvReservation.getDateResa()+"'AND optionMenage='"+nvReservation.getOptionMenage()+"'AND montant='"+nvReservation.getMontant()+"'";

        ret = bd.update("villa", value, condition ,null);
        return ret;
    }//Fin Modifier---------------------------------------------------------------------------------

    //SUPPRIMER-------------------------------------------------------------------------------------
    public long supprimerReservation(Reservation uneReservation){
        long ret;
        SQLiteDatabase bd = accesBD.getWritableDatabase();
        String condition = "id ='"+uneReservation.getId()+"'";
        Log.d("Reservation supprime", condition);
        ret = bd.delete("Reservation", condition ,null);
        return ret;
    }//Fin SUPPRIMER--------------------------------------------------------------------------------
}
