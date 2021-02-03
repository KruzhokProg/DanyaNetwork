package com.example.danyanetwork.Model;

public class History {
    private Integer userId;
    private Integer adId;
    private Boolean seen;
    private Boolean liked;

    public History(){

    }

    public History(Integer userId, Integer adId, Boolean seen, Boolean liked) {
        this.userId = userId;
        this.adId = adId;
        this.seen = seen;
        this.liked = liked;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public Boolean getSeen() {
        return seen;
    }

    public void setSeen(Boolean seen) {
        this.seen = seen;
    }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }
}
