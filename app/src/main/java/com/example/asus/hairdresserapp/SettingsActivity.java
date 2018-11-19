package com.example.asus.hairdresserapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

public class SettingsActivity extends AppCompatActivity {
    // need to hold the key needed to access shared preferences value of settings
    public static final String KEY_PREF_EXAMPLE_SWITCH = "example_switch";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment()).commit();

        // for the settings
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean switchPref = sharedPref.getBoolean(SettingsActivity.KEY_PREF_EXAMPLE_SWITCH, false);

        Toast.makeText(this, switchPref.toString(), Toast.LENGTH_SHORT).show();
    }

}
