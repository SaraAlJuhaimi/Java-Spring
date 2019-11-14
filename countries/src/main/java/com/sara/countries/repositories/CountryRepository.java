package com.sara.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sara.countries.models.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long>{
	
	@Query(value="SELECT countries.name, languages.language, languages.percentage FROM countries JOIN languages ON countries.code = languages.country_code WHERE language = 'Slovene'", nativeQuery=true)
	List<Object[]> getCountryWhereName(String name);
	
	@Query(value="SELECT ANY_VALUE(countries.name) AS country, COUNT(cities.id) AS number_cities FROM countries JOIN cities ON countries.code = cities.country_code GROUP BY countries.code ORDER BY COUNT(cities.id) desc", nativeQuery=true)
	List<Object[]> q2();
	
	//What query would you run to get all the countries with Surface Area below 501 
	//and Population greater than 100,000? (2)
	@Query(value="SELECT countries.name FROM countries WHERE countries.surface_area < 501 AND countries.population > 100000", nativeQuery=true)
	List<Object[]> q5();
	
	@Query(value="SELECT name, government_form, capital, life_expectancy FROM countries WHERE government_form = 'Constitutional Monarchy' and capital > 200 and life_expectancy > 75", nativeQuery=true)
	List<Object[]> q6();
	
	//What query would you run to get all the cities of Argentina inside the Buenos Aires district and have the population greater than 500, 000? 
	//The query should return the Country Name, City Name, District, and Population.
	@Query(value="SELECT countries.name AS country_name, cities.name AS city_name, cities.district, cities.population FROM countries JOIN cities ON cities.country_id = countries.id WHERE countries.name = 'Argentina' AND cities.district = 'Buenos Aires' AND cities.population > 500000", nativeQuery=true)
	List<Object[]> q7();
	
	@Query(value="SELECT region, COUNT(id) AS number_countries FROM countries GROUP BY region ORDER BY COUNT(id) desc", nativeQuery=true)
	List<Object[]> q8();

}
