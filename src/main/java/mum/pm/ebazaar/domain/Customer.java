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

    @OneToMany(mappedBy="customer")
    private List<Order> orders;

    @OneToMany(mappedBy="customer")
    private List<ShoppingCart> shoppingCarts;

    @OneToMany(mappedBy="customer")
    private List<Card> cards ;

    public Customer() {
        super();
    }
    
    
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

    public List<ShoppingCart> getShoppingCarts() {
        return shoppingCarts;
    }

    public void setShoppingCarts(List<ShoppingCart> shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }

   
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

//    public List<Card> getCards() {
//        return cards;
//    }
//
//    public void setCards(List<Card> cards) {
//        this.cards = cards;
//    }

  

}
