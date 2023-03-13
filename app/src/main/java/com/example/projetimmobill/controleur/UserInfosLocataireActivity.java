package com.example.projetimmobill.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.projetimmobill.R;

public class UserInfosLocataireActivity extends AppCompatActivity {
    private Button btnRetour,btnValider;
    private EditText editAdulte, editEnfant, editArrivee, editDepart;
    RadioButton oMenage, nMenage;
    RadioGroup optMenage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_infos_locataire);

        btnRetour = (Button) findViewById(R.id.btnRetour);
        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), UserInfosReservationActivity.class);
                startActivity(intent);
            }
        });

        editAdulte=findViewById(R.id.editNbAdultes);
        editEnfant=findViewById(R.id.editNbEnfants);
        editArrivee=findViewById(R.id.editDateArrivee);
        editDepart=findViewById(R.id.editDateDepart);

        oMenage=findViewById(R.id.radioOui);
        nMenage=findViewById(R.id.radioNon);
        optMenage=findViewById(R.id.radioGroup);

        btnValider=findViewById(R.id.btnValider);
        btnValider.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), UserConfirmationActivity.class);
                startActivity(intent);
            }
        });

    }
}