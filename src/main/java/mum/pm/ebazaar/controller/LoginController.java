package mum.pm.ebazaar.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import mum.pm.ebazaar.domain.User;
import mum.pm.ebazaar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope
public class LoginController {

    @Autowired
    UserService userservice;
    User userr;

    public User getUserr() {
        if (userr == null) {
            userr = new User();
        }
        return userr;
    }

    public void setUserr(User userr) {
        this.userr = userr;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String register(@ModelAttribute("user") User user) {
        return "login";
    }

    @RequestMapping(value = "/user/loginA", method = RequestMethod.POST)
    public String login(@Valid User userF, ModelMap model, BindingResult result) {
        if (result.hasErrors()) {
            return "login";
        } else {
            if (userservice.getUserByUsername(userF.getUsername()) != null) {
                User user = userservice.getUserByUsername(userF.getUsername());
                if (user.getUsername().equals(userF.getUsername())) {
                    model.addAttribute("userIN", user);
                    return "welcome";
                } else {
                    return "login";
                }
            } else {
                return "redirect:/login";
            }

        }
    }

    @RequestMapping(value = "/user/logout", method = RequestMethod.POST)
    public String logout(@Valid User userF, HttpSession session, BindingResult result) {
        session.invalidate();
        return "redirect:/login";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String editUser(Model model) {
       return "profile";
    }

    @RequestMapping(value = "/profile/{id}", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("currUser") User currUser, BindingResult result, @PathVariable long id) {

        currUser.setId(id);
        userservice.update(currUser);
        return "profile";
    }
    @RequestMapping(value = "/updateAdd/{id}", method = RequestMethod.POST)
    public String updateAdd(@PathVariable long id, HttpSession session) {
        User user = (User)session.getAttribute("currUser");
        userservice.updateAddress(user);
        return "checkout";
    }
    
}
