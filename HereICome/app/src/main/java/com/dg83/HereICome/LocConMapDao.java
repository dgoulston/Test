package com.dg83.HereICome;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class LocConMapDao  implements MainDao {
    LocConMapDao(){};


    public List<LocConMap> getAllLocations(SQLiteDatabase database){
        try {
            Cursor cursor = database.query(TABLE_LOCCON,
                    LocConMap.SQL_LOCCON_ALL_COLUMNS, null, null, null, null, null);
            cursor.moveToFirst();
            List<LocConMap> LocConMapList = new ArrayList<LocConMap>();
            while (!cursor.isAfterLast()) {
                LocConMapList.add( rowToLocation(cursor));
                cursor.moveToNext();
            }
            cursor.close();
            return LocConMapList;
        } catch (Exception e) {

            return new ArrayList();
        }
    }

    private LocConMap rowToLocation(Cursor cursor) {
        return (new LocConMap(
                cursor.getInt(cursor.getColumnIndex(LocConMap.SQL_LOCCON_ID)),
                cursor.getInt(cursor.getColumnIndex(LocConMap.SQL_LOCCON_LOCID)),
                cursor.getInt(cursor.getColumnIndex(LocConMap.SQL_LOCCON_CONID)),
                cursor.getDouble(cursor.getColumnIndex(LocConMap.SQL_LOCCON_DISTANCE)),
                cursor.getString(cursor.getColumnIndex(LocConMap.SQL_LOCCON_DAYS)),
                DBHelper.textToTime(cursor.getString(cursor.getColumnIndex(LocConMap.SQL_LOCCON_START_TIMES))),
                DBHelper.textToTime(cursor.getString(cursor.getColumnIndex(LocConMap.SQL_LOCCON_END_TIMES)))
                )
        );
    }
}
