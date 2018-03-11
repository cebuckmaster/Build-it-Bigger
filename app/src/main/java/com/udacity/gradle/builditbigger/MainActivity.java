package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.android.jokedisplayer.DisplayJokeActivity;



public class MainActivity extends AppCompatActivity implements JokeReceivedListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private String mTheJoke;
    private ProgressBar mLoadingIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoadingIndicator = (ProgressBar) findViewById(R.id.pb_loading_indicator);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // This is started from an Button onClick in the activity_main layout.
    // This kicks off off an AsyncTask to get the joke from Google Cloud Endpoints.
    public void tellJoke(View view) {
        mLoadingIndicator.setVisibility(View.VISIBLE);
        new EndpointAsyncTask(this).execute();
    }


    //This is using a custom JokeReceivedListener to know when the joke was received from the
    //Google Cloud Endpoints.
    @Override
    public void onJokeReceived(String jokeString){
        mTheJoke = jokeString;
        mLoadingIndicator.setVisibility(View.INVISIBLE);
        showJokeIntent();
    }

    private void showJokeIntent() {
        Intent jokeDisplayerIntent = new Intent(this, DisplayJokeActivity.class);
        jokeDisplayerIntent.putExtra("theJoke", mTheJoke);
        startActivity(jokeDisplayerIntent);

    }


}
