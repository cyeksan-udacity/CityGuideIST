package com.example.android.tourguideapp;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PopularPlacesFragment extends Fragment {

    private int[] image = {
            R.drawable.hagia_sophia,
            R.drawable.topkapi_palace,
            R.drawable.blue_mosque,
            R.drawable.basilica_cistern,
            R.drawable.hippodrome_square,
            R.drawable.grand_bazaar,
            R.drawable.suleymaniye_mosque,
            R.drawable.spice_bazaar,
            R.drawable.dolmabahce_palace,
            R.drawable.yedikule_fortress,
            R.drawable.galata_tower,
            R.drawable.maidens_tower};

    public PopularPlacesFragment() {
        //Required empty public constructor;
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


        //Set the fragment title as "Popular Places" and arrow back drawable as back icon:
        toolbar.setTitle("Popular Places");

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        Resources res = getResources();
        final String[] name = res.getStringArray(R.array.popular_places_name);
        final String[] shortAddress = res.getStringArray(R.array.popular_places_short_address);
        final String[] longAddress = res.getStringArray(R.array.popular_places_long_address);
        final String[] phone = res.getStringArray(R.array.popular_places_phone);
        final String[] workHours = res.getStringArray(R.array.popular_places_working_hours);
        final String[] webpage = res.getStringArray(R.array.popular_places_webpage);
        final String[] description = res.getStringArray(R.array.popular_places_description);
        final String[] lat = res.getStringArray(R.array.popular_places_latitude);
        final String[] lng = res.getStringArray(R.array.popular_places_longitude);


        //Convert string-array to double-array for latitude:
        double[] latitude = new double[lat.length];
        for(int i=0; i<lat.length; i++)
        {
            latitude[i] = Double.parseDouble(lat[i]);
        }
        //Convert string-array to double-array for longitude:
        double[] longitude = new double[lng.length];
        for(int i=0; i<lng.length; i++)
        {
            longitude[i] = Double.parseDouble(lng[i]);
        }

        final ArrayList<Place> places = new ArrayList<>();

        for (int i = 0; i < name.length; i++) {


            places.add(new Place(name[i], shortAddress[i], description[i],
                    longAddress[i], workHours[i], longitude[i], latitude[i],
                    phone[i], webpage[i], image[i]));
        }

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

}
}
