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

    public TextView textView;
    public EditText editText;
    public Button saveButton;

    public TextView textView2;
    public EditText editText2;
    public Button saveButton2;

    public static final String SHARED_PREFERENCES = "sharedPreferences";

    //"BSL" is BLOOD SUGAR LEVEL

    public String age;
    public String BSL;

    public void saveAge()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("age", textView.getText().toString());
        editor.apply();
        Toast.makeText(this, "Age Saved", Toast.LENGTH_SHORT).show();
    }

    public void saveBSL()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("BSL", textView2.getText().toString());
        editor.apply();
        Toast.makeText(this, "Blood Sugar Level Saved", Toast.LENGTH_SHORT).show();
    }

    public void loadAge()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        age = sharedPreferences.getString("age", "");
    }

    public void loadBSL()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        BSL = sharedPreferences.getString("BSL", "");
    }

    public void updateAge() {

        textView.setText(age);
    }
    public void updateBSL() {

        textView2.setText(BSL);
    }

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

    //sanitized inputs incase user tries to input string
    public void fixAge(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        age = sharedPreferences.getString("age", "0");

        if(!(isInteger(age)))
        {
            SharedPreferences.Editor editor = sharedPreferences.edit();
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
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        BSL = sharedPreferences.getString("BSL", "0");

        if(!(isInteger(BSL)))
        {
            SharedPreferences.Editor editor = sharedPreferences.edit();
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

        fixAge();
        loadAge();
        updateAge();

        loadBSL();
        updateBSL();


    }



}