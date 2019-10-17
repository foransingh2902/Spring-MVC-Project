package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class SillyController {
	@RequestMapping("/showForm")
	public String displayTheForm()
	{
		// will be added with suffix and prefix to be viewed as /WEB-INF/view/helloworld-form.jsp
		return "silly";
	}
}
