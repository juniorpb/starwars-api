package com.b2w.starwars;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.b2w.starwars.entity.PlanetaEntity;
import com.b2w.starwars.repositories.PlanetaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PlanetaRepositoryTest {
	
	@Autowired
	private PlanetaRepository planetaRepository;
		
	@Test
	public void createPlaneta() {
		// String nome, String clima, String terreno
		PlanetaEntity planetaEntity = new PlanetaEntity("Dagobah", "murky", "swamp, jungles");
		this.planetaRepository.save(planetaEntity);
		Assertions.assertThat(planetaEntity.getId()).isNotNull();
		Assertions.assertThat(planetaEntity.getNome()).isEqualTo("Dagobah");
		Assertions.assertThat(planetaEntity.getClima()).isEqualTo("murky");
		Assertions.assertThat(planetaEntity.getTerreno()).isEqualTo("swamp, jungles");
	}

	@Test
	public void findPlanetaById() {
		PlanetaEntity planetaEntity = new PlanetaEntity("Dagobah", "murky", "swamp, jungles");
		this.planetaRepository.save(planetaEntity);
		Assertions.assertThat(planetaRepository.findById(planetaEntity.getId())).isNotNull();
	}

	@Test
	public void findPlanetaByNome() {
		PlanetaEntity planetaEntity = new PlanetaEntity("Dagobah", "murky", "swamp, jungles");
		this.planetaRepository.save(planetaEntity);
		String planetName = planetaRepository.findByNome(planetaEntity.getNome()).getNome();
		Assertions.assertThat(planetName).isEqualTo("Dagobah");
	}

    @Test
	public void listAllPlanetas() {
		PlanetaEntity planetaEntity = new PlanetaEntity("Dagobah", "temperate", "swamp, jungles");
		PlanetaEntity planetaEntity2 = new PlanetaEntity("Bespin", "murky", "gas giant");
		this.planetaRepository.save(planetaEntity);
		this.planetaRepository.save(planetaEntity2);
		
		// list planets
		List<PlanetaEntity> listPlanetaEntity = planetaRepository.findAll();
		Assertions.assertThat(listPlanetaEntity.size()).isEqualTo(2);
	}
    
	@Test
	public void deletePlaneta() {
		PlanetaEntity planetaEntity = new PlanetaEntity("Dagobah", "murky", "swamp, jungles");
		
		// save planetaEntity
		this.planetaRepository.save(planetaEntity);
		
		// delete planetaEntity
		planetaRepository.delete(planetaEntity);
		Assertions.assertThat(planetaRepository.findByNome("Dagobah")).isNull();
	}
}
