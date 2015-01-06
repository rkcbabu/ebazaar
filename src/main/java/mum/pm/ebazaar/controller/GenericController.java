package mum.pm.ebazaar.controller;

import mum.pm.ebazaar.service.CategoryService;
import mum.pm.ebazaar.service.ProductService;
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

    public void pageSetup(Model model) {
        model.addAttribute("productList", productService.getAll());
        model.addAttribute("categoryList", categoryService.getAll());
        model.addAttribute("vendorList", userService.getVendors());
        model.addAttribute("displaySidebar", true);
    }

}
