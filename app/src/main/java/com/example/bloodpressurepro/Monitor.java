package com.example.bloodpressurepro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Monitor extends AppCompatActivity {

    public static final String SHARED_PREFERENCES = "sharedPreferences";
    public String text = " ";
    public TextView ageDisplay;
    public TextView displayWhetherHealthy;
    public Switch scenarioSwitch1;
    public Switch scenarioSwitch2;
    public Switch scenarioSwitch3;
    public Switch scenarioSwitch4;

    public void getAge(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        String age = sharedPreferences.getString("age","None");
        Toast.makeText(this, "Age: "+ age,Toast.LENGTH_SHORT).show();

    }

    public void getBSL(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        String BSL = sharedPreferences.getString("BSL", "None");
        Toast.makeText(this, "Blood Sugar Level: "+ BSL,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health_monitor);

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        String age = sharedPreferences.getString("age","None");
        String BSL = sharedPreferences.getString("BSL","None");
        displayWhetherHealthy = (TextView) findViewById(R.id.displayStatus);

        scenarioSwitch1 = (Switch) findViewById(R.id.scenario1);
        scenarioSwitch2 = (Switch) findViewById(R.id.scenario2);
        scenarioSwitch3 = (Switch) findViewById(R.id.scenario3);
        scenarioSwitch4 = (Switch) findViewById(R.id.scenario4);

        Boolean switchState1 = scenarioSwitch1.isChecked();
        Boolean switchState2 = scenarioSwitch2.isChecked();
        Boolean switchState3 = scenarioSwitch3.isChecked();
        Boolean switchState4 = scenarioSwitch4.isChecked();


        int numAge = Integer.parseInt(age);
        int numBSL = Integer.parseInt(BSL);

        getAge();
        getBSL();
        //SWITCH ONE
        scenarioSwitch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @SuppressLint("SetTextI18n")
            @Override
            // All blood glucose levels during fasting
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(scenarioSwitch1.isChecked()){
                    //shuts off other switches if one switch is enabled
                    scenarioSwitch2.setChecked(false);
                    scenarioSwitch3.setChecked(false);
                    scenarioSwitch4.setChecked(false);

                    if (numAge<6){
                        if (numBSL<=180 & numBSL>=80){
                            displayWhetherHealthy.setText("Your blood sugar level is healthy. Based on your scenario, you should try and keep your blood sugar between 80-180 mg/dL.");
                        }
                        if(numBSL>180){
                            displayWhetherHealthy.setText("Your blood sugar level is too high, it should be between 80-180 mg/dL. Please administer insulin to lower your blood sugar.");
                        }
                        if(numBSL<80){
                            displayWhetherHealthy.setText("Your blood sugar level is low. You should eat something in order to raise your blood sugar to somewhere between 80-180 mg/dL");
                        }

                    }

                    if (numAge>=6 & numAge<=12 ){
                        if (numBSL<=180 & numBSL>=80){
                            displayWhetherHealthy.setText("Your blood sugar level is healthy. Based on your scenario, you should try and keep your blood sugar between 80-180 mg/dL.");
                        }
                        if(numBSL>180){
                            displayWhetherHealthy.setText("Your blood sugar level is too high, it should be between 80-180 mg/dL. Please administer insulin to lower your blood sugar.");
                        }
                        if(numBSL<80){
                            displayWhetherHealthy.setText("Your blood sugar level is low. You should eat something in order to raise your blood sugar to somewhere between 80-180 mg/dL");
                        }

                    }
                    if (numAge>=13 & numAge<=19 ){
                        if (numBSL<=150 & numBSL>=70){
                            displayWhetherHealthy.setText("Your blood sugar level is healthy. Based on your scenario, you should try and keep your blood sugar between 70-150 mg/dL.");
                        }
                        if(numBSL>150){
                            displayWhetherHealthy.setText("Your blood sugar level is too high, it should be between 80-180 mg/dL. Please administer insulin to lower your blood sugar.");
                        }
                        if(numBSL<70){
                            displayWhetherHealthy.setText("Your blood sugar level is low. You should eat something in order to raise your blood sugar to somewhere between 70-150 mg/dL");
                        }

                    }

                    if (numAge>=20 ){
                        if (numBSL<=100){
                            displayWhetherHealthy.setText("Your blood sugar level is healthy. Based on your scenario, you should try and keep your blood sugar below 100 mg/dL.");
                        }
                        if(numBSL>100){
                            displayWhetherHealthy.setText("Your blood sugar level is too high, it should be less than 100mg/dL. Please administer insulin to lower your blood sugar.");
                        }


                    }


                }
                else{
                    displayWhetherHealthy.setText("Select a Scenario");
                }
            }
        });
        //SWITCH TWO
        scenarioSwitch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @SuppressLint("SetTextI18n")
            @Override
            // All blood glucose levels during fasting
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(scenarioSwitch2.isChecked()){
                    //shuts off other switches if one switch is enabled
                    scenarioSwitch1.setChecked(false);
                    scenarioSwitch3.setChecked(false);
                    scenarioSwitch4.setChecked(false);

                    if (numAge<6){
                        if (numBSL<=180 & numBSL>=100){
                            displayWhetherHealthy.setText("Your blood sugar level is healthy. Based on your scenario, you should try and keep your blood sugar between 100-180 mg/dL.");
                        }
                        if(numBSL>180){
                            displayWhetherHealthy.setText("Your blood sugar level is too high, it should be between 100-180 mg/dL. Please administer insulin to lower your blood sugar.");
                        }
                        if(numBSL<100){
                            displayWhetherHealthy.setText("Your blood sugar level is low. You should eat something in order to raise your blood sugar to somewhere between 100-180 mg/dL");
                        }

                    }

                    if (numAge>=6 & numAge<=12 ){
                        if (numBSL<=180 & numBSL>=90){
                            displayWhetherHealthy.setText("Your blood sugar level is healthy. Based on your scenario, you should try and keep your blood sugar between 90-180 mg/dL.");
                        }
                        if(numBSL>180){
                            displayWhetherHealthy.setText("Your blood sugar level is too high, it should be between 90-180 mg/dL. Please administer insulin to lower your blood sugar.");
                        }
                        if(numBSL<90){
                            displayWhetherHealthy.setText("Your blood sugar level is low. You should eat something in order to raise your blood sugar to somewhere between 90-180 mg/dL");
                        }

                    }
                    if (numAge>=13 & numAge<=19 ){
                        if (numBSL<=130 & numBSL>=90){
                            displayWhetherHealthy.setText("Your blood sugar level is healthy. Based on your scenario, you should try and keep your blood sugar between 90-130 mg/dL.");
                        }
                        if(numBSL>130){
                            displayWhetherHealthy.setText("Your blood sugar level is too high, it should be between 90-130 mg/dL. Please administer insulin to lower your blood sugar.");
                        }
                        if(numBSL<90){
                            displayWhetherHealthy.setText("Your blood sugar level is low. You should eat something in order to raise your blood sugar to somewhere between 90-130 mg/dL");
                        }

                    }

                    if (numAge>=20 ){
                        if (numBSL<=130 & numBSL>=70){
                            displayWhetherHealthy.setText("Your blood sugar level is healthy. Based on your scenario, you should try and keep your blood sugar between 70-130 mg/dL.");
                        }
                        if(numBSL>130){
                            displayWhetherHealthy.setText("Your blood sugar level is too high, it should be between 70-130 mg/dL. Please administer insulin to lower your blood sugar.");
                        }
                        if(numBSL<70){
                            displayWhetherHealthy.setText("Your blood sugar level is low. You should eat something in order to raise your blood sugar to somewhere between 70-130 mg/dL");
                        }


                    }


                }
                else{
                    displayWhetherHealthy.setText("Select a Scenario");
                }
            }
        });
        //SWITCH THREE
        scenarioSwitch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @SuppressLint("SetTextI18n")
            @Override
            // All blood glucose levels during fasting
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(scenarioSwitch3.isChecked()){
                    //shuts off other switches if one switch is enabled
                    scenarioSwitch1.setChecked(false);
                    scenarioSwitch2.setChecked(false);
                    scenarioSwitch4.setChecked(false);

                    if (numAge<6){
                        if (numBSL<=190 & numBSL>=150){
                            displayWhetherHealthy.setText("Your blood sugar level is healthy. Based on your scenario, you should try and keep your blood sugar between 150-190 mg/dL.");
                        }
                        if(numBSL>190){
                            displayWhetherHealthy.setText("Your blood sugar level is too high, it should be between 150-190 mg/dL. Please administer insulin to lower your blood sugar.");
                        }
                        if(numBSL<150){
                            displayWhetherHealthy.setText("Your blood sugar level is low. You should eat something in order to raise your blood sugar to somewhere between 150-190 mg/dL");
                        }

                    }

                    if (numAge>=6 & numAge<=12 ){
                        if (numBSL<=140 & numBSL>=90){
                            displayWhetherHealthy.setText("Your blood sugar level is healthy. Based on your scenario, you should try and keep your blood sugar between 90-140 mg/dL.");
                        }
                        if(numBSL>140){
                            displayWhetherHealthy.setText("Your blood sugar level is too high, it should be between 90-140 mg/dL. Please administer insulin to lower your blood sugar.");
                        }
                        if(numBSL<90){
                            displayWhetherHealthy.setText("Your blood sugar level is low. You should eat something in order to raise your blood sugar to somewhere between 90-140 mg/dL");
                        }

                    }
                    if (numAge>=13 & numAge<=19 ){
                        if (numBSL<=140 & numBSL>=90){
                            displayWhetherHealthy.setText("Your blood sugar level is healthy. Based on your scenario, you should try and keep your blood sugar between 90-140 mg/dL.");
                        }
                        if(numBSL>140){
                            displayWhetherHealthy.setText("Your blood sugar level is too high, it should be between 90-140 mg/dL. Please administer insulin to lower your blood sugar.");
                        }
                        if(numBSL<90){
                            displayWhetherHealthy.setText("Your blood sugar level is low. You should eat something in order to raise your blood sugar to somewhere between 90-140 mg/dL");
                        }

                    }

                    if (numAge>=20 ){
                        if (numBSL<=180){
                            displayWhetherHealthy.setText("Your blood sugar level is healthy. Based on your scenario, you should try and keep your blood sugar below 180 mg/dL.");
                        }
                        if(numBSL>180){
                            displayWhetherHealthy.setText("Your blood sugar level is too high, it should be less than 180 mg/dL. Please administer insulin to lower your blood sugar.");
                        }


                    }


                }
                else{
                    displayWhetherHealthy.setText("Select a Scenario");
                }
            }
        });
        //SWITCH FOUR
        scenarioSwitch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @SuppressLint("SetTextI18n")
            @Override
            // All blood glucose levels during fasting
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(scenarioSwitch4.isChecked()){
                    //shuts off other switches if one switch is enabled
                    scenarioSwitch1.setChecked(false);
                    scenarioSwitch2.setChecked(false);
                    scenarioSwitch3.setChecked(false);

                    if (numAge<6){
                        if (numBSL<=110 & numBSL>=200){
                            displayWhetherHealthy.setText("Your blood sugar level is healthy. Based on your scenario, you should try and keep your blood sugar between 110-200 mg/dL.");
                        }
                        if(numBSL>200){
                            displayWhetherHealthy.setText("Your blood sugar level is too high, it should be between 110-200 mg/dL. Please administer insulin to lower your blood sugar.");
                        }
                        if(numBSL<110){
                            displayWhetherHealthy.setText("Your blood sugar level is low. You should eat something in order to raise your blood sugar to somewhere between 110-200 mg/dL");
                        }

                    }

                    if (numAge>=6 & numAge<=12 ){
                        if (numBSL<=180 & numBSL>=100){
                            displayWhetherHealthy.setText("Your blood sugar level is healthy. Based on your scenario, you should try and keep your blood sugar between 100-180 mg/dL.");
                        }
                        if(numBSL>180){
                            displayWhetherHealthy.setText("Your blood sugar level is too high, it should be between 100-180 mg/dL. Please administer insulin to lower your blood sugar.");
                        }
                        if(numBSL<100){
                            displayWhetherHealthy.setText("Your blood sugar level is low. You should eat something in order to raise your blood sugar to somewhere between 100-180 mg/dL");
                        }

                    }
                    if (numAge>=13 & numAge<=19 ){
                        if (numBSL<=150 & numBSL>=90){
                            displayWhetherHealthy.setText("Your blood sugar level is healthy. Based on your scenario, you should try and keep your blood sugar between 90-150 mg/dL.");
                        }
                        if(numBSL>150){
                            displayWhetherHealthy.setText("Your blood sugar level is too high, it should be between 90-150 mg/dL. Please administer insulin to lower your blood sugar.");
                        }
                        if(numBSL<90){
                            displayWhetherHealthy.setText("Your blood sugar level is low. You should eat something in order to raise your blood sugar to somewhere between 90-150 mg/dL");
                        }

                    }

                    if (numAge>=20 ){
                        if (numBSL<=140 & numBSL>=100){
                            displayWhetherHealthy.setText("Your blood sugar level is healthy. Based on your scenario, you should try and keep your blood sugar between 100-140 mg/dL.");
                        }
                        if(numBSL>140){
                            displayWhetherHealthy.setText("Your blood sugar level is too high, it should be between 100-140 mg/dL. Please administer insulin to lower your blood sugar.");
                        }
                        if(numBSL<100){
                            displayWhetherHealthy.setText("Your blood sugar level is low. You should eat something in order to raise your blood sugar to somewhere between 100-140 mg/dL");
                        }

                    }


                }
                else{
                    displayWhetherHealthy.setText("Select a Scenario");
                }
            }
        });


    }


    }

