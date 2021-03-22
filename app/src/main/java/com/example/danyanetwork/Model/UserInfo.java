package com.example.danyanetwork.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserInfo {
    private int id;
    private String email;
    private String role;
    private Integer balance_avito;
    private String photo;
    private Integer rating;
    private String adress;
    @SerializedName("phone_number")
    private String phone;
    @SerializedName("ads")
    private List<AdsInfo> adsInfoList;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getBalance_avito() {
        return balance_avito;
    }

    public void setBalance_avito(Integer balance_avito) {
        this.balance_avito = balance_avito;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

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
