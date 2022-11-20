package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Product> listProduct;
    ProductListListViewAdapter productListListViewAdapter;
    ListView listViewProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // KHOI TAO LIST PRODUCT
        listProduct = new ArrayList<>();
        listProduct.add(new Product("Apple", "Apple is the largest technology company by revenue (totaling US$365.8 billion in 2021)", R.drawable.ios));
        listProduct.add(new Product("Android", "Android is the...", R.drawable.android));
        listProduct.add(new Product("Window", "Windowphone is the ...", R.drawable.winphone));
        listProduct.add(new Product("Asus", "Asus is the best ...", R.drawable.asus));

        productListListViewAdapter = new ProductListListViewAdapter(listProduct);
        listViewProduct = findViewById(R.id.listviewMain);
        listViewProduct.setAdapter(productListListViewAdapter);

        listViewProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Data", listProduct.get(i));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }


}

/*Model phan tu du lieu*/
class Product implements Serializable {
    String name;
    String content;
    int idImage;

    public Product(String name, String content, int idImage) {
        this.name = name;
        this.content = content;
        this.idImage = idImage;
    }
}

class ProductListListViewAdapter extends BaseAdapter {

    final ArrayList<Product> listProduct;

    public ProductListListViewAdapter(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }

    @Override
    public int getCount() {
        return listProduct.size();
    }

    @Override
    public Object getItem(int i) {
        return listProduct.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int positon, View convertView, ViewGroup parent) {
        View viewProduct;

        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.mylist, null);
        } else viewProduct = convertView;

        Product product = (Product) getItem(positon);
        ((TextView) viewProduct.findViewById(R.id.txtTitle)).setText(String.format(product.name));
        ((TextView) viewProduct.findViewById(R.id.txtContent)).setText(String.format(product.content));
        ((ImageView) viewProduct.findViewById(R.id.imageIcon)).setImageResource(product.idImage);

        return viewProduct;
    }
}