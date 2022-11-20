package com.example.myapplication;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterProduct extends BaseAdapter {
    public List<Product> productList = new ArrayList<Product>();

    // Alt + Ins

    // Constructor -> Ham khoi tao
    public AdapterProduct(List<Product> productList) {
        this.productList = productList;
    }

    //    Nhan Alt + Enter -> All -> Enter
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int i) {
        return productList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return -1;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        // Chuyen layout product_item_view -> View
        View viewProduct;
        if (view == null) {
            viewProduct = View.inflate(parent.getContext(),R.layout.product_item_view, null);
        } else viewProduct = view;

        // Anh xa
        ImageView imgLogo = viewProduct.findViewById(R.id.imgLogo);
        TextView txtTitle = viewProduct.findViewById(R.id.txtTilte);
        TextView txtDetail = viewProduct.findViewById(R.id.txtDetail);

        // Do du lieu
        Product product = (Product) getItem(i);
//        Product product = productList.get(i);
        imgLogo.setImageResource(product.imgId);
        txtTitle.setText((product.title));
        txtDetail.setText((product.detail));

        return viewProduct;
    }
}

















