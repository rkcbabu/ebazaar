package mum.pm.ebazaar.controller;

import javax.servlet.http.HttpServletRequest;

import mum.pm.ebazaar.domain.Admin;
import mum.pm.ebazaar.service.AdminService;
import mum.pm.ebazaar.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    
    @Autowired
    private UserService userService;

    @RequestMapping()
    public String getadmin(Model model) {

        model.addAttribute("users", userService.getAll());
        return "admin/admin-index";
    }

    @RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
    public String postadmin(@ModelAttribute("newAdmin") Admin admin, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "login";
        }
        adminService.create(admin);
        return "index";
    }

}
