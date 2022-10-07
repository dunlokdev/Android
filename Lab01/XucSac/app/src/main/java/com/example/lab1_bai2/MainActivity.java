package com.example.lab1_bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtView, txtView1;
    ImageView imgView;
    Button btnRandom, btnTap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControl();
    }
    public void initControl() {
        txtView = findViewById(R.id.txtResult);
        txtView1 = findViewById(R.id.txtresult);
        imgView = findViewById(R.id.imgPhoto);
        btnRandom = findViewById(R.id.btnRandom);
        btnTap = findViewById(R.id.btnTap);
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random ran = new Random();
                int result = ran.nextInt(100)+1;
                txtView.setText(String.valueOf(result));
            }
        });

        int result = 1;
        updateUI(result);
        txtView1.setText(String.valueOf(result));

        btnTap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rand = new Random();
                int result = rand.nextInt(6) + 1;
                updateUI(result);
                txtView1.setText(String.valueOf(result));
            }
        });
    }
    public void updateUI(int n) {
        imgView = findViewById(R.id.imgPhoto);
        switch(n) {
            case 1:
                imgView.setImageResource(R.drawable.photo1);
                break;
            case 2:
                imgView.setImageResource(R.drawable.photo2);
                break;
            case 3:
                imgView.setImageResource(R.drawable.photo3);
                break;
            case 4:
                imgView.setImageResource(R.drawable.photo4);
                break;
            case 5:
                imgView.setImageResource(R.drawable.photo5);
                break;
            case 6:
                imgView.setImageResource(R.drawable.photo6);
                break;
        }
    }

}