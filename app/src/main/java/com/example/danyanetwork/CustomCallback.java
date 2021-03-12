package com.example.danyanetwork;


import com.example.danyanetwork.Model.AdsInfo;
import com.example.danyanetwork.Model.UserInfo;

import java.util.List;

public interface CustomCallback {

    void onSuccess(List<AdsInfo> value);
    void onFailure();
}