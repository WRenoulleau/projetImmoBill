package com.example.projetimmobill.modele;

public class User {
    private int id;
    private String login;
    private String password;
    private int id_TypeUser;

    public User(int id, String login, String password, int type){
        this.id=id;
        this.login=login;
        this.password=password;
        this.id_TypeUser=type;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return id_TypeUser;
    }

    public void setType(int type) {
        this.id_TypeUser = type;
    }



    public String toString(){
        return(login);
    }
}
