package ca.ubc.cs.cpsc210.quiz.google;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ca.ubc.cs.cpsc210.quiz.model.LatLng;
import ca.ubc.cs.cpsc210.quiz.model.Leg;
import ca.ubc.cs.cpsc210.quiz.model.Route;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Parser for response from Google Directions API.
 */
public class GoogleDirectionsParser {

    public GoogleDirectionsParser() {}



static Route art;


    public static Route parseRoute(java.lang.String response)
            throws org.json.JSONException {

art = new Route();


        //creating object JSON from string response
        JSONObject obj = new JSONObject(response);
        //extracting routes as a JSON array
        JSONArray routejson = obj.getJSONArray("routes");

        //extract legs from within routes
        JSONArray legs = routejson.getJSONObject(0).getJSONArray("legs");
        //Leg leg1 = new Leg();


        int distance= 0;


       for (int i =0; i<legs.length();i++) {

           //go over every leg and get the items in the legs as objects
           JSONObject leg = legs.getJSONObject(i);

           //create new real leg
           Leg legg = new Leg();


           distance = leg.getJSONObject("distance").getInt("value");


           //go through those objects and find distance and set to a variablr
           //leg1.setDistance(routedistance);

           //get the int value of distance and set to the real leg distance
           legg.setDistance(distance);

           //another of the objects is steps which we will make into an array so we can iterate over


           JSONArray steps = legs.getJSONObject(i).getJSONArray("steps");

            for (int j =0; j<steps.length();j++) {
                String tt =steps.getJSONObject(j).getJSONObject("polyline").getString("points");
                PolylineDecoder ply1 = new PolylineDecoder();
                List<LatLng> lstlngspt = ply1.decodePoly(tt);

                    legg.addAllPoints(lstlngspt);




            }

           art.addLeg(legg);


        }



        return  art;

    }

}

