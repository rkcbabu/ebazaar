package mum.pm.ebazaar.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import mum.pm.ebazaar.domain.Card;
import mum.pm.ebazaar.domain.Customer;
import mum.pm.ebazaar.domain.OrderItem;
import mum.pm.ebazaar.domain.ShoppingCart;
import mum.pm.ebazaar.domain.User;
import mum.pm.ebazaar.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShoppingCartController extends GenericController {

    @Autowired
    ShoppingCartService cartservice;

    @RequestMapping(value = "/addtocart/{id}", method = RequestMethod.GET)
    public String addToCart(@PathVariable long id, HttpSession session) {
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        
        if (cart == null) {
            cart = new ShoppingCart();
            cartservice.create(cart);
        }
        List<OrderItem> orderItems = cart.getOrderItems();
        boolean found = false;
        Integer cartItemCount = (Integer) session.getAttribute("cartItemCount");
        Double totalPrice = (Double) session.getAttribute("totalPrice");
        if (cartItemCount == null) {
            cartItemCount = 0;
            totalPrice = 0.0;
        }
        if (!orderItems.isEmpty()) {
            for (OrderItem o : orderItems) {
                if (o.getProduct().getId() == id) {
                    o.setQuantity(o.getQuantity() + 1);
                    totalPrice = totalPrice + o.getProduct().getPrice();
                    cartItemCount++;
                    found = true;
                    break;
                }

            }
        }
        if (!found) {
            OrderItem oi = new OrderItem();
            oi.setProduct(productService.findById(id));
            oi.setQuantity(1);
            totalPrice = totalPrice + oi.getProduct().getPrice();
            cartItemCount++;
            orderItems.add(oi);
        }
        cartservice.update(cart);
        session.setAttribute("cart", cart);
        session.setAttribute("totalPrice", totalPrice);
        session.setAttribute("cartItemCount", cartItemCount);
        return "redirect:/cart";
    }

    @RequestMapping("/cart")
    public String shoppingCart(Model model, HttpSession session) {
        return "order/cart";
    }
    @RequestMapping(value="/cart/increment", method = RequestMethod.POST)
    public String shoppingCartI(@RequestParam("id") Long id, Model model, HttpSession session) {
        
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        
        if (cart == null) {
            return "redirect:/cart";
        }
        List<OrderItem> orderItems = cart.getOrderItems();
        Integer cartItemCount = (Integer) session.getAttribute("cartItemCount");
        Double totalPrice = (Double) session.getAttribute("totalPrice");
        if (cartItemCount == null) {
            cartItemCount = 0;
            totalPrice = 0.0;
        }
        if (!orderItems.isEmpty()) {
            for (OrderItem o : orderItems) {
                if (o.getProduct().getId() == id) {
                    o.setQuantity(o.getQuantity() + 1);
                    totalPrice = totalPrice + o.getProduct().getPrice();
                    cartItemCount++;
                    break;
                }

            }
        }
        cartservice.update(cart);
        session.setAttribute("cart", cart);
        session.setAttribute("totalPrice", totalPrice);
        session.setAttribute("cartItemCount", cartItemCount);
        return "redirect:/cart";
    }
    @RequestMapping(value="/cart/decrement", method = RequestMethod.POST)
    public String shoppingCartD(@RequestParam("id") Long id, Model model, HttpSession session) {
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        
        if (cart == null) {
            return "redirect:/cart";
        }
        List<OrderItem> orderItems = cart.getOrderItems();
        
        Integer cartItemCount = (Integer) session.getAttribute("cartItemCount");
        Double totalPrice = (Double) session.getAttribute("totalPrice");
        if (cartItemCount == null) {
            cartItemCount = 0;
            totalPrice = 0.0;
        }
        if (!orderItems.isEmpty()) {
            for (OrderItem o : orderItems) {
                if (o.getProduct().getId() == id && o.getQuantity()>1) {
                    o.setQuantity(o.getQuantity() - 1);
                    totalPrice = totalPrice - o.getProduct().getPrice();
                    cartItemCount--;
                    break;
                }

            }
        }
        cartservice.update(cart);
        session.setAttribute("cart", cart);
        session.setAttribute("totalPrice", totalPrice);
        session.setAttribute("cartItemCount", cartItemCount);
        return "redirect:/cart";
    }
    @RequestMapping(value="/cart/delete", method = RequestMethod.POST)
    public String shoppingCartDEL(@RequestParam("id") Long id, Model model, HttpSession session) {
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        
        if (cart == null) {
            return "redirect:/cart";
        }
        List<OrderItem> orderItems = cart.getOrderItems();
        
        Integer cartItemCount = (Integer) session.getAttribute("cartItemCount");
        Double totalPrice = (Double) session.getAttribute("totalPrice");
        if (cartItemCount == null) {
            cartItemCount = 0;
            totalPrice = 0.0;
        }
        if (!orderItems.isEmpty()) {
            for (OrderItem o : orderItems) {
                if (o.getProduct().getId() == id && o.getQuantity()>1) {
                    totalPrice = totalPrice - o.getProduct().getPrice()*o.getQuantity();
                    cartItemCount = cartItemCount-o.getQuantity();
                    orderItems.remove(o);
                    break;
                }

            }
        }
        cartservice.update(cart);
        session.setAttribute("cart", cart);
        session.setAttribute("totalPrice", totalPrice);
        session.setAttribute("cartItemCount", cartItemCount);
        return "redirect:/cart";
    }

    @RequestMapping("/checkout")
    public String checkoutRedirect(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getName().equals("anonymousUser")) {
            Customer currUser= new Customer();
            model.addAttribute("currUser",currUser);
            return "/order/checkoutGuest";
        } else {
            Card card = new Card();
            model.addAttribute("currUser", customerService.getUserByUsername(auth.getName()));
            model.addAttribute("card", card);
            
            return "/order/checkoutCust";
        }
    }

    @RequestMapping("/cancelCart")
    public String cancelCart(Model model, HttpSession session
    ) {
        session.setAttribute("cart", null);
        session.setAttribute("totalPrice", null);
        session.setAttribute("cartItemCount", null);
        return "/checkout";
    }
   

}
