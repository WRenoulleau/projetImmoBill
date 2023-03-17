package com.example.projetimmobill.controleur;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.projetimmobill.R;
import com.example.projetimmobill.modele.Villa;
import com.example.projetimmobill.modele.VillaDAO;

import java.util.ArrayList;
import java.util.Iterator;

public class AdminNewLocationActivity extends AppCompatActivity {

    private Button btnRetour, btnAjouter;
    private EditText editTitre, editAdresse, editSurface, editNbChambres, editType, editAnnee, editCaution, editDescription, editPieces, editMontant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_new_location);
        editTitre = (EditText) findViewById(R.id.editNomLoc);
        editAdresse = (EditText) findViewById(R.id.editAdresse);
        editSurface = (EditText) findViewById(R.id.editSurface);
        editNbChambres = (EditText) findViewById(R.id.editNbChambre);
        editType = (EditText) findViewById(R.id.editTypeVilla);
        editAnnee = (EditText) findViewById(R.id.editAnnee);
        editCaution = (EditText) findViewById(R.id.editCaution);
        editDescription = (EditText) findViewById(R.id.editDescription);
        editPieces = (EditText) findViewById(R.id.editDescPieces);
        editMontant = (EditText) findViewById(R.id.editMontant);
        btnRetour = (Button) findViewById(R.id.btnRetour);
        btnAjouter = (Button) findViewById(R.id.btnAjouterLocation);
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
                Intent intent = new Intent(v.getContext(), AdminConsultLocationActivity.class);
                startActivity(intent);
            }
        });
    }
    private void add(){
        editTitre = (EditText) findViewById(R.id.editNomLoc);
        editAdresse = (EditText) findViewById(R.id.editAdresse);
        editSurface = (EditText) findViewById(R.id.editSurface);
        editNbChambres = (EditText) findViewById(R.id.editNbChambre);
        editType = (EditText) findViewById(R.id.editTypeVilla);
        editAnnee = (EditText) findViewById(R.id.editAnnee);
        editCaution = (EditText) findViewById(R.id.editCaution);
        editDescription = (EditText) findViewById(R.id.editDescription);
        editPieces = (EditText) findViewById(R.id.editDescPieces);
        editMontant = (EditText) findViewById(R.id.editMontant);
        VillaDAO villaAcces = new VillaDAO(this);
        Villa uneVilla= new Villa(0,editTitre.getText().toString(), editAdresse.getText().toString(),editDescription.getText().toString(),editPieces.getText().toString(), Float.valueOf(String.valueOf(editSurface.getText())), editAnnee.getText().toString(), editCaution.getText().toString(),
                editMontant.getText().toString(),Integer.valueOf(String.valueOf(editMontant.getText())));
        villaAcces.addVilla(uneVilla);
        ArrayList<Villa> listVilla;
        listVilla = villaAcces.getVillas();
        Iterator<Villa> itVilla;
        Villa laVilla;
        for( itVilla = listVilla.iterator(); itVilla.hasNext(); ){
            laVilla = itVilla.next();
        }
    }
}