package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class DetailViewActivity extends Activity {

    private EditText nameField, locationField, bidField, addressField;
    private Spinner s;
    private MyApplicationData appState;
    Contact receivedPersonInfo;
    private String[] arraySpinner;
    private String job;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        appState = ((MyApplicationData) getApplicationContext());
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        nameField = (EditText) findViewById(R.id.name);
        locationField = (EditText) findViewById(R.id.location);
        addressField = (EditText) findViewById(R.id.address);

        /**
         * Repopulates the data field based on what was previously entered
         * and grabbed from the database
         */
        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            locationField.setText(receivedPersonInfo.location);
            addressField.setText(receivedPersonInfo.address);
        }

        //Creates data for the dropdown menu
        this.arraySpinner = new String[]{
                "Fisher", "Distributor", "Processor", "Fish Monger"
        };
        //adds the data to the spinner object
        s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        s.setAdapter(adapter);
    }

    /**
     *
     * @param v
     * Changes the data by using the previous business ID to get the changeable data
     */
    public void updateContact(View v){
        job = s.getSelectedItem().toString();
        String ID=Integer.toString(receivedPersonInfo.bNumber);
        int businessID = receivedPersonInfo.bNumber;
        String name = nameField.getText().toString();
        String location = locationField.getText().toString();
        String primaryBusiness = job;
        String address = addressField.getText().toString();
        Contact person = new Contact(businessID, name, primaryBusiness, address, location);

        appState.firebaseReference.child(ID).setValue(person);

        finish();
    }

    /**
     *
     * @param v
     * Deletes the data based on whatever ID was gotten
     */
    public void eraseContact(View v)
    {
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");
        String ID=Integer.toString(receivedPersonInfo.bNumber);
        appState.firebaseReference.child(ID).removeValue();

        finish();
    }
}
