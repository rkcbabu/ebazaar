package mum.pm.ebazaar.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mum.pm.ebazaar.domain.Product;
import mum.pm.ebazaar.domain.User;
import mum.pm.ebazaar.service.CategoryService;
import mum.pm.ebazaar.service.ProductService;
import mum.pm.ebazaar.service.UserService;
import mum.pm.ebazaar.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope
//@Transactional
public class HomeController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    UserService userService;

    @Autowired
    CustomerService customerService;

    @RequestMapping("/")
    public String homePage(Model model) {
        model.addAttribute("productList", productService.getAll());
        return "index";
    }

    @RequestMapping("/successPage")
    public String successPage(HttpServletRequest request, ModelMap model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        request.getSession().setAttribute("currUser", userService.getUserByUsername(auth.getName()));
        model.addAttribute("currUser", userService.getUserByUsername(auth.getName()));
        if (request.isUserInRole("ROLE_ADMIN")) {
            String referrer = request.getHeader("referer");
            if (referrer.contains("/cart")) {
                return "redirect:/checkout";
            } else {
                return "redirect:/admin";
            }
        } else if (request.isUserInRole("ROLE_CUSTOMER")) {
            request.getSession().setAttribute("currUser", customerService.getUserByUsername(auth.getName()));
            model.addAttribute("currUser", customerService.getUserByUsername(auth.getName()));
            String referrer = request.getHeader("referer");
            if (referrer.contains("/cart")) {
                return "redirect:/checkout";
            } else {
                return "redirect:/";
            }
        } else if (request.isUserInRole("ROLE_VENDOR")) {
            String referrer = request.getHeader("referer");
            if (referrer.contains("/cart")) {
                return "redirect:/checkout";
            } else {
                return "redirect:/vendor";
            }
        } else {
            return "redirect:/";
        }

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

    @RequestMapping("/search")
    public String searchProduct(Model model, @RequestParam("q") String q) {
        model.addAttribute("productList", productService.productsByKey(q));
        return "search";
    }

    @RequestMapping("/search/category/{category}")
    public String searchProductByCategory(Model model, @PathVariable("category") Long category) {
//        System.err.println(categoryService.get(category));
        model.addAttribute("productList", categoryService.get(category).getProducts());
        return "search";
    }

    @RequestMapping("/search/vendor/{vendor}")
    public String searchProductByVendor(Model model, @PathVariable("vendor") String vendor) {
        System.err.println(userService.getUserByUsername(vendor));
        User user = userService.getUserByUsername(vendor);
        List<Product> productList = new ArrayList<Product>();
        for (Product p : productService.getAll()) {
            if (p.getId().equals(user.getId())) {
                productList.add(p);
            }
        }
        model.addAttribute("productList", productList);
        return "search";
    }
}
