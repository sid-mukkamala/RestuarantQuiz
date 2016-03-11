package ca.ubc.cs.cpsc210.quiz.model;

import java.util.ArrayList;

/**
 * Represents a restaurant having a street address, geographical area, postal code, name, id categories
 * and list of reviews.
 */
public class Restaurant {

    private String name;
    private java.util.List<Category> categories;
    private String id;
    private String address;
    private String postalCode;
    private GeoArea geographicalArea;

    public Restaurant(String name,java.util.List<Category> categories,String id,String address,String postalCode,GeoArea geographicalArea ) {
        this.name=name;
        this.categories = new ArrayList<Category>();
        this.id= id;
        this.address=address;
        this.postalCode= postalCode;
        this.geographicalArea= geographicalArea;
        }

    public java.lang.String getAddress() {
        return address;
    }
    public java.lang.String getName() {
        return name;
    }
    public java.util.List<Category> getCategories(){
        return  categories;
    }
    public java.lang.String getId(){
        return id;
    }
    public java.lang.String getPostalCode(){
        return postalCode;
    }
    public GeoArea getGeographicalArea(){
        return geographicalArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Restaurant otherres = (Restaurant) o;


        return this.name.equals(otherres.name)
                && this.id.equals(otherres.id)
                && this.categories.equals(otherres.categories)
                && this.address.equals(otherres.address)
                && this.postalCode.equals(otherres.postalCode)
                && this.geographicalArea.equals(otherres.geographicalArea);

    }

    @Override
    public int hashCode() {
        int result = 1;
        final int prime=43;
        result = prime*result +((id==null) ? 0: id.hashCode());
        result = prime*result +((name==null) ? 0: name.hashCode());
        result = prime*result +((categories==null) ? 0: categories.hashCode());
        result = prime*result +((address==null) ? 0: address.hashCode());
        result = prime*result +((postalCode==null) ? 0: postalCode.hashCode());
        result = prime*result +((geographicalArea==null) ? 0: geographicalArea.hashCode());

        return result;
    }


    public String toString() {
        if (postalCode==null) {
            return name+","+geographicalArea;}
        else
        return name+","+geographicalArea+","+postalCode;
    }

}
























