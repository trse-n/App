package com.example.myapplication2.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.Data;
import com.example.myapplication2.DataDetails;
import com.example.myapplication2.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class DataAdapter extends FirestoreRecyclerAdapter<Data, DataAdapter.DataViewHolder>{
    Context context;


    public DataAdapter(@NonNull FirestoreRecyclerOptions<Data> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull DataViewHolder holder, int position, @NonNull Data data) {
        holder.titleTextView.setText(data.getData());
        holder.contentTextView.setText(data.getDataposeva());

        holder.itemView.setOnClickListener((view) -> {
            Intent intent = new Intent(context, DataDetails.class);
            intent.putExtra("data",data.getData());
            intent.putExtra("dataposeva",data.getDataposeva());
            intent.putExtra("day_dataposeva",data.getDay_dataposeva());
            intent.putExtra("stadiiplant",data.getStadiiplant());
            String dataId = this.getSnapshots().getSnapshot(position).getId();
            intent.putExtra("dataId",dataId);
            context.startActivity(intent);
        });

    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_data_item,parent,false);
        return new DataViewHolder(view);
    }

    class DataViewHolder extends RecyclerView.ViewHolder{

        TextView titleTextView,contentTextView;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.data_title_text_view);
            contentTextView = itemView.findViewById(R.id.data_content_text_view);
        }
    }
}
