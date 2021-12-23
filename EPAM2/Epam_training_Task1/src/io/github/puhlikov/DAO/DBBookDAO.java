package com.epam.training.DAO;
/**
 * com.epam.training.DAO
 *
 * @author Pavel Bukhtsiyarau
 */

//import com.epam.training.connection.SqlPoolConnection;
import com.epam.training.connection.MySQLConnector;
import com.epam.training.model.Book;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/* create class DAO */

public class DBBookDAO  implements BookDAO {
    private static final Logger LOGGER = Logger.getLogger(DBBookDAO.class.getName());

    private static final String SQL_GET_ALL_BOOKS = "SELECT id, name FROM books";
    private static final String SQL_ADD_BOOK = "INSERT BOOKS (NAME, AUTHOR, DESCRIPTION) VALUES(?, ?, ?)";
    private static final String SQL_GET_BOOK_BY_ID = "SELECT * FROM books WHERE id = ?";
    private static final String SQL_UPDATE_BOOK = "UPDATE books" + "SET name = ?, author = ?, description = ? WHERE id = ?";

    @Override
    public void addBook(Book book) throws SQLException {

        PreparedStatement ps = null;
        Connection connection = null;

        try {
            connection = MySQLConnector.createConnection();
            ps = connection.prepareStatement(SQL_ADD_BOOK);

            ps.setInt(1, book.getId());
            ps.setString(2, book.getName());
            ps.setString(3, book.getAuthor());
            ps.setString(4, book.getDescription());
            ps.executeUpdate();


        } catch (SQLException e) {
            LOGGER.error(Arrays.toString(e.getStackTrace()) + ":" + e.getMessage());


        } finally {
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public List<Book> getBooks() throws SQLException {
        List<Book> books = new ArrayList<>();

        PreparedStatement ps = null;
        Connection connection = null;

        try {
            connection = MySQLConnector.createConnection();
            ps = connection.prepareStatement(SQL_GET_ALL_BOOKS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                books.add(new Book(id, name));
            }
        } catch (SQLException e) {
            LOGGER.info("Illegal sql-response." + e.getMessage());
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return books;
    }


    @Override
    public void updateBook(Book book) throws SQLException {
        PreparedStatement ps = null;
        Connection connection = null;

        try {
            ps = connection.prepareStatement(SQL_UPDATE_BOOK);

            ps.setString(1, book.getName());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getDescription());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public Book getBook(int id) throws SQLException {



        Book book = null;

        try (Connection connection = MySQLConnector.createConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BOOK_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name2 = resultSet.getString("name");
                String author2 = resultSet.getString("author");
                String description2 = resultSet.getString("description");

                book = new Book(id, name2, author2, description2);
            }
        }catch (SQLException e){
            LOGGER.error(Arrays.toString(e.getStackTrace()) + ":" + e.getMessage());
        }

        return book;
    }
}
