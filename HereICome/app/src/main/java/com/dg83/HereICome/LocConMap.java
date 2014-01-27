package com.dg83.HereICome;

import java.sql.Time;

public class LocConMap
{
    public static final String SQL_LOCCON_ID = "Id";
	public static final String SQL_LOCCON_LOCID = "LocationId";
	public static final String SQL_LOCCON_CONID = "ContactId";
	public static final String SQL_LOCCON_DISTANCE = "Distance";
    public static final String SQL_LOCCON_DAYS = "Days";
    public static final String SQL_LOCCON_START_TIMES = "StartTime";
    public static final String SQL_LOCCON_END_TIMES = "EndTime";

    public static final String[] SQL_LOCCON_ALL_COLUMNS = {
            SQL_LOCCON_ID, SQL_LOCCON_LOCID, SQL_LOCCON_CONID, SQL_LOCCON_DISTANCE,
            SQL_LOCCON_DAYS, SQL_LOCCON_START_TIMES, SQL_LOCCON_END_TIMES };

	private int id;
	private int locationId;
	private int contactId;
	private double distance;
    private String days;
    private Time startTime;
    private Time endTime;



    LocConMap(int id, int locationId, int contactId, double distance,
              String days, Time startTime, Time endTime) {
        this.id = id;
        this.locationId = locationId;
        this.contactId = contactId;
        this.distance = distance;
        this.days = days;
        this.startTime = startTime;
        this.endTime = endTime;
    }

	public int getId() { return id; } 
	
	public void setId(int id) { this.id = id; } 
	
	public int getLocationId() { return locationId; } 
	
	public void setLocationId(int locationId) { this.locationId = locationId; }
	
	public int getContactId() { return contactId; } 
	
	public void setContactId(int contactId) { this.contactId = contactId; }
	
	public double getDistance() { return distance; }
	
	public void setDistance(double distance) { this.distance = distance; } 

    public String getDays() { return days; }

    public void setDays(String days) { this.days = days; }

    public Time getStartTime() { return startTime; }

    public Time getEndTime() { return endTime; }

    public void setEndTime(Time endTime) { this.endTime = endTime; }
}