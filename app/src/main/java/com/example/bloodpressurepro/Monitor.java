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




    @Override
    public void onCreate(Bundle savedInstanceState) {
        String importedUserAge;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.health_monitor);
        getAge();



        }
        public void getAge(){
            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
            String age = sharedPreferences.getString("age", "No Input");
            Toast.makeText(this, "Age: "+ age,Toast.LENGTH_SHORT).show();
        }





    }

