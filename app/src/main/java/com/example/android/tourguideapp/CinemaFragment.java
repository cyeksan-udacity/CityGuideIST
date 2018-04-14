package com.example.android.tourguideapp;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CinemaFragment extends Fragment {
    private int[] image = { R.drawable.rexx_cinema,
        R.drawable.cinemaximum_historia,
            R.drawable.cinemaximum_forum_istanbul,
            R.drawable.cinemaximum_citys_nisantasi,
            R.drawable.atlas_cinema,
            R.drawable.fitas_cinema,
            R.drawable.cinema_pink,
            R.drawable.cinemaximum_trump_towers
};
    public CinemaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);
        Toolbar toolbar = rootView.findViewById(R.id.toolbar);
        toolbar.setTitle("Cinema");

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        Resources res = getResources();
        final String[] name = res.getStringArray(R.array.cinema_name);
        final String[] shortAddress = res.getStringArray(R.array.cinema_short_address);
        final String[] longAddress = res.getStringArray(R.array.cinema_long_address);
        final String[] phone = res.getStringArray(R.array.cinema_phone);
        final String[] webpage = res.getStringArray(R.array.cinema_webpage);

        final String[] lat = res.getStringArray(R.array.cinema_latitude);
        final String[] lng = res.getStringArray(R.array.cinema_longitude);


        //Convert string-array to double-array for latitude:
        double[] latitude = new double[lat.length];
        for (int i = 0; i < lat.length; i++) {
            latitude[i] = Double.parseDouble(lat[i]);
        }
        //Convert string-array to double-array for longitude:
        double[] longitude = new double[lng.length];
        for (int i = 0; i < lng.length; i++) {
            longitude[i] = Double.parseDouble(lng[i]);
        }

        final ArrayList<Place> places = new ArrayList<>();

        for (int i = 0; i < name.length; i++) {


            places.add(new Place(name[i], shortAddress[i],
                    longAddress[i], longitude[i], latitude[i],
                    phone[i], webpage[i], image[i]));
        }

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;


    }
}
