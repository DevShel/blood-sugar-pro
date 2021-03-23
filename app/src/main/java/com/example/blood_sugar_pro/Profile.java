package com.example.blood_sugar_pro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Scanner;

public class Profile extends AppCompatActivity {

    //establish textView variable
    public TextView textView;
    //establish editText variable
    public EditText editText;
    //establish saveButton variable
    public Button saveButton;

    //establish textView2 variable
    public TextView textView2;
    //establish editText2 variable
    public EditText editText2;
    //establish saveButton variable
    public Button saveButton2;

    //access shared preferences folder
    public static final String SHARED_PREFERENCES = "sharedPreferences";

    //"BSL" is BLOOD SUGAR LEVEL

    public String age;
    public String BSL;
    //saveAge function saves the age as a string within Shared Preferences
    public void saveAge()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("age", textView.getText().toString());
        editor.apply();
        //displays the message indicating that it was saved
        Toast.makeText(this, "Age Saved", Toast.LENGTH_SHORT).show();
    }
    //saveAge function saves the BSL as a string within Shared Preferences
    public void saveBSL()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("BSL", textView2.getText().toString());
        editor.apply();
        Toast.makeText(this, "Blood Sugar Level Saved", Toast.LENGTH_SHORT).show();
    }

    //loads age based on age key in shared preferences
    public void loadAge()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        age = sharedPreferences.getString("age", "");
    }

    //loads BSL based on BSL key in shared preferences
    public void loadBSL()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        BSL = sharedPreferences.getString("BSL", "");
    }

    //updates Age based on age value pulled from shared Preference folder
    public void updateAge() {

        textView.setText(age);
    }

    //updates BSL based on BSL value pulled from shared Preference folder
    public void updateBSL() {

        textView2.setText(BSL);
    }

    //is integer method uses a try catch, and parses the string to an integer
    // if it throws an error then the input string is not an integer
    public  boolean isInteger(String s) {
        boolean isValidInteger = false;
        try
        {
            Integer.parseInt(s);
            isValidInteger = true;
        }
        catch (NumberFormatException ex)
        {
        }

        return isValidInteger;
    }

    //fixAge method turns user inputs into "zero" if user tries to input string
    //uses the isInteger
    public void fixAge(){
        //initializing sharedpreference file
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        //setting local BSL variable to the value of BSL in sharedpreferences file
        age = sharedPreferences.getString("age", "0");

        if(!(isInteger(age)))
        {
            //opens Sharepreferences editor
            SharedPreferences.Editor editor = sharedPreferences.edit();
            //turns age value in shared preferences into zero if isInteger is false
            editor.putString("age", "0");
            editor.apply();
            loadAge();
            updateAge();
        }
        else{
            System.out.println("There are no integer conflicts");

        }

    }

    public void fixBSL(){
        //initializing sharedpreference file
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        //setting local BSL variable to the value of BSL in sharedpreferences file
        BSL = sharedPreferences.getString("BSL", "0");

        if(!(isInteger(BSL)))
        {
            //opens Sharepreferences editor
            SharedPreferences.Editor editor = sharedPreferences.edit();
            //turns BSL value in shared preferences into zero if isInteger is false
            editor.putString("BSL", "0");
            editor.apply();
            loadBSL();
            updateBSL();
        }
        else{
            System.out.println("There are no integer conflicts");

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textView = (TextView) findViewById(R.id.text_view);
        editText = (EditText) findViewById(R.id.edit_text);
        saveButton = (Button) findViewById(R.id.save_button);

        textView2 = (TextView) findViewById(R.id.text_view2);
        editText2 = (EditText) findViewById(R.id.edit_text2);
        saveButton2 = (Button) findViewById(R.id.save_button2);

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        textView.setText(editText.getText().toString());


        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textView.setText(editText.getText().toString());
                saveAge();
                fixAge();

            }
        });

        saveButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                textView2.setText(editText2.getText().toString());
                saveBSL();
                fixBSL();

            }
        });


        loadAge();
        updateAge();

        loadBSL();
        updateBSL();


    }



}