package com.example.danyanetwork.Model;

public class AdsInfo {
    private String description;
    private Integer price;
    private Boolean active;

    public AdsInfo() {
    }

    public String getDescription() {
        return description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
