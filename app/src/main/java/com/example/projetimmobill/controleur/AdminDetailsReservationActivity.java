package com.example.projetimmobill.controleur;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.projetimmobill.R;
import com.example.projetimmobill.modele.BD_SQLiteOpenHelper;
import com.example.projetimmobill.modele.Reservation;
import com.example.projetimmobill.modele.ReservationDAO;
import com.example.projetimmobill.modele.Villa;
import com.example.projetimmobill.modele.VillaDAO;

import java.util.ArrayList;

public class AdminDetailsReservationActivity extends AppCompatActivity {
    private Button btnRetour,btnModifier,btnSupprimer;
    private EditText editArrivee, editDepart, editAdultes, editEnfants, editDate, editMontant, editMenage, editLocataire, editVilla;

    private int id;
    private String arrivee;
    private String depart;
    private int adultes;
    private int enfants;
    private String date;
    private String montant;
    private String menage;
    private int locataire;
    private int villa;

    private ArrayList<Reservation> lesVillas = new ArrayList<Reservation>();

    BD_SQLiteOpenHelper accesBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_details_reservation);

        editArrivee = (EditText) findViewById(R.id.editDateArrivee);
        editDepart = (EditText) findViewById(R.id.editDateDepart);
        editAdultes = (EditText) findViewById(R.id.editNbAdultes);
        editEnfants = (EditText) findViewById(R.id.editNbEnfants);
        editDate = (EditText) findViewById(R.id.editDateResa);
        editMontant = (EditText) findViewById(R.id.editMontant);
        editMenage = (EditText) findViewById(R.id.editOptionMenage);
        editLocataire = (EditText) findViewById(R.id.editIdLocataire);
        editVilla = (EditText) findViewById(R.id.editIdVilla);

        id=getIntent().getIntExtra("id",0);
        arrivee=getIntent().getStringExtra("dateArrivee");
        depart=getIntent().getStringExtra("dateDepart");
        adultes=getIntent().getIntExtra("nbAdultes", 0);
        enfants=getIntent().getIntExtra("nbEnfants",0);
        date=getIntent().getStringExtra("dateResa");
        montant=getIntent().getStringExtra("montant");
        menage=getIntent().getStringExtra("optionMenage");
        locataire=getIntent().getIntExtra("id_Locataire",0);
        villa=getIntent().getIntExtra("id_Villa",0);

        editArrivee.setText(arrivee);
        editDepart.setText(depart);
        editAdultes.setText(String.valueOf(adultes));
        editEnfants.setText(String.valueOf(enfants));
        editDate.setText(date);
        editMontant.setText(montant);
        editMenage.setText(menage);
        editLocataire.setText(String.valueOf(locataire));
        editVilla.setText(String.valueOf(villa));


        btnRetour = (Button) findViewById(R.id.btnRetour);
        btnModifier=(Button) findViewById(R.id.btnModifierReservation);
        btnSupprimer=(Button) findViewById(R.id.btnSupprimerReservation);

        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AdminConsultReservationActivity.class);
                startActivity(intent);
            }
        });
        btnModifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
                Intent intent = new Intent(v.getContext(), AdminConsultReservationActivity.class);
                startActivity(intent);
            }
        });
        btnSupprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
                Intent intent = new Intent(v.getContext(), AdminConsultReservationActivity.class);
                startActivity(intent);
            }
        });

    }
    private void update(){
        ReservationDAO resaAcces = new ReservationDAO(this);
        ArrayList<Reservation> listResa;
        listResa = resaAcces.getReservations();
        Reservation uneResa= new Reservation(id,
                String.valueOf(editArrivee.getText()),
                String.valueOf(editDepart.getText()),
                Integer.valueOf(String.valueOf(editAdultes.getText())),
                Integer.valueOf(String.valueOf(editEnfants.getText())),
                String.valueOf(editDate.getText()),
                String.valueOf(editMontant.getText()),
                String.valueOf(editMenage.getText()),
                Integer.valueOf(String.valueOf(editLocataire.getText())),
                Integer.valueOf(String.valueOf(editVilla.getText())));

        Reservation ancResa = new Reservation(id,arrivee, depart,adultes,enfants, date, montant, menage,
                locataire, villa);

        resaAcces.modifierReservation(uneResa, ancResa);
    }



    private void delete(){
        ReservationDAO resaAcces = new ReservationDAO(this);
        Reservation uneResa= new Reservation(id,
                String.valueOf(editArrivee.getText()),
                String.valueOf(editDepart.getText()),
                Integer.valueOf(String.valueOf(editAdultes.getText())),
                Integer.valueOf(String.valueOf(editEnfants.getText())),
                String.valueOf(editDate.getText()),
                String.valueOf(editMontant.getText()),
                String.valueOf(editMenage.getText()),
                Integer.valueOf(String.valueOf(editLocataire.getText())),
                Integer.valueOf(String.valueOf(editVilla.getText())));
        resaAcces.supprimerReservation(uneResa);
    }

}