/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.controller;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.neu.pojo.FlightInformation;
/**
 *
 * @author tanishka
 */
public class FlightBookingValidator implements Validator {

    @Override
    public boolean supports(Class aClass) {
        return aClass.equals(FlightInformation.class);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        FlightInformation fd = (FlightInformation) obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "flight_name", "error.invalid.flight_name",
                "Flight Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "airplane_id", "error.invalid.airplane_id",
                "Airplane Id Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "from", "error.invalid.from", "From Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dest", "error.invalid.dest", "Dest Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "deptTime", "error.invalid.deptTime",
                "Departure Time Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "arrivalTime", "error.invalid.arrivalTime",
                "Arrival Time Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "travelClass", "error.invalid.travelClass",
                "Travel Class Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "totalSeats", "error.invalid.totalSeats",
                "Total Seats Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "availableSeats", "error.invalid.availableSeats",
                "Available Seats Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount", "error.invalid.amount", "Amount Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "deptDate", "error.invalid.deptDate",
                "Departure Date Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "arrDate", "error.invalid.arrDate", "Arrival Date Required");

    }
}
