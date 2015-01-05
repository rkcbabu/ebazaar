/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.pm.ebazaar.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Ghenet
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such Order")  // 404
public class NotFoundException extends RuntimeException {
    // ...
}
