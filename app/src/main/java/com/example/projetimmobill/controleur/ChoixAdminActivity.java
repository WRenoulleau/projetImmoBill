package com.example.projetimmobill.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projetimmobill.R;

public class ChoixAdminActivity extends AppCompatActivity {

    private Button consultResa, consultLocataire, consultLocation, consultTypeVilla, consultUser, newLocataire, newLocation, newTypeVilla, newUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_admin);

        consultResa=findViewById(R.id.btnConsultReservation);
        consultResa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AdminConsultReservationActivity.class);
                startActivity(intent);
            }
        });
        consultLocataire=findViewById(R.id.btnConsultLocataire);
        consultLocataire.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AdminConsultLocatairesActivity.class);
                startActivity(intent);
            }
        });
        consultLocation=findViewById(R.id.btnConsultLocation);
        consultLocation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AdminConsultLocationActivity.class);
                startActivity(intent);
            }
        });
        consultTypeVilla=findViewById(R.id.btnConsultTypeVilla);
        consultTypeVilla.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AdminConsultTypeVillaActivity.class);
                startActivity(intent);
            }
        });
        consultUser=findViewById(R.id.btnConsultUser);
        consultUser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AdminConsultUserActivity.class);
                startActivity(intent);
            }
        });

        newLocataire=(Button)findViewById(R.id.btnNewLocataire);
        newLocataire.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AdminNewLocataireActivity.class);
                startActivity(intent);
            }
        });
        newLocation=findViewById(R.id.btnNewLocation);
        newLocation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AdminNewLocationActivity.class);
                startActivity(intent);
            }
        });
        newTypeVilla=findViewById(R.id.btnNewTypeVilla);
        newTypeVilla.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AdminNewTypeVillaActivity.class);
                startActivity(intent);
            }
        });
        newUser=findViewById(R.id.btnNewUser);
        newUser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AdminNewUserActivity.class);
                startActivity(intent);
            }
        });
    }
}