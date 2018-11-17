package com.example.asus.hairdresserapp;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

public class HairSalonDAO implements IHairSalonDAO{
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mHairSalonsDtabaseReference;
    private ChildEventListener mChildEventListener;

    public HairSalonDAO(final HairSalonAdapter adapter){
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mHairSalonsDtabaseReference = mFirebaseDatabase.getReference().child("salons");

        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                HairSalon salon =  dataSnapshot.getValue(HairSalon.class);
                adapter.addSalon(salon);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                HairSalon salon =  dataSnapshot.getValue(HairSalon.class);
                adapter.removeSalon(salon);
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };

        mHairSalonsDtabaseReference.addChildEventListener(mChildEventListener);
    }

    public FirebaseDatabase getFirebaseInstance(){
        return mFirebaseDatabase;
    }

    @Override
    public void insert(HairSalon hairSalon) {
        mHairSalonsDtabaseReference.push().setValue(hairSalon);
    }

    @Override
    public void update(HairSalon hairSalon) {

    }

    @Override
    public void delete(HairSalon hairSalon) {
        mHairSalonsDtabaseReference.child("salons").child("").removeValue();
    }

    @Override
    public LiveData<List<HairSalon>> getAllHairSalons() {
        return null;
    }
}
