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
package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations
        ArrayList<EarthQuickInfo> earthquakes = new ArrayList<EarthQuickInfo>();
        earthquakes.add(new EarthQuickInfo("7.5", "San Francisco", "15 sept,2017"));
        earthquakes.add(new EarthQuickInfo("6.75", "London", "23 oct,2017"));
        earthquakes.add(new EarthQuickInfo("4.566", "Tokyo", "23 july,2017"));
        earthquakes.add(new EarthQuickInfo("5.66", "Mexico City", "12 august,2017"));
        earthquakes.add(new EarthQuickInfo("3.2", "Moscow", "15 august,2017"));
        earthquakes.add(new EarthQuickInfo("5.67", "Rio de Janeiro", "26 july,2017"));
        earthquakes.add(new EarthQuickInfo("4.567", "Paris", "7 oct,2017"));

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        EarthQuickAdapter  adapter = new EarthQuickAdapter(this,  earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
    }
}
