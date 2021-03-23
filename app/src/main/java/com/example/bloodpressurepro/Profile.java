package com.example.bloodpressurepro;

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

public class Profile extends AppCompatActivity {

    public TextView textView;
    public EditText editText;
    public Button saveButton;

    public TextView textView2;
    public EditText editText2;
    public Button saveButton2;

    public static final String SHARED_PREFERENCES = "sharedPreferences";

    //"bslevel" is BLOOD SUGAR LEVEL

    public String age;
    public String BSL;



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

        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textView.setText(editText.getText().toString());
                saveAge();

            }
        });

        saveButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textView2.setText(editText2.getText().toString());
                saveBSL();

            }
        });

        loadAge();
        updateAge();

        loadBSL();
        updateBSL();


    }

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


}