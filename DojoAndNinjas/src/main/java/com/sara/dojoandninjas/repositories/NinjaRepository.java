package com.sara.dojoandninjas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sara.dojoandninjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	
}
