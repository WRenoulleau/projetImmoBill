package com.example.projetimmobill.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.projetimmobill.R;
import com.example.projetimmobill.modele.BD_SQLiteOpenHelper;
import com.example.projetimmobill.modele.Locataire;
import com.example.projetimmobill.modele.LocataireDAO;
import com.example.projetimmobill.modele.TypeVilla;
import com.example.projetimmobill.modele.TypeVillaDAO;
import com.example.projetimmobill.modele.Villa;
import com.example.projetimmobill.modele.VillaDAO;

import java.util.ArrayList;

public class AdminDetailsLocataireActivity extends AppCompatActivity {
    private Button btnRetour, btnModifier,btnSupprimer;
    private EditText editId, editNom, editPrenom, editAdresse, editTel, editEmail, editCommentaire;
    private String nom;
    private int id;
    private String prenom;
    private String adresse;
    private String tel;
    private String email;
    private String commentaire;
    private ArrayList<Locataire> lesLocataires = new ArrayList<Locataire>();
    BD_SQLiteOpenHelper accesBD;
    /*private int loc;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_details_locataire);






        editId = (EditText) findViewById(R.id.editIdLocataire);
        editAdresse = (EditText) findViewById(R.id.editAdresse);
        editNom = (EditText) findViewById(R.id.editPrenom2);
        editPrenom = (EditText) findViewById(R.id.editPrenom);
        editTel = (EditText) findViewById(R.id.editTel);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editCommentaire = (EditText) findViewById(R.id.editCommentaire);


        id=getIntent().getIntExtra("id",0);
        nom=getIntent().getStringExtra("nom");
        adresse=getIntent().getStringExtra("adresse");
        prenom=getIntent().getStringExtra("prenom");
        tel=getIntent().getStringExtra("tel");
        email=getIntent().getStringExtra("email");
        commentaire=getIntent().getStringExtra("commentaire");



        editAdresse.setText(adresse);
        editNom.setText(String.valueOf(nom));
        editPrenom.setText(prenom);
        editTel.setText(tel);
        editEmail.setText(email);
        editCommentaire.setText(commentaire);

        LocataireDAO locataireAcces = new LocataireDAO(this);

        btnRetour = (Button) findViewById(R.id.btnRetour);
        btnModifier=(Button) findViewById(R.id.btnModifierLocataire);
        btnSupprimer=(Button) findViewById(R.id.btnSupprimerLocataire);

        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AdminConsultLocatairesActivity.class);
                startActivity(intent);
            }
        });
        btnModifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
                Intent intent = new Intent(v.getContext(), AdminConsultLocatairesActivity.class);
                startActivity(intent);
            }
        });
        btnSupprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), AdminConsultLocatairesActivity.class);
                startActivity(intent);
            }
        });

    }
    private void update(){
        LocataireDAO locataireAcces = new LocataireDAO(this);
        ArrayList<Locataire> lesLocataires;
       lesLocataires = locataireAcces.getLocataire();
       Locataire nvLocataire= new Locataire(id, editAdresse.getText().toString(),editNom.getText().toString(),editPrenom.getText().toString(), editTel.getText().toString(), editEmail.getText().toString(),
                editCommentaire.getText().toString());
        Locataire ancLocataire = new Locataire(id,nom, adresse,prenom,tel, email, commentaire);
        locataireAcces.modifierLocataire(nvLocataire, ancLocataire);
    }
    public void delete(Locataire unLocataire){

        SQLiteDatabase db = accesBD.getWritableDatabase();
        String cond="id='"+unLocataire.getId()+"'";
        db.delete("Locataire", cond, null);

    }

}