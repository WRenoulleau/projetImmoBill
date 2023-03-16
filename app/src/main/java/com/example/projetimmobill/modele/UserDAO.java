package com.example.projetimmobill.modele;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.wifi.p2p.WifiP2pManager;
import android.util.Log;

import java.util.ArrayList;

public class UserDAO {
    private static String base = "BD_ImmoBill";
    private static int version = 1;
    BD_SQLiteOpenHelper accesBD;

    public UserDAO(Context ct) {
        accesBD = new BD_SQLiteOpenHelper(ct, base, null, version);
    }

    // CONSULTER

    public User getUser(int id) {
        User leUser = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery("select * from User where id=" + id + ";", null);
        if (curseur.getCount() > 0) {
            curseur.moveToFirst();
            leUser = new User(id,curseur.getString(1), curseur.getString(2), curseur.getInt(3));
        }
        return leUser;
    }

    public ArrayList<User> getUsers() {
        Cursor curseur;
        String req = "select * from User";
        curseur = accesBD.getReadableDatabase().rawQuery(req, null);
        return cursorToUserArrayList(curseur);
    }

    private ArrayList<User> cursorToUserArrayList(Cursor curseur) {
        ArrayList<User> listeUser = new ArrayList<User>();
        int id;
        String login;
        String password;
        int type;


        curseur.moveToFirst();
        while (!curseur.isAfterLast()) {
            id = curseur.getInt(0);
            login = curseur.getString(1);
            password = curseur.getString(2);
            type = curseur.getInt(3);
            listeUser.add(new User(id, login, password, type));
            curseur.moveToNext();
        }
        return listeUser;
    }
    public String seConnecter(String unLogin, String unMdp)
    {
        ArrayList<User> list = this.getUsers();
        String retour="erreur";
        for (User unUser:list) {
            if (unUser.getLogin().equals(unLogin) && unUser.getPassword().equals(unMdp) && unUser.getType()==1) {
                return retour="admin";
            }
            if(unUser.getLogin().equals(unLogin) && unUser.getPassword().equals(unMdp) && unUser.getType()==2){
                return retour="locataire";
            }
        }
        return retour ;
    }
    // AJOUTER--------------------------------------------------------------------------------------
    public long addUser(User unUser) {
        long ret;
        SQLiteDatabase bd = accesBD.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put("id", unUser.getId());
        value.put("login", unUser.getLogin());
        value.put("password", unUser.getPassword());
        value.put("type", unUser.getType());
        ret = bd.insert("user", null, value);

        return ret;
    } //FIN AJOUTER---------------------------------------------------------------------------------
    //Modifier--------------------------------------------------------------------------------------
    public int modifierUser(User nvUser, User ancUser){
        int ret;
        SQLiteDatabase bd = accesBD.getWritableDatabase();
        ContentValues value = new ContentValues();

        value.put("id",nvUser.getId());
        value.put("login", nvUser.getLogin());
        value.put("password", nvUser.getPassword());
        value.put("type",nvUser.getType());



        String condition = "id ='"+nvUser.getId()+"'";

        ret = bd.update("user", value, condition ,null);
        return ret;
    }//Fin Modifier---------------------------------------------------------------------------------

    //SUPPRIMER-------------------------------------------------------------------------------------
    public long supprimerUser(User unUser){
        long ret;
        SQLiteDatabase bd = accesBD.getWritableDatabase();
        String condition = "login ='"+unUser.getLogin()+"' AND password='"+unUser.getPassword()+"'";
        Log.d("User supprime", condition);
        ret = bd.delete("User", condition ,null);
        return ret;
    }//Fin SUPPRIMER--------------------------------------------------------------------------------
}
