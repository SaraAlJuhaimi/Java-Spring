package com.sara.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sara.relationships.models.License;
import com.sara.relationships.models.Person;
import com.sara.relationships.services.LicenseService;
import com.sara.relationships.services.PersonService;

@Controller
public class LicenseController {
private final LicenseService licenseService;

	@Autowired
	private PersonService personService;
	
	public LicenseController(LicenseService licenseService) {
		this.licenseService = licenseService;
	}
	
	@RequestMapping("/licenses/new")
    public String newLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> pers = personService.allNullPersons();
        model.addAttribute("pers", pers);
		return "newLicense.jsp";
    }
	
	@RequestMapping(value="/licenses/new", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("license") License license, BindingResult result) {
        if (result.hasErrors()) {
            return "/newLicense.jsp";
        } else {
        	Person p = license.getPerson();
        	license.setNumber("00000"+p.getId().toString());
        	licenseService.createLicense(license);
        	p.setLicense(license);
            return "/showPerson.jsp";
        }
    }


}
