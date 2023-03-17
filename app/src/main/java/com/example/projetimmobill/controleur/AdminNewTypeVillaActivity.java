package com.example.projetimmobill.controleur;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.projetimmobill.R;
import com.example.projetimmobill.modele.TypeVilla;
import com.example.projetimmobill.modele.TypeVillaDAO;
import com.example.projetimmobill.modele.Villa;
import com.example.projetimmobill.modele.VillaDAO;

import java.util.ArrayList;
import java.util.Iterator;

public class AdminNewTypeVillaActivity extends AppCompatActivity {

    private Button btnRetour, btnAjouter;
    private EditText editNom, editNbCouchages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_new_typevilla);
        editNom = (EditText) findViewById(R.id.editNomTypeVilla);
        editNbCouchages = (EditText) findViewById(R.id.editNbCouchages);
        btnRetour = (Button) findViewById(R.id.btnRetour);
        btnAjouter = (Button) findViewById(R.id.btnAjouterTypeVilla);
        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ChoixAdminActivity.class);
                startActivity(intent);
            }
        });
        btnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
                Intent intent = new Intent(v.getContext(), AdminConsultTypeVillaActivity.class);
                startActivity(intent);
            }
        });
    }
    private void add(){
        editNom = (EditText) findViewById(R.id.editNomTypeVilla);
        editNbCouchages = (EditText) findViewById(R.id.editNbCouchages);

        TypeVillaDAO typeAcces = new TypeVillaDAO(this);
        TypeVilla unType= new TypeVilla(0,editNom.getText().toString(), Integer.valueOf(String.valueOf(editNbCouchages.getText())));
        typeAcces.addTypeVilla(unType);
        ArrayList<TypeVilla> listType;
        listType = typeAcces.getTypeVillas();

        Iterator<TypeVilla> itType;
        TypeVilla letype;
        for( itType = listType.iterator(); itType.hasNext(); ){
            letype = itType.next();
        }
    }
}