/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.controller;

import edu.neu.pojo.PaymentProcessor;

/**
 *
 * @author tanishka
 */
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
public class PaymentProcessValidator implements Validator {

    @Override
    public boolean supports(Class aClass) {

        return aClass.equals(PaymentProcessor.class);
    }

    @Override
    public void validate(Object obj, Errors errors) {

        PaymentProcessor payment = (PaymentProcessor) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "creditCardNumber", "error.invalid.creditCardNumber",
                "Credit Card Number Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "error.invalid.fullName", "Full Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "expiration_month", "error.invalid.expiration_month",
                "Expiration Month Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "expiration_year", "error.invalid.expiration_year",
                "Expiration year Required");

    }
}
