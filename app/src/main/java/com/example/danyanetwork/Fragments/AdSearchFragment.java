package com.example.danyanetwork.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.danyanetwork.Adapters.AdSearchAdapter;
import com.example.danyanetwork.R;
import com.example.danyanetwork.databinding.FragmentAdSearchBinding;


public class AdSearchFragment extends Fragment {

    FragmentAdSearchBinding binding;
    FragmentManager manager;
    GridLayoutManager gridLayoutManager;

    public AdSearchFragment(FragmentManager manager) {
        this.manager = manager;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAdSearchBinding.inflate(getLayoutInflater(), container, false);

        AdSearchAdapter adapter = new AdSearchAdapter(this, data);
        gridLayoutManager = new GridLayoutManager(getContext(), 2);
        binding.rvAds.setLayoutManager(gridLayoutManager);
        binding.rvAds.setAdapter(adapter);





        return inflater.inflate(R.layout.fragment_ad_search, container, false);
    }
}