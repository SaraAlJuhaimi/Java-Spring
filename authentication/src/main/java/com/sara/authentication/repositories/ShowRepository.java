package com.sara.authentication.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sara.authentication.models.Show;

@Repository
public interface ShowRepository extends CrudRepository<Show, Long> {
    Show findByTitle(String email);
	List<Show> findAll();
	Optional<Show> findById(Long id);
}
