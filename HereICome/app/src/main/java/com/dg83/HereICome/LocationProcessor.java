package com.dg83.HereICome;

import android.content.Context;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.List;

public class LocationProcessor {
    List<Location> locationList;
    LocationDao locationDao;
    DatabaseConnection databaseConnection;

    LocationProcessor(Context context){
        loadLocations();
        databaseConnection = new DatabaseConnection(context);
    }

    private double getDistanceFrom(Location location, double latitude, double longitude) {
        LocationCalc lc = new LocationCalc();
        return (lc.DistToMiles(latitude,longitude,location.getLatitude(),location.getLongitude()));
    }

    private void loadLocations() {
        if (locationList.size() <= 0)
            locationList = locationDao.getAllLocations(databaseConnection.getDatabase());
    }

    public void processLocations(Context context, double latitude, double longitude)  {
        loadLocations();
        for(Location location: locationList){
            double distance = getLocationDistance(location, latitude, longitude);
            DecimalFormat threeDec = new DecimalFormat("0.00");
            String DistanceText = "Distance: " + threeDec.format(distance/1000);
            Toast.makeText(context, DistanceText, Toast.LENGTH_LONG).show();
        }
    }

    private double getLocationDistance(Location location, double latitude, double longitude) {
        LocationCalc locationCalc = new LocationCalc();
        return (locationCalc.DistToMiles(location.getLatitude(), location.getLongitude(), latitude, longitude));
    }


}
