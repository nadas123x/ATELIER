package com.example.atelier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class espaceEtud extends AppCompatActivity {
    Button Ensiass;
    Button logoutt;
    Button emploi;
    Button profs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espace_etud);


        Ensiass=findViewById(R.id.Ensiass);
        logoutt=findViewById(R.id.logoutt);
        emploi=findViewById(R.id.emploi);
        profs=findViewById(R.id.profs);


        Ensiass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(espaceEtud.this, Visiteurpage.class));

            }

        });
        logoutt.setOnClickListener(view -> {
            startActivity(new Intent(espaceEtud.this, login1.class));
        });
        emploi.setOnClickListener(view -> {
            startActivity(new Intent(espaceEtud.this, Emploi.class));
        });
        profs.setOnClickListener(view -> {
            startActivity(new Intent(espaceEtud.this, ListesProfContacts.class));
        });
    }
}