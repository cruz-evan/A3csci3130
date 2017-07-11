package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */

public class Contact implements Serializable {

    public  int bNumber;
    public  String name;
    public  String primaryBusiness;
    public  String address;
    public  String location;

    public Contact() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    /**
     *
     * @param bNumber
     * @param name
     * @param primaryBusiness
     * @param address
     * @param location
     * Contact is changed to hold the necessary values
     */
    public Contact(int bNumber, String name, String primaryBusiness, String address, String location){
        this.bNumber = bNumber;
        this.name = name;
        this.primaryBusiness = primaryBusiness;
        this.address=address;
        this.location=location;
    }

    /**
     *
     * @return
     * Pushes the data to the database
     */
    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("bNumber", bNumber);
        result.put("name", name);
        result.put("primaryBusiness", primaryBusiness);
        result.put("address", address);
        result.put("location", location);

        return result;
    }
}
