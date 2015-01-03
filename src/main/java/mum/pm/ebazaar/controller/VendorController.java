package mum.pm.ebazaar.controller;

import mum.pm.ebazaar.domain.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VendorController {

	@RequestMapping(value="/addVendor", method=RequestMethod.GET)
	public String getadmin(@ModelAttribute ("newVendor") Admin admin) {
		
		return "login";
	}
}
