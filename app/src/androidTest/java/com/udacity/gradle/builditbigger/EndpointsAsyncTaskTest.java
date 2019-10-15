package com.udacity.gradle.builditbigger;


import android.content.Context;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import com.ramyhelow.jokelibrary.JokeFactory;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testExecuteMethod() throws Exception {
        Context context = mainActivityActivityTestRule.getActivity().getApplicationContext();
        GetJokeFromServerAsyncTask endpointsAsyncTask = new GetJokeFromServerAsyncTask(context);
        endpointsAsyncTask.execute();
        String jokeFromLib = endpointsAsyncTask.get(10, TimeUnit.SECONDS);
        Assert.assertNotNull(jokeFromLib);

        JokeFactory jokeTelling = new JokeFactory();
        ArrayList<String> jokeList = jokeTelling.getJokeList();
        Assert.assertTrue("Unexpected value for d.getFormType(): " + jokeFromLib,
                jokeFromLib.equals(jokeList.get(0)) ||
                        jokeFromLib.equals(jokeList.get(1)) ||
                        jokeFromLib.equals(jokeList.get(2))||
                        jokeFromLib.equals(jokeList.get(3))||
                        jokeFromLib.equals(jokeList.get(4))||
                        jokeFromLib.equals(jokeList.get(5)));
    }
}