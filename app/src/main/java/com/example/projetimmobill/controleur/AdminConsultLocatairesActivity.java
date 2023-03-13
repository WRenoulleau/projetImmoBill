package com.example.projetimmobill.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.projetimmobill.R;
import com.example.projetimmobill.modele.Locataire;
import com.example.projetimmobill.modele.LocataireDAO;

import java.util.ArrayList;

public class AdminConsultLocatairesActivity extends AppCompatActivity {
    private Button btnRetour;
    private ListView listview;
    private ArrayList<Locataire> lesLocataires=new ArrayList<>();
    private EditText txtid,txtPrenom,txtNom,txtAdresse,txtTel,txtEmail,txtCommentaire;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_consult_locataires);


        txtid=(EditText)findViewById(R.id.editIdLocataire) ;
        txtNom=(EditText)findViewById(R.id.editNomLocataire);
        txtPrenom=(EditText)findViewById(R.id.editPrenom);
        txtAdresse=(EditText)findViewById(R.id.editAdresse);
        txtTel=(EditText)findViewById(R.id.editTel);
        txtEmail=(EditText)findViewById(R.id.editEmail);
        txtCommentaire=(EditText)findViewById(R.id.editCommentaire);


        listview=(ListView)findViewById(R.id.listLocataires);



        LocataireDAO locataireDAO=new LocataireDAO(getApplicationContext());

        ArrayList<Locataire> ok= locataireDAO.getLocataire();
        ArrayAdapter<Locataire> v=new ArrayAdapter(this,android.R.layout.simple_list_item_1,ok);
        listview.setAdapter(v);


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