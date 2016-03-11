package ca.ubc.cs.cpsc210.quiz.model.tests;

import ca.ubc.cs.cpsc210.quiz.model.LatLng;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by sid1995 on 10/24/2014.
 */
public class LatLngTest {


    @Test
    public void TestgetLang() {

        LatLng latLng1 = new LatLng(50,0.05);


        assertFalse(latLng1.getLat()==20);
        assertTrue(latLng1.getLng()== 0.05);
        //assertEquals(latLng1.getLat(),50);
    }






}
