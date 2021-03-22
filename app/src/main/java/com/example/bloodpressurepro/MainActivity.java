package com.example.bloodpressurepro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public CardView profile_card,card1,card2,card3,card4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        card1 = (CardView) findViewById(R.id.profile_card);
        card2 = (CardView) findViewById(R.id.data_entry_card);
        card3 = (CardView) findViewById(R.id.monitor_card);
        card4 = (CardView) findViewById(R.id.faqs_card);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.profile_card :
                i = new Intent(this,Profile.class);
                startActivity(i);
                break;

            case R.id.data_entry_card :
                i = new Intent(this,DataEntry.class);
                startActivity(i);
                break;

            case R.id.monitor_card :
                i = new Intent(this,Monitor.class);
                startActivity(i);
                break;
            case R.id.faqs_card :
                i = new Intent(this,FAQs.class);
                startActivity(i);
                break;

        }

    }
}