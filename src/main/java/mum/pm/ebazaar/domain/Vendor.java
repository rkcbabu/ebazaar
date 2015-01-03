/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.pm.ebazaar.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
/**
 *
 * @author Chaulagai
 */
@Entity
public class Vendor extends User implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @OneToMany(mappedBy="vendor")
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    

}
