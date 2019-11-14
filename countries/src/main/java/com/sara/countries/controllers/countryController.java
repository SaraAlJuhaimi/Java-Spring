package com.sara.countries.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sara.countries.services.ApiService;

@Controller
public class countryController {	
private final ApiService apiService;
	
	public countryController(ApiService apiService) {
		this.apiService = apiService;
	}
	
	@RequestMapping("/")
    public String index(Model model) {
		List<Object[]> countries = apiService.getCountryByName("Slovene");
		model.addAttribute("countries",countries);
        return "/index.jsp";
    }
	@RequestMapping("/q2")
    public String q2(Model model) {
		List<Object[]> countries = apiService.q2();
		model.addAttribute("countries",countries);
        return "/index.jsp";
    }
	
	@RequestMapping("/q3")
    public String q3(Model model) {
		List<Object[]> countries = apiService.q3();
		model.addAttribute("countries",countries);
        return "/index.jsp";
    }
	
	@RequestMapping("/q4")
    public String q4(Model model) {
		List<Object[]> countries = apiService.q4();
		model.addAttribute("countries",countries);
        return "/index.jsp";
    }
	
	@RequestMapping("/q5")
    public String q5(Model model) {
		List<Object[]> countries = apiService.q5();
		model.addAttribute("countries",countries);
        return "/index.jsp";
    }
	
	@RequestMapping("/q6")
    public String q6(Model model) {
		List<Object[]> countries = apiService.q6();
		model.addAttribute("countries",countries);
        return "/index.jsp";
    }
	
	@RequestMapping("/q7")
    public String q7(Model model) {
		List<Object[]> countries = apiService.q7();
		model.addAttribute("countries",countries);
        return "/index.jsp";
    }
	
	@RequestMapping("/q8")
    public String q8(Model model) {
		List<Object[]> countries = apiService.q8();
		model.addAttribute("countries",countries);
        return "/index.jsp";
    }
}

