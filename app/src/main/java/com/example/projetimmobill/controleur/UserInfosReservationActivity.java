package com.example.projetimmobill.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projetimmobill.R;
import com.example.projetimmobill.modele.TypeVilla;
import com.example.projetimmobill.modele.TypeVillaDAO;
import com.example.projetimmobill.modele.VillaDAO;

public class UserInfosReservationActivity extends AppCompatActivity {
    private Button btnRetour,btnChoisir;
    private TextView textTitre, textAdresse, textSurface, textNbChambres, textType, textAnnee, textCaution, textDescription, textPieces, textMontant;
    private int id;
    private String nom;
    private String adresse;
    private String description;
    private String pieces;
    private float surface;
    private String anneeConstruction;
    private String caution;
    private String montant;
    private int type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_infos_reservation);

        btnRetour = (Button) findViewById(R.id.btnRetour);

        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), UserNewReservationActivity.class);
                startActivity(intent);
            }
        });
        btnChoisir=findViewById(R.id.btnChoisir);
        btnChoisir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), UserInfosLocataireActivity.class);
                startActivity(intent);
            }
        });

        textTitre = (TextView) findViewById(R.id.textTitre);
        textAdresse = (TextView) findViewById(R.id.textAdresse);
        textSurface = (TextView) findViewById(R.id.textSurface);
        textNbChambres = (TextView) findViewById(R.id.textNbChambres);
        textType = (TextView) findViewById(R.id.textTypeVilla);
        textAnnee = (TextView) findViewById(R.id.textAnneeConstruction);
        textCaution = (TextView) findViewById(R.id.textCaution);
        textDescription = (TextView) findViewById(R.id.textDescription);
        textPieces = (TextView) findViewById(R.id.textDescPieces);
        textMontant = (TextView) findViewById(R.id.textMontant);

        nom=getIntent().getStringExtra("nom");
        adresse=getIntent().getStringExtra("adresse");
        surface=getIntent().getFloatExtra("surface", 0);
        type=getIntent().getIntExtra("typeVilla", 0);
        anneeConstruction=getIntent().getStringExtra("annee");
        caution=getIntent().getStringExtra("caution");
        description=getIntent().getStringExtra("desc");
        pieces=getIntent().getStringExtra("descPieces");
        montant=getIntent().getStringExtra("montant");


        TypeVillaDAO resaAcces = new TypeVillaDAO(this);
        TypeVilla typeV = resaAcces.getTypeVilla(type);


        textTitre.setText(nom);
        textAdresse.setText("Adresse : " + adresse);
        textSurface.setText("Surface : " + String.valueOf(surface)+"m²");
        textNbChambres.setText("Nombre de couchages : "+ String.valueOf(typeV.getNbCouchages()));
        textType.setText("Type de villa : "+ typeV.getNom());
        textAnnee.setText("Annee de construction : "+ anneeConstruction);
        textCaution.setText("Caution : " + caution + "€");
        textDescription.setText("Description : "+ description);
        textPieces.setText("Nombre de pieces : "+pieces);
        textMontant.setText("Montant par jour : "+ montant+"€");

    }
}