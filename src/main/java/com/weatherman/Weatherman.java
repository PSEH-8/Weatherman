package com.weatherman;

import com.weatherman.com.weatherman.http.HttpClient;
import jdk.nashorn.internal.parser.JSONParser;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("weather")
public class Weatherman {

    private static String URL = "http://samples.openweathermap.org/data/2.5/forecast?appid=b6907d289e10d714a6e88b30761fae22";
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt(@QueryParam("cityId")String city) throws IOException {
        HttpURLConnection connection = HttpClient.getConnectionUrl(URL + "?id=" + city, "GET");
        String response = HttpClient.getResponse(connection);

        return parseResponse(response);
    }

    public String parseResponse(String response){
        //TODO: Have to properly parse data
        StringBuilder result = new StringBuilder();
        if(response.contains("scattered clouds"))
        {
            result.append("Carry umbrella");
        }else{
            result.append("Use sunscreen lotion");
        }

        return result.toString();
    }

}
