package com.example.atelier;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class adddata extends AppCompatActivity
{
    EditText name,filiere,email,NumTel,purl;
    Button submit,backk;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddata);

        name=(EditText)findViewById(R.id.add_name);
        email=(EditText)findViewById(R.id.add_email);
        filiere=(EditText)findViewById(R.id.add_filiere);
        NumTel=(EditText)findViewById(R.id.add_NumTel);
        purl=(EditText)findViewById(R.id.add_purl);



        submit=(Button)findViewById(R.id.add_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processinsert();
            }
        });
        backk=findViewById(R.id.backk);

        backk.setOnClickListener(view -> {
            startActivity(new Intent(adddata.this, MainActivity22.class));
        });
    }

    private void processinsert()
    {
        Map<String,Object> map=new HashMap<>();
        map.put("name",name.getText().toString());
        map.put("filiere",filiere.getText().toString());
        map.put("email",email.getText().toString());
        map.put("NumTel",NumTel.getText().toString());
        map.put("purl",purl.getText().toString());
        FirebaseDatabase.getInstance().getReference().child("etudiant").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        name.setText("");
                        filiere.setText("");
                        email.setText("");
                        NumTel.setText("");

                        purl.setText("");
                        Toast.makeText(getApplicationContext(),"Inserted Successfully",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e)
                    {
                        Toast.makeText(getApplicationContext(),"Could not insert",Toast.LENGTH_LONG).show();
                    }
                });

    }
}