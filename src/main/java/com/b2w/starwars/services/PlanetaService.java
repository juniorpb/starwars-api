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
	
	// list all planets
	public List<PlanetaEntity> findAll(){
        return planetaRepository.findAll();
    }
	
	// create new planet
	public PlanetaEntity createPlaneta(PlanetaEntity planetaEntity){
        return planetaRepository.save(planetaEntity);
    }
	
	// search planet by id
	public PlanetaEntity findPlanetaById(String id){
        return planetaRepository.findById(id);
    }
	
	// list planet by name
	public PlanetaEntity findPlanetaByNome(String nome){
        return planetaRepository.findByNome(nome);
    }
	
	// delete planet
	public void deletePlaneta(PlanetaEntity planetaEntity) {
		planetaRepository.delete(planetaEntity);
	}
}
