/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.pm.ebazaar.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Chaulagai
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    
    private String result ; 

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    

 }