package com.udacity.gradle.builditbigger;

/**
 * This is interface is used as a custom listener and is kicked off
 * when the joke is received from the google cloud endpoint which is called from the AsyncTask
 */

public interface JokeReceivedListener {
    void onJokeReceived(String joke);

}
