package com.sara.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sara.countries.models.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
	@Query(value="SELECT cities.name, cities.population FROM cities JOIN countries ON cities.country_id = countries.id WHERE countries.name = 'Mexico' and cities.population > 500000 ORDER BY cities.population desc", nativeQuery=true)
	List<Object[]> q3();
	
	//What query would you run to get all the cities in Mexico with a population of greater than 500,000? 
	//Your query should arrange the result by population in descending order.
}
