package com.example.android.quakereport;

/**
 * {@link EarthQuake} class to handle all data perteining to EarthQuake
 */

public class EarthQuake {

    private double magnitude;
    private String city;
    private long date;
    private String url;

    /**
     * constructor for EarthQuake class taking three inputs
     * @param mag magnitude of earthquake
     * @param city city where it happened
     * @param date date of earthquake
     * */
    public EarthQuake(double mag, String city, long date, String url) {
        magnitude = mag;
        this.city = city;
        this.date = date;
        this.url = url;
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

    /**
     * getUrl returns url string link from every earthQuake
     * @return url
     */
    public String getUrl() { return url; }


}
