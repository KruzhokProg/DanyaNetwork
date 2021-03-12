package com.example.danyanetwork.Utils;

import com.example.danyanetwork.Adapters.AdsAdapter;
import com.example.danyanetwork.CustomCallback;
import com.example.danyanetwork.Model.AdsInfo;
import com.example.danyanetwork.Model.UserInfo;
import com.example.danyanetwork.Network.ApiClient;
import com.example.danyanetwork.Network.ApiService;
import com.example.danyanetwork.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkRequest {
    public static void getUserInfo(Integer userId, Boolean active,  CustomCallback customCallback){
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<List<UserInfo>> call = apiService.getUsers(1);
        call.enqueue(new Callback<List<UserInfo>>() {
            @Override
            public void onResponse(Call<List<UserInfo>> call, Response<List<UserInfo>> response) {
                List<UserInfo> list = response.body();
                UserInfo tmp = list.get(0);
                List<AdsInfo> out = new ArrayList<>();

                if (active){
                    List<AdsInfo> ads = tmp.getAdsInfoList();
                    for (AdsInfo item : ads) {
                        if(item.getActive()){
                            out.add(item);
                        }
                    }
                }else{
                    List<AdsInfo> ads = tmp.getAdsInfoList();
                    for (AdsInfo item : ads) {
                        if(!item.getActive()){
                            out.add(item);
                        }
                    }
                }

                customCallback.onSuccess(out);
            }

            @Override
            public void onFailure(Call<List<UserInfo>> call, Throwable t) {

            }
        });
    }
}
