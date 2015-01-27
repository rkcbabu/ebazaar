package mum.pm.ebazaar.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mum.pm.ebazaar.domain.Product;
import mum.pm.ebazaar.service.ProductService;
import mum.pm.ebazaar.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    @Autowired
    ProductService productservice;
    @Autowired
    ShoppingCartService cartservice;

    @RequestMapping("/shop/addProduct")
    public void addProduct() {

    }

    @RequestMapping(value = "/product-details/{id}", method = RequestMethod.GET)
    public String productdetails(Model model, @PathVariable long id) {
        Product product = productservice.findById(id);
        List<Product> similar = productservice.getAll();
        model.addAttribute("product", product);
        model.addAttribute("similar", similar);

        return "product/product-details";
    }

//    @RequestMapping(method = RequestMethod.POST)
//	public @ResponseBody ShoppingCart create(@RequestBody ShoppingCart cart) {
//		return  cartservice.create(cart);
//	}
    @RequestMapping("/team7mycard")
    String validate(Model model) {
        String ccNo = "4024007182706563";
        String exptDate = "2017-01-03";
        String cvvNo = "549";
        double balance = 100;
        //model.addAttribute("result", Utils.isValid(ccNo, exptDate, cvvNo, balance));
        
        Map<String,String> params= new HashMap<String,String>();
        params.put("fullname", "Full Name");
        params.put("emailid", "rkcbabu@gmail.com");
        params.put("billingaddress", "fairfeild IOWA");
        
//        model.addAttribute("result", Utils.myfinance(ccNo, exptDate, cvvNo, balance, params));
        return "test";
    }
}
