package com.example.asus.hairdresserapp;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class HairSalonViewModel extends AndroidViewModel {

    private HairSalonRepository repository;
    private LiveData<List<HairSalon>> salons;
    private HairSalonAdapter adapter;

    public HairSalonViewModel(@NonNull Application application) {
        super(application);
        adapter = new HairSalonAdapter(application.getApplicationContext());
        repository = new HairSalonRepository(application, adapter);
        salons = repository.getSalons();
    }

    public void insert(HairSalon hairSalon){
        repository.insert(hairSalon);
    }

    public void update(HairSalon hairSalon){
        repository.update(hairSalon);
    }

    public void delete(HairSalon hairSalon){
        repository.delete(hairSalon);
    }

    public LiveData<List<HairSalon>> getSalons(){
        return salons;
    }

    public HairSalonAdapter getAdapter(){
        return adapter;
    }
}
