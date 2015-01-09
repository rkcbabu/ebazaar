/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.pm.ebazaar.controller;

import javax.servlet.http.HttpServletRequest;
import mum.pm.ebazaar.domain.Card;
import mum.pm.ebazaar.domain.Customer;
import mum.pm.ebazaar.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ghenet
 */
@Controller
public class CardController extends GenericController{
    
    @RequestMapping(value = "/updateCard/{id}", method = RequestMethod.POST)
    public String updateAdd(@ModelAttribute("currUser") Customer user, BindingResult result, @PathVariable long id, Model model) {
       
         user.setId(id);
         userService.updateAddress(user);
         Card card = new Card();
         card = user.getCard();
         Customer exCus= customerService.get(id);
//         card.setId(exCus.getCard().getId());
         card.setCustomer(user);
         cardService.update(card);
        return "redirect:/checkout";
    }
    @RequestMapping(value = "/addCard", method = RequestMethod.POST)
    public String addCard(@ModelAttribute("card") Card card, BindingResult result, Model model, HttpServletRequest request) {
         
         cardService.create(card);
         Customer customer=(Customer) request.getSession().getAttribute("currUser");
         customer.setCard(card);
         card.setCustomer(customer);
         cardService.update(card);
         model.addAttribute("currUser", customer);
         request.getSession().setAttribute("currUser", customer);
        return "redirect:/checkout";
    }
}
