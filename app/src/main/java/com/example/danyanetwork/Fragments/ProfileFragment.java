package com.example.danyanetwork.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.danyanetwork.Adapters.AdsAdapter;
import com.example.danyanetwork.Auth;
import com.example.danyanetwork.CustomCallback;
import com.example.danyanetwork.Model.AdsInfo;
import com.example.danyanetwork.Model.UserInfo;
import com.example.danyanetwork.Network.ApiClient;
import com.example.danyanetwork.Network.ApiService;
import com.example.danyanetwork.R;
import com.example.danyanetwork.Utils.NetworkRequest;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProfileFragment extends Fragment {

    CircleImageView userImage;
    TextView userName, userMoney;
    Button active, archive;
    RecyclerView rvUserAds;
    ImageView exit;
    List<AdsInfo> adsInfoList;
    AdsAdapter adapter;


    public ProfileFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        userImage = view.findViewById(R.id.imgvUserImage);
        userName = view.findViewById(R.id.tvUserName);
        userMoney = view.findViewById(R.id.tvMoney);
        active = view.findViewById(R.id.btnActive);
        archive = view.findViewById(R.id.btnArchive);
        rvUserAds = view.findViewById(R.id.rvAds);
        exit = view.findViewById(R.id.imgv_exit);


        SharedPreferences sharedPref = getContext().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        Integer userId = sharedPref.getInt("userId", -1);
        NetworkRequest.getUserInfo(userId, true, new CustomCallback() {
            @Override
            public void onSuccess(List<AdsInfo> value) {
//                userImage.setImageResource(R.drawable.doc_house);
//                userName.setText(value.getEmail());
//                userMoney.setText(value.getBalance_avito().toString());

                adsInfoList = value;
                adapter = new AdsAdapter(getContext(), adsInfoList);
                rvUserAds.setAdapter(adapter);
            }

            @Override
            public void onFailure() {

            }
        });

        active.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                active.setBackground(getResources().getDrawable(R.drawable.bordered_button));
                archive.setBackground(getResources().getDrawable(R.drawable.bordered_button_unselected));
                NetworkRequest.getUserInfo(userId, true, new CustomCallback() {
                    @Override
                    public void onSuccess(List<AdsInfo> value) {
                        adsInfoList = value;
                        adapter = new AdsAdapter(getContext(), adsInfoList);
                        rvUserAds.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure() {

                    }
                });
            }
        });

        archive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                active.setBackground(getResources().getDrawable(R.drawable.bordered_button_unselected));
                archive.setBackground(getResources().getDrawable(R.drawable.bordered_button));
                NetworkRequest.getUserInfo(userId, false, new CustomCallback() {
                    @Override
                    public void onSuccess(List<AdsInfo> value) {
                        adsInfoList = value;
                        adapter = new AdsAdapter(getContext(), adsInfoList);
                        rvUserAds.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure() {

                    }
                });
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               SharedPreferences sharedPref = getContext().getSharedPreferences("userInfo",Context.MODE_PRIVATE);
               SharedPreferences.Editor edit = sharedPref.edit();
               edit.putInt("userId",-1);
               edit.apply();

                Intent i = new Intent(getContext(), Auth.class);
                startActivity(i);
            }
        });



        return view;
    }
}