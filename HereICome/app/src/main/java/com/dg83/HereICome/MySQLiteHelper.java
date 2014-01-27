package com.dg83.HereICome;

import android.app.AlertDialog;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

    private Context _context;
			
    public MySQLiteHelper(Context context) {
        super(context, MainDao.DATABASE_NAME, null, MainDao.DATABASE_VERSION);
        _context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase database)
    {
		DBHelper.initDatabase(database);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + "");
        try
        {
            //db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOC + TABLE_TEMP_EXT);
            //db.execSQL("DROP TABLE IF EXISTS " + TABLE_CON + TABLE_TEMP_EXT);
			//db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCCON + TABLE_TEMP_EXT);

            //db.execSQL("ALTER TABLE " + TABLE_LOC + " RENAME TO " + TABLE_LOC + TABLE_TEMP_EXT);
            //db.execSQL("ALTER TABLE " + TABLE_CON + " RENAME TO " + TABLE_CON + TABLE_TEMP_EXT);
			//db.execSQL("ALTER TABLE " + TABLE_LOCCON + " RENAME TO " + TABLE_LOCCON + TABLE_TEMP_EXT);

      //      db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOC);
       //     db.execSQL("DROP TABLE IF EXISTS " + TABLE_CON);
	//		db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCCON);

            onCreate(db);

            //db.execSQL(TABLE_CON_UPGRADE_V1_V2);
			//db.execSQL(TABLE_LOC_UPGRADE_V1_V2);
            //db.execSQL(TABLE_LOCCON_UPGRADE_V1_V2);

      //      db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOC + TABLE_TEMP_EXT);
        //    db.execSQL("DROP TABLE IF EXISTS " + TABLE_CON + TABLE_TEMP_EXT);
		//	db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCCON + TABLE_TEMP_EXT);
        }
        catch (SQLException e)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(_context);
            builder.setMessage("SQL Error Upgrading Tables: \n" + e.toString()
            ).setNeutralButton("OK", null).show();
        }
		finally
		{
		    //db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOC + TABLE_TEMP_EXT);
            //db.execSQL("DROP TABLE IF EXISTS " + TABLE_CON + TABLE_TEMP_EXT);
			//db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCCON + TABLE_TEMP_EXT);
		}


    }

}