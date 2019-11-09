package com.sara.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Counter {
	
	@RequestMapping("")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/counter")
	public String count(HttpSession session) {
		 Integer number = (Integer) session.getAttribute("count");
		 if(number == null) {
			 session.setAttribute("count", 0);
		 }
		 else {
			 number++;
			 session.setAttribute("count", number);
		 }
		 return "counter.jsp";
	}
}
