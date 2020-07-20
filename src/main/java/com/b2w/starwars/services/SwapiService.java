package com.b2w.starwars.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SwapiService {
	private static String URL_CONNECT_SWAPI = "https://swapi.dev/api/planets/?page=";
	
	public static String getPlanetsSwapi(String nomePlaneta, long pageNumber) throws Exception {
		BufferedReader responseSwapiBufferedReader;
		StringBuilder newResponseSwapiStringBuilder = new StringBuilder();
		String responseSwapiReadLine = null;
		
		HttpURLConnection swapi_connect = (HttpURLConnection) new URL(URL_CONNECT_SWAPI + pageNumber + "&format=json").openConnection();
		swapi_connect.setRequestProperty("Content-Type", "application/json");
		swapi_connect.setRequestMethod("GET");
		
		int responseCode = swapi_connect.getResponseCode();
	   
	    if (200 <= responseCode && responseCode <= 299) {
	    	responseSwapiBufferedReader = new BufferedReader(new InputStreamReader(swapi_connect.getInputStream()));
	    	
	    } else {
	    	responseSwapiBufferedReader = new BufferedReader(new InputStreamReader(swapi_connect.getErrorStream()));
	    }
	
        while ((responseSwapiReadLine = responseSwapiBufferedReader.readLine()) != null) {
        	newResponseSwapiStringBuilder.append(responseSwapiReadLine + "\n");
        }
        
        responseSwapiBufferedReader.close();
        
        return newResponseSwapiStringBuilder.toString();

	}
}
