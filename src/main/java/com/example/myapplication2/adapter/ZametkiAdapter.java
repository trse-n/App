package com.example.myapplication2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.R;
import com.example.myapplication2.Utility;
import com.example.myapplication2.Zametki;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.Query;
import com.google.firebase.auth.FirebaseAuth;

public class ZametkiAdapter extends FirestoreRecyclerAdapter<Zametki, ZametkiAdapter.ZametkiViewHolder> {
    Context context;


    public ZametkiAdapter(@NonNull FirestoreRecyclerOptions<Zametki> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull ZametkiViewHolder holder, int position, @NonNull Zametki zametki) {
        holder.titleTextView.setText(zametki.getTitle());
        holder.contentTextView.setText(zametki.getContent());

    }

    @NonNull
    @Override
    public ZametkiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_zametki_item, parent, false);
        return new ZametkiViewHolder(view);
    }

    class ZametkiViewHolder extends RecyclerView.ViewHolder{
        TextView titleTextView,contentTextView;

        public ZametkiViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.zametki_title_text_view);
            contentTextView = itemView.findViewById(R.id.zametki_content_text_view);
        }
    }
}
