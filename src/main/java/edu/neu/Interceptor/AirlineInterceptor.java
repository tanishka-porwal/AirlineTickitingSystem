/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.Interceptor;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author tanishka
 */
public class AirlineInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            Enumeration<String> params = request.getParameterNames();
            while (params.hasMoreElements()) {
                String param = (String) params.nextElement();
                String value = request.getParameter(param);
                if (check(value)) {
                    request.setAttribute("unsafe_input", "true");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    private boolean check(String value) {
        if (value != null) {
            return (value.matches("<script>(.*?)</script>") || value.matches("\"<script(.*?)>\""));
        }
        return false;
    }

    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
        System.out.println("POST HANDLE");
    }

    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
        System.out.println("AFTER COMPLETION");
    }

}
