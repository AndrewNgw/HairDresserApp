package com.example.asus.hairdresserapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.PreferenceManager;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private Button buttonClient;
    private Button buttonSalon;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textView2);

        buttonClient = findViewById(R.id.button_1);
        buttonSalon = findViewById(R.id.button_2);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // fcode below ensures the settings are properly intialized with there default values, the
        // setdefaultvalues() takes 3 arguements
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

    }

    public void openSalons(View v){
            startActivity(new Intent(this,ListOfHairSalonsActivity.class));
    }

    public void createSalon(View v)
    {
        startActivity(new Intent(this,NewSalonActivity.class));
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    public boolean onOptionsItemSelected(MenuItem item)
    {
      switch (item.getItemId())
      {
          case R.id.action_settings:
              // show the App settings UI
              Intent intent = new Intent(this, SettingsActivity.class);
              startActivity(intent);
              return true;

          case R.id.action_favorite:
              // User chose "favorite" action, mark the current item as a favorite
              return true;

          default:
              //if we got here then the user's action was not recognized
              //Invoke the super class to handle it
              return super.onOptionsItemSelected(item);
      }
    }

}
