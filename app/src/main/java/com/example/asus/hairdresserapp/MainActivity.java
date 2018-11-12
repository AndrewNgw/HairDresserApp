package com.example.asus.hairdresserapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private Button buttonClient;
    private Button buttonSalon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textView2);

        buttonClient = findViewById(R.id.button_1);
        buttonSalon = findViewById(R.id.button_2);


    }

    public void openSalons(View v){
            startActivity(new Intent(this,ListOfHairSalonsActivity.class));
    }

    public void createSalon(View v)
    {
        startActivity(new Intent(this,HairSalon.class));
    }



}
