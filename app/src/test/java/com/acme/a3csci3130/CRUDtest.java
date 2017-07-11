package com.acme.a3csci3130;

import org.junit.Test;
import static org.junit.Assert.*;
import com.acme.a3csci3130.CreateContactAcitivity;

/**
 * Created by Evan on 2017-07-10.
 */

public class CRUDtest {
    @Test
    public void checkCreate() throws Exception
    {
        CreateContactAcitivity createContact= new CreateContactAcitivity();
        int businessID=111000111;
        String name="Evan";
        String primaryBusiness="Fisher";
        String address="place";
        String location="AB";
        Contact person1 = new Contact(businessID, name, primaryBusiness, address, location);
        Contact person2 = new Contact(111000111, "Evan", "Fisher", "place", "AB");
        assertEquals(person1, person2);
    }
    public void checkUpdate() throws Exception
    {
        DetailViewActivity DetailView = new DetailViewActivity();

    }
    public void delete() throws Exception
    {
        DetailViewActivity DetailView = new DetailViewActivity();

    }
}
