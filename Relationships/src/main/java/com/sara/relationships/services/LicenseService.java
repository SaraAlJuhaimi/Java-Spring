package com.sara.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sara.relationships.models.License;
import com.sara.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
private final LicenseRepository licenseRepository;

	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public License createLicense(License l) {
        return licenseRepository.save(l);
    }

}
