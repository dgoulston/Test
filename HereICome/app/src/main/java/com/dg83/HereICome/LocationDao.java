package com.dg83.HereICome;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class LocationDao implements MainDao {
    LocationDao(){};

    public List<Location> getAllLocations(SQLiteDatabase database){
        try {
            Cursor cursor = database.query(TABLE_LOC,
                    Location.SQL_LOC_ALL_COLUMNS, null, null, null, null, null);
            cursor.moveToFirst();
            List<Location> LocationList = new ArrayList<Location>();
            while (!cursor.isAfterLast()) {
                LocationList.add( rowToLocation(cursor));
                cursor.moveToNext();
            }
            cursor.close();
            return LocationList;
        } catch (Exception e) {

            return new ArrayList();
        }
    }

    private Location rowToLocation(Cursor cursor) {
        return (new Location(
                cursor.getInt(cursor.getColumnIndex(Location.SQL_LOC_ID)),
                cursor.getString(cursor.getColumnIndex(Location.SQL_LOC_NAME)),
                cursor.getString(cursor.getColumnIndex(Location.SQL_LOC_POSTCODE)),
                cursor.getDouble(cursor.getColumnIndex(Location.SQL_LOC_LAT)),
                cursor.getDouble(cursor.getColumnIndex(Location.SQL_LOC_LONG)),
                cursor.getString(cursor.getColumnIndex(Location.SQL_LOC_ADV_LOC)),
                cursor.getString(cursor.getColumnIndex(Location.SQL_LOC_STATE)))
        );
    }
}

