package com.example.myapplication2.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.PlantsPage;
import com.example.myapplication2.R;
import com.example.myapplication2.model.Plants;

import java.util.List;

public class PlantsAdapter extends RecyclerView.Adapter<PlantsAdapter.PlantsViewHolder> {


    Context context;
    List<Plants> plants;

    public PlantsAdapter(Context context, List<Plants> plants) {
        this.context = context;
        this.plants = plants;
    }

    @NonNull
    @Override
    public PlantsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View plantsItems = LayoutInflater.from(context).inflate(R.layout.plants_item, parent, false);
        return new PlantsAdapter.PlantsViewHolder(plantsItems);
    }

    @Override
    public void onBindViewHolder(@NonNull PlantsViewHolder holder, int position) {
        holder.plantsclr.setBackgroundColor(Color.parseColor(plants.get(position).getColor()));

        holder.plantsTitle.setText(plants.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PlantsPage.class);

                intent.putExtra("plantsTitle", plants.get(position).getTitle());
                intent.putExtra("plantsText", plants.get(position).getText());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return plants.size();
    }

    public static final class PlantsViewHolder extends RecyclerView.ViewHolder{

        LinearLayout plantsclr;
        TextView plantsTitle;


        public PlantsViewHolder(@NonNull View itemView) {
            super(itemView);

            plantsclr = itemView.findViewById(R.id.plantsclr);
            plantsTitle = itemView.findViewById(R.id.plantsTitle);
        }
    }


}
