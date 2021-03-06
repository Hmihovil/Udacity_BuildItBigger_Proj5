package com.udacity.gradle.builditbigger;

import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.view.View;

public interface IGetJokeFromServerAsyncTask {

    @UiThread
    void onRetrieveJokeFinish(@Nullable String result);

    void onRetrieveJokeStart();

}