package com.example.atelier;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class ListesProfContacts extends AppCompatActivity
{
    RecyclerView recview;
    myadapteretud adapter;
    Button ajout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profcontact);
        setTitle("Search here..");






        recview=(RecyclerView)findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Professeur> options =
                new FirebaseRecyclerOptions.Builder<Professeur>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("professeur"), Professeur.class)
                        .build();

        adapter=new myadapteretud(options);
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
        FirebaseRecyclerOptions<Professeur> options =
                new FirebaseRecyclerOptions.Builder<Professeur>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("professeur").orderByChild("name").startAt(s).endAt(s+"\uf8ff"), Professeur.class)
                        .build();

        adapter=new myadapteretud(options);
        adapter.startListening();
        recview.setAdapter(adapter);

    }
}