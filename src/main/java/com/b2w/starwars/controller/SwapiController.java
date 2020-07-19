package com.b2w.starwars.controller;

import org.json.JSONObject;

import com.b2w.starwars.services.SwapiService;

public class SwapiController {
	private String responseSwApi;
	private String planeta_swapi;
	private long incremetPageNumber = 1;
	
	public long getQuantidadeFilmes(String nomePlaneta, long pageNumber) throws Exception {
		
		responseSwApi = SwapiService.getPlanetsSwapi(nomePlaneta, pageNumber);
		
		JSONObject responseSwApiJson = new JSONObject(responseSwApi);
        
        for (int indexPlanetResponse = 0; indexPlanetResponse < responseSwApiJson.getJSONArray("results").length(); indexPlanetResponse ++) {
        	
        	planeta_swapi = responseSwApiJson.getJSONArray("results").getJSONObject(indexPlanetResponse).getString("name");
        	
        	if(nomePlaneta.equals(planeta_swapi)) {
        		return responseSwApiJson.getJSONArray("results").getJSONObject(indexPlanetResponse).getJSONArray("films").length();
        	}
        }
        
        if(responseSwApiJson.get("next").equals(null)) {
        	return 0;        	
        }
        
        return getQuantidadeFilmes(nomePlaneta, incremetPageNumber++);
        
	}
}
