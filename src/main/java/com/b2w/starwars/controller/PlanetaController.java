package com.b2w.starwars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.b2w.starwars.entity.PlanetaEntity;
import com.b2w.starwars.services.PlanetaService;
import com.b2w.starwars.services.utils.GenericResponse;
import com.b2w.starwars.controller.SwapiController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/planeta")
public class PlanetaController {
	
	@Autowired
	PlanetaService planetaService;
	
	@GetMapping("/list")
	public List<PlanetaEntity> findAllPlaneta() throws Exception {
		List<PlanetaEntity> listaPlanetas = planetaService.findAll();
		
		for (PlanetaEntity planetaEntity : listaPlanetas) {
			planetaEntity = findPlanetaAndSetQuantidadeFilmeSwapi(planetaEntity);
		}
		
		return listaPlanetas;
	}

	@PostMapping
	public PlanetaEntity createPlaneta(@RequestBody PlanetaEntity planetaEntity) throws Exception {
		
		if (findPlanetaByNome(planetaEntity) == null) {
			// if not exist planet name, create new
			return findPlanetaAndSetQuantidadeFilmeSwapi(planetaService.createPlaneta(planetaEntity));
		}
		
		// return if exist planet
		return findPlanetaByNome(planetaEntity);
	}

	@GetMapping("/{id}")
	public PlanetaEntity findPlanetaById(@PathVariable(value = "id") String id) throws Exception {
		PlanetaEntity planetaEntity = planetaService.findPlanetaById(id);
		
		return findPlanetaAndSetQuantidadeFilmeSwapi(planetaEntity);
	}

	@PostMapping("/nome")
	public PlanetaEntity findPlanetaByNome(@RequestBody PlanetaEntity planetaEntity) throws Exception {
		planetaEntity = planetaService.findPlanetaByNome(planetaEntity.getNome());
		
		return findPlanetaAndSetQuantidadeFilmeSwapi(planetaEntity);
	}

	@DeleteMapping("/delete/{id}")
	public GenericResponse deletePlaneta(@PathVariable(value = "id") String id) {
		PlanetaEntity planetaEntity = planetaService.findPlanetaById(id);
		GenericResponse genericResponse = new GenericResponse();
		
		if(planetaEntity == null) {
			genericResponse.setMessage("Planeta não encontrado");
			return genericResponse;
		}
		
		try {
			planetaService.deletePlaneta(planetaEntity);
			genericResponse.setMessage("Planeta excluído com sucesso");
			
		} catch (Exception e) {
			genericResponse.setMessage("Erro ao tentar excluir o planeta");
		}
		
		return genericResponse;
	}
	
	public PlanetaEntity findPlanetaAndSetQuantidadeFilmeSwapi(PlanetaEntity planetaEntity) throws Exception {
		
		if (planetaEntity == null) return planetaEntity;
		
		SwapiController swapiController = new SwapiController();
				
		planetaEntity.setQuantidadeFilmes(swapiController.getQuantidadeFilmes(planetaEntity.getNome(), 1));
		
		return planetaEntity;
	}
}
