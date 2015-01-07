package mum.ea.myfinance.controller;

import java.util.ArrayList;
import java.util.List;
import mum.ea.myfinance.domain.Finance;
import mum.ea.myfinance.service.FinanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

}
