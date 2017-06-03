package com.example.android.tourguideapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private String street;
    private String cityStateZip;

    /**
     * Shows all place info on to activity_detail.xml
     *
     * @param savedInstanceState takes current saved instance state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent i = getIntent();

        String name = i.getStringExtra(ParkFragment.EXTRA_MESSAGE_NAME);
        String street = i.getStringExtra(ParkFragment.EXTRA_MESSAGE_STREET);
        this.street = street;

        String cityStateZip = i.getStringExtra(ParkFragment.EXTRA_MESSAGE_CITY);
        this.cityStateZip = cityStateZip;

        TextView nameTextView = (TextView) findViewById(R.id.name_text_view);
        nameTextView.setText(name);

        TextView streetTextView = (TextView) findViewById(R.id.street_text_view);
        streetTextView.setText(street);

        TextView cityTextView = (TextView) findViewById(R.id.city_state_zip_text_view);
        cityTextView.setText(cityStateZip);
    }

    /**
     * Creates Intent for Google Maps.
     *
     * @param view takes current view.
     */
    public void openLocation(View view) {
        Uri gmmIntentUri = Uri.parse("https://www.google.com/maps/search/?api=1&query=" + street + " " + cityStateZip);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

}
