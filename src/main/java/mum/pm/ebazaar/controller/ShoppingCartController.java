package mum.pm.ebazaar.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import mum.pm.ebazaar.domain.OrderItem;
import mum.pm.ebazaar.domain.ShoppingCart;
import mum.pm.ebazaar.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        Integer cartItemCount=(Integer)session.getAttribute("cartItemCount");
        if(cartItemCount==null){
            cartItemCount=0;
        }
        if (!orderItems.isEmpty()) {
            for (OrderItem o : orderItems) {
                if (o.getProduct().getId() == id) {
                    o.setQuantity(o.getQuantity() + 1);
                    cartItemCount++;
                    found = true;
                }
                
            }
        }
        if (!found) {
            OrderItem oi = new OrderItem();
            oi.setProduct(productService.findById(id));
            oi.setQuantity(1);
            cartItemCount++;
            orderItems.add(oi);
        }
        
        session.setAttribute("cart", cart);
        session.setAttribute("cartItemCount", cartItemCount);
        return "redirect:/cart";
    }

    @RequestMapping("/cart")
    public String shoppingCart(Model model, HttpSession session) {
        
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        int orderCount = 0;
        if (cart != null) {
            orderCount = cart.getOrderItems().size();
        }
        model.addAttribute("orderCount", orderCount);
        return "cart";
    }
}
