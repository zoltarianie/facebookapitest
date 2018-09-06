package com.zolt.facebookapitest;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

public class MainActivity extends Activity {

    private static final int RESULT_PROFILE_ACTIVITY = 1;
    private static final int RESULT_POSTS_ACTIVITY = 2;
    private static final int RESULT_PERMISSIONS_ACTIVITY = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // If MainActivity is reached without the user being logged in, redirect to the Login
        // Activity
        if (AccessToken.getCurrentAccessToken() == null) {
            Intent loginIntent = new Intent(MainActivity.this, FacebookLoginActivity.class);
            startActivity(loginIntent);
        }

        Log.d("log", "AccessToken -> "+AccessToken.getCurrentAccessToken());

        // https://www.facebook.com/events//
        GraphRequest request = GraphRequest.newGraphPathRequest(
                AccessToken.getCurrentAccessToken(),
                "/236577567033233",
                new GraphRequest.Callback() {
                    @Override
                    public void onCompleted(GraphResponse response) {
                        Log.d("log", response.getJSONObject().toString());
                    }
                });

        request.executeAsync();

        System.out.println("-->" + AccessToken.getCurrentAccessToken());


        /* make the API call */
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/236577567033233/attending",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
                        Log.d("log", "attending -> "+response.getJSONObject().toString());
                    }
                }
        ).executeAsync();


        /* make the API call */
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/236577567033233/noreply",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
                        Log.d("log", "noreply -> "+response.getJSONObject().toString());
                    }
                }
        ).executeAsync();
        /* make the API call */
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/236577567033233/maybe",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
                        Log.d("log", "maybe -> "+response.getJSONObject().toString());
                    }
                }
        ).executeAsync();

        /* make the API call */
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/236577567033233/interested",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
                        Log.d("log", "interested -> "+response.getJSONObject().toString());
                    }
                }
        ).executeAsync();

        /* make the API call */
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/236577567033233/declined",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
                        Log.d("log", "declined -> "+response.getJSONObject().toString());
                    }
                }
        ).executeAsync();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case RESULT_PROFILE_ACTIVITY:
                if (resultCode == RESULT_OK) {

                }
                break;
            case RESULT_POSTS_ACTIVITY:
                if (resultCode == RESULT_OK) {

                }
                break;
            case RESULT_PERMISSIONS_ACTIVITY:
                if (resultCode == RESULT_OK) {

                }
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
