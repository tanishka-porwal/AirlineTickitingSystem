/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.controller;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.neu.dao.DisplayFlightsDAO;
import edu.neu.exception.AddException;
import edu.neu.pojo.FlightInformation;

/**
 *
 * @author tanishka
 */

@Controller
@RequestMapping(value = "/listflights.htm")
public class ListFlightsController {

    @RequestMapping(value = "/listflights.htm", method = RequestMethod.POST)
    public String initializeForm(@ModelAttribute("flightDetails") FlightInformation flightDetails,
            HttpServletRequest request, DisplayFlightsDAO ldao) throws AddException {
        HttpSession session = request.getSession();
        String from = request.getParameter("from");
        from = from.replaceAll("[^A-Za-z]+$", "");
        String dest = request.getParameter("dest");
        dest = dest.replaceAll("[^A-Za-z]+$", "");
        String deptDate = request.getParameter("deptDate");
        System.out.println("From place " + from + "Dest " + dest + "Dept date " + deptDate);
        try {
            List<String> flightlist = ldao.listFlights(from, dest, deptDate);
            int length = flightlist.size();
            session.setAttribute("flightlist", flightlist);

        } catch (AddException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        return "flightList";
    }

}
