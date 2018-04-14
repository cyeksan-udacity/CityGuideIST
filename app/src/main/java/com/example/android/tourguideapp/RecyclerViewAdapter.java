package com.example.android.tourguideapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Cansu on 11.04.2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    //In order to adapt cardViews:

    public Context mContext;
    private List<Card> mData;

    public RecyclerViewAdapter(Context mContext, List<Card> mData){

        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.card_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.nameTV.setText(mData.get(position).getName());
        holder.hookTV.setText(mData.get(position).getHookSentence());
        holder.shortAddressTV.setText(mData.get(position).getShortAddress());
        holder.cardIV.setImageResource(mData.get(position).getImageResourceID());

        String name = mData.get(position).getName();
        String shortAddress = mData.get(position).getShortAddress();
        String longAddress = mData.get(position).getLongAddress();
        String description = mData.get(position).getDescription();
        int imageID = mData.get(position).getImageResourceID();
        String workingHoursOrPrice = mData.get(position).getWorkingHoursOrPrice();
        String phone = mData.get(position).getPhone();
        String webPage = mData.get(position).getWebPage();
        double longitude = mData.get(position).getLongitude();
        double latitude = mData.get(position).getLatitude();


        final Intent detailsIntent = new Intent(mContext, DetailsActivity.class);

        Bundle bun = new Bundle();

        bun.putString("NAME", name);
        bun.putString("LONG_ADDRESS", longAddress);
        bun.putString("SHORT_ADDRESS", shortAddress);
        bun.putString("DESCRIPTION", description);
        bun.putInt("IMAGE_ID", imageID);
        bun.putString("WORK_HOURS_OR_PRICE", workingHoursOrPrice);
        bun.putString("PHONE", phone);
        bun.putString("WEBPAGE", webPage);
        bun.putDouble("LONGITUDE", longitude);
        bun.putDouble("LATITUDE", latitude);

        detailsIntent.putExtras(bun);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mContext.startActivity(detailsIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nameTV;
        TextView hookTV;
        TextView shortAddressTV;
        ImageView cardIV;
        CardView cardView;
        String name;
        String longAddress;
        String shortAddress;

        public MyViewHolder(View itemView) {

            super(itemView);

            nameTV = itemView.findViewById(R.id.name);
            hookTV = itemView.findViewById(R.id.hook_sentence);
            shortAddressTV = itemView.findViewById(R.id.short_address);
            cardIV = itemView.findViewById(R.id.card_image);
            cardView = itemView.findViewById(R.id.card_view);

        }
    }
}
