package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.ramyhelow.androidlibrary.JokeActivity;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class GetJokeFromServerAsyncTask extends AsyncTask<Void, Void, String> {
    public static MyApi sMyApiService = null;
    private IGetJokeFromServerAsyncTask mCallback;

    public GetJokeFromServerAsyncTask(IGetJokeFromServerAsyncTask callback) {
        mCallback = callback;
    }


    @Override
    protected String doInBackground(Void... params) {
        if (sMyApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            sMyApiService = builder.build();
        }

        try {
            return sMyApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {

        mCallback.onRetrieveJokeFinish(result);

//        Intent jokeIntent = new Intent(mContext, JokeActivity.class);
//        jokeIntent.putExtra(JokeActivity.EXTRA_JOKE, output);
//        mContext.startActivity(jokeIntent);
    }
}
