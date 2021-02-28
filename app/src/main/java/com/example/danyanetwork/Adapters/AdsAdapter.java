package com.example.danyanetwork.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.danyanetwork.Model.AdsInfo;
import com.example.danyanetwork.R;

import java.util.List;

public class AdsAdapter extends RecyclerView.Adapter<AdsViewHolder>{

    Context context;
    List<AdsInfo> adsInfoList;

    public AdsAdapter(Context context, List<AdsInfo> adsInfoList) {
        this.context = context;
        this.adsInfoList = adsInfoList;
    }

    @NonNull
    @Override
    public AdsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_item_user_ads, null);
        return new AdsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdsViewHolder holder, int position) {
        holder.adsImage.setImageResource(R.drawable.sell1);
        holder.tvPrice.setText(adsInfoList.get(position).getPrice().toString());
        holder.tvDesc.setText(adsInfoList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        if(adsInfoList != null){
            return adsInfoList.size();
        }
        else{
            return 0;
        }
    }
}
