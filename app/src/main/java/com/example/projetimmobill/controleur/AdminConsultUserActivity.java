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
import com.example.projetimmobill.modele.User;
import com.example.projetimmobill.modele.UserDAO;
import com.example.projetimmobill.modele.Villa;
import com.example.projetimmobill.modele.VillaDAO;

import java.util.ArrayList;

public class AdminConsultUserActivity extends AppCompatActivity {

    private Button btnRetour;
    private ListView listUser;
    private ArrayList<User> lesUser = new ArrayList<User>();
    private String login;
    private String password;
    private String type;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_consult_user);

        listUser=(ListView)findViewById(R.id.listUser);

        UserDAO userAcces = new UserDAO(this);

        lesUser=userAcces.getUsers();
        ArrayAdapter monAdapter = new ArrayAdapter(AdminConsultUserActivity.this,android.R.layout.simple_list_item_1,lesUser);
        listUser.setAdapter(monAdapter);

        listUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User selectedItem= (User) listUser.getAdapter().getItem(position);
                Intent i = new Intent(AdminConsultUserActivity.this,AdminDetailsUserActivity.class);
                i.putExtra("pos", position);
                i.putExtra("id",selectedItem.getId());
                i.putExtra("login",selectedItem.getLogin());
                i.putExtra("password",selectedItem.getPassword());
                i.putExtra("type",selectedItem.getType());

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