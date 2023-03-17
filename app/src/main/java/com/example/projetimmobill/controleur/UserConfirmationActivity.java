package com.example.projetimmobill.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projetimmobill.R;

public class UserConfirmationActivity extends AppCompatActivity {
    private Button btnRetour;
    private String montantStr;
    private TextView textMontant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_confirmation);
        btnRetour = (Button) findViewById(R.id.btnRetourAccueil);
        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ChoixUserActivity.class);
                startActivity(intent);
            }
        });
        montantStr=getIntent().getStringExtra("montant");
        textMontant=findViewById(R.id.textMontant);
        textMontant.setText(montantStr+"€");



    }
}