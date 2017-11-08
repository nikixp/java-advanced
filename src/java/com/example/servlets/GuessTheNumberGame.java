/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Student
 */
public class GuessTheNumberGame extends HttpServlet {

    Map<String, NumberHunter> sessionStorage = new HashMap<>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getSession().getId();
        NumberHunter numberHunter = sessionStorage.get(id);
        //Integer number = sessionStorage.get(id);
        if (numberHunter == null) {
            numberHunter = new NumberHunter();
            sessionStorage.put(id, numberHunter);
        }
        System.out.println(numberHunter.toString());

        String parameter = request.getParameter("guessNumber");
        Integer guessNumber = 0;
        if(parameter != null){
            guessNumber = Integer.parseInt(parameter);
        }
        
        String message = "Enter number";
        /*if (guessNumber == number) {
            message = "Your random number is " + String.valueOf(guessNumber) + ". Good job!";
            sessionStorage.put(id, new Random().nextInt(100));
        } else if (guessNumber > number) {
            message = "Your random number is smaller than " + String.valueOf(guessNumber) + ". Try again!";
        } else if (guessNumber < number) {
            message = "Your random number is greater than " + String.valueOf(guessNumber) + ". Try again!";
        }*/

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GuessTheNumberGame</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<form action=\"GuessTheNumberGame\">");
            out.println("<input type=\"number\" name=\"guessNumber\"");
            out.println("value=\"" + guessNumber + "\"");
            out.println("/>");
            out.println("<input type=\"submit\" value=\"Submit\"/></form>");

            out.println("<div>" + message + "</div>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
