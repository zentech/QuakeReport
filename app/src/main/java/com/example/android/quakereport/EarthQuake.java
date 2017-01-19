package com.example.android.quakereport;

/**
 * {@link EarthQuake} class to handle all data perteining to EarthQuake
 */

public class EarthQuake {

    private double magnitude;
    private String city;
    private long date;

    /**
     * constructor for EarthQuake class taking three inputs
     * @param mag magnitude of earthquake
     * @param city city where it happened
     * @param date date of earthquake
     * */
    public EarthQuake(double mag, String city, long date) {
        magnitude = mag;
        this.city = city;
        this.date = date;
    }

    /**
     * getMagnitud returns the earthquake magnitud
     * @return magnitud
     * */
    public double getMagnitude() { return magnitude; }

    /**
     * getCity returns the city where earthquake happened
     * @return city
     * */
    public String getCity() { return city; }

    /**
     * getDate returns the date of earthquake
     * @return date
     * */
    public long getDate() { return date; }


}
