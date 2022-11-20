package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    ImageView imgLogo;
    TextView txtTitle, txtDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Anh xa
        imgLogo = findViewById(R.id.imgLogo);
        txtTitle = findViewById(R.id.txtTitle);
        txtDetail = findViewById(R.id.txtDetail);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Bundle");
        if (bundle != null) {
            Product product = (Product) bundle.getSerializable("Data");
            imgLogo.setImageResource(product.imgId);
            txtDetail.setText(product.detail);
            txtTitle.setText(product.title);
        }

    }
}