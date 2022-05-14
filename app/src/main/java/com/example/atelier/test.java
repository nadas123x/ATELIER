package com.example.atelier;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.atelier.modele.Professeur1;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class test extends AppCompatActivity {

    LinkedList<Professeur1> profs;

    EditText search,prof_textview;
    ListView list_prof;
    FloatingActionButton fab;


    FirebaseFirestore db;
    RecyclerView.LayoutManager layoutManager;

    RecyclerView myrecycler;
    ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        db = FirebaseFirestore.getInstance();

        list_prof=findViewById((R.id.list_prof));
        fab=findViewById(R.id.add_prof);

        profs=new LinkedList<Professeur1>();
        getallProfesseurs();

    }



    void getallProfesseurs() {

        db.collection("professeur")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Professeur1 p = new Professeur1(document.getString("nom"),
                                        document.getString("prenom"),
                                        document.getString("tel"),
                                        document.getString("photo"),
                                        document.getString("departement"));
                                profs.add(p);
                            }
                            System.out.println(profs);
                        } else {
                            System.out.println("Erreur");
                        }


                        ArrayList<String> noms_prof = new ArrayList<String>();
                        for (Professeur1 prof : profs) {
                            noms_prof.add(prof.getNom());
                            noms_prof.add(prof.getPrenom());
                            noms_prof.add(prof.getTel());
                            noms_prof.add(prof.getPhoto());


                        }


                    }
                });


    }}