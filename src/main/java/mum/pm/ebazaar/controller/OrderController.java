/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.pm.ebazaar.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import mum.pm.ebazaar.domain.Card;
import mum.pm.ebazaar.domain.Customer;
import mum.pm.ebazaar.domain.Order;
import mum.pm.ebazaar.domain.OrderItem;
import mum.pm.ebazaar.domain.Payment;
import mum.pm.ebazaar.domain.Product;
import mum.pm.ebazaar.domain.ShoppingCart;
import mum.pm.ebazaar.mail.Mail;
import mum.pm.ebazaar.util.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cartAfter");
         for (OrderItem item : cart.getOrderItems()) {

             for (int i = 0; i < item.getQuantity(); i++) {
                 Product p=item.getProduct();
                 p.setQuantity(p.getQuantity()-1);
                 productService.update(p);
             }
         }
        
        session.setAttribute("cart", null);
        model.addAttribute("cart", null);
        return "order/confirmation";
    }
    public String myFinance(Card card, Customer customer, double total){
        
        int month=card.getMonth();
        int year=card.getYear();
        String expry=year+"-"+month+"-"+"03";
        Map<String, String> params=new HashMap<String, String>();
        String fullname=customer.getFirstName()+" "+customer.getLastName();
        String billingaddress= customer.getAddress().toString();
        String ccNo = card.getCreditCardNo()+"";        
        String exptDate =expry;
        String cvvNo = card.getCardCV();
        params.put("fullname", customer.getFirstName()+" "+customer);
        params.put("emailid", customer.getEmail());
        params.put("billingaddress", billingaddress);
        
        String s=Utils.myfinance(ccNo, exptDate, cvvNo, total, params);
       return s;
        
    }
     @RequestMapping("/createOrder")
    public String createOrder(Model model, HttpSession session) {
        Customer currUser=(Customer) session.getAttribute("currUser");
        Order order= new Order();
        Payment payment = new Payment();
        payment.setCard(currUser.getCard());
        payment.setPaidDate(new Date());
        Double subtotal = (Double) session.getAttribute("totalPrice");
        Double total=subtotal + 0.1*subtotal;
        payment.setTotal(total);
        
        paymentService.create(payment);
        order.setCustomer(currUser);
        order.setDateOrder(new Date());
        order.setDateShip(new Date());
        
        ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
        order.setOrderItems(cart.getOrderItems());
        order.setOrderItems(cart.getOrderItems());
        order.setOrderItems(cart.getOrderItems());
        order.setPayment(payment);
        String orderId = generateNumber()+"";
        order.setOrderID(orderId);
        paymentService.update(payment);
        orderService.create(order);
        session.setAttribute("finalOrder", order);
        session.setAttribute("cartAfter", cart);
        session.setAttribute("confirmation", order.getOrderID()+"");
        session.setAttribute("cart", null);
        shoppingService.delete(cart);
         
         String s = myFinance(currUser.getCard(), currUser, total);
         setMailBody(order, currUser); 
        return "redirect:/confirmation";
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
    public boolean isValid(Card card, String expry, Double total){
        boolean valid=false;
        if("YES".equals(Utils.isValid(card.getCreditCardNo(), expry, card.getCardCV(), total))){
           valid=true;
        }
        return valid;
    }
    private void setMailBody(Order order, Customer customer) {
        Mail mail = new Mail();
        String message="Dear " + customer.getFirstName()+"\n"+
               "Thanks for oreder your goods from us. You don’t need to do anything "
                + "else – just look forward to enjoy your goods. Your ebazzar.com "
                + " Order Confirmation Number is " +order.getOrderID()+". \n"
                +"If you want to know track your shipping, we will send you the UPS tracking code "
                + "with in 24 Hours.";
        mail.setSubject("Order confirmation");
        mail.setMessage(message);
        mail.setTomail(customer.getEmail());
        mail.sendMail();
    }
  
}
