package com.epam.training.DAO;
/**
 * com.epam.training.DAO
 * @author Pavel Bukhtsiyarau
 */
import com.epam.training.model.Book;

import java.sql.SQLException;
import java.util.List;


public interface BookDAO {

    List<Book> getBooks() throws SQLException;

    void addBook(Book book) throws SQLException;

    void updateBook (Book book) throws SQLException;

    Book getBook(int id) throws SQLException;
}
