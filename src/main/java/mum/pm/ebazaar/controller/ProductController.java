package mum.pm.ebazaar.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import mum.pm.ebazaar.domain.Product;
import mum.pm.ebazaar.domain.Result;
import mum.pm.ebazaar.service.ProductService;
import mum.pm.ebazaar.service.ShoppingCartService;
import mum.pm.ebazaar.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

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
    @RequestMapping("/mycard")
    String validate(Model model) {
        String ccNo = "4024007182706563";
        String exptDate = "2018-01-03";
        String cvvNo = "549";
        Double balance = 100.0;
        model.addAttribute("result", Utils.isValid(ccNo, exptDate, cvvNo, balance));
        return "test";
    }
}
