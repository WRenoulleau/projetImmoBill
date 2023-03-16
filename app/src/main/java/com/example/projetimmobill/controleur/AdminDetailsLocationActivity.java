package com.example.projetimmobill.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.projetimmobill.R;
import com.example.projetimmobill.modele.BD_SQLiteOpenHelper;
import com.example.projetimmobill.modele.Villa;
import com.example.projetimmobill.modele.VillaDAO;

import java.util.ArrayList;

public class AdminDetailsLocationActivity extends AppCompatActivity {
    private Button btnRetour,btnModifier,btnSupprimer;
    private EditText editTitre, editAdresse, editSurface, editNbChambres, editType, editAnnee, editCaution, editDescription, editPieces, editMontant;
    private String nom;
    private int id;
    private String adresse;
    private String annee;
    private String description;
    private String pieces;
    private float surface;
    private String caution;
    private String montant;
    private int type;
    private int leType;
    private ArrayList<Villa> lesVillas = new ArrayList<Villa>();
    BD_SQLiteOpenHelper accesBD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_details_location);


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

        id=getIntent().getIntExtra("id",0);
        nom=getIntent().getStringExtra("nom");
        adresse=getIntent().getStringExtra("adresse");
        surface=getIntent().getFloatExtra("surface", 0);
        type=getIntent().getIntExtra("typeVilla",0);
        annee=getIntent().getStringExtra("annee");
        caution=getIntent().getStringExtra("caution");
        description=getIntent().getStringExtra("desc");
        pieces=getIntent().getStringExtra("descPieces");
        montant=getIntent().getStringExtra("montant");



        editTitre.setText(nom);
        editAdresse.setText(adresse);
        editSurface.setText(String.valueOf(surface));
        editType.setText(String.valueOf(type));
        editAnnee.setText(annee);
        editCaution.setText(caution);
        editDescription.setText(description);
        editPieces.setText(pieces);
        editMontant.setText(montant);
        VillaDAO villaAcces = new VillaDAO(this);
;


        btnRetour = (Button) findViewById(R.id.btnRetour);
        btnModifier=(Button) findViewById(R.id.btnModifierLocation);
        btnSupprimer=(Button) findViewById(R.id.btnSupprimerLocation);

        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AdminConsultLocationActivity.class);
                startActivity(intent);
            }
        });
        btnModifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
                Intent intent = new Intent(v.getContext(), AdminConsultLocationActivity.class);
                startActivity(intent);
            }
        });
        btnSupprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), AdminConsultLocationActivity.class);
                startActivity(intent);
            }
        });

        }
    private void update(){
        VillaDAO villaAcces = new VillaDAO(this);
        ArrayList<Villa> listVilla;
        listVilla = villaAcces.getVillas();
        Villa uneVilla= new Villa(id,editTitre.getText().toString(), editAdresse.getText().toString(),editDescription.getText().toString(),editPieces.getText().toString(), Float.valueOf(String.valueOf(editSurface.getText())), editAnnee.getText().toString(), editCaution.getText().toString(),
                  editMontant.getText().toString(),Integer.valueOf(String.valueOf(editMontant.getText())));
        Villa ancVilla = new Villa(id,nom, adresse,description,pieces, surface, annee, caution,
                  montant, type);
        villaAcces.modifierVilla(uneVilla, ancVilla);
    }
    public void delete(Villa uneVilla){
        SQLiteDatabase db = accesBD.getWritableDatabase();
        String cond="id='"+uneVilla.getId()+"'";
        db.delete("Villa", cond, null);

    }


}
