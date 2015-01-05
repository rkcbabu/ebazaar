package mum.pm.ebazaar.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.security.Principal;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mum.pm.ebazaar.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController  extends GenericController{
    
    @RequestMapping("/")
    public String homePage(Model model,HttpServletRequest request) {
        pageSetup(model,request);
        return "index";
    }
    
    
    @RequestMapping("/successPage")
    public String successPage(HttpServletRequest request,ModelMap model) {
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

    @RequestMapping(value = "/productpic/{id}")
    public void getImage(@PathVariable long id, HttpServletResponse response) {
        try {
            Product p = productService.findById(id);
            if (p != null) {
                OutputStream out = response.getOutputStream();
                out.write(p.getProductImage());
                response.flushBuffer();
            }
        } catch (IOException ex) {

        }
    }
    @RequestMapping("/template/login")
    public String login() {
        return "templates/login";
    }

    @RequestMapping("/page404")
    public String page404() {
        return "templates/page404";
    }
    @RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied(Principal user) {
 
		ModelAndView model = new ModelAndView();
 
		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", 
			"You do not have permission to access this page!");
		}
 
		model.setViewName("403");
		return model;
 
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

    @RequestMapping("/checkout")
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
