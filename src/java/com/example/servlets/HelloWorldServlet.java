package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Student
 */
public class HelloWorldServlet extends HttpServlet {

    Map<String, List<String>> sessionStorage = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String sessionId = req.getSession().getId();
        List<String> inputs = sessionStorage.get(sessionId);
        if (inputs == null) {
            inputs = new ArrayList<>();
            sessionStorage.put(sessionId, inputs);
        }

        String userName = req.getParameter("userName");
        if (userName == null) {
            userName = "";
        } else {
            inputs.add(userName);
        }

        PrintWriter out = resp.getWriter();
        out.append("<!DOCTYPE html><html><head></head><body>");
        out.append("<form action=\"HelloWorldServlet\">");
        out.append("<input type=\"text\" name=\"userName\"");
        out.append("value=\"" + userName + "\"");
        out.append("/>");
        out.append("<input type=\"submit\" value=\"Submit\"/></form>");
        out.append("<div><strong>Session: </strong>" + sessionId + "</div>");
        out.append("<div><strong>Inputs:</strong></div>");

        for (String s : inputs) {
            out.append("<div>input: " + s + "<div>");
        }

        out.append("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
