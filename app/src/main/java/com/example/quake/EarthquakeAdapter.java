package com.example.quake;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
        TextView eqPrimaryLoc = listItemView.findViewById(R.id.earthquake_primaryLocation);
        TextView eqOffset = listItemView.findViewById(R.id.earthquake_offset);
        TextView eqDate = listItemView.findViewById(R.id.earthquake_date);
        TextView eqTime = listItemView.findViewById(R.id.earthquake_time);

        Earthquake earthquake = getItem(position);

        eqMag.setText(String.valueOf(earthquake.getMagnitude()));
//        String date = earthquake.getMonth() + " " + earthquake.getDay() + ", " + earthquake.getYear();
//        eqDate.setText(date);
        Date dateObject = new Date(earthquake.getTimeMilliseconds());
        String formattedDate = formatDate(dateObject);
        String formattedTime = formatTime(dateObject);

        eqDate.setText(formattedDate);
        eqTime.setText(formattedTime);

        //setting location
        //UI related change, so modifying here
        String location = earthquake.getLocation();
        int ofIndex = location.indexOf(" of ");

        String offset;
        String primaryLocation;
        if (ofIndex != -1) {
            offset = location.substring(0, ofIndex);
            primaryLocation = location.substring(ofIndex + 4, location.length());
        }
        else{
            offset = "Near the";
            primaryLocation = location;
        }

        eqOffset.setText(offset);
        eqPrimaryLoc.setText(primaryLocation);


        return listItemView;


    }

    //TODO: won't it create new Simpledateformat object each time the method is called?
    //or will it clean the previous one since dateFormat now points to a new simpledateformat object
    private String formatDate(Date dateObject){
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject){
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}
