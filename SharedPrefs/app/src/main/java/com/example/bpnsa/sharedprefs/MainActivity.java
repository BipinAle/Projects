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

public class MainActivity extends AppCompatActivity {

    TextView name,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name= (TextView) findViewById(R.id.name);
        password= (TextView) findViewById(R.id.password);

    }


    public void save(View view)
    {
        SharedPreferences sharedPreferences=getSharedPreferences("My Data", Context.MODE_PRIVATE);//filename and mode
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("name",name.getText().toString());
        editor.putString("password",password.getText().toString());
        editor.commit();


    }
    public  void gotoB(View view)
    {
        Toast.makeText(this,"switching to B",Toast.LENGTH_LONG).show();

        Intent intent=new Intent(this,Activity_B.class);
        startActivity(intent);
    }
    
}
