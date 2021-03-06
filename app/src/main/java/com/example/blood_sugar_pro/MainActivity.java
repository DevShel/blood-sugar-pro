package com.example.blood_sugar_pro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //creation of card variables (which are used to link to each page)
    public CardView profile_card,card1,card2,card3,card4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connecting card variables to their respective XML cardviews
        card1 = (CardView) findViewById(R.id.profile_card);
        card2 = (CardView) findViewById(R.id.monitor_card);
        card3 = (CardView) findViewById(R.id.blood_sugar_faq_card);
        card4 = (CardView) findViewById(R.id.faqs_card);


        //setting onclick listeners for each card
        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent i;
        //switch case used because of multiple choices, with actions for each choice

        switch (v.getId()){
            case R.id.profile_card :
                //android intents allow for the user to be directed to certain activities based on actions
                // syntax variable = new Intent(CURRENT_ACTIVITY,ACTIVITY_USER_IS_BEING_DIRECTED_TO);
                i = new Intent(this,Profile.class);
                //startActivity is what runs the event
                startActivity(i);
                break;

            case R.id.monitor_card :
                i = new Intent(this, Monitor.class);
                startActivity(i);
                break;

            case R.id.blood_sugar_faq_card :
                i = new Intent(this, GlucoseFAQs.class);
                startActivity(i);
                break;
            case R.id.faqs_card :
                i = new Intent(this,FAQs.class);
                startActivity(i);
                break;

        }

    }
}