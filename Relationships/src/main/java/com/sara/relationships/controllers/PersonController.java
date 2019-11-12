package com.sara.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sara.relationships.models.Person;
import com.sara.relationships.services.PersonService;

@Controller
public class PersonController {
private final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@RequestMapping("/persons/{id}")
    public String index(Model model, @PathVariable("id") Long id) {
        Person person = personService.findPerson(id);
        model.addAttribute("person", person);
        return "/showPerson.jsp";
    }
	
	@RequestMapping("/persons/new")
    public String newPerson(@ModelAttribute("person") Person person) {
		return "/newPerson.jsp";
    }
	
	@RequestMapping(value="/persons/new", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "/newPerson.jsp";
        } else {
        	personService.createPerson(person);
            return "/showPerson.jsp";
        }
    }

}
