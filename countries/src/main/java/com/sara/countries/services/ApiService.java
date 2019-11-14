package com.sara.countries.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sara.countries.models.Country;
import com.sara.countries.repositories.CityRepository;
import com.sara.countries.repositories.CountryRepository;
import com.sara.countries.repositories.LanguageRepository;

@Service
public class ApiService {
	private final CountryRepository countryRepository;
	private final CityRepository cityRepository;
	private final LanguageRepository languageRepository;
	
	public ApiService(CountryRepository countryRepository, CityRepository cityRepository,
			LanguageRepository languageRepository) {
		this.countryRepository = countryRepository;
		this.cityRepository = cityRepository;
		this.languageRepository = languageRepository;
	}
	
	public List<Object[]> getCountryByName(String name){
		List<Object[]> countries =  countryRepository.getCountryWhereName(name);
		return countries;
	}
	
	public List<Object[]> q2(){
		List<Object[]> countries =  countryRepository.q2();
		return countries;
	}
	
	public List<Object[]> q3(){
		List<Object[]> countries =  cityRepository.q3();
		return countries;
	}
	
	public List<Object[]> q4(){
		List<Object[]> countries =  languageRepository.q4();
		return countries;
	}
	
	public List<Object[]> q5(){
		List<Object[]> countries =  countryRepository.q5();
		return countries;
	}
	
	public List<Object[]> q6(){
		List<Object[]> countries =  countryRepository.q6();
		return countries;
	}
	
	public List<Object[]> q7(){
		List<Object[]> countries =  countryRepository.q7();
		return countries;
	}
	
	public List<Object[]> q8(){
		List<Object[]> countries =  countryRepository.q8();
		return countries;
	}

}
