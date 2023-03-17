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
import com.example.projetimmobill.modele.TypeVilla;
import com.example.projetimmobill.modele.TypeVillaDAO;
import com.example.projetimmobill.modele.Villa;
import com.example.projetimmobill.modele.VillaDAO;

import java.util.ArrayList;

public class AdminConsultTypeVillaActivity extends AppCompatActivity {
    private ListView listType;
    private ArrayList<TypeVilla> lesTypes = new ArrayList<TypeVilla>();
    private String nom;
    private String nbCouchages;
    private Button btnRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_consult_typevilla);
        listType=(ListView)findViewById(R.id.listTypeVilla);
        TypeVillaDAO typeAcces = new TypeVillaDAO(this);
        lesTypes=typeAcces.getTypeVillas();
        ArrayAdapter monAdapter = new ArrayAdapter(AdminConsultTypeVillaActivity.this,android.R.layout.simple_list_item_1,lesTypes);
        listType.setAdapter(monAdapter);

        listType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TypeVilla selectedItem= (TypeVilla) listType.getAdapter().getItem(position);
                Intent i = new Intent(AdminConsultTypeVillaActivity.this,AdminDetailsTypeVillaActivity.class);
                i.putExtra("pos", position);
                i.putExtra("id",selectedItem.getId());
                i.putExtra("nom",selectedItem.getNom());
                i.putExtra("nbCouchages",selectedItem.getNbCouchages());
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
    }
}