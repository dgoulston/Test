package com.dg83.HereICome;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.SQLException;
import java.util.ArrayList;
import java.util.List;

//SQL Class
public class ContactDao implements MainDao {
    public static final String TABLE_CON = "ContactData";

    public ContactDao(){};

    public List<Contact> getAllContacts(SQLiteDatabase database){
	    try {
		  Cursor cursor = database.query(TABLE_CON,
                Contact.SQL_CON_ALL_COLUMNS, null, null, null, null, Contact.SQL_CON_NAME);
          if(cursor.getCount() == 0)
              return new ArrayList<Contact>();
		  cursor.moveToFirst();

			List<Contact> contactList = new ArrayList<Contact>();
			while (!cursor.isAfterLast()) {
				contactList.add( rowToContact(cursor));
				cursor.moveToNext();
			}        
			cursor.close();				
			return contactList;
		} catch (Exception e) {

		  return new ArrayList();
		}
	}

    private Contact getContact(int id,SQLiteDatabase database) {
        try {
            Cursor cursor = database.query(TABLE_CON,
                    Contact.SQL_CON_ALL_COLUMNS, null, null, null, null, null);
            if (cursor.getCount() != 1) {
                //TODO//
                //ERROR
            }
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                Contact contact = rowToContact(cursor);
                cursor.close();
                return (contact);
            }
        } catch (Exception e) {

            return new Contact();
        }
        return new Contact();
    }

	private Contact rowToContact(Cursor cursor)	{
		return (new Contact(
			cursor.getInt(cursor.getColumnIndex(Contact.SQL_CON_ID)),
			cursor.getString(cursor.getColumnIndex(Contact.SQL_CON_NAME)),
			cursor.getString(cursor.getColumnIndex(Contact.SQL_CON_NICKNAME)),
			cursor.getString(cursor.getColumnIndex(Contact.SQL_CON_NUMBER)),
			cursor.getString(cursor.getColumnIndex(Contact.SQL_CON_EMAIL))));
	}

    public boolean addContact(SQLiteDatabase database, Contact contact)
    {
        ContentValues values = new ContentValues();

        values.put(Contact.SQL_CON_NAME, contact.getName());
        values.put(Contact.SQL_CON_NICKNAME, contact.getNickName());
        values.put(Contact.SQL_CON_NUMBER, contact.getNumber());
        values.put(Contact.SQL_CON_EMAIL, contact.getEmail());

        long insertId = -1;
        try {
            insertId = database.insertOrThrow(TABLE_CON, null,
                values);
        }
        catch (SQLException e)
        {
            //TODO Handle exception
            return false;
        }
        //Cursor cursor = database.query(TABLE_CON,
        //       Contact.SQL_CON_ALL_COLUMNS, Contact.SQL_CON_ID + " = " + insertId, null,
        //        null, null, null);
        //cursor.moveToFirst();
        //Contact newContact = rowToContact(cursor);
        //cursor.close();
        //return newContact;
        return (insertId == -1 ? false : true);

    }

    public boolean updateContact(SQLiteDatabase database, Contact contact)
    {
        ContentValues values = new ContentValues();

        values.put(Contact.SQL_CON_NAME, contact.getName());
        values.put(Contact.SQL_CON_NICKNAME, contact.getNickName());
        values.put(Contact.SQL_CON_NUMBER, contact.getNumber());
        values.put(Contact.SQL_CON_EMAIL, contact.getEmail());

        String whereClause = " Id = " + contact.getId();
        long rowsUpdated = -1;
        try {
            rowsUpdated = database.update(TABLE_CON, values, whereClause, null);
        }
        catch (SQLException e)
        {
            //TODO Handle exception
            return false;
        }

        return (rowsUpdated != 1 ? false : true);

    }
  
}