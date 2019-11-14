package com.sara.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sara.countries.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{
	@Query(value="SELECT countries.name, languages.language FROM countries JOIN languages ON languages.country_id = countries.id WHERE languages.percentage > 89 ORDER BY languages.percentage desc", nativeQuery=true)
	List<Object[]> q4();
	
	//What query would you run to get all languages in each country with a percentage greater than 89%? 
	//Your query should arrange the result by percentage in descending order.
}
