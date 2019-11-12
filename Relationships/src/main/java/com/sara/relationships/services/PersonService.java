package com.sara.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sara.relationships.models.Person;
import com.sara.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	public List<Person> allNullPersons() {
        return personRepository.findByLicenseIsNull();
    }
	public Person createPerson(Person p) {
        return personRepository.save(p);
    }
	
	public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if(optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
    }
	

}
