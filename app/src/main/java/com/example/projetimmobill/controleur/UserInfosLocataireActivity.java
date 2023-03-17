package com.example.projetimmobill.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.projetimmobill.R;
import com.example.projetimmobill.modele.Locataire;
import com.example.projetimmobill.modele.LocataireDAO;
import com.example.projetimmobill.modele.Reservation;
import com.example.projetimmobill.modele.ReservationDAO;
import com.example.projetimmobill.modele.TypeVilla;
import com.example.projetimmobill.modele.TypeVillaDAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import static java.lang.Integer.parseInt;

public class UserInfosLocataireActivity extends AppCompatActivity {
    private Button btnRetour,btnValider;
    private EditText editAdulte, editEnfant, editArrivee, editDepart;
    RadioButton radioChoix;
    RadioGroup optMenage;
    private String montantStr, menageStr;
    private int idVilla, idLocataire;
    private long montantTotal;
    Spinner spinLocataire;
    private ArrayList<Locataire> listeLocataires;
    Date dateDepart, dateArrivee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_infos_locataire);

        btnRetour = (Button) findViewById(R.id.btnRetour);
        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), UserInfosReservationActivity.class);
                startActivity(intent);
            }
        });
        montantStr=getIntent().getStringExtra("montant");
        idVilla=getIntent().getIntExtra("id",0);
        ReservationDAO resaAcces = new ReservationDAO(this);
        editAdulte=findViewById(R.id.editNbAdultes);
        editEnfant=findViewById(R.id.editNbEnfants);
        editArrivee=findViewById(R.id.editDateArrivee);
        editDepart=findViewById(R.id.editDateDepart);
        optMenage=findViewById(R.id.radioGroup);
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
        String dateResa = formatter.format(now);
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
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
        btnValider=findViewById(R.id.btnValider);
        btnValider.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), UserConfirmationActivity.class);
                try {
                    dateArrivee = new SimpleDateFormat("dd/MM/yyyy").parse(String.valueOf(editArrivee.getText()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                try {
                    dateDepart = new SimpleDateFormat("dd/MM/yyyy").parse(String.valueOf(editDepart.getText()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                long diff = dateDepart.getTime() - dateArrivee.getTime();
                long nbJours = (diff / (1000*60*60*24));
                int montant = parseInt(montantStr);
                montantTotal = (nbJours* montant);
                String montantTotalStr = String.valueOf(montantTotal);
                radioChoix=findViewById(optMenage.getCheckedRadioButtonId());
                menageStr = radioChoix.getText().toString();
                Reservation Entite = new Reservation(0,
                        String.valueOf(editArrivee.getText()),
                        String.valueOf(editDepart.getText()),
                        Integer.valueOf(String.valueOf(editAdulte.getText())),
                        Integer.valueOf(String.valueOf(editEnfant.getText())),
                        dateResa,
                        montantTotalStr,
                        menageStr,

                        idLocataire,
                        idVilla);


                Log.d("log",Entite.toString());
                resaAcces.addReservation(Entite);
                intent.putExtra("montant", montantTotalStr);
                startActivity(intent);
            }
        });
    }
}