package mum.pm.ebazaar.controller;

import javax.validation.Valid;

import mum.pm.ebazaar.domain.User;
import mum.pm.ebazaar.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    UserService userservice;

//    @InitBinder
//    public void initConverter(WebDataBinder binder)
//    {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        dateFormat.setLenient(false);
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//        binder.registerCustomEditor(Vendor.class, new UserPropertyEditor(userservice));        
//    } 
    @RequestMapping(value = "/register")
    public String vendorRegister(@RequestParam("user") String type, Model model) {
        User user = new User();
        model.addAttribute("user", user);
        if (type == null) {
            return "user/customerForm";
        } else if (type.equalsIgnoreCase("vendor")) {
            return "user/vendorForm";
        } else if (type.equalsIgnoreCase("admin")) {
            return "user/adminForm";
        } else {
            return "user/customerForm";
        }
    }

//    @RequestMapping(value = "/userRegistration")
//    public String userRegister(Model model) {
//        model.addAttribute("user", new User());
//        return "user/userRegistration";
//    }

//    @RequestMapping(value = "/register", method = RequestMethod.GET)
//    public String register(@ModelAttribute("user") User user) {
//        return "login";
//    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            if (user.getRole() == null) {
                return "user/customerForm";
            } else if (user.getRole().equalsIgnoreCase("ROLE_VENDOR")) {
                
                return "user/vendorForm";
            } else if (user.getRole().equalsIgnoreCase("ROLE_ADMIN")) {
                return "user/adminForm";
            } else {
                return "user/customerForm";
            }
        } else {
             user.setEnabled(true);
             if (user.getRole().equalsIgnoreCase("ROLE_VENDOR")) {
                user.setEnabled(true); // we have to disable it later.
                return "user/vendorForm";
            } else if (user.getRole().equalsIgnoreCase("ROLE_ADMIN")) {
                user.setEnabled(false);
                return "user/adminForm";
            } 
            String md5password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
            user.setPassword(md5password);

           
            if (user.getRole() == null) {
                user.setRole("ROLE_CUSTOMER");
            }
            userservice.create(user);
        }
        return "redirect:/login";
    }

//    @RequestMapping(value = "/user/list")
//    public String listUsers(Model model)
//    {
//        model.addAttribute("users", userservice.getAllUser());
//        return "user/userList";
//    }
//    @RequestMapping("/user/edit/{userid}")
//    public String editUser(@PathVariable("userid") int id, Model model)
//    {
//        model.addAttribute("user", userservice.getUserById(id) );
//        return "user/userForm";
//    }
//    
//    @RequestMapping("/user/delete/{userid}")
//    public String deleteUser(@PathVariable("userid") int id, Model model)
//    {
//        userservice.deleteUser(id);
//        return "redirect:/user/list";
//    }
}
