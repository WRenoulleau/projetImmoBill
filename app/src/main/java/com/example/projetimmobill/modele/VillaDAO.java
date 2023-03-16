package com.example.projetimmobill.modele;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class VillaDAO {
    private static String base = "BD_ImmoBill";
    private static int version = 1;
    BD_SQLiteOpenHelper accesBD;

    public VillaDAO(Context ct) {
        accesBD = new BD_SQLiteOpenHelper(ct, base, null, version);
    }

    // CONSULTER------------------------------------------------------------------------------------
    public Villa getVilla(int id) {
        Villa laVilla = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery("select * from Villa where id=" + id + ";", null);
        if (curseur.getCount() > 0) {
            curseur.moveToFirst();
            laVilla = new Villa(id, curseur.getString(1), curseur.getString(2), curseur.getString(3), curseur.getString(4), curseur.getInt(5), curseur.getString(6), curseur.getString(7), curseur.getString(8), curseur.getInt(8));
        }
        return laVilla;
    }

    public ArrayList<Villa> getVillas() {
        Cursor curseur;
        String req = "select * from Villa";
        curseur = accesBD.getReadableDatabase().rawQuery(req, null);
        return cursorToVillaArrayList(curseur);
    }

    private ArrayList<Villa> cursorToVillaArrayList(Cursor curseur) {
        ArrayList<Villa> listVilla = new ArrayList<Villa>();
        int id;
        String nom;
        String adresse;
        String description;
        String pieces;
        float surface;
        String anneeConstruction;
        String caution;
        String montant;
        int type;

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
            montant = curseur.getString(8);
            type = curseur.getInt(9);
            listVilla.add(new Villa(id, nom, adresse, description, pieces, surface, anneeConstruction, caution, montant, type));
            curseur.moveToNext();
        }
        return listVilla;
    }
    //FIN CONSULER----------------------------------------------------------------------------------

    // AJOUTER--------------------------------------------------------------------------------------
    public long addVilla(Villa uneVilla) {
        long ret;
        SQLiteDatabase bd = accesBD.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put("id", uneVilla.getId());
        value.put("nom", uneVilla.getNom());
        value.put("adresse", uneVilla.getAdresse());
        value.put("description", uneVilla.getDescription());
        value.put("pieces", uneVilla.getPieces());
        value.put("surface", uneVilla.getSurface());
        value.put("anneeConstruction", uneVilla.getAnneeConstruction());
        value.put("caution", uneVilla.getCaution());
        value.put("montant", uneVilla.getMontant());
        value.put("id_TypeVilla", uneVilla.getType());
        ret = bd.insert("Villa", null, value);

        return ret;
    } //FIN AJOUTER---------------------------------------------------------------------------------

    //Modifier--------------------------------------------------------------------------------------
        public int modifierVilla(Villa nvVilla, Villa ancVilla){
        int ret;
        SQLiteDatabase bd = accesBD.getWritableDatabase();
        ContentValues value = new ContentValues();

        Integer ancId=ancVilla.getId();
        value.put("id",nvVilla.getId());
        value.put("nom", nvVilla.getNom());
        value.put("adresse",nvVilla.getAdresse());
        value.put("Description",nvVilla.getDescription());
        value.put("Pieces",nvVilla.getPieces());
        value.put("surface", nvVilla.getSurface());
        value.put("anneeConstruction",nvVilla.getAnneeConstruction());
        value.put("caution", nvVilla.getCaution());
        value.put("montant",nvVilla.getMontant());

        String condition = "id='"+nvVilla.getId()+"'";


        ret = bd.update("villa", value, condition ,null);
        return ret;
    }//Fin Modifier---------------------------------------------------------------------------------

    //SUPPRIMER-------------------------------------------------------------------------------------
    public long supprimerVilla(Villa uneVilla){
        long ret;
        SQLiteDatabase bd = accesBD.getWritableDatabase();
        String condition = "id='"+uneVilla.getId()+"'";
        Log.d("Villa supprime", condition);
        ret = bd.delete("Villa", condition ,null);
        return ret;
    }//Fin SUPPRIMER--------------------------------------------------------------------------------

}

