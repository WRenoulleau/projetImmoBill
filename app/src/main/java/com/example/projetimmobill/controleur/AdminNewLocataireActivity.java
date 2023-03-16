package com.example.projetimmobill.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.projetimmobill.R;
import com.example.projetimmobill.modele.Locataire;
import com.example.projetimmobill.modele.LocataireDAO;
import com.example.projetimmobill.modele.Villa;
import com.example.projetimmobill.modele.VillaDAO;

import java.util.ArrayList;
import java.util.Iterator;

public class AdminNewLocataireActivity extends AppCompatActivity {
    private Button btnRetour,btnAjouter;
    private EditText editId, editNom, editAdresse, editPrenom, editTel, editEmail, editCommentaire;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_new_locataire);

        editAdresse = (EditText) findViewById(R.id.editAdresse);
        editNom = (EditText) findViewById(R.id.editNomLocataire);
        editPrenom = (EditText) findViewById(R.id.editPrenom);
        editTel = (EditText) findViewById(R.id.editTel);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editCommentaire = (EditText) findViewById(R.id.editCommentaire);


        btnRetour = (Button) findViewById(R.id.btnRetour);
        btnAjouter = (Button) findViewById(R.id.btnAjouterLocataire);

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
                Intent intent = new Intent(v.getContext(), AdminConsultLocatairesActivity.class);
                startActivity(intent);
            }
        });
    }
        private void add() {


            editNom = (EditText) findViewById(R.id.editNomLocataire);
            editAdresse = (EditText) findViewById(R.id.editAdresse);
            editPrenom = (EditText) findViewById(R.id.editPrenom);
            editTel = (EditText) findViewById(R.id.editTel);
            editEmail = (EditText) findViewById(R.id.editEmail);
            editCommentaire = (EditText) findViewById(R.id.editCommentaire);


            LocataireDAO locataireAcces = new LocataireDAO(this);
            Locataire unLocataire= new Locataire(0, editNom.getText().toString(),editAdresse.getText().toString(),editPrenom.getText().toString(), editTel.getText().toString(), editEmail.getText().toString(),
                    editCommentaire.getText().toString());
            locataireAcces.addLocataire(unLocataire);
            ArrayList<Locataire> listeLocataires;
            listeLocataires = locataireAcces.getLocataire();

            Iterator<Locataire> itLocataire;
            Locataire leLocataire;
            for( itLocataire = listeLocataires.iterator(); itLocataire.hasNext(); ){
                leLocataire = itLocataire.next();
            }
        }
    }


