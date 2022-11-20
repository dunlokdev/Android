package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listViewProduct;
    List<Product> listProduct = new ArrayList<Product>();
    AdapterProduct adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listProduct.add(new Product(R.drawable.asus, "ASUS", "Asus code trau lam"));
        listProduct.add(new Product(R.drawable.android, "Android", "Android sieu re, vip pro max"));
        listProduct.add(new Product(R.drawable.winphone, "Window Phone", "Window ky niem lua ga ve roi"));
        listProduct.add(new Product(R.drawable.ios, "Apple", "Apple muot ma"));

        adapter = new AdapterProduct(listProduct);
        listViewProduct = findViewById(R.id.listViewProduct);
        listViewProduct.setAdapter(adapter);

        listViewProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("Data", listProduct.get(i));
                intent.putExtra("Bundle", bundle);
                startActivity(intent);
            }
        });
    }
}