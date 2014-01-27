package com.dg83.HereICome;


public class Location {
    public static final String SQL_LOC_ID = "Id";
	public static final String SQL_LOC_NAME = "Name";
    public static final String SQL_LOC_POSTCODE = "PostCode";
	public static final String SQL_LOC_LAT = "Lat";
	public static final String SQL_LOC_LONG = "Long";
	public static final String SQL_LOC_ADV_LOC = "AdvancedLocation";
	public static final String SQL_LOC_STATE = "State";

    public static final String[] SQL_LOC_ALL_COLUMNS = {
            SQL_LOC_ID, SQL_LOC_NAME, SQL_LOC_POSTCODE,
            SQL_LOC_LAT, SQL_LOC_LONG, SQL_LOC_ADV_LOC, SQL_LOC_STATE
    };

	private int id;
	private String name;
	private String postcode; 
	private double latitude;
	private double longitude;
	private String advancedLocation;
	private String state;
	
	public Location(int id, String name, String postcode, double latitude, double longitude, String advancedLocation, String state) {
		this.id = id;
		this.name = name;
		this.postcode = postcode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.advancedLocation = advancedLocation;
		this.state = state;
	}
	
	public int getId() {return id; }
	
	public void setId(int id) {  this.id = id;  }
	
	public String getName() { return name; }

	public void setName(String name) { this.name = name;  }
	
	public String getPostcode() {return postcode;}
	
	public void setPostcode(String postcode) { this.postcode = postcode; }
	
	public double getLatitude() { return latitude; }
	
	public void setLatitude(double latitude) { this.latitude = latitude; }
	
	public double getLongitude() { return longitude; }
	
	public void setLongitude(double longitude) { this.longitude = longitude; }
	
	public String getAdvancedLocation() { return advancedLocation; }
	
	public void setAdvancedLocation(String AdvancedLocation) { this.advancedLocation = advancedLocation; }
	
	public String getState() { return state; }
	
	public void setState(String state) { this.state = state; }


}