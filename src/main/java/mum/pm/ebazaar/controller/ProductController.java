package mum.pm.ebazaar.controller;

import java.util.List;
import mum.pm.ebazaar.domain.Product;
import mum.pm.ebazaar.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @Autowired
    ProductService productservice;

    @RequestMapping("/shop/addProduct")
    public void addProduct() {

    }

    @RequestMapping("/product-details")
    public String productdetails(Model model) {
        Product product = productservice.findById(3);
        List <Product> similar = productservice.getAll();
        model.addAttribute("product", product);
        model.addAttribute("similar", similar);
        
        return "product/product-details";
    }

}
