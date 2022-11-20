package com.example.myapplication;

import java.io.Serializable;

public class Product implements Serializable {
    // Khai bao thuoc tinh
    public int imgId;
    public String title;
    public String detail;

    // Constructor
    // Alt + Ins

    public Product(int imgId, String title, String detail) {
        this.imgId = imgId;
        this.title = title;
        this.detail = detail;
    }
}
