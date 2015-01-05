/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.pm.ebazaar.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
/**
 *
 * @author Ram
 */
@Embeddable
public class Address implements Serializable {

	@NotEmpty(message = "Please enter your street.")
    private String street;

	@NotEmpty(message = "Please enter your city.")
    private String city;

	@NotEmpty(message = "Please enter your state.")
    private String state;

	@NotEmpty(message = "Please enter your zipcode.")
    private String zipcode;


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }


}
