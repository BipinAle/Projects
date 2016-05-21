package com.example.bpnsa.settextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= (TextView) findViewById(R.id.textView);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void click(View view)
    {
        String message="Namaste Nepal";
        textView.setText(message);


    }
}
