package com.dg83.HereICome;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ContactAPIFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private View rootView;
    private ContactProcessor contactProcessor;
    private int updateId = -1;
    private EditText etName;
    private EditText etNick;
    private EditText etPhone;
    private EditText etEmail;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ContactAPIFragment newInstance() {
        ContactAPIFragment fragment = new ContactAPIFragment();
        Bundle args = new Bundle();

        //args.putInt(ARG_SECTION_NUMBER, 111);
        //fragment.setArguments(args);
        return fragment;
    }

    public ContactAPIFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_contact_main, container, false);
        contactProcessor = new ContactProcessor(rootView.getContext());

        Button btnSave = (Button)rootView.findViewById(R.id.btnContactSave);
        btnSave.setOnClickListener(saveOnClick);
        etName = (EditText)rootView.findViewById(R.id.etContactName);
        etNick = (EditText)rootView.findViewById(R.id.etContactNick);
        etPhone = (EditText)rootView.findViewById(R.id.etContactPhone);
        etEmail = (EditText)rootView.findViewById(R.id.etContactEmail);

        populateContactSpinner();
        return rootView;
    }

    private void populateContactSpinner()
    {
        try{
            Spinner spnContactList = (Spinner)rootView.findViewById(R.id.spnContactList);
            List<Contact> contactList = contactProcessor.getContacts();
            contactList.add(0, new Contact("Select a Contact to Edit", "", "", ""));

            ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(rootView.getContext(),
                    android.R.layout.simple_spinner_item, contactList);

            spnContactList.setAdapter(spinnerArrayAdapter);
            spnContactList.setOnItemSelectedListener(contactItemSelectedListener);
        }
        catch (Exception e)
        {
            //TODO handle exceptions
            return;
        }
    }

    protected AdapterView.OnItemSelectedListener contactItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            Spinner spnContactList = (Spinner)rootView.findViewById(R.id.spnContactList);
            Contact contact = (Contact)spnContactList.getSelectedItem();
            setETValues(contact);

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    protected OnClickListener saveOnClick = new OnClickListener()
    {
        @Override
        public void onClick(View view) {
            boolean ret = false;
            if (updateId == -1)
                ret = contactProcessor.addContact(etName.getText().toString(), etNick.getText().toString(),
                    etPhone.getText().toString(), etEmail.getText().toString());
            else
                ret = contactProcessor.updateContact(updateId, etName.getText().toString(), etNick.getText().toString(),
                    etPhone.getText().toString(), etEmail.getText().toString());
            if (ret){
                Toast.makeText(rootView.getContext(),
                        (updateId == -1 ?  "Contact added successfully" : "Contact updated successfully")
                        ,Toast.LENGTH_SHORT).show();
                populateContactSpinner();
                ClearETValues();
            }
            else
            {
                Toast.makeText(rootView.getContext(), "Failed to write record. ",Toast.LENGTH_SHORT).show();
            }
        }
    };

    private void setETValues(Contact contact)    {
        updateId = contact.getId();
        if (updateId != -1) {
            etName.setText(contact.getName());
            etNick.setText(contact.getNickName());
            etPhone.setText(contact.getNumber());
            etEmail.setText(contact.getEmail());
        }
    }

    private void ClearETValues(){
        etName.setText("");
        etNick.setText("");
        etPhone.setText("");
        etEmail.setText("");
    }
}

