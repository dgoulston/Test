package com.dg83.HereICome;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by darren on 26/01/14.
 */
public class DatabaseConnection {

    private SQLiteDatabase _database;
    private MySQLiteHelper _dbHelper;
    private Boolean _bConnectionIsOpen;

    public DatabaseConnection(Context context) {
        _dbHelper = new MySQLiteHelper(context);
        _bConnectionIsOpen = Boolean.FALSE;
    }

    public void open() throws SQLException {
        _database = _dbHelper.getWritableDatabase();
        _bConnectionIsOpen = Boolean.TRUE;
    }

    public void close() {
        if (_bConnectionIsOpen)
            _dbHelper.close();
    }

    public SQLiteDatabase getDatabase() {
        if (!_bConnectionIsOpen)
            open();
        return _database;
    }

}
