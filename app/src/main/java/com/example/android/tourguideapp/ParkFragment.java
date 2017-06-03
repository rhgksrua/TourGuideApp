package com.example.android.tourguideapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.name;
import static android.media.CamcorderProfile.get;
import static android.provider.AlarmClock.EXTRA_MESSAGE;

//import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class ParkFragment extends Fragment {

    public static final String EXTRA_MESSAGE_NAME = "com.example.android.tourguideapp.name";
    public static final String EXTRA_MESSAGE_STREET = "com.example.android.tourguideapp.street";
    public static final String EXTRA_MESSAGE_CITY = "com.example.android.tourguideapp.city";


    public ParkFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FoodFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ParkFragment newInstance() {
        ParkFragment fragment = new ParkFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place("Millennium Park", "201 E Randolph St",  "Chicago", "IL", "60602"));
        places.add(new Place("Grant Park", "337 E Randolph St", "Chicago", "IL", "60601"));

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Place place = places.get(position);
                String name = place.getName();
                String street = place.getStreet();
                String city = place.getCityStateZip();
                Toast toast = Toast.makeText(getContext(), name, Toast.LENGTH_SHORT);
                toast.show();

                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(EXTRA_MESSAGE_NAME, name);
                intent.putExtra(EXTRA_MESSAGE_STREET, street);
                intent.putExtra(EXTRA_MESSAGE_CITY, city);
                startActivity(intent);
            }
        });
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();

    }
}
