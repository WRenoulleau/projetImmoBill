package com.example.projetimmobill.controleur;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.projetimmobill.R;
import com.example.projetimmobill.modele.TypeVilla;
import com.example.projetimmobill.modele.TypeVillaDAO;
import com.example.projetimmobill.modele.Villa;
import com.example.projetimmobill.modele.VillaDAO;

import java.util.ArrayList;

public class AdminDetailsTypeVillaActivity extends AppCompatActivity {

    private Button btnRetour, btnModifier, btnSupprimer;
    private EditText editNom, editNbCouchages;
    private String nom;
    private Integer nbCouchages;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_details_typevilla);
        editNom = (EditText) findViewById(R.id.editNomTypeVilla);
        editNbCouchages = (EditText) findViewById(R.id.editNbCouchages);

        id=getIntent().getIntExtra("id",0);
        nom=getIntent().getStringExtra("nom");
        nbCouchages=getIntent().getIntExtra("nbCouchages",0);
        editNom.setText(nom);
        editNbCouchages.setText(String.valueOf(nbCouchages));
        btnRetour = (Button) findViewById(R.id.btnRetour);
        btnModifier = (Button) findViewById(R.id.btnModifierTypeVilla);
        btnSupprimer = (Button) findViewById(R.id.btnSupprimerTypeVilla);
        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AdminConsultTypeVillaActivity.class);
                startActivity(intent);
            }
        });
        btnModifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
                Intent intent = new Intent(v.getContext(), AdminConsultTypeVillaActivity.class);
                startActivity(intent);
            }
        });
        btnSupprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
                Intent intent = new Intent(v.getContext(), AdminConsultTypeVillaActivity.class);
                startActivity(intent);
            }
        });
    }
    private void update(){
        TypeVillaDAO typeAcces = new TypeVillaDAO(this);
        ArrayList<TypeVilla> listType;
        listType = typeAcces.getTypeVillas();
        TypeVilla unType= new TypeVilla(id,editNom.getText().toString(), Integer.valueOf(String.valueOf(editNbCouchages.getText())));
        TypeVilla ancType = new TypeVilla(id,nom, nbCouchages);
        typeAcces.modifierTypeVilla(unType, ancType);
    }
    private void delete(){
        TypeVillaDAO typeAcces = new TypeVillaDAO(this);
        TypeVilla unType= new TypeVilla(id,editNom.getText().toString(), Integer.valueOf(String.valueOf(editNbCouchages.getText())));
        typeAcces.supprimerTypeVilla(unType);
    }
}