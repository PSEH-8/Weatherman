package com.weatherman;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("city")
public class City {

    private static JSONArray array = new JSONArray();

    static {
        array.put(createCity(524901, "Moscow"));
        array.put(createCity(4119617, "London"));
    }

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCities(@QueryParam("count")int count) throws JSONException {


        return array.toString();
    }

    public static JSONObject createCity(int id, String city)  {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", id);
            jsonObject.put("name", city);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return  jsonObject;
    }

}
