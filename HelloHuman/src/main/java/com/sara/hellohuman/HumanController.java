package com.sara.hellohuman;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HumanController {
	@RequestMapping("")
	public String coding() {
		return "<h1>Hello Human!</h1><br><p>Welcome to SpringBoot!</p>";
	}

	@RequestMapping("{input}")
    public String showDojo(@PathVariable("input") String input){
		return "<h1>Hello "+input+"!</h1><br><p>Welcome to SpringBoot!</p>";
	}
}
