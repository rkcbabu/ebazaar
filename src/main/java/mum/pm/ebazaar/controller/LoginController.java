package mum.pm.ebazaar.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import mum.pm.ebazaar.domain.User;
import mum.pm.ebazaar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope
public class LoginController {
    
    @Autowired
    UserService userservice;
   
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String register(@ModelAttribute("user") User user)
    {
            return "login";
    }
    
    @RequestMapping(value = "/user/loginA", method = RequestMethod.POST)
    public String login(@Valid User userF, ModelMap model, BindingResult result)
    {
        if(result.hasErrors())
            return "login";
        else{
            if(userservice.getUserByUsername(userF.getUsername())!=null){
               User user=userservice.getUserByUsername(userF.getUsername());
                if(user.getUsername().equals(userF.getUsername())){
                    model.addAttribute("userIN",user);
                    return "welcome";
                }
                else{
                   return "login";
                }
            }
            else {
                return "redirect:/login";
            }
            
        }
    }
     @RequestMapping(value = "/user/logout", method = RequestMethod.POST)
    public String logout(@Valid User userF, HttpSession session, BindingResult result)
    {
         session.invalidate();
        return "redirect:/login";
    }
   
}
