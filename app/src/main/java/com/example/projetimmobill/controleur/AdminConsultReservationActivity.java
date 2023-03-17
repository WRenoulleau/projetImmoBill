package com.example.projetimmobill.controleur;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.projetimmobill.R;
import com.example.projetimmobill.modele.Villa;
import com.example.projetimmobill.modele.VillaDAO;

import java.util.ArrayList;

public class AdminConsultReservationActivity extends AppCompatActivity {
    private Button btnRetour;
    private ListView listReservation;
    private ArrayList<Villa> lesVillas = new ArrayList<Villa>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_consult_reservation);
        btnRetour = (Button) findViewById(R.id.btnRetour);
        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ChoixAdminActivity.class);
                startActivity(intent);
            }
        });
        listReservation = (ListView) findViewById(R.id.listReservationAdmin);
        VillaDAO resaAcces = new VillaDAO(this);
        //------------> lesVillas = resaAcces.getVillas();
        ArrayAdapter monAdapter = new ArrayAdapter(AdminConsultReservationActivity.this,android.R.layout.simple_list_item_1,lesVillas);
        listReservation.setAdapter(monAdapter);
        listReservation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(AdminConsultReservationActivity.this,AdminDetailsReservationActivity.class);
                startActivity(i);
            }
        });
    }
}