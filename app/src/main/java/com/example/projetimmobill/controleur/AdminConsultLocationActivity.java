package com.example.projetimmobill.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.projetimmobill.R;
import com.example.projetimmobill.modele.Villa;
import com.example.projetimmobill.modele.VillaDAO;

import java.util.ArrayList;

public class AdminConsultLocationActivity extends AppCompatActivity {
    private Button btnRetour;
    private ListView listLoc;
    private ArrayList<Villa> lesVillas = new ArrayList<Villa>();
    private int id;
    private String nom;
    private String adresse;
    private String annee;
    private String description;
    private String pieces;
    private float surface;
    private String caution;
    private String montant;
    private int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_consult_location);


        listLoc=(ListView)findViewById(R.id.listLocations);
        VillaDAO villaAcces = new VillaDAO(this);
        lesVillas=villaAcces.getVillas();
        ArrayAdapter monAdapter = new ArrayAdapter(AdminConsultLocationActivity.this,android.R.layout.simple_list_item_1,lesVillas);
        listLoc.setAdapter(monAdapter);

        listLoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Villa selectedItem= (Villa) listLoc.getAdapter().getItem(position);
                Intent i = new Intent(AdminConsultLocationActivity.this,AdminDetailsLocationActivity.class);
                i.putExtra("pos", position);
                i.putExtra("nom",selectedItem.getNom());
                i.putExtra("adresse",selectedItem.getAdresse());
                i.putExtra("surface",selectedItem.getSurface());
                i.putExtra("typeVilla",selectedItem.getType());
                i.putExtra("annee",selectedItem.getAnneeConstruction());
                i.putExtra("caution",selectedItem.getCaution());
                i.putExtra("description",selectedItem.getDescription());
                i.putExtra("descPieces",selectedItem.getPieces());
                i.putExtra("montant",selectedItem.getMontant());
                startActivity(i);
            }
        });

        btnRetour = (Button) findViewById(R.id.btnRetour);

        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ChoixAdminActivity.class);
                startActivity(intent);
            }
        });
        int pos=getIntent().getIntExtra("pos", -1);
        if(pos>=0){
            nom=getIntent().getStringExtra("nom");
            adresse=getIntent().getStringExtra("adresse");
            surface=getIntent().getFloatExtra("surface", 0);
            type=getIntent().getIntExtra("typeVilla",0);
            annee=getIntent().getStringExtra("annee");
            caution=getIntent().getStringExtra("caution");
            description=getIntent().getStringExtra("desc");
            pieces=getIntent().getStringExtra("descPieces");
            montant=getIntent().getStringExtra("montant");
        }
    }
}