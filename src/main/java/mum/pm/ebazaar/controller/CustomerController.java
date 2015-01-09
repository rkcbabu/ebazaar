/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.pm.ebazaar.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import mum.pm.ebazaar.domain.Card;
import mum.pm.ebazaar.domain.Customer;
import mum.pm.ebazaar.domain.User;
import mum.pm.ebazaar.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ghenet
 */
@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/createGuest", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("currUser") Customer currUser, BindingResult result, HttpServletRequest requesst) {
        if (result.hasErrors()) {
            return "redirect:/checkout";
        } else {
            currUser.setEnabled(true);
//            String md5password = DigestUtils.md5DigestAsHex(currUser.getPassword().getBytes());
            currUser.setPassword("gustPassword");
            currUser.setRole("ROLE_GUEST");
            currUser.setUsername("guestUser");
            customerService.create(currUser);
            requesst.getSession().setAttribute("currUser", currUser);
            requesst.getSession().setAttribute("card", new Card());
            return "redirect:/payment";
        }

    }

}
