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
public class HotelFragment extends Fragment {

    private int[] image = {

            R.drawable.grand_cevahir_hotel,
            R.drawable.wyndham_grand_istanbul_europe,
            R.drawable.hotel_suadiye,
            R.drawable.burgu_arjaan_by_rotana,
            R.drawable.radisson_blu_hotel,
            R.drawable.hotel_mercure_istanbul_topkapi,
            R.drawable.armada_hotel,
            R.drawable.divan_istanbul_asia
};

    public HotelFragment() {
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
        toolbar.setTitle("Hotel");

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        Resources res = getResources();
        final String[] name = res.getStringArray(R.array.hotel_name);
        final String[] shortAddress = res.getStringArray(R.array.hotel_short_address);
        final String[] longAddress = res.getStringArray(R.array.hotel_long_address);
        final String[] phone = res.getStringArray(R.array.hotel_phone);
        final String[] workHours = res.getStringArray(R.array.hotel_price);
        final String[] webpage = res.getStringArray(R.array.hotel_webpage);

        final String[] lat = res.getStringArray(R.array.hotel_latitude);
        final String[] lng = res.getStringArray(R.array.hotel_longitude);


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
                    longAddress[i], workHours[i], longitude[i], latitude[i],
                    phone[i], webpage[i], image[i]));
        }

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;


    }
}
