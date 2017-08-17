package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
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

            String mag = formatMagnitude(currentItem.getEarthQuickMagInfo());
            TextView magTextView = (TextView) listItemView.findViewById(R.id.list_magnitude);
            magTextView.setText(mag);
            GradientDrawable magnitudeCircle = (GradientDrawable) magTextView.getBackground();

            // Get the appropriate background color based on the current earthquake magnitude
            int magnitudeColor = getMagnitudeColor(currentItem.getEarthQuickMagInfo());

            // Set the color on the magnitude circle
            magnitudeCircle.setColor(magnitudeColor);


            //shows the place where earthQuick occurs
            String place = currentItem.getPlaceInfo();
            String q = "Near Of";
            int index = place.lastIndexOf("of");
            if(index!=-1){
                q= place.substring(0,index+3);
                place=place.substring(index+3,place.length());
            }
            TextView placeTextView = (TextView) listItemView.findViewById(R.id.list_place);
            placeTextView.setText(q);
            TextView placeTextView2 = (TextView) listItemView.findViewById(R.id.list_place_country);
            placeTextView2.setText(place);
            //Shows the time and date

            Date dateTimeObj = new Date(currentItem.getDateTimeInfo());
            String date = formatDate(dateTimeObj);
            TextView dateTextView = (TextView) listItemView.findViewById(R.id.list_date);
            dateTextView.setText(date);

            String time = formatTime(dateTimeObj);
            TextView timeTextView = (TextView) listItemView.findViewById(R.id.list_time);
            timeTextView.setText(time);
            //listItemView.setBackgroundResource(list_id);
            // Set the color that the resource ID maps
            // Set the background color of the text container View
            // Set the proper background color on the magnitude circle.
            // Fetch the background from the TextView, which is a GradientDrawable.

        }
        return listItemView;
    }

    private String formatMagnitude(double mag){
        DecimalFormat magFormat = new DecimalFormat("0.0");
        return magFormat.format(mag);
    }
    private int getMagnitudeColor(double mag){
        int magCircleColor,magInt;
        magInt = (int)mag;
        switch(magInt){
            case 0:
            case 1: magCircleColor = ContextCompat.getColor(getContext(), R.color.magnitude1);
                    break;
            case 2: magCircleColor = ContextCompat.getColor(getContext(), R.color.magnitude2);
                    break;
            case 3: magCircleColor = ContextCompat.getColor(getContext(), R.color.magnitude3);
                    break;
            case 4: magCircleColor = ContextCompat.getColor(getContext(), R.color.magnitude4);
                    break;
            case 5: magCircleColor = ContextCompat.getColor(getContext(), R.color.magnitude5);
                    break;
            case 6: magCircleColor = ContextCompat.getColor(getContext(), R.color.magnitude6);
                    break;
            case 7: magCircleColor = ContextCompat.getColor(getContext(), R.color.magnitude7);
                    break;
            case 8: magCircleColor = ContextCompat.getColor(getContext(), R.color.magnitude8);
                    break;
            case 9: magCircleColor = ContextCompat.getColor(getContext(), R.color.magnitude9);
                    break;
            default: magCircleColor =ContextCompat.getColor(getContext(), R.color.magnitude10plus);
        }
            return magCircleColor;
    }
    private String formatDate(Date dateTimeObj){

        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd,yyyy");
        return dateFormat.format(dateTimeObj);
    }
    private String formatTime(Date dateTimeObj){

        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm aa");
        return timeFormat.format(dateTimeObj);
    }
}
