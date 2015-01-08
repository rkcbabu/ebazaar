package mum.ea.myfinance.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mum.ea.myfinance.domain.Finance;
import mum.ea.myfinance.domain.Result;
import mum.ea.myfinance.service.FinanceService;
import mum.ea.myfinance.util.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping()
public class FinanceController {
    
    @Autowired
    private FinanceService financeService;
    
    @RequestMapping("/")
    @ResponseBody
    List<String> home(Model model) {
        List<String> welcome = new ArrayList<String>();
        welcome.add("Welcome to myfinance.COM webservices.");
        return welcome;
    }
    
    @RequestMapping(value = "/finances", method = RequestMethod.GET)
    @ResponseBody
    List<Finance> read() {
        return financeService.listFinances();
    }
    
    @RequestMapping(value = "/process/{ccNo}/{exptDate}/{cvvNo}/{balance}", method = RequestMethod.GET)
    @ResponseBody
    Result process(@PathVariable("ccNo") String ccNo, @PathVariable("exptDate") String exptDate,
            @PathVariable("cvvNo") String cvvNo, @PathVariable("balance") float balance, @RequestParam Map<String, String> params) {
        
        Result result = new Result();
        //result.setResult("NO");
//        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
//        headers.add("HeaderName", "value");
//        headers.add("Content-Type", "application/json");
//
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//
//        HttpEntity<ObjectToPass> request = new HttpEntity<ObjectToPass>(objectToPass, headers);
//
//        restTemplate.postForObject(url, request, Result.class);
        
        if ("YES".equals(Utils.isValid(ccNo, exptDate, cvvNo, balance))) {
            if ("YES".equals(Utils.deduct(ccNo, exptDate, cvvNo, balance))) {
                Finance finance = new Finance();
                finance.setCcno(ccNo);
                
                if (params.containsKey("fullname")) {
                    finance.setCcno(params.get("fullname"));
                }
                if (params.containsKey("emailid")) {
                    finance.setEmailid(params.get("emailid"));
                }
                if (params.containsKey("billingaddress")) {
                    finance.setBillingaddress(params.get("billingaddress"));
                }
                if (params.containsKey("paidtovendor")) {
                    finance.setPaidtovendor(balance*.80);
                }
//               finance.set
            }
        }
        
        return result;
        
    }
}
