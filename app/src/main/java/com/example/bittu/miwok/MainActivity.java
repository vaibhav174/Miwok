package com.example.bittu.miwok;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //listener for numbers

        // Find the View that shows the numbers category
        TextView numbers = (TextView) findViewById(R.id.numbers);
        // Set a click listener on that View
        numbers.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(numbersIntent);
            }
        });

        //listener for family

        // Find the View that shows the family category
        TextView family = (TextView) findViewById(R.id.family);
        // Set a click listener on that View
        family.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family View is clicked on.
            @Override
            public void onClick(View view) {
                Intent familyIntent = new Intent(MainActivity.this, FamilyMembersActivity.class);
                startActivity(familyIntent);
            }
        });

        //listener for colors

        // Find the View that shows the colors category
        TextView colors = (TextView) findViewById(R.id.colors);
        // Set a click listener on that View
        colors.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the colors View is clicked on.
            @Override
            public void onClick(View view) {
                Intent colorIntent = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(colorIntent);
            }
        });

        //listener for phrases

        // Find the View that shows the phrases category
        TextView ph = (TextView) findViewById(R.id.phrases);
        // Set a click listener on that View
        ph.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the phrases View is clicked on.
            @Override
            public void onClick(View view) {
                Intent phrasesIntent = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(phrasesIntent);
            }
        });
    }
    //we can use android:onClick attribute in xml to define what will happen on clicking but we can
    // also use on click listener interface as shown above



    //code using onClick attribute
//    public void openNumbersList(View view)
//    {
//        Intent i = new Intent(this,NumbersActivity.class);
//        startActivity(i);
//    }
//    public void openFamilyList(View view)
//    {
//        Intent i = new Intent(this,FamilyMembersActivity.class);
//        startActivity(i);
//    }
//    public void openColorList(View view)
//    {
//        Intent i = new Intent(this,ColorsActivity.class);
//        startActivity(i);
//    }
//    public void openPhrasesList(View view)
//    {
//        Intent i = new Intent(this,PhrasesActivity.class);
//        startActivity(i);
//    }
}
