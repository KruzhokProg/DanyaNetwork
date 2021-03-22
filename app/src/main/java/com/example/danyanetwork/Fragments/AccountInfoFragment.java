package com.example.danyanetwork.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.danyanetwork.CustomCallback;
import com.example.danyanetwork.Model.AdsInfo;
import com.example.danyanetwork.Model.UserInfo;
import com.example.danyanetwork.Network.ApiClient;
import com.example.danyanetwork.Network.ApiService;
import com.example.danyanetwork.R;
import com.example.danyanetwork.Utils.NetworkRequest;
import com.example.danyanetwork.databinding.FragmentAccountInfoBinding;
import com.example.danyanetwork.databinding.FragmentProfileBinding;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountInfoFragment extends Fragment {

    FragmentAccountInfoBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAccountInfoBinding.inflate(getLayoutInflater(), container, false);

        Glide.with(this)
                .load("http://vongu3-001-site2.ctempurl.com/api/image/JPEG_20200819_202357_784096771411385555.jpg")
                .into(binding.imgvAccountImage);

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<List<UserInfo>> call = apiService.getUsers(1);
        call.enqueue(new Callback<List<UserInfo>>() {
            @Override
            public void onResponse(Call<List<UserInfo>> call, Response<List<UserInfo>> response) {
                List<UserInfo> list = response.body();
                UserInfo tmp = list.get(0);
                //binding.tvRole.setText(tmp.getRole());
                if(tmp.getAdsInfoList() != null) {
                    Integer count = tmp.getAdsInfoList().size();
                    binding.tvRole.setText(String.valueOf(count));
                }

                count = 0
                for (UserInfo item : list) {
                     List<AdsInfo> lst2 = item.getAdsInfoList();
                    for (AdsInfo item2 : lst2) {
                        if(item2.getActive() == true){
                            count++
                        }
                    }
                }

            }

            @Override
            public void onFailure(Call<List<UserInfo>> call, Throwable t) {

            }
        });

        return binding.getRoot();
    }
}