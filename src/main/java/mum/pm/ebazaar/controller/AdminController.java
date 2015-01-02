package mum.pm.ebazaar.controller;

import javax.servlet.http.HttpServletRequest;

import mum.pm.ebazaar.domain.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AdminController {
	
//	@Autowired
//	private AdminService adminService;

	@RequestMapping(value="/addAdmin", method=RequestMethod.GET)
	public String getadmin(@ModelAttribute ("newAdmin") Admin admin) {
		
		return "login";
	}
	
	
	@RequestMapping(value="/addAdmin", method=RequestMethod.POST)
	public String postadmin(@ModelAttribute ("newAdmin") Admin admin, BindingResult	 result , HttpServletRequest request) {   
		if(result.hasErrors()){
			return "login";
		}
		
//		adminService.create(admin);
		return "index";
	}
	
}
