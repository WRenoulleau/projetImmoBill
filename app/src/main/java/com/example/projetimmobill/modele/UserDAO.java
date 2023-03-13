package com.example.projetimmobill.modele;

import android.content.Context;
import android.database.Cursor;

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
}
