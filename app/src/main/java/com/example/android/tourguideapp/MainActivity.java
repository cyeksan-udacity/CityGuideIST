package com.example.android.tourguideapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    List<Card> recyclerList;
    private static final String ITEM_ID = "selected";
    private static final String FIRST_TIME = "first_time";
    private int mSelectedId;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;
    private NavigationView mDrawer;
    private boolean mDrawerIsSeen = false;
    private boolean isStartup = true;

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){

        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt(ITEM_ID, mSelectedId);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mDrawer = findViewById(R.id.main_drawer);
        mDrawer.setNavigationItemSelectedListener(this);

        mDrawerLayout = findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);


        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        //in order to save instance state in case of orientation change:
        if (savedInstanceState != null) {

            savedInstanceState.getInt(ITEM_ID, mSelectedId);
            if(!isStartup){
                ((FrameLayout) findViewById(R.id.container)).removeAllViews();
            }
            isStartup = true;
            navigate(mSelectedId);
        }

        if(!drawerSeen()){

            showDrawer();

        } else{

            hideDrawer();
        }

        navigate(mSelectedId);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Add recycler arraylist:

        recyclerList = new ArrayList<>();
        recyclerList.add(new Card(getString(R.string.topkapi_palace), getString(R.string.topkapi_palace_hook), getString(R.string.topkapi_palace_short_address),R.drawable.topkapi_palace, getString(R.string.topkapi_palace_description),getString(R.string.topkapi_palace_long_address), getString(R.string.topkapi_palace_work_hours),28.983400,41.011843, getString(R.string.topkapi_palace_phone), getString(R.string.topkapi_palace_web)));
        recyclerList.add(new Card(getString(R.string.maidens_tower), getString(R.string.maidens_tower_hook), getString(R.string.maidens_tower_short_address),R.drawable.maidens_tower, getString(R.string.maidens_tower_description),getString(R.string.maidens_tower_long_address), getString(R.string.maidens_tower_work_hours),29.004153,41.022077,getString(R.string.maidens_tower_phone), getString(R.string.maidens_tower_web)));
        recyclerList.add(new Card(getString(R.string.blue_mosque), getString(R.string.blue_mosque_hook), getString(R.string.blue_mosque_short_address),R.drawable.blue_mosque, getString(R.string.blue_mosque_description),getString(R.string.blue_mosque_long_address), getString(R.string.blue_mosque_work_hours),28.976857,41.006365,getString(R.string.blue_mosque_phone), getString(R.string.blue_mosque_web)));
        recyclerList.add(new Card(getString(R.string.spice_bazaar), getString(R.string.spice_bazaar_hook), getString(R.string.spice_bazaar_short_address),R.drawable.spice_bazaar, getString(R.string.spice_bazaar_description),getString(R.string.spice_bazaar_long_address), getString(R.string.spice_bazaar_work_hours),28.970305,41.017617,getString(R.string.spice_bazaar_phone), getString(R.string.spice_bazaar_web)));
        recyclerList.add(new Card(getString(R.string.yedikule_fortress), getString(R.string.yedikule_fortress_hook), getString(R.string.yedikule_fortress_short_address),R.drawable.yedikule_fortress, getString(R.string.yedikule_fortress_description),getString(R.string.yedikule_fortress_long_address),getString(R.string.yedikule_fortress_work_hours),28.921123,40.994273, getString(R.string.yedikule_fortress_phone),getString(R.string.yedikule_fortress_web)));
        recyclerList.add(new Card(getString(R.string.pera_museum), getString(R.string.pera_museum_hook), getString(R.string.pera_museum_short_address),R.drawable.pera_museum, getString(R.string.pera_museum_description),getString(R.string.pera_museum_long_address),getString(R.string.pera_museum_work_hours),28.975200,41.032642, getString(R.string.pera_museum_phone),getString(R.string.pera_museum_web)));
        recyclerList.add(new Card(getString(R.string.istanbul_modern), getString(R.string.istanbul_modern_hook), getString(R.string.istanbul_modern_short_address),R.drawable.istanbul_modern, getString(R.string.istanbul_modern_description), getString(R.string.istanbul_modern_long_address),getString(R.string.yedikule_fortress_work_hours),28.984402,41.027666, getString(R.string.istanbul_modern_phone), getString(R.string.istanbul_modern_web)));
        recyclerList.add(new Card(getString(R.string.nusret), getString(R.string.nusret_hook), getString(R.string.nusret_short_address),R.drawable.nusret_steakhouse, getString(R.string.nusret_long_address), getString(R.string.nusret_work_hours),29.033478,41.081435,getString(R.string.nusret_phone), getString(R.string.nusret_web)));
        recyclerList.add(new Card(getString(R.string.mall_of_istanbul), getString(R.string.mall_of_istanbul_hook), getString(R.string.mall_of_istanbul_short_address),R.drawable.mall_of_istanbul, getString(R.string.mall_of_istanbul_long_address), getString(R.string.mall_of_istanbul_work_hours), 28.807746,41.063819, getString(R.string.mall_of_istanbul_phone), getString(R.string.mall_of_istanbul_web)));
        recyclerList.add(new Card(getString(R.string.armada_hotel), getString(R.string.armada_hotel_hook), getString(R.string.armada_hotel_short_address),R.drawable.armada_hotel, getString(R.string.armada_hotel_long_address), getString(R.string.armada_hotel_price),28.981463,41.004760,getString(R.string.armada_hotel_phone), getString(R.string.armada_hotel_web)));

        int mNoOfColumns = Utility.calculateNoOfColumns(getApplicationContext());
        RecyclerView recyclerView = findViewById(R.id.recyler_view);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, recyclerList);

        //Shuffle the cardView positions:
        //(for the next two lines of code, credit goes to: https://stackoverflow.com/questions/38708377/select-random-item-in-cardview)
        long seed = System.nanoTime();
        Collections.shuffle(recyclerList, new Random(seed));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,mNoOfColumns);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(recyclerViewAdapter);

    }

    private boolean drawerSeen(){

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        mDrawerIsSeen = sharedPreferences.getBoolean(FIRST_TIME, false);
        return mDrawerIsSeen;
    }

    private void markIfDrawerIsSeen(){

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mDrawerIsSeen = true;
        sharedPreferences.edit().putBoolean(FIRST_TIME, mDrawerIsSeen).apply();

    }

    private void showDrawer(){

        mDrawerLayout.openDrawer(GravityCompat.START);
        markIfDrawerIsSeen();
    }
    private void hideDrawer(){

        mDrawerLayout.closeDrawer(GravityCompat.START);
    }

    public void navigate(int mSelectedId) {


        if(mSelectedId==R.id.popular_places){
            if(isStartup) {
                ((FrameLayout) findViewById(R.id.container)).removeAllViews();
                isStartup = false;
            }


            PopularPlacesFragment popularPlacesFragment = new PopularPlacesFragment();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, popularPlacesFragment).addToBackStack("Null").commit();

        }

        else if (mSelectedId == R.id.museums) {
            if(isStartup) {
                ((FrameLayout) findViewById(R.id.container)).removeAllViews();
                isStartup = false;
            }
            MuseumFragment museumFragment= new MuseumFragment();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, museumFragment).addToBackStack("Null").commit();

        } else if (mSelectedId == R.id.cafe_restaurant) {
            if(isStartup) {
                ((FrameLayout) findViewById(R.id.container)).removeAllViews();
                isStartup = false;
            }
            CafeRestaurantFragment cafeRestaurantFragment = new CafeRestaurantFragment();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, cafeRestaurantFragment).addToBackStack("Null").commit();

        } else if (mSelectedId == R.id.cinema) {
            if(isStartup) {
                ((FrameLayout) findViewById(R.id.container)).removeAllViews();
                isStartup = false;
            }
            CinemaFragment cinemaFragment = new CinemaFragment();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, cinemaFragment).addToBackStack("Null").commit();

        } else if (mSelectedId == R.id.shopping) {
            if(isStartup) {
                ((FrameLayout) findViewById(R.id.container)).removeAllViews();
                isStartup = false;
            }
            ShoppingFragment shoppingFragment = new ShoppingFragment();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, shoppingFragment).addToBackStack("Null").commit();

        } else if (mSelectedId == R.id.hotels) {
            if(isStartup) {
                ((FrameLayout) findViewById(R.id.container)).removeAllViews();
                isStartup = false;
            }
            HotelFragment hotelFragment = new HotelFragment();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, hotelFragment).addToBackStack("Null").commit();

        } else if (mSelectedId == R.id.bus) {
            if(isStartup) {
                ((FrameLayout) findViewById(R.id.container)).removeAllViews();
                isStartup = false;
            }
            BusFragment busFragment = new BusFragment();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, busFragment).addToBackStack("Null").commit();

        } else if (mSelectedId == R.id.airports) {
            if(isStartup) {
                ((FrameLayout) findViewById(R.id.container)).removeAllViews();
                isStartup = false;
            }
            AirportFragment airportFragment = new AirportFragment();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, airportFragment).addToBackStack("Null").commit();

        } else if (mSelectedId == R.id.hospitals) {
            if(isStartup) {
                ((FrameLayout) findViewById(R.id.container)).removeAllViews();
                isStartup = false;
            }
            HospitalFragment hospitalFragment = new HospitalFragment();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, hospitalFragment).addToBackStack("Null").commit();

        }
        mDrawerLayout.closeDrawer(GravityCompat.START);

    }

    @Override

    public void onConfigurationChanged(Configuration newConfig){

        super.onConfigurationChanged(newConfig);
        mToggle.onConfigurationChanged(newConfig);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mToggle.onOptionsItemSelected(item)) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        item.setChecked(true);

        mSelectedId = item.getItemId();

        navigate(mSelectedId);

        return true;
    }


    @Override
    public void onBackPressed(){

        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){

            mDrawerLayout.closeDrawer(GravityCompat.START);
        }

       else {

            do {
                if (!isStartup) {

                    //recreate after removeAllFiles command:
                    startActivity(new Intent(this, MainActivity.class));
                    super.onBackPressed();
                    isStartup = true;


                } else {

                    super.onBackPressed();
                    isStartup = false;

                }
            }while (isStartup);

        }
    }

}

