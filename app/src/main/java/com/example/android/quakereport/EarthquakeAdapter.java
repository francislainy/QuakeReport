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
        TextView city_text_view = (TextView) convertView.findViewById(R.id.city_text_view);
        TextView date_text_view = (TextView) convertView.findViewById(R.id.date_text_view);
        TextView time_text_view = (TextView) convertView.findViewById(R.id.time_text_view);

        magnitude_text_view.setText(earthquake.getMagnitude());
        city_text_view.setText(earthquake.getPlace());
        date_text_view.setText(earthquake.getDate());
        time_text_view.setText(earthquake.geTime());

        return convertView;
    }
}
