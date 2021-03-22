package com.example.danyanetwork.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
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
import com.example.danyanetwork.R;
import com.example.danyanetwork.Utils.NetworkRequest;
import com.example.danyanetwork.databinding.FragmentProfileBinding;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class ProfileFragment extends Fragment {

    List<AdsInfo> adsInfoList;
    AdsAdapter adapter;
    FragmentManager manager;
    FragmentProfileBinding binding;


    public ProfileFragment(FragmentManager manager) {
        this.manager = manager;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentProfileBinding.inflate(getLayoutInflater(), container, false);

        binding.imgvToolBarNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.beginTransaction().replace(R.id.frame_layout, new AccountInfoFragment()).commit();
            }
        });


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
                binding.rvAds.setAdapter(adapter);
            }

            @Override
            public void onFailure() {

            }
        });

        binding.btnActive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.btnActive.setBackground(getResources().getDrawable(R.drawable.bordered_button));
                binding.btnArchive.setBackground(getResources().getDrawable(R.drawable.bordered_button_unselected));
                NetworkRequest.getUserInfo(userId, true, new CustomCallback() {
                    @Override
                    public void onSuccess(List<AdsInfo> value) {
                        adsInfoList = value;
                        adapter = new AdsAdapter(getContext(), adsInfoList);
                        binding.rvAds.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure() {

                    }
                });
            }
        });

        binding.btnArchive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.btnActive.setBackground(getResources().getDrawable(R.drawable.bordered_button_unselected));
                binding.btnArchive.setBackground(getResources().getDrawable(R.drawable.bordered_button));
                NetworkRequest.getUserInfo(userId, false, new CustomCallback() {
                    @Override
                    public void onSuccess(List<AdsInfo> value) {
                        adsInfoList = value;
                        adapter = new AdsAdapter(getContext(), adsInfoList);
                        binding.rvAds.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure() {

                    }
                });
            }
        });

        binding.imgvExit.setOnClickListener(new View.OnClickListener() {
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



        return binding.getRoot();
    }
}