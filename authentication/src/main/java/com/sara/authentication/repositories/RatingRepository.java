package com.sara.authentication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sara.authentication.models.Rating;
import com.sara.authentication.models.Show;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long>{
	List<Rating> findAll();
	List<Rating> findByShowOrderByValueAsc(Show show);
	@Query(value="SELECT AVG(value), show_id FROM ratings GROUP BY show_id", nativeQuery=true)
	List<Object[]> avg();
}
