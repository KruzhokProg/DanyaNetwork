package com.example.danyanetwork.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.danyanetwork.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class AccountInfoFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account_info, container, false);
        CircleImageView image = view.findViewById(R.id.imgvAccountImage);

        Glide.with(this).load("http://vongu3-001-site2.ctempurl.com/api/image/JPEG_20200819_202357_784096771411385555.jpg").into(image);

        return view;
    }
}