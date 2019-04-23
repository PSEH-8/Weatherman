package com.weatherman.com.weatherman.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {

    public static HttpURLConnection getConnectionUrl(String urPath, String method) throws IOException {
        URL url = new URL(urPath);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod(method);
        return conn;
    }

    public static String getResponse(HttpURLConnection http) throws IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (http.getInputStream())));

        System.out.println("Output from Server .... \n");
        String output;
        while ((output = br.readLine()) != null) {
            System.out.println(output);
            builder.append(output);
        }

        return builder.toString();
    }
}
