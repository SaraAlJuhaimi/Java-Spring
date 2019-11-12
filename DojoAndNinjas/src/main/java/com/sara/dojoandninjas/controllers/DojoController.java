package com.sara.dojoandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sara.dojoandninjas.models.Dojo;
import com.sara.dojoandninjas.models.Ninja;
import com.sara.dojoandninjas.services.DojoService;

@Controller
public class DojoController {
	private final DojoService dojoService;
	
	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
	@RequestMapping("/dojos/{id}")
    public String index(Model model, @PathVariable("id") Long id) {
        Dojo dojo = dojoService.findDojo(id);
        model.addAttribute("dojo", dojo);
        return "/dojo.jsp";
    }
	
	@RequestMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "/newDojo.jsp";
    }
	
	@RequestMapping(value="/dojos/new", method=RequestMethod.POST)
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/dojos/new";
        } else {
        	dojoService.createDojo(dojo);
            return "redirect:/dojos/new";
        }
    }


}
