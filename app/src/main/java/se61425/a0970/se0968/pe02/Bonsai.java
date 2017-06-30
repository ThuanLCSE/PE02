package se61425.a0970.se0968.pe02;

import android.graphics.Bitmap;

/**
 * Created by Thuans on 5/26/2017.
 */

public class Bonsai {
    private  int id;
   private String name;
    private int picture;
    private String detail;
    private String origin;
    private double price;

    public Bonsai(String name, int picture, String detail, String origin, double price) {
        this.name = name;
        this.picture = picture;
        this.detail = detail;
        this.origin = origin;
        this.price = price;
    }
    public Bonsai(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
