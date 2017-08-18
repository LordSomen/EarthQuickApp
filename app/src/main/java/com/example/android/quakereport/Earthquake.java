package com.example.android.quakereport;
/**
 * Created by soumyajit on 12/8/17.
 */

public class Earthquake {

    private double mag;
    private String place;
    private Long dateTime;
    private String URL;
        public Earthquake(double mag , String place , Long dateTime,String URL){
            this.mag = mag;
            this.place = place;
            this.dateTime = dateTime;
            this.URL = URL;
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
    String getURL(){
        return URL;
    }
}
