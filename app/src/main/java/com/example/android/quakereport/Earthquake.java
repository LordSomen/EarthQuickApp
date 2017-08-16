package com.example.android.quakereport;
/**
 * Created by soumyajit on 12/8/17.
 */

public class Earthquake {

    private double mag;
    private String place;
    private Long dateTime;
        public Earthquake(double mag , String place , Long dateTime){
            this.mag = mag;
            this.place = place;
            this.dateTime = dateTime;
        }

    double getEarthQuickMagInfo(){
        return mag;
    }

    String getPlaceInfo(){
        return place;
    }
    Long getDateTimeInfo(){
        return dateTime;
    }

}
