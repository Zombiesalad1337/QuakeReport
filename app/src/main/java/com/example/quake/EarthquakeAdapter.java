package com.example.quake;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes){
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_earthquake, parent, false);
        }
        TextView eqMag = listItemView.findViewById(R.id.earthquake_magnitude);
        TextView eqLoc = listItemView.findViewById(R.id.earthquake_location);
        TextView eqDate = listItemView.findViewById(R.id.earthquake_date);

        Earthquake earthquake = getItem(position);

        eqMag.setText(String.valueOf(earthquake.getMagnitude()));
        eqLoc.setText(earthquake.getLocation());
//        String date = earthquake.getMonth() + " " + earthquake.getDay() + ", " + earthquake.getYear();
//        eqDate.setText(date);
        String date = earthquake.getDate();
        eqDate.setText(date);
        return listItemView;


    }
}
