package mum.pm.ebazaar.controller;


import mum.pm.ebazaar.domain.User;
import mum.pm.ebazaar.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private UserService userService;
//    @Autowired
//    private VenderService venderService;

    @RequestMapping()
    public String getadmin(Model model) {

        model.addAttribute("users", userService.getAll());
        return "admin/admin-index";
    }
    @RequestMapping(value="/toggle",method = RequestMethod.POST)
    public String toggle(@RequestParam("id") Long id, Model model) {
        
        User user = userService.findById(id);
        user.setEnabled(!user.isEnabled());
        userService.update(user);
        System.err.println(user);
        model.addAttribute("users", userService.getAll());
//        return "redirect:/admin";
        return "admin/admin-index";
    }

}
