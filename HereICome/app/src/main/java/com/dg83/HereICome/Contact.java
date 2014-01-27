
package com.dg83.HereICome;

public class Contact {

	//Table Contact Data	
    public static final String SQL_CON_ID = "Id";
	public static final String SQL_CON_NAME = "Name";
	public static final String SQL_CON_NICKNAME = "NickName";
	public static final String SQL_CON_NUMBER = "Number";
	public static final String SQL_CON_EMAIL = "Email";
    public static final String[] SQL_CON_ALL_COLUMNS = {
            SQL_CON_ID, SQL_CON_NAME, SQL_CON_NICKNAME, SQL_CON_NUMBER, SQL_CON_EMAIL};

	private int id;
	private String name;
	private String nickName;
	private String number;
	private String email;

	public Contact(String name, String nickName, String number, String email) {
		this.id = -1;
		this.name = name;
		this.nickName = nickName;
		this.number = number;
		this.email = email;		
	}

    public Contact(int id, String name, String nickName, String number, String email) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
        this.number = number;
        this.email = email;
    }


    public Contact() {}

	
	public int getId() { return id; }
	
	public void setId(int id) { this.id = id; }
	
	public String getName() { return name; }
	
	public void setName(String name) { this.name = name; }
	
	public String getNickName() { return nickName; }
	
	public void setNickName(String nickName) { this.nickName = nickName; }
	
	public String getNumber() { return number; }
	
	public void setNumber(String number) { this.number = number; }
	
	public String getEmail() { return email; } 
	
	public void setEmail(String email) { this.email = email;}
	
	@Override
    public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Contact that = (Contact) o;

		if (id != that.id) return false;
		if (!name.equals(that.name)) return false;
		if (!nickName.equals(that.nickName)) return false;
		if (!number.equals(that.number)) return false;
		if (!email.equals(that.email)) return false;

		return true;
	}

    public String toString(){
        return (nickName + " - " + name);
    }

}
