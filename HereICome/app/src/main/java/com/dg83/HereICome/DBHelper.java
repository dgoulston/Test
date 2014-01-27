package com.dg83.HereICome;

import android.database.sqlite.SQLiteDatabase;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBHelper {
  DBHelper(){}

  public static void initDatabase(SQLiteDatabase database) {
    createLocationTable(database);
    createContactTable(database);
    createLocConMapTable(database);
  }
  public static void insertDefaults(SQLiteDatabase database){
	insertLocationTableDefault1(database);
	insertLocationTableDefault2(database);
	insertContactTableDefault1(database);
	insertLocConTableDefault1(database);
  } 
  
  private static void createLocationTable(SQLiteDatabase database) {
    String creationSql = "CREATE TABLE IF NOT EXISTS "
            + MainDao.TABLE_LOC + "("
            + Location.SQL_LOC_ID + " integer primary key autoincrement, "
			+ Location.SQL_LOC_NAME + " text not null, "
            + Location.SQL_LOC_POSTCODE + " text not null,"
            + Location.SQL_LOC_LAT + " real,"
            + Location.SQL_LOC_LONG + " real,"
            + Location.SQL_LOC_ADV_LOC + " text,"
            + Location.SQL_LOC_STATE + " text not null"
            + ");";
	database.execSQL(creationSql);
  }

  private static void createContactTable(SQLiteDatabase database) {
	String creationSql = "CREATE TABLE IF NOT EXISTS "
			+ MainDao.TABLE_CON + "("
            + Contact.SQL_CON_ID + " integer primary key autoincrement, "
            + Contact.SQL_CON_NAME + " text not null,"
            + Contact.SQL_CON_NICKNAME + " text,"
            + Contact.SQL_CON_NUMBER + " text,"
            + Contact.SQL_CON_EMAIL + " text "
            + ");";
	database.execSQL(creationSql);
  }
  
  private static void createLocConMapTable(SQLiteDatabase database) {
	String creationSql = "CREATE TABLE IF NOT EXISTS "
		    + MainDao.TABLE_LOCCON + "("
            + LocConMap.SQL_LOCCON_ID + " integer primary key autoincrement, "
            + LocConMap.SQL_LOCCON_LOCID + " integer not null,"
            + LocConMap.SQL_LOCCON_CONID + " integer not null,"
			+ LocConMap.SQL_LOCCON_DISTANCE + " real not null,"
            + LocConMap.SQL_LOCCON_DAYS + " text,"
            + LocConMap.SQL_LOCCON_START_TIMES + " text,"
            + LocConMap.SQL_LOCCON_END_TIMES + " text,"
            + "FOREIGN KEY(" + LocConMap.SQL_LOCCON_LOCID + ") REFERENCES " + MainDao.TABLE_LOC + "(" + Location.SQL_LOC_ID + "),"
			+ "FOREIGN KEY(" + LocConMap.SQL_LOCCON_CONID + ") REFERENCES " + MainDao.TABLE_CON + "(" + Contact.SQL_CON_ID + ")"
            + ");";
	database.execSQL(creationSql);
  }
		
  private static void insertLocationTableDefault1(SQLiteDatabase database) {
    String insertSQL = "insert into "
            + MainDao.TABLE_LOC + " values (0,'EC2V 5HA',51.516182,-0.090827,'','ACTIVE') ";
    database.execSQL(insertSQL);
  }
	
  private static void insertLocationTableDefault2(SQLiteDatabase database) {
    String insertSQL = "insert into "
            + MainDao.TABLE_LOC + " values (0,'EC2A 4BT',51.515615,-0.107893,'','ACTIVE') ";
    database.execSQL(insertSQL);
  }	
   
  private static void insertContactTableDefault1(SQLiteDatabase database) {
    String insertSQL = "insert into "
            + MainDao.TABLE_CON + " values (0,'Darren','Dal'','07947391145','dal1983@gmail.com') ";
    database.execSQL(insertSQL);
  }
     
  private static void insertLocConTableDefault1(SQLiteDatabase database) {
    String insertSQL = "insert into "
            + MainDao.TABLE_LOCCON + " values (0,0,0,2) ";
    database.execSQL(insertSQL);
  }

  public static Time textToTime(String dbTime) {
      Date date;
      DateFormat formatter = new SimpleDateFormat("H:mm:ss");
      try {
        date = (Date)formatter.parse(dbTime);
      }
      catch (ParseException e) {
        return new Time(0);
      }
      return new Time(date.getTime());
  }

    public static String timeToText(Time dbTime) {
        return (new SimpleDateFormat("H:mm:ss").format(dbTime));
    }
}


