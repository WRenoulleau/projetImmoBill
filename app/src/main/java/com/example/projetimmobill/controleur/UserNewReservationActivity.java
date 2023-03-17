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

public class UserNewReservationActivity extends AppCompatActivity {
    private Button btnRetour;
    private ListView listReservation;
    private ArrayList<Villa> lesVillas = new ArrayList<Villa>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_new_reservation);
        btnRetour = (Button) findViewById(R.id.btnRetour);
        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ChoixUserActivity.class);
                startActivity(intent);
            }
        });
        listReservation = (ListView) findViewById(R.id.listReservation);
        VillaDAO resaAcces = new VillaDAO(this);
        lesVillas = resaAcces.getVillas();
        ArrayAdapter monAdapter = new ArrayAdapter(UserNewReservationActivity.this,android.R.layout.simple_list_item_1,lesVillas);
        listReservation.setAdapter(monAdapter);
        listReservation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Villa selectedItem= (Villa) listReservation.getAdapter().getItem(position);
                Intent i = new Intent(UserNewReservationActivity.this,UserInfosReservationActivity.class);
                i.putExtra("pos", position);
                i.putExtra("id",selectedItem.getId());
                i.putExtra("nom",selectedItem.getNom());
                i.putExtra("adresse",selectedItem.getAdresse());
                i.putExtra("surface",selectedItem.getSurface());
                i.putExtra("typeVilla",selectedItem.getType());
                i.putExtra("annee",selectedItem.getAnneeConstruction());
                i.putExtra("caution",selectedItem.getCaution());
                i.putExtra("desc",selectedItem.getDescription());
                i.putExtra("descPieces",selectedItem.getPieces());
                i.putExtra("montant",selectedItem.getMontant());
                startActivity(i);
            }
        });
    }
}