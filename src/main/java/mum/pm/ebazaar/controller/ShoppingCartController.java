package mum.pm.ebazaar.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import mum.pm.ebazaar.domain.OrderItem;
import mum.pm.ebazaar.domain.ShoppingCart;
import mum.pm.ebazaar.domain.User;
import mum.pm.ebazaar.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShoppingCartController extends GenericController {

    @Autowired
    ShoppingCartService cartservice;

    @RequestMapping(value = "/addtocart/{id}", method = RequestMethod.GET)
    public String addToCart(@PathVariable long id, HttpSession session) {
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart == null) {
            cart = new ShoppingCart();
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

        session.setAttribute("cart", cart);
        session.setAttribute("totalPrice", totalPrice);
        session.setAttribute("cartItemCount", cartItemCount);
        return "redirect:/cart";
    }

    @RequestMapping("/cart")
    public String shoppingCart(Model model, HttpSession session) {

//        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
//        int orderCount = 0;
//        if (cart != null) {
//            orderCount = cart.getOrderItems().size();
//        }
//        model.addAttribute("orderCount", orderCount);
        return "order/cart";
    }
    @RequestMapping("/checkout")
    public String checkoutRedirect(Model model) {
        return "/order/checkout";
    }

//    @RequestMapping("/checkout")
//    public String checkoutCust(Model model) {
//        model.addAttribute("user", new User());
//        Map modelMap = model.asMap();
//        if (!modelMap.isEmpty()) {
//            for (Object modelKey : modelMap.keySet()) {
//                Object modelValue = modelMap.get(modelKey);
//                model.addAttribute("user", new User());
//            }
//           
//        }
//         return "redirect:/order/checkout";
//    }
//     @RequestMapping(value = "/profile", method = RequestMethod.GET)
//    public String editUser(Model model) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        userr = userservice.getUserByUsername(auth.getName());
//        model.addAttribute("currUser", userservice.getUserByUsername(auth.getName()));
//        return "profile";
//    }
        @RequestMapping("/cancelCart")
        public String cancelCart
        (Model model, HttpSession session
        
            ){
        session.setAttribute("cart", null);
            session.setAttribute("totalPrice", null);
            session.setAttribute("cartItemCount", null);
            return "/checkout";
        }

    }
