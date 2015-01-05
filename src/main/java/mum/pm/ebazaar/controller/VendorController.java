package mum.pm.ebazaar.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import mum.pm.ebazaar.domain.Product;
import mum.pm.ebazaar.domain.User;
import mum.pm.ebazaar.service.CategoryService;
import mum.pm.ebazaar.service.ProductService;
import mum.pm.ebazaar.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/vendor")
public class VendorController {

//    @Autowired
//    VendorService vendorService;
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping()
    public String vendorHome(Model model) {
        model.addAttribute("products", productService.getAll());
        return "vendor/vendor-index";
    }

    @RequestMapping(value = "/addproduct", method = RequestMethod.GET)
    public String getadmin(@ModelAttribute("vendor") User user, Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categoryList", categoryService.getAll());
        return "vendor/addproduct";
    }

    @RequestMapping(value = "/addproduct", method = RequestMethod.POST)
    public String postadmin(@Valid @ModelAttribute("product") Product product, BindingResult result,
            HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        if(result.hasErrors()){
         return "vendor/addproduct";
         }	
        try {
            product.setProductImage(file.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByUsername(auth.getName());
        product.setUser(user);
//        productService.update(product);
        productService.create(product);
        return "redirect:/vendor";
    }

    @RequestMapping(value = "/editproduct/{id}", method = RequestMethod.GET)
    public String editProduct(@ModelAttribute("user") User user, @PathVariable long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("categoryList", categoryService.getAll());
        return "vendor/editproduct";
    }

    @RequestMapping(value = "/editproduct/{id}", method = RequestMethod.POST)
    public String editProduct(@Valid @ModelAttribute("product") Product product, BindingResult result,
            @PathVariable long id, HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        if(result.hasErrors()){
         return "vendor/editproduct";
         }	
        product.setId(id);
        try {
            product.setProductImage(file.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByUsername(auth.getName());
        product.setUser(user);
        productService.update(product);
        return "redirect:/vendor";
    }

    @RequestMapping(value = "/deleteproduct", method = RequestMethod.POST)
    public String deleteproduct(@RequestParam(value = "productId") long id) {
        Product p = productService.findById(id);
        if (p != null) {
            productService.delete(p);
        }
        return "redirect:/vendor";
    }

    

}
