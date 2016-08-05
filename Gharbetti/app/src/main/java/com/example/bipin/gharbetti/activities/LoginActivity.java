package com.example.bipin.gharbetti.activities;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.bipin.gharbetti.R;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URL;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginBt, signUpBt;
    private LoginButton fbtLogin;
    private CallbackManager mcallbackManager;
    private EditText usernameEt;
    private EditText passwordEt;
    AccessTokenTracker tokenTracker;
    ProfileTracker profileTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this);
        setContentView(R.layout.activity_login);

        //this if case is to avoid Caused by: android.os.NetworkOnMainThreadException error
        networkOnMainThreadSolve();
        tracerinit();
        AppEventsLogger.activateApp(this);


        usernameEt = (EditText) findViewById(R.id.username);
        passwordEt = (EditText) findViewById(R.id.password);
        loginBt = (Button) findViewById(R.id.login);
        signUpBt = (Button) findViewById(R.id.signUp);
        fbtLogin = (LoginButton) findViewById(R.id.login_button);
        mcallbackManager = CallbackManager.Factory.create();
        fbtLogin.setReadPermissions("public_profile");

        FacebookCallback<LoginResult> callback = new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                //Naam ko lagi
                if (Profile.getCurrentProfile()==null)
                {
                    profileTracker = new ProfileTracker() {
                        @Override
                        protected void onCurrentProfileChanged(Profile oldProfile, Profile newProfile) {
                           String name=newProfile.getName();

                            SharedPreferences prefs=getSharedPreferences("FbName",MODE_PRIVATE);
                            SharedPreferences.Editor editor=prefs.edit();
                            editor.putString("profileName",name);
                            editor.apply();
                            profileTracker.stopTracking();
                        }
                    };
                }else {
                    Profile unChanged=Profile.getCurrentProfile();
                   String name=unChanged.getName();
                    SharedPreferences prefs=getSharedPreferences("FbName",MODE_PRIVATE);
                    SharedPreferences.Editor editor=prefs.edit();
                    editor.putString("profileName",name);
                    editor.apply();
                }
                //profile pic ko lagi
                final Bundle params = new Bundle();
                params.putString("fields", "id,gender,cover,picture.type(large)");
                GraphRequest graphRequest = new GraphRequest(AccessToken.getCurrentAccessToken(), "me", params, HttpMethod.GET,
                        new GraphRequest.Callback() {
                            @Override
                            public void onCompleted(GraphResponse response) {
                                Log.e("response", response.toString());

                                try {
                                    JSONObject data = response.getJSONObject();
                                    Log.e("data", data.toString());
                                    if (data.has("picture")) {
                                        String profilePicUrl = data.getJSONObject("picture").getJSONObject("data").getString("url");
                                        // set profile image to imageview using Picasso or Native methods
                                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                        intent.putExtra("profilePicUrl", profilePicUrl);
                                        startActivity(intent);

                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                graphRequest.executeAsync();
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), "Somethin went error", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onError(FacebookException error) {

                Toast.makeText(getApplicationContext(), "Something went error", Toast.LENGTH_LONG).show();

            }
        };

        if (fbtLogin != null)

            fbtLogin.registerCallback(mcallbackManager, callback);

        loginBt.setOnClickListener(this);
        signUpBt.setOnClickListener(this);
    }

    private void networkOnMainThreadSolve() {
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }

    private void tracerinit() {
        tokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {

            }
        };
        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {


            }

        };
    }


    public static Bitmap getFacebookProfilePicture(String url) throws IOException {
        URL facebookProfileURL = new URL(url);
        return BitmapFactory.decodeStream(facebookProfileURL.openConnection().getInputStream());//returna bitmap
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mcallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onStop() {
        super.onStop();
        tokenTracker.stopTracking();
        profileTracker.stopTracking();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login) {

            String uName = usernameEt.getText().toString();
            String pass = passwordEt.getText().toString();

            SharedPreferences preferences = getSharedPreferences("SignUp", Context.MODE_PRIVATE);
            String pref_name = preferences.getString("fName", "n/a");
            String pref_pass = preferences.getString("password", "n/a");
            if (uName.equals(pref_name) && pass.equals(pref_pass)) {

                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
            }
        }
        if (v.getId() == R.id.signUp) {
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);
        }

    }


}
