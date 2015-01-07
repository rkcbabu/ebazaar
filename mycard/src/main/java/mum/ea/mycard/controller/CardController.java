package mum.ea.mycard.controller;

import java.util.ArrayList;
import java.util.List;
import mum.ea.mycard.domain.Card;
import mum.ea.mycard.service.CardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping()
public class CardController {

    @Autowired
    private CardService cardService;

    @RequestMapping("/")
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

}
