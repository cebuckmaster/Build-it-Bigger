package com.example.android.jokedisplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * This is an Android Library that displays a joke.
 */

public class DisplayJokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);

        TextView theJokeTextView = (TextView) findViewById(R.id.tv_joke);

        Intent intentThatStartedThisActivity = getIntent();

        if(intentThatStartedThisActivity.hasExtra("theJoke")) {
            String theJoke = intentThatStartedThisActivity.getStringExtra("theJoke");
            theJokeTextView.setText(theJoke);
        } else {
            theJokeTextView.setText(R.string.no_joke);
        }
    }
}
