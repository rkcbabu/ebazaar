/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.pm.ebazaar.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
/**
 *
 * @author Chaulagai
 */
@Entity
public class Customer extends User implements Serializable {

    private static final long serialVersionUID = 1L;
    

    private String stutus;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateRegister;

    @OneToMany
    private List<Order> orders;

    private ShoppingCart shoppingCart;

    private Card card;

    public String getStutus() {
        return stutus;
    }

    public void setStutus(String stutus) {
        this.stutus = stutus;
    }

    public Date getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }


}
