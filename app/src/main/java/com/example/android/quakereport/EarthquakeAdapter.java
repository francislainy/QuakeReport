package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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


        magnitude_text_view.setText(earthquake.getMagnitude()+"");
        near_of_text_view.setText(nearOf);
        city_text_view.setText(city);
        date_text_view.setText(earthquake.getDate());
        time_text_view.setText(earthquake.geTime());

        return convertView;
    }
}
