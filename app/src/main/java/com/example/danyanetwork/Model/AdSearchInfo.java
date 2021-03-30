package com.example.danyanetwork.Model;

import android.content.Intent;

import java.util.List;

public class AdSearchInfo {
    private String name;
    private Intent price;
    private String desc;
    private List<AdPhoto> adPhotos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Intent getPrice() {
        return price;
    }

    public void setPrice(Intent price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<AdPhoto> getAdPhotos() {
        return adPhotos;
    }

    public void setAdPhotos(List<AdPhoto> adPhotos) {
        this.adPhotos = adPhotos;
    }
}
