package com.b2w.starwars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.b2w.starwars.entity.PlanetaEntity;
import com.b2w.starwars.services.PlanetaService;
import java.util.List;

@RestController
@RequestMapping("/api/v1/planeta")
public class PlanetaController {
	
	@Autowired
	PlanetaService planetaService
;	
	@GetMapping
    public List<PlanetaEntity> findAllPlaneta(){
        return planetaService.findAll();
    }

}
