package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // its a must to tell that it's a controller
@RequestMapping("/hello")// parent mapping
public class HelloWorldController {
// need a controller method to show the initial HTML form
	@RequestMapping("/showForm") // sub mappings (relative)
	public String showForm()
	{
		// will be added with suffix and prefix to be viewed as /WEB-INF/view/helloworld-form.jsp
		return "helloworld-form";
	}
	// need a controller method to process the HTML form
	@RequestMapping("/processForm") // sub mappings (relative)
	public String processForm()
	{
		return "helloworld";
	}
	// need a controller method to read from data and
	// add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request,Model model)
	{
		// read the request parameter from the HTML form
		String theName=request.getParameter("studentName");
		// convert the data to all caps
		theName=theName.toUpperCase();
		// create the message
		String result="Yo!!!! "+theName;
		// add message to the model
		model.addAttribute("message",result);
		return "helloworld";
	}
	@RequestMapping("/processFormVersionThree")
	public String processFormWithAnnotations(@RequestParam("studentName")String theName,Model model)
	{
		// convert the data to all caps
		theName=theName.toUpperCase();
		// create the message
		String result="hey my friend!!!! "+theName;
		// add message to the model
		model.addAttribute("message",result);
		return "helloworld";
	}
}
