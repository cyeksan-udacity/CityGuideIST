package com.example.android.tourguideapp;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Map;

import static java.lang.Integer.parseInt;

public class DetailsActivity extends AppCompatActivity {

    //Details Activity holds two child fragments: Information and Map.

    private String name;
    private String longAddress;
    private String shortAddress;
    private String description;
    private int imageID;
    private String workHoursOrPrice;
    private String phone;
    private String webpage;
    private double longitude;
    private double latitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle bun = getIntent().getExtras();

        name = bun.getString("NAME");
        longAddress = bun.getString("LONG_ADDRESS");
        shortAddress = bun.getString("SHORT_ADDRESS");
        description = bun.getString("DESCRIPTION");
        imageID = bun.getInt("IMAGE_ID", imageID);
        workHoursOrPrice = bun.getString("WORK_HOURS_OR_PRICE");
        phone = bun.getString("PHONE");
        webpage = bun.getString("WEBPAGE");
        longitude = bun.getDouble("LONGITUDE");
        latitude = bun.getDouble("LATITUDE");

        final Intent infoIntent = new Intent(DetailsActivity.this, InformationFragment.class);
        final Intent mapIntent = new Intent(DetailsActivity.this, MapFragment.class);

        Bundle bundle = new Bundle();

        bundle.putString("NAME", name);
        bundle.putString("LONG_ADDRESS", longAddress);
        bundle.putString("SHORT_ADDRESS", shortAddress);
        bundle.putString("DESCRIPTION", description);
        bundle.putInt("IMAGE_ID", imageID);
        bundle.putString("WORK_HOURS_OR_PRICE", workHoursOrPrice);
        bundle.putString("PHONE", phone);
        bundle.putString("WEBPAGE", webpage);
        bundle.putDouble("LONGITUDE", longitude);
        bundle.putDouble("LATITUDE", latitude);

        infoIntent.putExtras(bundle);
        mapIntent.putExtras(bundle);

        ViewPager viewPager = findViewById(R.id.viewpager);

        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);


    }
}
