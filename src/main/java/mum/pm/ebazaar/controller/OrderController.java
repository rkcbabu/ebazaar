/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.pm.ebazaar.controller;

import javax.servlet.http.HttpSession;
import mum.pm.ebazaar.domain.Card;
import mum.pm.ebazaar.domain.Customer;
import mum.pm.ebazaar.domain.Order;
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
public class OrderController extends GenericController{
    
     @RequestMapping("/placeOrder")
    public String placeOrder(Model model, HttpSession session) {
        Order order= new Order();
        session.getAttribute("cart");
        session.getAttribute("currUser");
        session.setAttribute("cart", null);
        session.setAttribute("totalPrice", null);
        session.setAttribute("cartItemCount", null);
        return "/checkout";
    }
}
