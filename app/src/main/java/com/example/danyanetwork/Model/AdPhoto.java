package com.example.danyanetwork.Model;

import android.content.Intent;

public class AdPhoto {
    private Intent id;
    private String photo;

    public Intent getId() {
        return id;
    }

    public void setId(Intent id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public AdPhoto(Intent id, String photo) {
        this.id = id;
        this.photo = photo;
    }
}
