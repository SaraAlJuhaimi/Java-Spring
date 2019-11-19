package com.sara.authentication.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sara.authentication.models.Rating;
import com.sara.authentication.models.Show;
import com.sara.authentication.models.User;
import com.sara.authentication.services.RatingService;
import com.sara.authentication.services.ShowService;
import com.sara.authentication.services.UserService;
import com.sara.authentication.validator.ShowValidator;
import com.sara.authentication.validator.UserValidator;

@Controller
public class ShowsController {
private final UserService userService;
private final ShowService showService;
private final RatingService ratingService;
private final UserValidator userValidator;
private final ShowValidator showValidator;


    public ShowsController(UserService userService, ShowService showService, RatingService ratingService, UserValidator userValidator, ShowValidator showValidator) {
        this.userService = userService;
        this.showService = showService;
        this.ratingService = ratingService;
        this.userValidator = userValidator;
        this.showValidator = showValidator;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	userValidator.validate(user, result);
        if(result.hasErrors()) {
        	return "registrationPage.jsp";
        }
        User u = userService.registerUser(user);
        session.setAttribute("userId", u.getId());
        return "redirect:/home";
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        boolean isAuthenticated = userService.authenticateUser(email, password);
        if(isAuthenticated) {
        	User u = userService.findByEmail(email);
            session.setAttribute("userId", u.getId());
            return "redirect:/home";
        }
        else {
        	model.addAttribute("error","Invalid Credentials!");
        	return "loginPage.jsp";
        	
        }
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        User u = userService.findUserById(userId);
    	model.addAttribute("user",u);
    	List<Object[]> avgs = ratingService.avg();
    	List<Show> shows = showService.allShows();
		int shows_length = shows.size()-1;
		List<Double> ratess = new ArrayList<>();
		for(int i=0 ; i<avgs.size() ; i++)
		{
			ratess.add((Double)avgs.get(i)[0]);
		}
		if(avgs.size()<shows.size()) {
			int num = shows.size() - avgs.size();
			for(int i=0 ; i<num ; i++) {
				ratess.add((double) 0);
			}
		}
		model.addAttribute("countries",ratess);	
    	model.addAttribute("showsLength", shows_length);
    	model.addAttribute("shows", shows);
    	return "homePage.jsp";
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/login";
    }
    
	@RequestMapping("/shows/new")
    public String newShow(Model model, @ModelAttribute("show") Show show) {
		return "newShow.jsp";
    }
	
	@RequestMapping(value="/shows/new", method=RequestMethod.POST)
    public String createShow(@Valid @ModelAttribute("show") Show show, BindingResult result) {
		showValidator.validate(show, result);
        if (result.hasErrors()) {
            return "newShow.jsp"; // (1)be careful dont redirct the page! only return the page so the validation can appear (2) add the dependency
        } else {
        	showService.createShow(show);
            return "redirect:/home";
        }
    }
	
	@RequestMapping("/shows/{id}")
	public String showShow(Model model, @PathVariable("id") Long id, HttpSession session) {
		Boolean rateError = (Boolean) session.getAttribute("rateError");
		if(rateError == null) {
			rateError = false;
		}
		if(rateError) {
			model.addAttribute("rateMessage","Rate is only between 1 and 5!");
			rateError = false;
	        session.setAttribute("rateError",rateError);
		}
		else {
			model.addAttribute("rateMessage","");
		}
		Show show = showService.findById(id);
		model.addAttribute("show", show);	
		Long userId = (Long) session.getAttribute("userId");
        User u = userService.findUserById(userId);
		model.addAttribute("show", show);	
        List<Rating> ratings = ratingService.findRatingsByShow(show);
		model.addAttribute("ratings", ratings);	
		return "oneShow.jsp";
	}
	

	@RequestMapping(value="/new/rate", method=RequestMethod.POST)
	public String addRate(HttpSession session,@RequestParam("rate") double rate, @ModelAttribute("rating") Rating rating, @RequestParam("showId") Long showId) {	
		boolean rateError = false;
		if(rate>5||rate<1) {
			rateError = true;
	        session.setAttribute("rateError",rateError);
			return "redirect:/shows/"+showId;
		}
		Long userId = (Long) session.getAttribute("userId");
		User u = userService.findUserById(userId);		
		Show show = showService.findById(showId);	
		Rating show_rate = new Rating(rate,u,show);
		ratingService.createRating(show_rate);
		return "redirect:/home";
	}
	
	@RequestMapping("/shows/{id}/edit")
    public String editShowPage(@PathVariable("id") Long id, Model model) {
		Show show = showService.findById(id);
		model.addAttribute("show", show);	
		return "editShow.jsp";
    }
	
	@RequestMapping(value="/shows/{id}/edit", method=RequestMethod.POST)
	public String editShow(@Valid @ModelAttribute("show") Show show, BindingResult result, RedirectAttributes attr, @PathVariable("id") Long id) {
		showValidator.validate(show, result);
		if (result.hasErrors()) {
			attr.addFlashAttribute("org.springframework.validation.BindingResult.show", result);
		    attr.addFlashAttribute("message", "Title and Network fields are required!");
			return "redirect:/shows/"+id+"/edit";
		}
		else {
			showService.updateShow(show);
			return "redirect:/home";
		}
	}
		
	@RequestMapping(value="/deleteShow/{id}")
    public String destroy(@PathVariable("id") Long id) {
        showService.deleteShow(id);
        return "redirect:/home";
    }

}
