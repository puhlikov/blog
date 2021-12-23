package com.epam.training.servlets;

import com.epam.training.DAO.BookDAO;
import com.epam.training.DAO.DBBookDAO;
import com.epam.training.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;


@WebServlet(name = "AddBooksServlet")
public class AddBooksServlet extends AbstractServlet {
    private static final Logger LOGGER = Logger.getLogger(AddBooksServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Do post");

        String bookName= request.getParameter("addBookname");
        String bookAuthor = request.getParameter("addBookAouthor");
        String bookDescription = request.getParameter("addBookDescription");


        BookDAO dbBookDAO = new DBBookDAO();
        Book books = null;
        try {
            dbBookDAO.addBook(books);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("books", books);
        forward("/add.jsp", request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
