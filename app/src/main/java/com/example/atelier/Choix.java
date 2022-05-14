package com.example.atelier;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Choix extends AppCompatActivity {

    Button etud;
    Button prof;
    Button retour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix
        );
        retour=findViewById(R.id.retour);
        etud=findViewById(R.id.etud);
        prof=findViewById(R.id.prof);
        prof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Choix.this, MainActivity2.class));

            }

        });
        etud.setOnClickListener(view -> {
            startActivity(new Intent(Choix.this, MainActivity22.class));
        });

        retour.setOnClickListener(view -> {
            startActivity(new Intent(Choix.this, login.class));
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuother:
                Intent appel = new Intent(Choix.this, email.class);
                startActivity(appel);

            case R.id.menuother2:
                Toast.makeText(this, "other_menu2 selected", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }}