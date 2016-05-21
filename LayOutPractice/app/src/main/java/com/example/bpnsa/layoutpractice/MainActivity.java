package com.example.bpnsa.layoutpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        editText.setEnabled(false);

    }

    public void onClick(View view) {
        String previousText = editText.getText().toString();
        Button button = (Button) view;
        String newText = previousText + button.getText().toString();
        editText.setText(newText);

    }

}
