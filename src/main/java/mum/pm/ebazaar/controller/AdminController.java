package mum.pm.ebazaar.controller;


import mum.pm.ebazaar.domain.User;
import mum.pm.ebazaar.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/getEdit", method = RequestMethod.GET)
    public String editUser(@RequestParam("id") long id, Model model) {
       User user = userService.findById(id);
      
        model.addAttribute("user", user);
       return "admin/profileedit";
    }

    @RequestMapping(value = "/editprofile/{id}", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("User") User user, BindingResult result, @PathVariable long id, Model model) {

        user.setId(id);
        userService.update(user);
        model.addAttribute("users", userService.getAll());
        return "redrect:/successPage";
    }
}
