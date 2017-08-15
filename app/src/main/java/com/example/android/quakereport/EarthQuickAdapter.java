package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by soumyajit on 12/8/17.
 */

public class EarthQuickAdapter extends ArrayAdapter<Earthquake> {


    /**
     * creating Constructor
     */
    public EarthQuickAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes); // Intializing the ArrayAdapter class
        //this.list_id = id;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_eql, parent, false);

            Earthquake currentItem = getItem(position);

            //shows the magnitude

            TextView rateTextView = (TextView) listItemView.findViewById(R.id.list_rate);
            rateTextView.setText(currentItem.getRateInfo());

            //shows the place where earthQuick occurs

            TextView placeTextView = (TextView) listItemView.findViewById(R.id.list_place);
            placeTextView.setText(currentItem.getPlaceInfo());

            //Shows the time and date

            Date dateTimeObj = new Date(currentItem.getdatetimeInfo());
            String date = formatDate(dateTimeObj);
            TextView dateTextView = (TextView) listItemView.findViewById(R.id.list_date);
            dateTextView.setText(date);

            String time = formatTime(dateTimeObj);
            TextView timeTextView = (TextView) listItemView.findViewById(R.id.list_time);
            timeTextView.setText(time);
            //listItemView.setBackgroundResource(list_id);
            // Set the theme color for the list item
            // Find the color that the resource ID maps
            // Set the background color of the text container View


        }
        return listItemView;
    }

    private String formatDate(Date dateTimeObj){

        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd,yyyy");
        return dateFormat.format(dateTimeObj);
    }
    private String formatTime(Date dateTimeObj){

        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        return timeFormat.format(dateTimeObj);
    }
}
