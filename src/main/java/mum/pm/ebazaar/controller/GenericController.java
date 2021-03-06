package mum.pm.ebazaar.controller;

import java.util.ArrayList;
import java.util.List;
import mum.pm.ebazaar.domain.Category;
import mum.pm.ebazaar.service.CardService;
import mum.pm.ebazaar.service.CategoryService;
import mum.pm.ebazaar.service.CustomerService;
import mum.pm.ebazaar.service.OrderService;
import mum.pm.ebazaar.service.PaymentService;
import mum.pm.ebazaar.service.ProductService;
import mum.pm.ebazaar.service.ShoppingCartService;
import mum.pm.ebazaar.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

//@SessionAttributes("cartItemCount")
public class GenericController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    UserService userService;

    @Autowired
    CustomerService customerService;
    
    @Autowired
    CardService cardService;
    
    @Autowired
    PaymentService paymentService;
    
    @Autowired
    OrderService orderService;
    
    @Autowired
    ShoppingCartService shoppingService;

    public void pageSetup(Model model) {
        
        List<Category> categories= new ArrayList<Category>();
        for(Category c:categoryService.getAll()){
            if(!categories.contains(c)){
                categories.add(c);
            }
        }
        model.addAttribute("productList", productService.getAll());
        model.addAttribute("categoryList",categories);
        model.addAttribute("vendorList", userService.getVendors());
        model.addAttribute("displaySidebar", true);
    }

}
