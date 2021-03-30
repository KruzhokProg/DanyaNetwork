package com.example.danyanetwork.Adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.danyanetwork.R;

public class AdSearchVH extends RecyclerView.ViewHolder {
    ImageView adsImage;
    TextView tvDesc, tvPrice, tvName;

    public AdSearchVH(@NonNull View itemView) {
        super(itemView);

        adsImage = itemView.findViewById(R.id.imgvAdSearch);
        tvDesc = itemView.findViewById(R.id.tvAdDesc);
        tvPrice = itemView.findViewById(R.id.tvAdPrice);
        tvName = itemView.findViewById(R.id.tvAdName);
    }
}
