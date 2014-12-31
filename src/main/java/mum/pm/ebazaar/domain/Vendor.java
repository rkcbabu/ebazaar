/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.pm.ebazaar.domain;

import java.io.Serializable;
import javax.persistence.Entity;
/**
 *
 * @author Chaulagai
 */
@Entity
public class Vendor extends User implements Serializable {

    private static final long serialVersionUID = 1L;
   
    private Product[] product;

    public Product[] getProduct() {
        return product;
    }

    public void setProduct(Product[] product) {
        this.product = product;
    }

    

}
