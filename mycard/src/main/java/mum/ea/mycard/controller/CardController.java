package mum.ea.mycard.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mum.ea.mycard.domain.Card;
import mum.ea.mycard.domain.Result;
import mum.ea.mycard.service.CardService;
import mum.ea.mycard.util.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping()
public class CardController {

    @Autowired
    private CardService cardService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    List<String> home(Model model) {
        List<String> welcome = new ArrayList<String>();
        welcome.add("Welcome to MYCARD.COM webservices.");
        return welcome;
    }

    @RequestMapping(value = "/cards", method = RequestMethod.GET)
    @ResponseBody
    List<Card> read() {
        return cardService.listCards();
    }

    @RequestMapping(value = "/validate/{ccNo}/{exptDate}/{cvvNo}/{balance}", method = RequestMethod.GET)
    @ResponseBody
    Result valid(@PathVariable("ccNo") String ccNo, @PathVariable("exptDate") String exptDate,
            @PathVariable("cvvNo") String cvvNo, @PathVariable("balance") float balance) {

        Card card = cardService.findByCCNO(ccNo);
        Result result = new Result();
        result.setResult(Utils.isValid(card, exptDate, cvvNo, balance) ? "YES" : "NO");
        return result;
    }

    @RequestMapping(value = "/deduct/{ccNo}/{exptDate}/{cvvNo}/{balance}", method = RequestMethod.GET)
    @ResponseBody
    Result deduct(@PathVariable("ccNo") String ccNo, @PathVariable("exptDate") String exptDate,
            @PathVariable("cvvNo") String cvvNo, @PathVariable("balance") float balance) {
        Card card = cardService.findByCCNO(ccNo);
        Result result = new Result();
        if (Utils.isValid(card, exptDate, cvvNo, balance)) {
            card.setAvailablebalance(card.getAvailablebalance() - balance);
            cardService.saveCard(card);
            result.setResult("YES");
        } else {
            result.setResult("NO");
        }
        return result;
    }

//    @RequestMapping(value = "/validate", method = RequestMethod.POST)
//    @ResponseBody
//    Result valid(@RequestParam Map<String,String> allRequestParams) {
//        System.out.println(allRequestParams);
//        Result result = new Result();
//        result.setResult("YES");
//        return result;
//    }
//    @GET
//    @Path("{cardnumber}/{holdername}/{expireddate}/{securecode}/{amount}")
////    @Produces("text/plain")
//    public boolean validate(
//            @PathParam("cardnumber") String cardnumber,
//            @PathParam("holdername") String holdername,
//            @PathParam("expireddate") String expiredate,
//            @PathParam("securecode") String securecode,
//            @PathParam("amount") double amount
//            ) {
//        
//        return true; 
//    }
}
