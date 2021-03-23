package com.example.blood_sugar_pro;

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


    //setting default value for text string
    public String text = " ";

    //creating TextView that displays the responses to the inputted age and BSL
    public TextView displayWhetherHealthy;

    //creating each switch variable
    public Switch scenarioSwitch1;
    public Switch scenarioSwitch2;
    public Switch scenarioSwitch3;
    public Switch scenarioSwitch4;

    //getAge method is used to set the age string to the shared preference value of "age"
    public void getAge(){
        //accessing shared preferences file
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPreferences", MODE_PRIVATE);
        //sets local age variable to the shared preferences value for age
        String age = sharedPreferences.getString("age","None");
    }

    public void getBSL(){
        //accessing shared preferences file
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPreferences", MODE_PRIVATE);
        //sets local BSL variable to the shared preferences value for BSL
        String BSL = sharedPreferences.getString("BSL", "None");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health_monitor);

        SharedPreferences sharedPreferences = getSharedPreferences("sharedPreferences", MODE_PRIVATE);
        String age = sharedPreferences.getString("age","None");
        String BSL = sharedPreferences.getString("BSL","None");

        //connects displayWhetherHealthy variable to corresponding XML ID
        displayWhetherHealthy = (TextView) findViewById(R.id.displayStatus);

        //connects scenarioSwitch[num] variable to corresponding XML IDs
        scenarioSwitch1 = (Switch) findViewById(R.id.scenario1);
        scenarioSwitch2 = (Switch) findViewById(R.id.scenario2);
        scenarioSwitch3 = (Switch) findViewById(R.id.scenario3);
        scenarioSwitch4 = (Switch) findViewById(R.id.scenario4);

        //establishing switchState boolean variables based on whether or not switches are checked
        Boolean switchState1 = scenarioSwitch1.isChecked();
        Boolean switchState2 = scenarioSwitch2.isChecked();
        Boolean switchState3 = scenarioSwitch3.isChecked();
        Boolean switchState4 = scenarioSwitch4.isChecked();

        //user inputs of age and BSL are now parsed into integers for use in if statements
        int numAge = Integer.parseInt(age);
        int numBSL = Integer.parseInt(BSL);

        getAge();
        getBSL();

        //SWITCH ONE
        //ACTIVITY: Fasting
        scenarioSwitch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            //suppressing highlighted message within androidstudio
            @SuppressLint("SetTextI18n")
            @Override
            // All blood glucose levels during fasting
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(scenarioSwitch1.isChecked()){
                    //shuts off other switches if one switch is enabled
                    scenarioSwitch2.setChecked(false);
                    scenarioSwitch3.setChecked(false);
                    scenarioSwitch4.setChecked(false);

                    //logic using chart from https://www.singlecare.com/blog/normal-blood-glucose-levels/
                    //this if tree format is repeated for each of the four activities
                    if (numAge<6){
                        //if they're within the health range for their age then it says they are healthy
                        if (numBSL<=180 & numBSL>=80){
                            displayWhetherHealthy.setText("Your blood sugar level is healthy. Based on your scenario, you should try and keep your blood sugar between 80-180 mg/dL.");
                        }
                        // if they are above the healthy age then it outputs that they are not healthy and tells them to administer insulin
                        if(numBSL>180){
                            displayWhetherHealthy.setText("Your blood sugar level is too high, it should be between 80-180 mg/dL. Please administer insulin to lower your blood sugar.");
                        }
                        // if they are below the healthy age then it outputs that they are not healthy and tells them to eat something
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
        //ACTIVITY: Before Meal
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
        //ACTIVITY: 1-2 hours after eating
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
        //ACTIVITY: Bedtime
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
                    // displays "Select a Scenario" if there is no switch checked
                    displayWhetherHealthy.setText("Select a Scenario");
                }
            }
        });


    }


    }

