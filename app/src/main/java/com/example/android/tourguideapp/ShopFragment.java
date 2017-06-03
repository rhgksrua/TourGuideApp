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
import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static com.example.android.tourguideapp.ParkFragment.EXTRA_MESSAGE_CITY;
import static com.example.android.tourguideapp.ParkFragment.EXTRA_MESSAGE_NAME;
import static com.example.android.tourguideapp.ParkFragment.EXTRA_MESSAGE_STREET;


public class ShopFragment extends Fragment {

    public ShopFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FoodFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShopFragment newInstance() {
        ShopFragment fragment = new ShopFragment();
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
        places.add(new Place("Water Tower Place", "835 N Michigan Ave", "Chicago", "IL", "606011"));
        places.add(new Place("Block 37", "108 N State", "Chicago", "IL", "60602"));

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        ListView listView = (ListView) rootView.findViewById(R.id.list);


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new ListViewAdapter(getContext(), getActivity(), places));
        /*
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
        */

        return rootView;
    }
}
