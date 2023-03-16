package com.example.projetimmobill.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.projetimmobill.R;
import com.example.projetimmobill.modele.Locataire;
import com.example.projetimmobill.modele.LocataireDAO;
import com.example.projetimmobill.modele.Reservation;
import com.example.projetimmobill.modele.ReservationDAO;

import java.util.ArrayList;

public class UserConsultReservationsActivity extends AppCompatActivity {
    private Button btnRetour;
    Spinner spinLocataire;
    private int idLocataire;
    private ArrayList<Locataire> listeLocataires;
    private ListView listResa;
    private ArrayList<Reservation> lesReservations = new ArrayList<Reservation>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_consult_reservations);

        btnRetour = (Button) findViewById(R.id.btnRetour);
        btnRetour.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ChoixUserActivity.class);
                startActivity(intent);
            }
        });


        listResa=(ListView)findViewById(R.id.listMesReservations);

        ReservationDAO resaAcces = new ReservationDAO(UserConsultReservationsActivity.this);
        lesReservations=resaAcces.getReservations();



        spinLocataire = (Spinner) findViewById(R.id.spinLocataire);

        LocataireDAO locaAcces = new LocataireDAO(this);
        listeLocataires = locaAcces.getLocataire();
        ArrayAdapter<String> spinStationsAdapter = new ArrayAdapter<String>(this.getBaseContext(),android.R.layout.simple_spinner_item);
        for(int i=0;i<listeLocataires.size();i++){
            spinStationsAdapter.add(listeLocataires.get(i).getNom()+" "+listeLocataires.get(i).getPrenom());
        }
        spinLocataire.setAdapter(spinStationsAdapter);
        spinLocataire.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                Log.d("log",Integer.toString(arg2)+" "+listeLocataires.get(arg2).toString());
                idLocataire = listeLocataires.get(arg2).getId();
                Log.d("log",Integer.toString(arg2)+" "+listeLocataires.get(arg2).getId());

               Actualiser(idLocataire);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
    }
    private void Actualiser(int id){
        ArrayList<Reservation> mesReservations = new ArrayList<Reservation>();
        Log.d("log", "Actualiser: "+ id);

        for(int i=0;i<lesReservations.size();i++){
            Log.d("******","*****"+lesReservations.get(i));
            if(lesReservations.get(i).getIdLocataire()==id) {
                mesReservations.add(lesReservations.get(i));
                Log.d("log", "onItemSelected MesResa: "+ mesReservations);
                Log.d("log", "onItemSelected LesResa: "+ lesReservations);
            }
        }
        ArrayAdapter monAdapter = new ArrayAdapter(UserConsultReservationsActivity.this,android.R.layout.simple_list_item_1,mesReservations);
        listResa.setAdapter(monAdapter);
    }
}