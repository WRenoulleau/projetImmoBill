package com.example.projetimmobill.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetimmobill.R;
import com.example.projetimmobill.modele.User;
import com.example.projetimmobill.modele.UserDAO;
import com.example.projetimmobill.modele.Villa;
import com.example.projetimmobill.modele.VillaDAO;

public class MainActivity extends AppCompatActivity {
    private Button connexion;
    private EditText editLogin,editMdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connexion=findViewById(R.id.btnConnexion);
        editLogin=findViewById(R.id.editIdentifiant);
        editMdp=findViewById(R.id.editMdp);
        UserDAO userAcces = new UserDAO(this);

        connexion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String login=editLogin.getText().toString();
                String mdp=editMdp.getText().toString();

                if (userAcces.seConnecter(login,mdp).equals("admin")){
                    Intent intent = new Intent(v.getContext(), ChoixAdminActivity.class);
                    startActivity(intent);
                    Log.d("****", userAcces.seConnecter(login,mdp));
                }
                if (userAcces.seConnecter(login,mdp).equals("locataire")){
                    Intent intent = new Intent(v.getContext(), ChoixUserActivity.class);
                    startActivity(intent);
                    Log.d("****", userAcces.seConnecter(login,mdp));
                }

                if (userAcces.seConnecter(login,mdp).equals("erreur")){
                    Toast.makeText(MainActivity.this,"erreur ",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}