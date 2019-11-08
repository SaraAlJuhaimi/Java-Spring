package com.sara.gettingfamiliarwithrouting;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	
	@RequestMapping("{input}")
    public String showDojo(@PathVariable("input") String input){
		if(input.equals("dojo")) {
			return "The dojo is awesome!";
		}
		if(input.equals("burbank-dojo")) {
			return "Burbank Dojo is located in Southern California";
		}
		if(input.equals("san-jose")){
			return "SJ dojo is the headquarters";
		}
		return "nothing";
    }
}
