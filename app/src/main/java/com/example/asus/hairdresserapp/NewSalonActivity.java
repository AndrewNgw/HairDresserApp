package com.example.asus.hairdresserapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NewSalonActivity extends AppCompatActivity {

    private TextView name;
    private TextView adress;
    private TextView parking;
    private TextView wifi;
    private TextView prices;
    private TextView openingHours;
    private HairSalonViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_salon);

        viewModel = new HairSalonViewModel(getApplication());

        name = findViewById(R.id.nameText);
        adress = findViewById(R.id.adressText);
        parking = findViewById(R.id.parkingText);
        wifi = findViewById(R.id.wifiText);
        prices = findViewById(R.id.pricesText);
        openingHours = findViewById(R.id.openingHoursText);

    }

    public void createNewHairSalon(View v){
        HairSalon salon = new HairSalon(name.getText().toString(), adress.getText().toString(), parking.getText().toString(), wifi.getText().toString(), prices.getText().toString(), openingHours.getText().toString());
        viewModel.insert(salon);
        finishMyActivity();
    }

    private void finishMyActivity(){
        finish();
    }
}
