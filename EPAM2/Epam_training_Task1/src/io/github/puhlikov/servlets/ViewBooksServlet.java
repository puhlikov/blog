package com.epam.training.servlets;
/**
 * com.epam.training.servlets
 * @author Pavel Bukhtsiyarau
 */

/* Servlets */

import com.epam.training.DAO.BookDAO;
import com.epam.training.DAO.DBBookDAO;

import com.epam.training.model.Book;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ViewBooksServlet")
public class ViewBooksServlet extends AbstractServlet {
    private static final Logger LOGGER = Logger.getLogger(ViewBooksServlet.class);

//    boolean stat = true;


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("do get");

        BookDAO dbBookDAO = new DBBookDAO();
        List<Book> books = new ArrayList<>();
        try {
            books = dbBookDAO.getBooks();
        } catch (SQLException e) {
            LOGGER.error(e.getStackTrace());
            forwardError(e.getMessage(), "error page", req, resp);
        }
//        if (stat) {
//            int param = Integer.parseInt(req.getParameter("Flag"));
//            if (req.getParameter("Flag").equals("Flag")) {
//                stat = true;
//                throw new UnavailableException("Error.", param);
//            }
//        }
        req.setAttribute("books", books);
        forward("/view.jsp", req, resp);

    }

    protected void forward(String url, HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }
}
