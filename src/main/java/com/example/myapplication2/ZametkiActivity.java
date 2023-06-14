package com.example.myapplication2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication2.adapter.DataAdapter;
import com.example.myapplication2.adapter.ZametkiAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.Query;
import com.google.firebase.auth.FirebaseAuth;


public class ZametkiActivity extends AppCompatActivity {

    FloatingActionButton addZametkiBtn;
    RecyclerView recyclerView;
    ZametkiAdapter zametkiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zametki);

        addZametkiBtn = findViewById(R.id.add_zametki_btn);
        recyclerView = findViewById(R.id.recycler_view);

        addZametkiBtn.setOnClickListener((view) -> startActivity(new Intent(ZametkiActivity.this, ZametkiDetails.class)));
        setupRecyclerView();
        btnExit();
        btnMainPage();
    }

    private void btnExit() {
        Button btnexit = (Button) findViewById(R.id.btnexit);
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ZametkiActivity.this, MainActivity.class));
            }
        });
    }

    private void btnMainPage() {
        Button btnexit = (Button) findViewById(R.id.btnmain);
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ZametkiActivity.this, PageActivity.class));
            }
        });
    }

    void setupRecyclerView(){
        Query query = Utility.getCollectionReferenceForZametki();
        FirestoreRecyclerOptions<Zametki> options = new FirestoreRecyclerOptions.Builder<Zametki>()
                .setQuery(query,Zametki.class).build();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        zametkiAdapter = new ZametkiAdapter(options, this);
        recyclerView.setAdapter(zametkiAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        zametkiAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        zametkiAdapter.stopListening();
    }

    @Override
    protected void onResume() {
        super.onResume();
        zametkiAdapter.notifyDataSetChanged();
    }
}