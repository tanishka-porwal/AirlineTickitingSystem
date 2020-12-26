/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.controller;

import edu.neu.dao.AirlineDao;
import edu.neu.exception.AddException;
import edu.neu.pojo.Airline;


import org.springframework.beans.factory.annotation.Qualifier;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author tanishka
 */

@Controller
@RequestMapping(value = "/*Airplane.htm")

public class AirlineController {

    @Autowired
    @Qualifier("airplaneValidator")
    AirlineValidator avalidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(avalidator);
    }

    @RequestMapping(value = "/addAirplane.htm", method = RequestMethod.POST)
    protected String doSubmitAction(@Validated @ModelAttribute("airplane") Airline airplane, BindingResult result)
            throws Exception {
        avalidator.validate(airplane, result);
        if (result.hasErrors()) {
            return "addAirplane";
        }
        try {
            AirlineDao a_dao = new AirlineDao();
            String name = airplane.getAirlineName();
            name = name.replaceAll("[^A-Za-z]+$", "");
            String owner = airplane.getOwner();
            owner = owner.replaceAll("[^A-Za-z]+$", "");

            a_dao.create(name, owner);
        } catch (AddException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        return "addedAirplane";
    }

    @RequestMapping(value = "/addAirplane.htm", method = RequestMethod.GET)
    public String initializeForm(@ModelAttribute("airplane") Airline airplane, BindingResult result) {

        return "addAirplane";
    }

    @RequestMapping(value = "/deleteAirplane.htm", method = RequestMethod.GET)
    public String delete() {

        return "deleteAirplane";
    }

    @RequestMapping(value = "/deleteAirplane.htm", method = RequestMethod.POST)
    public String deleteAirplane(HttpServletRequest request) {

        String desiredJsp = " ";
        try {
            AirlineDao a_dao = new AirlineDao();
            String id = request.getParameter("airplane_id");
            id = id.replaceAll("[^\\d]+$", "");
            long airplane_id = Long.parseLong(id);
            int res = a_dao.deleteAirplane(airplane_id);
            if (res == 1) {
                desiredJsp = "deletedAirplane";
            } else {
                desiredJsp = "error";
            }
        } catch (AddException e){
            System.out.println("Exception: " + e.getMessage());
        }
        
        return desiredJsp;
        
        }
    
    }
