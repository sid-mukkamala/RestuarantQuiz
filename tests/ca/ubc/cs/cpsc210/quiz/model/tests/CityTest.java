package ca.ubc.cs.cpsc210.quiz.model.tests;


import ca.ubc.cs.cpsc210.quiz.model.City;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class CityTest {

    @Test
    public void testGetGeographicalString() {
        City city = new City("Vancouver", "BC", "CA");
        assertEquals("Vancouver, BC, CA", city.getCityString());

    }

    @Test
    public void testGetAllGeoStrings() {
        City city = new City("Vancouver", "BC", "CA");
        List<String> geoStrings = city.getAllGeoStrings();

        assertEquals(1, geoStrings.size());
        assertEquals("Vancouver, BC, CA", geoStrings.get(0));
    }
    @Test

    public void testobjectequals() {
        City van = new City("vancouver", "AB", "CA");
        City tan = new City("dropkick", "ac", "CA");

        assertFalse(van.equals(tan));


    }

}
