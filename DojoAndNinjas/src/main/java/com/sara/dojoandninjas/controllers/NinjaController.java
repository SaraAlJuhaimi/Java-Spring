package com.sara.dojoandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sara.dojoandninjas.models.Dojo;
import com.sara.dojoandninjas.models.Ninja;
import com.sara.dojoandninjas.services.DojoService;
import com.sara.dojoandninjas.services.NinjaService;

@Controller
public class NinjaController {
	private final NinjaService ninjaService;

	@Autowired
	private DojoService dojoService;
	
	public NinjaController(NinjaService ninjaService) {
		this.ninjaService = ninjaService;
	}
	
	@RequestMapping("/ninjas/new")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
        model.addAttribute("dojos", dojoService.allDojos());
		return "/newNinja.jsp";
    }
	
	@RequestMapping(value="/ninjas/new", method=RequestMethod.POST)
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/ninjas/new";
        } else {
        	ninjaService.createNinja(ninja);
            return "redirect:/dojos/new";
        }
    }
	
}
