package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private String job;
    private Spinner s;
    private EditText nameField, locationField, bidField, addressField;
    private MyApplicationData appState;
    private String[] arraySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        //Creates data for the dropdown menu
        this.arraySpinner = new String[]{
                "Fisher", "Distributor", "Processor", "Fish Monger"
        };
        //adds the data to the spinner object
        s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        s.setAdapter(adapter);

        submitButton = (Button) findViewById(R.id.submitButton);
        bidField=(EditText) findViewById(R.id.bNumber);
        nameField = (EditText) findViewById(R.id.name);
        locationField = (EditText) findViewById(R.id.location);
        addressField = (EditText) findViewById(R.id.address);
    }

    /**
     *
     * @param v
     * Gets the values from the data fields and pushes it to the database by creating a new Contact
     * and adding creating a new entry at the ID based on it's ID
     */
    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        job = s.getSelectedItem().toString();
        String ID=bidField.getText().toString();
        int businessID = Integer.parseInt(bidField.getText().toString());
        String name = nameField.getText().toString();
        String location = locationField.getText().toString();
        String primaryBusiness = job;
        String address = addressField.getText().toString();
        Contact person = new Contact(businessID, name, primaryBusiness, address, location);

        appState.firebaseReference.child(ID).setValue(person);

        finish();

    }
}
