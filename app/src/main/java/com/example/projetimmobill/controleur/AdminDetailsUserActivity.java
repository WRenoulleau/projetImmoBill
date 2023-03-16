package com.example.projetimmobill.controleur;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.projetimmobill.R;
import com.example.projetimmobill.modele.BD_SQLiteOpenHelper;
import com.example.projetimmobill.modele.User;
import com.example.projetimmobill.modele.UserDAO;
import com.example.projetimmobill.modele.Villa;
import com.example.projetimmobill.modele.VillaDAO;

import java.util.ArrayList;

public class AdminDetailsUserActivity extends AppCompatActivity {

    private Button btnRetour, btnModifier, btnSupprimer;
    private EditText editId, editLogin, editPassword, editType;
    private int id;
    private String login;
    private String password;
    private int type;
    private ArrayList<User> lesUser = new ArrayList<User>();
    BD_SQLiteOpenHelper accesBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_details_user);

        editLogin = (EditText) findViewById(R.id.editLogin);
        editPassword = (EditText) findViewById(R.id.editPassword);
        editType = (EditText) findViewById(R.id.editTypeUser);



        login=getIntent().getStringExtra("login");
        password=getIntent().getStringExtra("password");
        type=getIntent().getIntExtra("type",0);




        editLogin.setText(login);
        editPassword.setText(password);
        editType.setText(String.valueOf(type));



        btnRetour = (Button) findViewById(R.id.btnRetour);
        btnModifier=(Button) findViewById(R.id.btnModifierUser);
        btnSupprimer=(Button) findViewById(R.id.btnSupprimerUser);

        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AdminConsultUserActivity.class);
                startActivity(intent);
            }
        });
        btnModifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
                Intent intent = new Intent(v.getContext(), AdminConsultUserActivity.class);
                startActivity(intent);
            }
        });
        btnSupprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
                Intent intent = new Intent(v.getContext(), AdminConsultUserActivity.class);
                startActivity(intent);
            }
        });

    }
    private void update(){
       UserDAO userAcces = new UserDAO(this);
        ArrayList<User> lesUser;
        lesUser = userAcces.getUsers();
        User nvUser= new User(id, editLogin.getText().toString(),editPassword.getText().toString(),Integer.valueOf(String.valueOf(editType.getText())));
        User ancUser = new User(id,login, password,type);
        userAcces.modifierUser(nvUser, ancUser);
    }



    private void delete(){
        UserDAO userAcces = new UserDAO(this);
        User nvUser= new User(id, editLogin.getText().toString(),editPassword.getText().toString(),Integer.valueOf(String.valueOf(editType.getText())));
        userAcces.supprimerUser(nvUser);
    }


}