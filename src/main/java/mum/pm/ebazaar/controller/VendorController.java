package mum.pm.ebazaar.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import mum.pm.ebazaar.domain.Admin;
import mum.pm.ebazaar.domain.Product;
import mum.pm.ebazaar.domain.Vendor;
import mum.pm.ebazaar.service.ProductService;
import mum.pm.ebazaar.service.VendorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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

    @Autowired
    VendorService vendorService;
    @Autowired
    ProductService productService;

    @RequestMapping()
    public String vendorHome(Model model) {
        model.addAttribute("products", productService.getAll());
        return "vendor/vendor-index";
    }

    @RequestMapping(value = "/editproduct/{id}", method = RequestMethod.GET)
    public String editProduct(@ModelAttribute("vendor") Vendor vendor, @PathVariable long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "vendor/editproduct";
    }
    @RequestMapping(value = "/editproduct/{id}", method = RequestMethod.POST)
    public String editProduct(@ModelAttribute("product") Product product, BindingResult result,
            @PathVariable long id, HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        /*if(result.hasErrors()){
         return "vendor/addproduct";
         }	*/
        product.setId(id);
        try {
            product.setProductImage(file.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }

        productService.update(product);
        return "redirect:/vendor";
    }
    @RequestMapping(value = "/deleteproduct", method = RequestMethod.POST)
    public String deleteproduct( @RequestParam(value = "productId") long id) {
        Product p = productService.findById(id);
        if (p != null) {
            productService.delete(p);
        }
        return "redirect:/vendor";
    }

    @RequestMapping(value = "/addproduct", method = RequestMethod.GET)
    public String getadmin(@ModelAttribute("vendor") Vendor vendor, Model model) {
        model.addAttribute("product", new Product());
        return "vendor/addproduct";
    }

    @RequestMapping(value = "/addproduct", method = RequestMethod.POST)
    public String postadmin(@ModelAttribute("product") Product product, BindingResult result,
            HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        /*if(result.hasErrors()){
         return "vendor/addproduct";
         }	*/
        try {
            product.setProductImage(file.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }

        productService.create(product);
        return "redirect:/vendor";
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

}
