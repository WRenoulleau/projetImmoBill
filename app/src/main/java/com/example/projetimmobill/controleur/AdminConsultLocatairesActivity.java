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

import com.example.projetimmobill.R;
import com.example.projetimmobill.modele.Locataire;
import com.example.projetimmobill.modele.LocataireDAO;
import com.example.projetimmobill.modele.Villa;
import com.example.projetimmobill.modele.VillaDAO;

import java.util.ArrayList;

public class AdminConsultLocatairesActivity extends AppCompatActivity {
    private Button btnRetour;
    private ListView listview;
    private ArrayList<Locataire> lesLocataires = new ArrayList<>();
    private String nom;
    private String prenom;
    private String adresse;
    private String tel;
    private String email;
    private String commentaire;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_consult_locataires);


        listview = (ListView) findViewById(R.id.listLocataires);
        LocataireDAO locataireDAO = new LocataireDAO(getApplicationContext());

        ArrayList<Locataire> ok = locataireDAO.getLocataire();
        ArrayAdapter<Locataire> v = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ok);
        listview.setAdapter(v);


        LocataireDAO resaAcces = new LocataireDAO(this);

        lesLocataires = resaAcces.getLocataire();

        ArrayAdapter monAdapter = new ArrayAdapter(AdminConsultLocatairesActivity.this, android.R.layout.simple_list_item_1, lesLocataires);

        listview.setAdapter(monAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Locataire selectedItem = (Locataire) listview.getAdapter().getItem(position);
                Intent i = new Intent(AdminConsultLocatairesActivity.this, AdminDetailsLocataireActivity.class);
                i.putExtra("pos", position);
                i.putExtra("id", selectedItem.getId());
                i.putExtra("nom", selectedItem.getNom());
                i.putExtra("adresse", selectedItem.getAdresse());
                i.putExtra("prenom", selectedItem.getPrenom());
                i.putExtra("tel", selectedItem.getTel());
                i.putExtra("email", selectedItem.getEmail());
                i.putExtra("commentaire", selectedItem.getCommentaire());

                startActivity(i);
            }
        });

        int pos = getIntent().getIntExtra("pos", -1);
        if (pos >= 0) {
            nom = getIntent().getStringExtra("nom");
            adresse = getIntent().getStringExtra("adresse");
            prenom = getIntent().getStringExtra("prenom");
            tel = getIntent().getStringExtra("tel");
            email = getIntent().getStringExtra("email");
            commentaire = getIntent().getStringExtra("commentaire");

        }


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
