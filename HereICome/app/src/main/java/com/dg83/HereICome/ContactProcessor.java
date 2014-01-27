package com.dg83.HereICome;

import android.content.Context;

import java.util.List;

public class ContactProcessor{
	private ContactDao contactDao;
    private DatabaseConnection databaseConnection;

	ContactProcessor(Context context) {
        contactDao = new ContactDao();
        databaseConnection = new DatabaseConnection(context);
    };

    public boolean addContact(String name, String nickName, String number, String email){
        return contactDao.addContact(databaseConnection.getDatabase(), new Contact(name,nickName,number,email));
    }

    public boolean updateContact(int Id, String name, String nickName, String number, String email){
        return contactDao.updateContact(databaseConnection.getDatabase(), new Contact(Id, name, nickName, number, email));
    }

    public List<Contact> getContacts(){
        return contactDao.getAllContacts(databaseConnection.getDatabase());
    }


}