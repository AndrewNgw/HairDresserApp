package com.example.asus.hairdresserapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class ListOfHairSalonsActivity extends AppCompatActivity {

    private HairSalonViewModel hairSalonViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_hair_salons);
        hairSalonViewModel = ViewModelProviders.of(this).get(HairSalonViewModel.class);

        HairSalon salon = new HairSalon("name10", "somegade", "yes", "yes", "free", "every day");

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final HairSalonAdapter adapter = hairSalonViewModel.getAdapter();
        recyclerView.setAdapter(adapter);


        //hairSalonViewModel.insert(salon);
        if(hairSalonViewModel.getSalons()!=null)
        hairSalonViewModel.getSalons().observe(this, new Observer<List<HairSalon>>() {
            @Override
            public void onChanged(List<HairSalon> hairSalons) {
                adapter.setSalons(hairSalons);
            }
        });
    }
}
