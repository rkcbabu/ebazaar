package mum.pm.ebazaar.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import mum.pm.ebazaar.domain.ShoppingCart;
import mum.pm.ebazaar.service.CategoryService;
import mum.pm.ebazaar.service.ProductService;
import mum.pm.ebazaar.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttributes;

//@SessionAttributes("cartItemCount")
public class GenericController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    UserService userService;

    public void pageSetup(Model model,HttpServletRequest request) {
        model.addAttribute("productList", productService.getAll());
        model.addAttribute("categoryList", categoryService.getAll());
        model.addAttribute("vendorList", userService.getVendors());
        model.addAttribute("displaySidebar", true);
//        HttpSession session = request.getSession();
//        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
//        int cartItemCount = 0;
//        if (cart != null) {
//            cartItemCount = cart.getOrderItems().size();
//        }
//        model.addAttribute("cartItemCount", cartItemCount);
    }

}
