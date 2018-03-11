package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

/**
 * Created by cebuc on 3/10/2018.
 */
@RunWith(AndroidJUnit4.class)
public class EndpointAsyncTaskTest {

    final CountDownLatch signal = new CountDownLatch(1);

    @Test
    public void testAsync() throws Throwable {

        final EndpointAsyncTask task = new EndpointAsyncTask() {

            @Override
            protected String doInBackground(Void... voids) {
                return super.doInBackground(voids);
            }

            @Override
            protected void onPostExecute(String results) {
                assertNotNull(results);
                assertFalse(results.equals(""));
                signal.countDown();
            }

        };

        Runnable runTest = new Runnable() {
            @Override
            public void run() {
                task.execute();
            }
        };

        runTest.run();

        signal.await(30, TimeUnit.SECONDS);
    }
}