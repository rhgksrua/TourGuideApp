package com.example.android.tourguideapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.android.tourguideapp.ParkFragment.EXTRA_MESSAGE_CITY;
import static com.example.android.tourguideapp.ParkFragment.EXTRA_MESSAGE_NAME;
import static com.example.android.tourguideapp.ParkFragment.EXTRA_MESSAGE_STREET;


public class ListViewAdapter implements AdapterView.OnItemClickListener {

    private ArrayList<Place> places;
    private Context context;
    private Activity activity;

    /**
     * Constructor for click listener.  It requires activity and context.
     *
     * @param context takes context of each fragment.
     * @param activity takes activity of each fragment.
     * @param places takes ArrayList of all places.
     */
    public ListViewAdapter(Context context, Activity activity, ArrayList<Place> places) {
        super();
        this.places = places;
        this.context = context;
        this.activity = activity;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Place place = places.get(position);
        String name = place.getName();
        String street = place.getStreet();
        String city = place.getCityStateZip();
        Toast toast = Toast.makeText(context, name, Toast.LENGTH_SHORT);
        toast.show();

        Intent intent = new Intent(activity, DetailActivity.class);
        intent.putExtra(EXTRA_MESSAGE_NAME, name);
        intent.putExtra(EXTRA_MESSAGE_STREET, street);
        intent.putExtra(EXTRA_MESSAGE_CITY, city);
        activity.startActivity(intent);

    }
}
