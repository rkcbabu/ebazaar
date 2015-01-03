package mum.pm.ebazaar.controller;

import javax.validation.Valid;
import mum.pm.ebazaar.domain.User;
import mum.pm.ebazaar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(@ModelAttribute("user") User user)
    {
//            user.setUsername("admin");
//            user.setPassword("admin");
//            user.setEnabled(true);
//            user.setRole("ROLE_ADMIN");
//            userservice.saveUser(user);    
            
//            return "templates/login";
            return "login";
    }
    
    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result)
    {
        if(result.hasErrors())
            return "login";
        else{
            String md5password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
            user.setPassword(md5password);
        
            user.setEnabled(true);
            user.setRole("ROLE_ADMIN");
           userservice.saveUser(user); 
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
