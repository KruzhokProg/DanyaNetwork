package com.example.danyanetwork.Adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.danyanetwork.R;

public class AdsViewHolder extends RecyclerView.ViewHolder {

    ImageView adsImage;
    TextView tvDesc, tvPrice;

    public AdsViewHolder(@NonNull View itemView) {
        super(itemView);

        adsImage = itemView.findViewById(R.id.imgvUserAdImage);
        tvDesc = itemView.findViewById(R.id.tvRvItemUserAdDesc);
        tvPrice = itemView.findViewById(R.id.tvRvItemUserAdPrice);
    }
}
