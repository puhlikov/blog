package by.epam.belsut.kdv.todolist.dao.impl;

import by.epam.belsut.kdv.todolist.dao.AttachmentDAO;
import by.epam.belsut.kdv.todolist.jdbc.DBConnector;
import by.epam.belsut.kdv.todolist.jdbc.MySQLQuery;
import by.epam.belsut.kdv.todolist.model.Attachment;

import java.sql.*;

/**
 * класс реализует интерфейс AttachmentDAO, получает данные из таблиц БД
 * через запросы из файла mysql_queries.properties с использованием JDBC.
 *
 *
 */
public class AttachmentDAOImpl implements AttachmentDAO {

    private Connection connection = DBConnector.getInstance().getConnection();

    /**
     * переопределеный метод, получает информацию о файле (приложение) из БД по входному параметку attachmentId
     *
     * @param attachmentId уникальное имя, порядновый номер файла в БД
     * @return результат запроса attachmentGetOne из файла mysql_query.properties
     */
    @Override
    public Attachment getOne(Long attachmentId) {
        String query = MySQLQuery.getInstance().getQuery("attachmentGetOne");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Attachment attachment = new Attachment();
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, attachmentId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                attachment.setId(resultSet.getLong("id"));
                attachment.setTaskId(resultSet.getLong("task_id"));
                attachment.setFileName(resultSet.getString("file_name"));
                attachment.setFilePath(resultSet.getString("file_path"));
            }
            return attachment;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            TaskDAOImpl.closeConnection(preparedStatement, null);
        }
        return attachment;
    }

    /**
     * переопределеный метод, сохраняет информацию о файле (приложение) в БД модели attachment
     *
     * @param attachment модель файла приложения которую необходимо сохранить в БД, без attachmentId
     * @return модель файла приложения которую сохраненная в БД, с attachmentId
     */
    @Override
    public Attachment save(Attachment attachment) {
        String query = MySQLQuery.getInstance().getQuery("attachmentSave");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, attachment.getTaskId());
            preparedStatement.setString(2, attachment.getFileName());
            preparedStatement.setString(3, attachment.getFilePath());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                return getOne(resultSet.getLong(1));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            TaskDAOImpl.closeConnection(preparedStatement, null);
        }
        return null;
    }

    /**
     * переопределеный метод, удаляет информацию о файле (приложение) в БД по attachmentId
     *
     * @param attachmentId уникальное имя, порядновый номер файла в БД
     * @return результат удаления boolean
     */
    @Override
    public boolean remove(Long attachmentId) {
        String query = MySQLQuery.getInstance().getQuery("attachmentDelete");
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, attachmentId);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            TaskDAOImpl.closeConnection(preparedStatement, null);
        }
        return false;
    }
}
