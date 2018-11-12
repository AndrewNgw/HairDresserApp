package com.example.asus.hairdresserapp;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class HairSalonAdapter extends RecyclerView.Adapter<HairSalonAdapter.HairSalonHolder> {

    private List<HairSalon> salons = new ArrayList<>();
    private Context context;

    public HairSalonAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public HairSalonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.salon_item, parent, false);
        return new HairSalonHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HairSalonHolder holder, final int position) {
        HairSalon currentSalon = salons.get(position);
        holder.name.setText(currentSalon.getName());

        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HairSalon salon = salons.get(position);
                Intent intent = new Intent(context, HairSalonInfo.class);
                intent.putExtra("salon", salon);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return salons.size();
    }

    public void setSalons(List<HairSalon> salons) {
        this.salons = salons;
        notifyDataSetChanged();
    }

    public void addSalon(HairSalon hairSalon){
        salons.add(hairSalon);
        notifyDataSetChanged();
    }
    
    public void removeSalon(HairSalon hairSalon){
        for (int i = 0; i < salons.size(); i++) {
            if(salons.get(i).equals(hairSalon)){
                salons.remove(i);
            }
        }
        notifyDataSetChanged();
    }

    class HairSalonHolder extends RecyclerView.ViewHolder {
       private TextView name;
       private CardView itemLayout;

        public HairSalonHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.hair_salon_name);
            itemLayout = itemView.findViewById(R.id.itemLayout);
        }
    }
}
