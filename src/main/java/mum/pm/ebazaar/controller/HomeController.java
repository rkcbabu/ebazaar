package mum.pm.ebazaar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/welcome/greeting")
	public String welcome(Model model) {
		model.addAttribute("greeting", "Welcome to Web Store!");
		model.addAttribute("tagline", "The one and only amazing web store");
		
		return "welcome";
	}
	
	@RequestMapping("/")
	public String greeting() {
                
		return "index";
	}
        
        @RequestMapping("/login")
	public String login() {
                
		return "login";
	}
}
