package com.example.projetimmobill.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projetimmobill.R;

public class ChoixUserActivity extends AppCompatActivity {

    private Button consultResa, newResa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_user);

      
        consultResa=findViewById(R.id.btnConsultMesResa);
        consultResa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), UserConsultReservationsActivity.class);
                startActivity(intent);
            }
        });
        newResa=findViewById(R.id.btnNewUserResa);
        newResa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), UserNewReservationActivity.class);
                startActivity(intent);
            }
        });
    }
}