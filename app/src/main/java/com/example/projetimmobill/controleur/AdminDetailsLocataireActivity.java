package com.example.projetimmobill.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projetimmobill.R;

public class AdminDetailsLocataireActivity extends AppCompatActivity {
    private Button btnRetour;
    private TextView textId, textNom, textAdresse, textPrenom, textTel, textEmail, textCommentaire;
    private String nom;
    private int id;
    private String prenom;
    private String adresse;
    private String tel;
    private String email;
    private String commentaire;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_details_locataire);

        btnRetour = (Button) findViewById(R.id.btnRetour);

        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AdminConsultLocatairesActivity.class);
                startActivity(intent);
            }
        });

        textId = (TextView) findViewById(R.id.textTitre);
        textAdresse = (TextView) findViewById(R.id.textView2);
        textNom = (TextView) findViewById(R.id.textView11);
        textPrenom = (TextView) findViewById(R.id.textView);
        textTel = (TextView) findViewById(R.id.textView3);
        textEmail = (TextView) findViewById(R.id.textView4);
        textCommentaire = (TextView) findViewById(R.id.textView5);


        id=getIntent().getIntExtra("id",0);
        nom=getIntent().getStringExtra("nom");
        adresse=getIntent().getStringExtra("adresse");
        prenom=getIntent().getStringExtra("prenom");
        tel=getIntent().getStringExtra("tel");
        email=getIntent().getStringExtra("email");
        commentaire=getIntent().getStringExtra("commentaire");

    }
}