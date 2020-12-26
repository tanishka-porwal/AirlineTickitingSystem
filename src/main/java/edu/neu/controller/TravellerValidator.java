/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
        

import edu.neu.pojo.Traveller;

/**
 *
 * @author tanishka
 */
public class TravellerValidator implements Validator {

    @Override
    public boolean supports(Class aClass) {
        return aClass.equals(Traveller.class);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Traveller passenger = (Traveller) obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.firstName",
                "First Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.lastName", "Last Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "error.invalid.gender", "Gender Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.email", "Email Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dob", "error.invalid.dob", "Date of Birth Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phonenum", "error.invalid.phonenum",
                "Phone Number Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "error.invalid.address", "Address Required");

    }

}
