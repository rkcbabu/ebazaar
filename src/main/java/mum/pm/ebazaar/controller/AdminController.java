package mum.pm.ebazaar.controller;

import javax.servlet.http.HttpServletRequest;

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
    private UserService userService;

    @RequestMapping()
    public String getadmin(Model model) {

        model.addAttribute("users", userService.getAll());
        return "admin/admin-index";
    }

}
