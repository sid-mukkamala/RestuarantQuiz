package ca.ubc.cs.cpsc210.quiz.model.tests;
import ca.ubc.cs.cpsc210.quiz.model.LatLng;
import ca.ubc.cs.cpsc210.quiz.model.Leg;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by sid1995 on 10/24/2014.
 */
public class LegTest {


    @Test
    public void testAddAllPoints() {
        Leg leg1 = new Leg();
        ArrayList<LatLng> lst = new ArrayList<LatLng>();
        LatLng l1 = new LatLng(0.5,0.6);
        LatLng l2 = new LatLng(0.55,0.66);
        LatLng l3 = new LatLng(0.65,0.56);
        LatLng l4 = new LatLng(0.556,0.665);

        lst.add(0,l1);
        lst.add(1,l2);
        lst.add(2,l3);
        lst.add(3,l4);

        leg1.addAllPoints(lst);

        assertTrue(leg1.getPoints().contains(l2));
        assertTrue(leg1.getPoints().contains(l3));


    }






}
