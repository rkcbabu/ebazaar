package mum.pm.ebazaar.controller;

import java.util.List;
import mum.pm.ebazaar.domain.Product;
import mum.pm.ebazaar.domain.ShoppingCart;
import mum.pm.ebazaar.service.ProductService;
import mum.pm.ebazaar.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {

    @Autowired
    ProductService productservice;
    @Autowired
    ShoppingCartService cartservice;

    @RequestMapping("/shop/addProduct")
    public void addProduct() {

    }

    @RequestMapping(value="/product-details/{id}", method = RequestMethod.GET)
    public String productdetails(Model model, @PathVariable long id) {
        Product product = productservice.findById(id);
        List <Product> similar = productservice.getAll();
        model.addAttribute("product", product);
        model.addAttribute("similar", similar);
        
        return "product/product-details";
    }
    
//    @RequestMapping(method = RequestMethod.POST)
//	public @ResponseBody ShoppingCart create(@RequestBody ShoppingCart cart) {
//		return  cartservice.create(cart);
//	}
    
    
}
