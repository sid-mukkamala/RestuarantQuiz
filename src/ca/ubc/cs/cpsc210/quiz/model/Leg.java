package ca.ubc.cs.cpsc210.quiz.model;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Represents a leg that has an arbitrary number of points and a distance.  Part of a route.
 */
public class Leg extends java.lang.Object {
    private List<LatLng> latLngs;
    private int distance;


    public Leg() {
        latLngs = new ArrayList<LatLng>();
        this.distance =0;


    }

    public void addAllPoints(List<LatLng> pts) {
        for (int i=0;i<pts.size();i++) {

            latLngs.add(pts.get(i));
        }
    }

    public void addPoint(LatLng pt) {

        latLngs.add(pt);
    }

    public int getDistance() {

        return distance;
    }

    public List<LatLng> getPoints() {

        return latLngs;
    }

    public void setDistance(int distance) {
        this.distance= distance;
    }


}

