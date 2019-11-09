package com.example.displaydate;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/")
public class DisplayController {
	
	@RequestMapping("")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		model.addAttribute("date", "Saturday, the 22 of January, 2028");
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		LocalTime time = LocalTime.now(); 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		model.addAttribute("time", time.format(formatter));
		return "time.jsp";
	}
}

