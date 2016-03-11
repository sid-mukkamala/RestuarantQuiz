package ca.ubc.cs.cpsc210.quiz.model;
import java.util.ArrayList;
import java.util.List;


/**
 * Represents a route having a list of legs and a distance.
 */
public class Route extends java.lang.Object{
    private List<Leg> legs;
    private int distance;


    public Route() {
        legs = new ArrayList<Leg>();
        this.distance= 0;


    }

    public void addLeg(Leg leg) {
        legs.add(leg);
    }

    public int getDistance() {
        int totalDistance = 0;

        for (int i =0;i<legs.size();i++) {

            totalDistance = totalDistance + legs.get(i).getDistance();
        }

        return totalDistance;
    }

    public java.util.List<Leg> getLegs() {

        return legs;
    }



}
