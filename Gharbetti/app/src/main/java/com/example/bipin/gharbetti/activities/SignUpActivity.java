package com.example.bipin.gharbetti.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bipin.gharbetti.R;
import com.example.bipin.gharbetti.pojos.UserNamePassword;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText fName, lName, email, password, c_password;
    Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fName = (EditText) findViewById(R.id.firstName);
        lName = (EditText) findViewById(R.id.lastName);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        c_password = (EditText) findViewById(R.id.confirmPassword);
        register= (Button) findViewById(R.id.register);
        if (register!=null)
        register.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.register) {
            SharedPreferences preferences = getSharedPreferences("SignUp", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("fName", fName.getText().toString());
            editor.putString("lName", lName.getText().toString());
            editor.putString("email", email.getText().toString());
            editor.putString("password", password.getText().toString());
            editor.putString("cPassword", c_password.getText().toString());
            editor.apply();


            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);


        }
    }
}
