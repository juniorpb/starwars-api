package com.b2w.starwars.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.b2w.starwars.entity.PlanetaEntity;
import java.util.List;

@Repository
public interface PlanetaRepository extends CrudRepository<PlanetaEntity, Long>{
	
	List<PlanetaEntity> findAll();
	
	PlanetaEntity findById(String id);
	
	PlanetaEntity findByNome(String nome);

}
