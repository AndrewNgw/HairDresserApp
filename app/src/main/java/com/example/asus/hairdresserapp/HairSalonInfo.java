package com.example.asus.hairdresserapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class HairSalonInfo extends AppCompatActivity {

    private TextView name;
    private TextView adress;
    private TextView parking;
    private TextView wifi;
    private TextView prices;
    private TextView openingHours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hair_salon_info);

        Intent intent = getIntent();
        HairSalon salon = (HairSalon) intent.getSerializableExtra("salon");

        name = findViewById(R.id.nameText);
        adress = findViewById(R.id.adressText);
        parking = findViewById(R.id.parkingText);
        wifi = findViewById(R.id.wifiText);
        prices = findViewById(R.id.pricesText);
        openingHours = findViewById(R.id.openingHoursText);

        name.setText(salon.getName());
        adress.setText(salon.getAddress());
        parking.setText(salon.getParking());
        wifi.setText(salon.getWifi());
        prices.setText(salon.getPrices());
        openingHours.setText(salon.getOpeningHours());
    }
}
