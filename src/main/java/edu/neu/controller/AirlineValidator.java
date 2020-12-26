/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.controller;


import edu.neu.pojo.Airline;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Errors;



/**
 *
 * @author tanishka
 */

public class AirlineValidator implements Validator{

    @Override
    public boolean supports(Class aClass){
        return aClass.equals(Airline.class);
    }
    @Override
    public void validate(Object obj, Errors errors){
        Airline airplane = (Airline) obj;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "airlineName", "error.invalid.airlineName", "Airplane Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "owner", "error.invalid.owner", "Owner Required");
    }    
}
