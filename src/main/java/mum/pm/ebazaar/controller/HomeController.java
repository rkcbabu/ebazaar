package mum.pm.ebazaar.controller;

import javax.servlet.http.HttpServletRequest;
import mum.pm.ebazaar.domain.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String homePage() {
        return "index";
    }
    
    @RequestMapping("/successPage")
    public String successPage(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin";
        } else if (request.isUserInRole("ROLE_CUSTOMER")) {
            return "redirect:/search-product";
        } else if (request.isUserInRole("ROLE_VENDOR")) {
            return "redirect:/vendor";
        } else {
            return "redirect:/";
        }

    }

    @RequestMapping("/welcome")
    public String welcomePage(Model model) {
        model.addAttribute("greeting", "Welcome to Web Store!");
        model.addAttribute("tagline", "The one and only amazing web store");
        return "welcome";
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
