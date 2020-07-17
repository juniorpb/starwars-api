package com.b2w.starwars.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.b2w.starwars.entity.PlanetaEntity;
import com.b2w.starwars.repositories.PlanetaRepository;

import java.util.List;

@Service
public class PlanetaService {
	
	@Autowired
	PlanetaRepository planetaRepository;
	
	public List<PlanetaEntity> findAll(){
        return planetaRepository.findAll();
    }
	
	public Long insertOrUpdate(PlanetaEntity planetaEntity){
        return planetaRepository.save(planetaEntity).getId();
    } 
}
