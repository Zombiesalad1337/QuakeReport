/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.quake;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quake.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake);

        // Create a fake list of earthquake locations.
        ArrayList<String> earthquake_names = new ArrayList<>();
        earthquake_names.add("San Francisco");
        earthquake_names.add("London");
        earthquake_names.add("Tokyo");
        earthquake_names.add("Mexico City");
        earthquake_names.add("Moscow");
        earthquake_names.add("Rio de Janeiro");
        earthquake_names.add("Paris");

        Double[] magnitudes = new Double[] {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};

        Integer[] days = new Integer[] {1,2,3,4,5,6,7};
        String[] months = new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "July"};
        Integer[] years = new Integer[] {2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007};

        ArrayList<Earthquake> earthquakes = new ArrayList<>();

        for (int i = 0; i != earthquake_names.size(); ++i){
            earthquakes.add(new Earthquake(earthquake_names.get(i), days[i], months[i], years[i], magnitudes[i]));
        }

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        EarthquakeAdapter earthquakeAdapter = new EarthquakeAdapter(this, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(earthquakeAdapter);
    }
}
