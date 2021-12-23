package by.epam.belsut.kdv.todolist.dao.impl;

import by.epam.belsut.kdv.todolist.constants.ConstantsSQL;
import by.epam.belsut.kdv.todolist.dao.AttachmentDAO;
import by.epam.belsut.kdv.todolist.dao.TaskDAO;
import by.epam.belsut.kdv.todolist.jdbc.DBConnector;
import by.epam.belsut.kdv.todolist.jdbc.MySQLQuery;
import by.epam.belsut.kdv.todolist.model.Attachment;
import by.epam.belsut.kdv.todolist.model.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * класс реализует интерфейс TaskDAO, получает данные из таблиц БД
 * через запросы из файла mysql_queries.properties с использованием JDBC.
 *
 *
 */
public class TaskDAOImpl implements TaskDAO {

    private Connection connection = DBConnector.getInstance().getConnection();

    /**
     * переопределеный метод, получает информацию о задании (заметки) из БД по входному параметку taskId
     *
     * @param taskId уникальное имя, порядновый номер файла в БД
     * @return результат запроса taskGetOne из файла mysql_query.properties
     */
    @Override
    public Task getOne(Long taskId) {
        String query = MySQLQuery.getInstance().getQuery("taskGetOne");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Task task = new Task();
        final int TASK_ID = 1;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(TASK_ID, taskId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                setOneTask(resultSet, task);
            }
            return task;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(preparedStatement, resultSet);
        }
        return task;
    }

    /**
     * переопределеный метод, получает информацию о заданиях (заметках) из БД за определенный деньпо входному параметку day
     *
     * @param day День
     * @return результат запроса taskFindAllByDay из файла mysql_query.properties
     */
    @Override
    public List<Task> findAllByDay(String day) {
        String query = MySQLQuery.getInstance().getQuery(ConstantsSQL.PROP_KEY_FIND_ALL_BY_DAY);
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Task> tasks = new ArrayList<>();
        final int DATE = 1;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(DATE, Date.valueOf(day));
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Task task = new Task();
                setOneTask(resultSet, task);
                tasks.add(task);
            }
            return tasks;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(preparedStatement, resultSet);
        }
        return null;
    }

    /**
     * переопределеный метод, получает информацию о заданиях (заметках) из БД которые будут послезавтра и дальше
     *
     * @return результат запроса taskFindAllSomeday из файла mysql_query.properties
     */
    @Override
    public List<Task> findAllSomeday() {
        String query = MySQLQuery.getInstance().getQuery("taskFindAllSomeday");
        return getTasksList(query);
    }

    /**
     * сохраняет задание (задачу) в БД
     *
     * @param task задание которое необходимо сохранить
     * @return возвращает сохраненное задание (задачу)
     */
    @Override
    public Task save(Task task) {
        String query = task.getId() == null ?
                MySQLQuery.getInstance().getQuery("taskSave") :
                MySQLQuery.getInstance().getQuery("taskUpdate");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = task.getId() == null ?
                    connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS) :
                    connection.prepareStatement(query);
            preparedStatement.setString(1, task.getName());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setDate(3, task.getEventDate());
            preparedStatement.setInt(4, boolToInt(task.getDeleted()));
            if (task.getId() == null) {
                preparedStatement.executeUpdate();
                resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    return getOne(resultSet.getLong(1));
                }
                return null;
            } else {
                preparedStatement.setLong(5, task.getId());
                if (preparedStatement.executeUpdate() > 0) {
                    return task;
                }
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(preparedStatement, resultSet);
        }
        return null;
    }

    @Override
    public Task updateAttachmentIdFromTask(Long taskId, Long attachmentId) {
        String query = MySQLQuery.getInstance().getQuery("taskUpdateAttachmentId");
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            if (attachmentId > 0) {
                preparedStatement.setLong(1, attachmentId);
            } else {
                preparedStatement.setString(1, null);
            }
            preparedStatement.setLong(2, taskId);
            preparedStatement.executeUpdate();
            if (preparedStatement.executeUpdate() > 0) {
                return getOne(taskId);
            }
            return null;
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(preparedStatement, null);
        }
        return null;
    }

    /**
     * переопределеный метод, помечает задание на удаление (перемещение в корзину), если задание уже имеет положительный
     * статус метки на удаление (в корзине) восстанавливает его из корзины меняя дату на сегодняшнюю
     *
     * @param taskId    номер задания которое необходимо поменить на удаление (перемещение в корзину)
     * @param isDeleted статус удаления (в корзину или из нее)
     * @return задание (заметку) с изменениями.
     */
    @Override
    public Task markDeleted(Long taskId, boolean isDeleted) {
        Task task = getOne(taskId);
        task.setDeleted(isDeleted);
        task.setEventDate(isDeleted ? task.getEventDate() : getTime());
        return save(task);
    }

    /**
     * переопределеный метод выводит список всех заметок (заданий) которые находятся в корзине (имеют статус удалены)
     *
     * @return List<Task>, список заданий которые находятся в корзине (имеют статус удалены)
     */
    @Override
    public List<Task> findAllFromBasket() {
        String query = MySQLQuery.getInstance().getQuery("taskFindAllBasket");
        return getTasksList(query);
    }

    /**
     * переопределеный метод который удаляет заметку из БД.
     *
     * @param taskId номер заметки которую необходимо удалить
     * @return boolean возвращает статус удалена заметка или нет
     */
    @Override
    public boolean remove(Long taskId) {
        String query = MySQLQuery.getInstance().getQuery("taskDelete");
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, taskId);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(preparedStatement, null);
        }
        return false;
    }

    /**
     * метод закрывает соединение
     *
     * @param preparedStatement
     * @param resultSet
     */
    static void closeConnection(PreparedStatement preparedStatement, ResultSet resultSet) {

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void setOneTask(ResultSet resultSet, Task task) throws SQLException {
        task.setId(resultSet.getLong("id"));
        task.setName(resultSet.getString("name"));
        task.setDescription(resultSet.getString("description"));
        task.setEventDate(resultSet.getDate("event_date"));
        task.setDeleted(resultSet.getInt("deleted"));
        task.setAttachmentId(resultSet.getLong("attachment_id"));
    }

    private List<Task> getTasksList(String query) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Task> tasks = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Task task = new Task();
                setOneTask(resultSet, task);
                tasks.add(task);
            }
            return tasks;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(preparedStatement, resultSet);
        }
        return null;
    }

    /**
     * Преобразует boolean к int
     *
     * @param bool boolean
     * @return int
     */
    private Integer boolToInt(Boolean bool) {
        if (bool) {
            return 1;
        }
        return 0;
    }

    /**
     * метод возвращает сегодняшнюю дату
     *
     * @return сегодняшняя дата
     */
    private Date getTime() {
        java.util.Date dateUtil = new java.util.Date();
        return new Date(dateUtil.getTime());
    }

    /**
     * класс реализует интерфейс AttachmentDAO, получает данные из таблиц БД
     * через запросы из файла mysql_queries.properties с использованием JDBC.
     *
     *
     */
    public static class AttachmentDAOImpl implements AttachmentDAO {

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
                closeConnection(preparedStatement, null);
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
                closeConnection(preparedStatement, null);
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
                closeConnection(preparedStatement, null);
            }
            return false;
        }
    }
}
