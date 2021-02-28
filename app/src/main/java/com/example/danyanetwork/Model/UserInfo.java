package com.example.danyanetwork.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserInfo {
    private int id;
    private String email;
    private String balance_avito;
    private String photo;
    @SerializedName("ads")
    private List<AdsInfo> adsInfoList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBalance_avito() {
        return balance_avito;
    }

    public void setBalance_avito(String balance_avito) {
        this.balance_avito = balance_avito;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<AdsInfo> getAdsInfoList() {
        return adsInfoList;
    }

    public void setAdsInfoList(List<AdsInfo> adsInfoList) {
        this.adsInfoList = adsInfoList;
    }
}
