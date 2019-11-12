package com.sara.dojoandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sara.dojoandninjas.models.Dojo;
import com.sara.dojoandninjas.models.Ninja;
import com.sara.dojoandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;

	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public Ninja createNinja(Ninja n) {
        return ninjaRepository.save(n);
    }
}
