package com.example.atelier;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ChoixDebut extends AppCompatActivity {

    Button etud;
    Button prof;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choixdebut
        );
        etud=findViewById(R.id.etud);
        prof=findViewById(R.id.prof);
        prof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChoixDebut.this, login.class));

            }

        });
        etud.setOnClickListener(view -> {
            startActivity(new Intent(ChoixDebut.this, login1.class));
        });
    }
}