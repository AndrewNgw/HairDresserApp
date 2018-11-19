package com.example.asus.hairdresserapp;

import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import androidx.lifecycle.LiveData;

public interface IHairSalonDAO {

    void insert(HairSalon hairSalon);
    void update(HairSalon hairSalon);
    void delete(HairSalon hairSalon);
    LiveData<List<HairSalon>> getAllHairSalons();
}
