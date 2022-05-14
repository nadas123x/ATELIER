package com.example.atelier;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atelier.modele.Et;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity22 extends AppCompatActivity
{
    RecyclerView recview;
    myadapter2 adapter;
    Button ajout;
    Button back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);
        setTitle("Search here..");
        ajout=findViewById(R.id.ajout);

        ajout.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity22.this, adddata.class));
        });




        recview=(RecyclerView)findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Etudiant> options =
                new FirebaseRecyclerOptions.Builder<Etudiant>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("etudiant"), Etudiant.class)
                        .build();

        adapter=new myadapter2(options);
        recview.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.searchmenu,menu);

        MenuItem item=menu.findItem(R.id.search);

        SearchView searchView=(SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String s) {

                processsearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                processsearch(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void processsearch(String s)
    {
        FirebaseRecyclerOptions<Etudiant> options =
                new FirebaseRecyclerOptions.Builder<Etudiant>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("etudiant").orderByChild("name").startAt(s).endAt(s+"\uf8ff"), Etudiant.class)
                        .build();

        adapter=new myadapter2(options);
        adapter.startListening();
        recview.setAdapter(adapter);

    }
}