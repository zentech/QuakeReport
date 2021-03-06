package com.example.android.quakereport;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;

import org.w3c.dom.Text;

/*
 *{@link EarthQuakeAdapter} is an {@link ArrayAdapter} is a custom adapter to provide a view for
 * {@link EarthQuake} objects.
 *
 */
public class EarthQuakeAdapter extends ArrayAdapter<EarthQuake> {

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param earthQuakes    A list of earthquakes to be display
     */
    public EarthQuakeAdapter(Activity context, ArrayList<EarthQuake> earthQuakes) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, earthQuakes);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link EarthQuake} object located at this position in the list
        EarthQuake currentEarthquake = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID magnitud
        TextView magTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        // set this text on the magnitud TextView
        magTextView.setText(Double.toString(currentEarthquake.getMagnitude()));

        // Find the TextView in the list_item_list.xml layout with the ID city
        TextView cityTextView = (TextView) listItemView.findViewById(R.id.city);
        // Get the the city from current earthquake and set item textView
        cityTextView.setText(getCityCountry(currentEarthquake.getCity()));

        // Find the textView with the date id
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);

        //format date object
        Date objDate = new Date(currentEarthquake.getDate());
        //format date
        dateTextView.setText(formatDate(objDate));

        //find textView for hour
        TextView hourTextView = (TextView) listItemView.findViewById(R.id.hour);
        //format time
        hourTextView.setText(formatTime(objDate));

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        Log.v("magnitudeColor: ", Double.toString(currentEarthquake.getMagnitude()));

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        // Return the whole list item layout (containing 3 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }

     /**
      * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
      */
     private String formatDate(Date dateObject) {
         SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
         return dateFormat.format(dateObject);
     }

     /**
      * Return the formatted date string (i.e. "4:30 PM") from a Date object.
      */
     private String formatTime(Date dateObject) {
         SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
         return timeFormat.format(dateObject);
     }

    /**
     * @return city and country of Earthquake
     */
    private String getCityCountry(String city) {
        //extracting city and country from whole address
        //spliting city into an array to extract city and country
        String[] quakeAddress = city.split(" ");
        int size = quakeAddress.length;
        return quakeAddress[size-2] + " " + quakeAddress[size-1];
    }

    /**
     * Return the color for the magnitude circle based on the intensity of the earthquake.
     * @param magnitude of the earthquake
     */
    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
