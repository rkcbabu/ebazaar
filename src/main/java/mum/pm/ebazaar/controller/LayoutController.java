package mum.pm.ebazaar.controller;

import javax.servlet.http.HttpServletRequest;
import mum.pm.ebazaar.service.CategoryService;
import mum.pm.ebazaar.service.ProductService;

import mum.pm.ebazaar.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;

@Controller
//@RequestMapping(value = "")
public class LayoutController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    UserService userService;

    @RequestMapping("/layout/sidebar")
    public String sidebar(Model model) {
        model.addAttribute("productList", productService.getAll());
        model.addAttribute("categoryList", categoryService.getAll());
        model.addAttribute("vendorList", userService.getVendors());
        return "layout/sidebar";
    }
    @RequestMapping("/layout/header")
    public String header(Model model) {
        model.addAttribute("categoryList", categoryService.getAll());
        model.addAttribute("vendorList", userService.getVendors());
        return "layout/header";
    }
    @RequestMapping("/layout/footer")
    public String footer(Model model) {
        return "layout/footer";
    }
    
    @RequestMapping("/layout/head")
    public String head(Model model,HttpServletRequest request) {
        model.addAttribute("title", " E-Bazaar ");
        return "layout/head";
    }
    
     @RequestMapping("/template/login")
    public String login() {
        return "templates/login";
    }

    @RequestMapping("/page404")
    public String page404() {
        return "templates/page404";
    }
    @RequestMapping("/blog-single")
    public String blogsingle() {
        return "templates/blog-single";
    }

    @RequestMapping("/blog")
    public String blog() {
        return "templates/blog";
    }

    @RequestMapping("/template/cart")
    public String cart() {
        return "templates/cart";
    }

    @RequestMapping("template/checkout")
    public String checkout() {
        return "templates/checkout";
    }

    @RequestMapping("/contact-us")
    public String contactus() {
        return "templates/contact-us";
    }

    @RequestMapping("/template/product-details")
    public String templateProductdetails() {
        return "templates/product-details";
    }

    @RequestMapping("/shop")
    public String shop() {
        return "templates/shop";
    }
}
