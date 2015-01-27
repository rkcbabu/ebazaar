/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.ea.mycard.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import mum.ea.mycard.controller.CardController;
import mum.ea.mycard.domain.Card;
import org.springframework.util.DigestUtils;

/**
 *
 * @author Chaulagai
 */
public class Utils {
    public static boolean isValid(Card card, String exptDate, String cvvNo,double balance){
        boolean found = false ;
        try {
            Date exptDate1 = new SimpleDateFormat("yyyy-MM-dd").parse(exptDate);
            
            if (card != null) {
                if (card.getCvvno().equals(cvvNo) 
                        && card.getExptdate().equals(exptDate1) 
                        && card.getTotalbalance() >= balance ) {
                    found = true; 
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Date conversion failed.");
        }
        return found ;
    }
}
