package com.example.bloodpressurepro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Monitor extends AppCompatActivity {

    public static final String SHARED_PREFERENCES = "sharedPreferences";
    public String text = " ";
    public TextView ageDisplay;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        String age = sharedPreferences.getString("age","None");
        String BSL = sharedPreferences.getString("BSL","None");

        int numAge = Integer.parseInt(age);
        int numBSL = Integer.parseInt(age);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.health_monitor);


        getAge();
        getBSL();

        if (numAge < 6){
            ageDisplay.setText("Age is over 10");
        }

        if (numAge < 10){
            ageDisplay.setText("Age is less than 10");
        }



    }

        public void getAge(){
            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
            String age = sharedPreferences.getString("age","None");
            Toast.makeText(this, "Age: "+ age,Toast.LENGTH_SHORT).show();

            ageDisplay = (TextView) findViewById(R.id.displayAge);
            ageDisplay.setText(age);
        }

        public void getBSL(){
            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
            String BSL = sharedPreferences.getString("BSL", "None");
            Toast.makeText(this, "Blood Sugar Level: "+ BSL,Toast.LENGTH_SHORT).show();
        }




    }

