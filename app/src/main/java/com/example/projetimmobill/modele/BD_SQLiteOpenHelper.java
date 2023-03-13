package com.example.projetimmobill.modele;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BD_SQLiteOpenHelper extends SQLiteOpenHelper {

    private String locataire = "CREATE TABLE IF NOT EXISTS Locataire( \n"+
            "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ," +
            "nom TEXT NOT NULL ,\n"+
            "prenom TEXT NOT NULL ,\n"+
            "adresse TEXT NOT NULL ,\n"+
            "tel TEXT NOT NULL ,\n"+
            "email TEXT NOT NULL ,\n"+
            "commentaire TEXT NOT NULL)";

    private String typeVilla = "CREATE TABLE IF NOT EXISTS TypeVilla( \n" +
            "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,\n"+
            "nom TEXT NOT NULL ,\n"+
            "nbCouchages INTEGER NOT NULL)";

    private String villa = "CREATE TABLE IF NOT EXISTS villa (\n" +
            " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,\n" +
            "nom TEXT NOT NULL ,\n" +
            "adresse TEXT NOT NULL ,\n" +
            "description TEXT NOT NULL ,\n" +
            "pieces TEXT NOT NULL ,\n" +
            "surface REAL NOT NULL ,\n" +
            "anneeConstruction TEXT NOT NULL ,\n" +
            "caution TEXT NOT NULL ,\n" +
            "montant TEXT NOT NULL ,\n" +
            "id_TypeVilla INTEGER NOT NULL,\n" +
            "CONSTRAINT Villa_TypeVilla_FK FOREIGN KEY (id_TypeVilla) REFERENCES TypeVilla(id))";


    private String reservation= "CREATE TABLE IF NOT EXISTS Reservation(\n" +
            "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,\n" +
            "dateArrivee TEXT NOT NULL ,\n"+
            "dateDepart TEXT NOT NULL ,\n"+
            "nbAdultes INTEGER NOT NULL ,\n"+
            "nbEnfants INTEGER NOT NULL ,\n"+
            "dateResa TEXT NOT NULL ,\n"+
            "montant TEXT NOT NULL ,\n"+
            "optionMenage TEXT NOT NULL ,\n"+
            "id_Locataire INTEGER NOT NULL ,\n"+
            "id_Villa INTEGER NOT NULL,\n"+

            "CONSTRAINT Reservation_Locataire_FK FOREIGN KEY (id_Locataire) REFERENCES Locataire(id),\n"+
            "CONSTRAINT Reservation_Villa0_FK FOREIGN KEY (id_Villa) REFERENCES Villa(id))";

    private  String equipement = "CREATE TABLE Equipement(\n"+
            "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,\n"+
            "nom TEXT NOT NULL ,\n"+
            "etat TEXT NOT NULL ,\n"+
            "description TEXT NOT NULL ,\n"+
            "caution TEXT NOT NULL)";

    private String typeUser = "CREATE TABLE IF NOT EXISTS TypeUser(\n"+
            "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,\n"+
            "libelle TEXT NOT NULL)";

    private String user = "CREATE TABLE IF NOT EXISTS User(\n"+
            "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,\n"+
            "login TEXT NOT NULL ,\n"+
            "password TEXT NOT NULL ,\n"+
            "id_TypeUser INTEGER NOT NULL,\n"+

            "CONSTRAINT User_TypeUser_FK FOREIGN KEY (id_TypeUser) REFERENCES TypeUser(id))";

    private String equiper = "CREATE TABLE IF NOT EXISTS Equiper("+
            "id INTEGER NOT NULL ,"+
            "id_Equipement INTEGER NOT NULL ,"+
            "qte INTEGER NOT NULL,"+
            "CONSTRAINT Equiper_PK PRIMARY KEY (id,id_Equipement)"+

	        "CONSTRAINT Equiper_Villa_FK FOREIGN KEY (id) REFERENCES Villa(id)"+
            "CONSTRAINT Equiper_Equipement0_FK FOREIGN KEY (id_Equipement) REFERENCES Equipement(id))";

    public BD_SQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(villa);
        db.execSQL(typeVilla);
        db.execSQL(user);
        db.execSQL(typeUser);
        db.execSQL(locataire);
        db.execSQL("INSERT INTO villa (nom, adresse, description, pieces, surface, anneeConstruction, caution,montant, id_TypeVilla) VALUES\n" +
                "('La Alain Philippe', '84 rue du tourmalet', 'villa au sommet', '1', '20', '2000', '400','50', '1'),\n" +
                "('La Margarita', '6 rue de l Italie', 'villa garnie', '2', '40', '2001', '120','100', '2'),\n" +
                "('Le Grand Iban', '1 au sommet du monde', 'la meilleure villa', '3', '90', '2003', '3000','200', '3'),\n" +
                "('La Foulque', '1 allee des debiles', 'une villa defaitiste', '1', '16', '2022', '200','26', '4'),\n" +
                "('La Clarence', '9 rue Ronsard', 'villla avec 3 l ', '1', '21', '2020', '326','50', '1'),\n" +
                "('La Pouis Pastarac', '7 rue imaginaire', 'la pilla', '2', '45', '1936', '16','45', '2'),\n" +
                "('El Magnifico Willem', '5 avenue des Champs Elysees', 'elle est a son prime', '3', '69', '1999', '1000','200', '3'),\n" +
                "('La Sterenn', '5 chemin du bonheur', 'belle villa', '1', '23', '2002', '500000','5000', '4');");

        db.execSQL("INSERT INTO typeVilla (nom,nbCouchages) VALUES\n" +
                "('T1', '1'),\n" +
                "('T2', '2'),\n" +
                "('T3', '3'),\n" +
                "('Studio', '1')");

        db.execSQL("INSERT INTO typeUser (libelle) VALUES\n" +
                "('admin')," +
                "('locataire')");

        db.execSQL("INSERT INTO user (login,password,id_TypeUser) VALUES\n" +
                "('imarlats3.85', 'iabpaa',1),\n" +
                "('wre', 'masterclass',1),\n" +
                "('unLogin', 'unPass',2),\n" +
                "('nouveau', 'nouveau',2);");

        db.execSQL("INSERT INTO locataire (nom,prenom,adresse,tel,email,commentaire) VALUES\n" +
                "('Marlats', 'Iban', '1 au sommet du monde','0789456321','ff','le pire locataire');");


        Log.d("log","base de test cree");
    }

}
