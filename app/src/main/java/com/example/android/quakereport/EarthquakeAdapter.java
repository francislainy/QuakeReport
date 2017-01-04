package com.example.android.quakereport;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Francislainy on 03/01/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Earthquake earthquake = getItem(position);

        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.eathquaqe_list_layout, parent, false);

        TextView magnitude_text_view = (TextView) convertView.findViewById(R.id.magnitude_text_view);
        TextView near_of_text_view = (TextView) convertView.findViewById(R.id.near_of_text_view);
        TextView city_text_view = (TextView) convertView.findViewById(R.id.city_text_view);
        TextView date_text_view = (TextView) convertView.findViewById(R.id.date_text_view);
        TextView time_text_view = (TextView) convertView.findViewById(R.id.time_text_view);

         /**
         * Split the location into two Strings. Some JSON responses will come without a
          * prefix before their location, and won't have a comma separator, so because of this
          * we need to handle those cases with a conditional statement
         */
        String place = earthquake.getPlace();
        String nearOf = "";
        String city = "";
        if(place.contains(",")) {
            nearOf = place.substring(0, place.indexOf(","));
            city = place.substring(place.indexOf(",")+1);
        }
        else {
            nearOf = "Near the";
            city = place.substring(0);
        }

        DecimalFormat magnitudeFormatter = new DecimalFormat("0.0");
        String magnitude = magnitudeFormatter.format(earthquake.getMagnitude());

        magnitude_text_view.setText(magnitude);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude_text_view.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(earthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        near_of_text_view.setText(nearOf);
        city_text_view.setText(city);
        date_text_view.setText(earthquake.getDate());
        time_text_view.setText(earthquake.geTime());

        // Get the url for the item clicked so as to implement click click listener to bring user to
        // that url
        final String url = earthquake.getUrl();

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                getContext().startActivity(intent);
            }
        });

        return convertView;
    }

    private int getMagnitudeColor(Double magnitude) {

        int magnitudeColor = 0;

        // Casting from Double to Integer
        Double myDouble = Double.valueOf(magnitude);
        Integer val = Integer.valueOf(myDouble.intValue());

        switch (val) {
            case 0:
            case 1:
                // Or
                // magnitudeColor = R.color.magnitude1;
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case 2:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case 3:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case 4:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case 5:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case 6:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case 7:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case 8:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case 9:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            default:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
        }

        Log.v("EarthquakeAdapter", val + " val");
        Log.v("EarthquakeAdapter", magnitude + " magnitude");
        return magnitudeColor;
    }
}
