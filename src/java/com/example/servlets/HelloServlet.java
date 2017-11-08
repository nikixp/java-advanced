package com.example.servlets;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Student
 */
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        /*PrintWriter writer = resp.getWriter();
        writer.append("<!DOCTYPE html>");
        writer.append("<html>");
        writer.append("<body>");
        writer.append("<h2>Hello, " + req.getParameter("userName") + "</h2>");
        writer.append("</body>");
        writer.append("</html>");*/
        
        ServletOutputStream out = resp.getOutputStream();
        out.println("<!DOCTYPE html>");
        out.println("<meta charset=\"utf-8\">");
        out.println("<html>");
        out.println("<body>");
        out.println("<h2>Hello, " + req.getParameter("userName") + "</h2>");
        out.println("</body>");
        out.println("</html>");

    }
    
    

}
