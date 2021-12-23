package com.epam.training.servlets;

import com.mysql.jdbc.Constants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class AbstractServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(AbstractServlet.class.getName());

    protected void forward(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        LOGGER.info(url);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
        requestDispatcher.forward(request,response);
    }
    protected void forwardError(String message, String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        LOGGER.info(message);
        request.setAttribute("errorMassage", message);
        forward(url, request, response);
    }

}
