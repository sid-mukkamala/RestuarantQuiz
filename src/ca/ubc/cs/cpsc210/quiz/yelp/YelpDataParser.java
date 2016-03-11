package ca.ubc.cs.cpsc210.quiz.yelp;



import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import ca.ubc.cs.cpsc210.quiz.model.Restaurant;
import ca.ubc.cs.cpsc210.quiz.model.City;
import ca.ubc.cs.cpsc210.quiz.model.Neighbourhood;
import ca.ubc.cs.cpsc210.quiz.model.Category;
/**
 * Parser for JSON data returned by Yelp.
 */
public class YelpDataParser {


    public YelpDataParser(){
    }

    public static List<Restaurant> parseRestaurantData(String response,
                                                       String yelpCityFilter)
            throws JSONException {


        JSONObject obj = new JSONObject(response.toString());
        List<Restaurant> ress = new ArrayList<Restaurant>();

        JSONArray business = obj.getJSONArray("businesses");
        for (int i = 0; i < business.length(); i++) {
            JSONObject businessobj = business.getJSONObject(i);
            Boolean incity = business.getJSONObject(i).getJSONObject("location").getString("city").equals(yelpCityFilter);

            if (incity
                    &&
                    !business.getJSONObject(i).getBoolean("is_closed")) {

                JSONObject location = businessobj.getJSONObject("location");
                String id = businessobj.getString("id");
                JSONArray addressarray = location.getJSONArray("address");
                String address = addressarray.getString(0);
                String postalcode;
                try {
                    postalcode = location.getString("postal_code"); }
                catch (JSONException j) {
                    postalcode = null;}



                JSONArray categories = businessobj.getJSONArray("categories");

                List<Category> categoryList = new ArrayList<Category>();




                for (int a =0; a<categories.length(); a++)
                {
                    Category cate = new Category(categories.getJSONArray(a).getString(0), categories.getJSONArray(a).getString(1));
                    categoryList.add(cate);
                }
                String stateCode = location.getString("state_code");
                String countryCode = location.getString("country_code");
                String cityn = location.getString("city");
                City city = new City(cityn, stateCode, countryCode);

                String name = business.getJSONObject(i).getString("name");

                try {
                    JSONArray neighborhoodsArray = location.getJSONArray("neighborhoods");
                    Neighbourhood neighbourhood = new Neighbourhood(neighborhoodsArray.getString(0), city);
                    Restaurant restaurant = new Restaurant(name, categoryList, id, address, postalcode, neighbourhood);

                    ress.add(restaurant);


                } catch (JSONException e) {
                    Restaurant restaurant = new Restaurant(name, categoryList, id, address, postalcode, city);
                    ress.add(restaurant);


                }
            }

        }
        return ress; }
}