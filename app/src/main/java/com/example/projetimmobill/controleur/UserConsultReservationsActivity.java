package com.example.projetimmobill.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.projetimmobill.R;
import com.example.projetimmobill.modele.Villa;
import com.example.projetimmobill.modele.VillaDAO;

import java.util.ArrayList;

public class UserConsultReservationsActivity extends AppCompatActivity {
    private Button btnRetour;

    private ListView listResa;
    private ArrayList<Villa> lesVillas = new ArrayList<Villa>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_consult_reservations);


        listResa=(ListView)findViewById(R.id.listMesReservations);
        VillaDAO villaAcces = new VillaDAO(this);
        lesVillas=villaAcces.getVillas();
        ArrayAdapter monAdapter = new ArrayAdapter(UserConsultReservationsActivity.this,android.R.layout.simple_list_item_1,lesVillas);
        listResa.setAdapter(monAdapter);

        btnRetour = (Button) findViewById(R.id.btnRetour);
        btnRetour.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ChoixUserActivity.class);
                startActivity(intent);
            }
        });
    }
}