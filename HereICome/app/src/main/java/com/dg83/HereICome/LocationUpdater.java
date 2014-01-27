package com.dg83.HereICome;

import android.content.Context;
import android.location.*;
import android.os.Bundle;
import android.widget.Toast;

import java.text.DecimalFormat;

public class LocationUpdater {
    private double currentLongitude;
    private double currentLatitude;
    LocationManager locationManager = null;
    LocationProcessor locationProcessor;
    Context context;

    LocationUpdater(Context context){
        this.context = context;
    }

    private void requestLocations() {
        locationManager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
        String provider = getProvider();
        if (provider != null)
            locationManager.requestLocationUpdates(getProvider(), 30000,1000, localLocationListener);
    }

    private String getProvider()  {
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setPowerRequirement(Criteria.NO_REQUIREMENT);
        String provider = locationManager.getBestProvider(criteria, true);
        return (provider);
    }


    private LocationListener localLocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(android.location.Location location) {

        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };

    private boolean FindDistanceFromHome(boolean live) {
        double Lat = 0.0;
        double Long = 0.0;
        String provider = getProvider();
        if (provider != null) {

            android.location.Location location  = locationManager.getLastKnownLocation(provider);
            if (location == null)
                location = locationManager.getLastKnownLocation( LocationManager.GPS_PROVIDER);
            if (location == null)
                location = locationManager.getLastKnownLocation( LocationManager.NETWORK_PROVIDER);
            if (location == null) {
                return false;
            }
            else {
                Lat = location.getLatitude();
                Long = location.getLongitude();

            }
        }
        else {
            Toast.makeText(context, "GPS Disabled, Please Enable & Try Again", Toast.LENGTH_LONG).show();
            return false;
        }
        //TESTING
        double Lat_Home = 51.44609;
        double Long_Home = 0.01369;

        locationProcessor.processLocations(context, Lat, Long);

        return true;
    }

    public void stopTracking() {
        locationManager.removeUpdates(localLocationListener);
    }


}
