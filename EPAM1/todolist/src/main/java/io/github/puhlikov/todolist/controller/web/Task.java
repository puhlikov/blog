package by.epam.belsut.kdv.todolist.controller.web;

import by.epam.belsut.kdv.todolist.constants.Constants;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 */
@WebServlet("/task")
public class Task extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Constants.TODAY_PAGE_URL).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//        req.getRequestDispatcher("view/task.html").forward(req, resp);
//    }

//    @Override
//    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("view/task.html").forward(req, resp);
//    }
}
