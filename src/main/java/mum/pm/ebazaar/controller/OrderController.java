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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Ghenet
 */
@Controller
public class OrderController extends GenericController{
    
     @RequestMapping("/placeOrder")
    public String placeOrder(Model model, HttpSession session) {
        Order order= new Order();
        Payment payment = new Payment();
        payment.setCard(null);
        payment.setPaidDate(new Date());
        payment.setTotal(0.0);
        
        paymentService.create(payment);
        order.setCustomer((Customer) session.getAttribute("currUser"));
        order.setDateOrder(new Date());
        order.setDateShip(new Date());
        ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
        
        order.setOrderItems(cart.getOrderItems());
        order.setOrderItems(cart.getOrderItems());
        order.setPayment(payment);
        order.setCustomer((Customer) session.getAttribute("currUser"));
        String orderId = generateNumber()+"";
        order.setOrderID(orderId);
        paymentService.create(payment);
        orderService.create(order);
        session.setAttribute("cart", null);
        session.setAttribute("totalPrice", null);
        session.setAttribute("cartItemCount", null);
        return "redirect:/";
    }
    public Long generateNumber(){
        long number = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
        while(orderService.findByOrderId(number+"")!=null){
            number = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
        }
        return number;
    }
    @RequestMapping("/payment")
    public String payment(Model model, HttpSession session){
        return "payment";
    }
    
}
