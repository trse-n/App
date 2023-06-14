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

public class PlantsPage extends AppCompatActivity {

    FloatingActionButton addDataBtn;
    RecyclerView recyclerView;
    DataAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plants_page);

        addDataBtn = findViewById(R.id.add_data_btn);
        recyclerView = findViewById(R.id.recycler_view_2);

        TextView plantsTitle = findViewById(R.id.plantsPageTitle);
        plantsTitle.setText(getIntent().getStringExtra("plantsTitle"));

        addDataBtn.setOnClickListener((view) -> startActivity(new Intent(PlantsPage.this, DataDetails.class)));
        setupRecyclerView();
        btnExit();
        btnZametki();
        btnMainPage();
    }

    private void btnExit() {
        Button btnexit = (Button) findViewById(R.id.btnexit);
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PlantsPage.this, MainActivity.class));
            }
        });
    }

    private void btnZametki() {
        Button btnzametki = (Button) findViewById(R.id.btnzametki);
        btnzametki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PlantsPage.this, ZametkiActivity.class));
            }
        });
    }

    private void btnMainPage() {
        Button btnexit = (Button) findViewById(R.id.btnmain);
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PlantsPage.this, PageActivity.class));
            }
        });
    }

    void setupRecyclerView(){
        Query query = Utility.getCollectionReferenceForData();
        FirestoreRecyclerOptions<Data>  options = new FirestoreRecyclerOptions.Builder<Data>()
                .setQuery(query, Data.class).build();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataAdapter = new DataAdapter(options, this);
        recyclerView.setAdapter(dataAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        dataAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        dataAdapter.startListening();
    }

    @Override
    protected void onResume() {
        super.onResume();
        dataAdapter.notifyDataSetChanged();
    }
}