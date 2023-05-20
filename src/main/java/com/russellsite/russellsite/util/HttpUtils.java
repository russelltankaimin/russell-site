package com.russellsite.russellsite.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class HttpUtils {

    public static int getStatusCode(HttpURLConnection connection) throws IOException {
        return connection.getResponseCode();
    }

    public static String getBodyString(HttpURLConnection connection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine = bufferedReader.readLine();
        bufferedReader.close();
        return inputLine;
    }

}
