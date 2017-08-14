package com.example.android.quakereport;
/**
 * Created by soumyajit on 12/8/17.
 */

public class Earthquake {

    private String rate;
    private String place;
    private String dateTime;
        public Earthquake(String rate , String place , String dateTime){
            this.rate = rate;
            this.place = place;
            this.dateTime = dateTime;
        }

    String getRateInfo(){
        return rate;
    }

    String getPlaceInfo(){
        return place;
    }
    String getdatetimeInfo(){
        return dateTime;
    }

}