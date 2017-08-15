package com.example.android.quakereport;
/**
 * Created by soumyajit on 12/8/17.
 */

public class Earthquake {

    private String rate;
    private String place;
    private Long dateTime;
        public Earthquake(String rate , String place , Long dateTime){
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
    Long getdatetimeInfo(){
        return dateTime;
    }

}
