package mum.pm.ebazaar.controller;

import mum.pm.ebazaar.service.CategoryService;
import mum.pm.ebazaar.service.ProductService;

import mum.pm.ebazaar.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/layout")
public class LayoutController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    UserService userService;

    @RequestMapping("/sidebar")
    public String sidebar(Model model) {
        model.addAttribute("productList", productService.getAll());
        model.addAttribute("categoryList", categoryService.getAll());
        return "layout/sidebar";
    }
    @RequestMapping("/header")
    public String header(Model model) {
        return "layout/header";
    }
    @RequestMapping("/footer")
    public String footer(Model model) {
        return "layout/footer";
    }
    
    @RequestMapping("/head")
    public String head(Model model) {
        return "layout/head";
    }
}
