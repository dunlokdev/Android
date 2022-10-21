package com.example.a10112022_learn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ShowInfoActiviti extends AppCompatActivity {

    TextView txtDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showinfo);
        showInfo();
    }

    private void showInfo() {
        txtDisplay = (TextView) findViewById(R.id.textView);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            txtDisplay.setText(extras.getString("value"));
        }
    }
}