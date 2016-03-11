package ca.ubc.cs.cpsc210.quiz.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a neighbourhood having a name in a city
 */
public class Neighbourhood implements GeoArea {
    private String neighborhoodname;
    private City city;

    public Neighbourhood(String neighbourhoodname, City city) {
        this.neighborhoodname = neighbourhoodname;
        this.city = city;

    }

    public City getCity() {
        return  city;
    }



    /**
     * Two neighbourhoods are equal if they have the same city and same name
     * When o is a City, this neighbourhood is equal to it, if it has the same city.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        // will have to revisit this if we add subtypes of GeoArea other than City and Neighborhood
        if (o == null || !(o instanceof GeoArea)) return false;

        // when o is a City, this Neighborhood is equal to o if the cities are equal
        if (o instanceof City)
            return city.equals(o);

        // must be a Neighborhood
        Neighbourhood other = (Neighbourhood) o;

        return (city.equals(other.city));
    }

    @Override
    public int hashCode() {
        return city != null ? city.hashCode() : 0;
    }


    public List<String> getAllGeoStrings() {
        List<String> geos=new ArrayList<String>();
        String[] splitstring=neighborhoodname.split(" ");
        for(int i=0;i<splitstring.length;i++){
            geos.add(splitstring[i]+", "+ city.getCityString());
            if (!(i==splitstring.length-1)){
                splitstring[i+1]=splitstring[i]+" "+splitstring[i+1];
            }

        }
        return geos;
    }

    public String getCityString(){

        return city.getCityString();
 }


}
