package com.example.bpnsa.sharedprefs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_B extends AppCompatActivity {

    TextView name,password;
    public  static final String DEFAULT="N/A";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__b);

        name= (TextView) findViewById(R.id.nameText);
        password= (TextView) findViewById(R.id.passwordText);
    }

    public void load(View view)
    {
        SharedPreferences sharedPreferences=getSharedPreferences("My Data", Context.MODE_PRIVATE);
       String Sname= sharedPreferences.getString("name", DEFAULT);
        String Spassword=sharedPreferences.getString("password",DEFAULT);
        if(Sname.equals(DEFAULT)||Spassword.equals(DEFAULT))
        {
            Toast.makeText(this,"Data donot load successfully",Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(this,"data load successfully",Toast.LENGTH_LONG).show();
            name.setText(Sname);
            password.setText(Spassword);


        }

    }
    public  void  gotoA(View view)
    {
        Toast.makeText(this,"switching to A",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
