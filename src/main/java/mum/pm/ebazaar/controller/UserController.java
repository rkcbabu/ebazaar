package mum.pm.ebazaar.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import mum.pm.ebazaar.domain.Customer;

import mum.pm.ebazaar.domain.User;
import mum.pm.ebazaar.domain.Vendor;
import mum.pm.ebazaar.service.CustomerService;
import mum.pm.ebazaar.service.UserService;
import mum.pm.ebazaar.service.VendorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    UserService userservice;
    
    @Autowired
    CustomerService customerService;
    
    @Autowired
    VendorService vendorService;

//    @InitBinder
//    public void initConverter(WebDataBinder binder)
//    {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        dateFormat.setLenient(false);
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//        binder.registerCustomEditor(Vendor.class, new UserPropertyEditor(userservice));        
//    } 
    @RequestMapping(value = "/register")
    public String vendorRegister(@RequestParam("user") String type, Model model) {
        if (type == null) {
            Customer user = new Customer();
            model.addAttribute("customer", user);
            return "redirect:/customerForm";
        } else if (type.equalsIgnoreCase("vendor")) {
            Vendor vendor = new Vendor();
            model.addAttribute("vendor", vendor);
            return "user/vendorForm";
        } else if (type.equalsIgnoreCase("admin")) {
            User user = new User();
            model.addAttribute("user", user);
            return "user/adminForm";
        } else {
            return "user/customerForm";
        }
    }

    @RequestMapping( "/registerCustomer")
    public String saveUserCustomer(Model model, HttpServletRequest request) {      
            model.addAttribute("customer",  new Customer());
            request.getSession().setAttribute("customer", new Customer());
         return "user/customerForm";
    }
    @RequestMapping(value = "/registerCustomer", method = RequestMethod.POST)
    public String saveUserCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            return "user/customerForm";
        } else {
            String md5password = DigestUtils.md5DigestAsHex(customer.getPassword().getBytes());
            customer.setPassword(md5password);
            customer.setEnabled(true);
            customerService.create(customer);
            return "redirect:/login";
        }

    }
    @RequestMapping(value = "/registerVendor", method = RequestMethod.POST)
    public String saveUserVendor(@Valid @ModelAttribute("user") Vendor vendor, BindingResult result) {
        if (result.hasErrors()) {
            return "user/customerForm";
        } else {
            String md5password = DigestUtils.md5DigestAsHex(vendor.getPassword().getBytes());
            vendor.setPassword(md5password);
            vendor.setEnabled(true);
            vendorService.create(vendor);
            return "redirect:/login";
        }

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            if (user.getRole() == null) {
                return "user/customerForm";
            } else if (user.getRole().equalsIgnoreCase("ROLE_VENDOR")) {

                return "user/vendorForm";
            } else if (user.getRole().equalsIgnoreCase("ROLE_ADMIN")) {
                return "user/adminForm";
            } else {
                return "user/customerForm";
            }
        } else {
            user.setEnabled(true);
            if (user.getRole().equalsIgnoreCase("ROLE_VENDOR")) {
                user.setEnabled(true); // we have to disable it later.

                return "user/vendorForm";
            } else if (user.getRole().equalsIgnoreCase("ROLE_ADMIN")) {
                user.setEnabled(false);

                return "user/adminForm";
            }
            

            if (user.getRole() == null) {
                user.setRole("ROLE_CUSTOMER");
            }
            userservice.create(user);

        }
        return "redirect:/login";
    }

}
