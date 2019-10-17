package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // this will tell spring that it is basically a MVC controller
public class HomeController {

	// defining a controller method
	// the '/' indicates that this method will handle all kind of requests for GET and POST
	@RequestMapping("/")
	public String showPage() {
		// we are not returning complete name as in the spring config file 
		// the prefix and will be added to this
		return "main-menu";
	}
}
