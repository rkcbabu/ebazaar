/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.pm.ebazaar.controller;

import java.util.Date;
import javax.servlet.http.HttpSession;
import mum.pm.ebazaar.domain.Card;
import mum.pm.ebazaar.domain.Customer;
import mum.pm.ebazaar.domain.Order;
import mum.pm.ebazaar.domain.Payment;
import mum.pm.ebazaar.domain.ShoppingCart;
import mum.pm.ebazaar.util.Utils;
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
        Customer currUser=(Customer) session.getAttribute("currUser");
        String expry=currUser.getCard().getYear()+"-"+currUser.getCard().getMonth()+"-"+"03";
        Double subtotal = (Double) session.getAttribute("totalPrice");
        Double total = subtotal+0.1*subtotal;
        isValid(currUser.getCard(),expry, total);
        return "redirect:/createOrder";
    }
     @RequestMapping("/confirmation")
    public String confirm(Model model, HttpSession session) {
        return "order/confirmation";
    }
     @RequestMapping("/createOrder")
    public String createOrder(Model model, HttpSession session) {
        Customer currUser=(Customer) session.getAttribute("currUser");
        Order order= new Order();
        Payment payment = new Payment();
        payment.setCard(currUser.getCard());
        payment.setPaidDate(new Date());
        payment.setTotal(0.0);
        
        paymentService.create(payment);
        order.setCustomer(currUser);
        order.setDateOrder(new Date());
        order.setDateShip(new Date());
        ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
        
        order.setOrderItems(cart.getOrderItems());
        order.setOrderItems(cart.getOrderItems());
        order.setPayment(payment);
        String orderId = generateNumber()+"";
        order.setOrderID(orderId);
        paymentService.create(payment);
        orderService.create(order);
        session.setAttribute("cart", null);
        session.setAttribute("totalPrice", null);
        session.setAttribute("cartItemCount", null);
        return "redirect:/confirmation";
    }
    public Long generateNumber(){
        long number = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
        while(orderService.findByOrderId(number+"")!=null){
            number = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
        }
        return number;
    }
//    @RequestMapping("/payment/{0}")
//    public String paymentDone(@ModelAttribute("currUser") Customer currUser,BindingResult result,@PathVariable long id, Model model, HttpSession session){
//        currUser.setId(id);
//        
//        return "payment";
//    }
    @RequestMapping("/payment")
    public String payment(Model model, HttpSession session){
        model.addAttribute("currUser", session.getAttribute("currUser"));
        model.addAttribute("card", new Card());
        return "order/payment";
    }
    @RequestMapping(value="/createCard", method = RequestMethod.POST)
    public String createPayment(@ModelAttribute("card") Card card, BindingResult result, Model model, HttpSession session){
        Customer currUser = (Customer) session.getAttribute("currUser");

        Double subtotal = (Double) session.getAttribute("totalPrice");
        cardService.create(card);
        currUser.setCard(card);
        Double total = subtotal+0.1*subtotal;
        int month=card.getMonth();
        int year=card.getYear();
        String expry=year+"-"+month+"-"+"03";
        model.addAttribute("currUser", session.getAttribute("currUser"));
        model.addAttribute("card", card);
        if(isValid(card, expry, total)){
            return "redirect:/createOrder";
        }
        else
            return "redirect:/payment";
    }
    public boolean isValid(Card card,String expry, Double total){
        boolean valid=false;
        if("YES".equals(Utils.isValid(card.getCreditCardNo(), expry, card.getCardCV(), total))){
           valid=true;
        }
        return valid;
    }
    
    
}
