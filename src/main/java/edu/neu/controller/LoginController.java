/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.neu.dao.LoginDao;
import edu.neu.exception.AddException;
import edu.neu.pojo.FlightInformation;
import edu.neu.pojo.User;

/**
 *
 * @author tanishka
 */

@Controller
@RequestMapping(value = "/")
public class LoginController {

    @RequestMapping(value = "/login.htm", method = RequestMethod.GET)
    public String initializeForm() {
        return "login";
    }

    @RequestMapping(value = "/login.htm", method = RequestMethod.POST)
    public String validatePassenger(HttpServletRequest request) throws Exception {
        LoginDao login = new LoginDao();
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean flag = false;
        boolean check = false;
        try {

            flag = login.validateAdmin(username, password);
            check = login.validatePassenger(username, password);

        } catch (AddException e) {

            System.out.println("Exception: " + e.getMessage());

        }

        if (flag) {
            System.out.println("Successfully Logged In");
            session.setAttribute("username", username);
            return "adminHome";

        } else if (check) {

            System.out.println("Login successful");
            session.setAttribute("username", username);
            return "viewCart";

        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
    public String logout(@ModelAttribute("flightInformation") FlightInformation flightInformation,
            HttpServletRequest request) {

        HttpSession session = request.getSession();

        session.invalidate();
        return "index";

    }

    @RequestMapping(value = "/signup.htm", method = RequestMethod.GET)
    public String SignUp(@ModelAttribute("users") User users) {

        return "signup";

    }

    @RequestMapping(value = "/signup.htm", method = RequestMethod.POST)
    public String SignUpUser(@ModelAttribute("users") User users, HttpServletRequest request,
            HttpServletResponse response, LoginDao login) throws IOException, JSONException {
        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("ajaxCheck")) {
            PrintWriter out = response.getWriter();

            if (login.userPreExists(request.getParameter("username"))) {

                JSONObject obj = new JSONObject();
                obj.put("message", "Username already exists");
                out.println(obj);

            } else {
                out.println("This Username is available");
            }
            return null;
        } else if (action.equalsIgnoreCase("signup")) {
            HttpSession session = request.getSession();
            String username = request.getParameter("username");
            System.out.println("username is:" + username);
            username = username.replaceAll("[^\\dA-Za-z ]", "");
            String password = request.getParameter("password");
            String role = "customer";

            try {
                login.addUser(username, password, role);
            } catch (AddException e) {

                System.out.println("Exception: " + e.getMessage());

            }

            System.out.println("New user added successfully");
            session.setAttribute("username", username);

        }

        return "viewCart";
    }

}
