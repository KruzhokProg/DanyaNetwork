package com.example.danyanetwork.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.danyanetwork.Model.AdSearchInfo;
import com.example.danyanetwork.Model.AdsInfo;
import com.example.danyanetwork.R;

import java.util.List;

public class AdSearchAdapter extends RecyclerView.Adapter<AdSearchVH> {

    Context context;
    List<AdSearchInfo> adsInfoList;

    public AdSearchAdapter(Context context, List<AdSearchInfo> adsInfoList) {
        this.context = context;
        this.adsInfoList = adsInfoList;
    }

    @NonNull
    @Override
    public AdSearchVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_item_ad_search, null);
        return new AdSearchVH(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AdSearchVH holder, int position) {
        holder.adsImage.setImageResource(R.drawable.sell1);
        holder.tvPrice.setText(adsInfoList.get(position).getPrice().toString());
        holder.tvDesc.setText(adsInfoList.get(position).getDesc());
        holder.tvName.setText(adsInfoList.get(position).getName());
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
