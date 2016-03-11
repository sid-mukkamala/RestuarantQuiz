package ca.ubc.cs.cpsc210.quiz.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a name having a name, province/state code and country code
 */
public class City implements GeoArea {
    private String cityName;
    private String province;
    private String countryCode;

    public City(String cityName, String province, String countryCode) throws java.lang.IllegalArgumentException {
        this.cityName = cityName;

        if (province.length() != 2 || countryCode.length() != 2) {
            throw new IllegalArgumentException();
        }
        this.province = province;
        this.countryCode = countryCode;
    }

    public String getCityString() {

        return cityName + ", " + province + ", " + countryCode;

    }

    public java.util.List<java.lang.String> getAllGeoStrings() {
        List<String> listofgeostring = new ArrayList<String>();

        listofgeostring.add(this.getCityString());


        return listofgeostring;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        City othercity = (City) o;


        return this.cityName.equals(othercity.cityName)
                && this.province.equals(othercity.province)&& this.countryCode.equals(othercity.countryCode);

    }

    @Override
    public int hashCode() {
        int result = 1;
        final int prime=43;
        result = prime*result +((cityName==null) ? 0: cityName.hashCode());
        result = prime*result +((province==null) ? 0: province.hashCode());
        result = prime*result +((countryCode==null) ? 0: countryCode.hashCode());

        return result;
    }
}















