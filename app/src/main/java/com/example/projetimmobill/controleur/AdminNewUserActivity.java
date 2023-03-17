package com.example.projetimmobill.controleur;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.projetimmobill.R;
import com.example.projetimmobill.modele.User;
import com.example.projetimmobill.modele.UserDAO;
import com.example.projetimmobill.modele.Villa;
import com.example.projetimmobill.modele.VillaDAO;

import java.util.ArrayList;
import java.util.Iterator;

public class AdminNewUserActivity extends AppCompatActivity {

    private Button btnRetour, btnAjouter;
    private EditText editId, editLogin, editPassword, editType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_new_user);
        editId = (EditText) findViewById(R.id.editNomLoc);
        editLogin = (EditText) findViewById(R.id.editLogin);
        editPassword = (EditText) findViewById(R.id.editPassword);
        editType = (EditText) findViewById(R.id.editTypeUser);

        btnRetour = (Button) findViewById(R.id.btnRetour);
        btnAjouter = (Button) findViewById(R.id.btnAjouterUser);

        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ChoixAdminActivity.class);
                startActivity(intent);
            }
        });

        btnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
                Intent intent = new Intent(v.getContext(), AdminConsultUserActivity.class);
                startActivity(intent);
            }
        });
    }
    private void add(){
        editLogin = (EditText) findViewById(R.id.editLogin);
        editPassword = (EditText) findViewById(R.id.editPassword);
        editType = (EditText) findViewById(R.id.editTypeUser);


        UserDAO userAcces = new UserDAO(this);
       User unUser= new User(0,editLogin.getText().toString(), editPassword.getText().toString(),Integer.valueOf(String.valueOf(editType.getText())));
        userAcces.addUser(unUser);
        ArrayList<User> lesUser;
        lesUser = userAcces.getUsers();

        Iterator<User> itUser;
        User leUser;
        for( itUser = lesUser.iterator(); itUser.hasNext(); ){
            leUser = itUser.next();
        }

    }
}