package mum.pm.ebazaar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("greeting", "Welcome to Web Store!");
        model.addAttribute("tagline", "The one and only amazing web store");
        return "welcome";
    }

    @RequestMapping("/")
    public String greeting() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
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

    @RequestMapping("/cart")
    public String cart() {
        return "templates/cart";
    }

    @RequestMapping("/checkout")
    public String checkout() {
        return "templates/checkout";
    }

    @RequestMapping("/contact-us")
    public String contactus() {
        return "templates/contact-us";
    }

    @RequestMapping("/product-details")
    public String productdetails() {
        return "templates/product-details";
    }

    @RequestMapping("/shop")
    public String shop() {
        return "templates/shop";
    }
}
