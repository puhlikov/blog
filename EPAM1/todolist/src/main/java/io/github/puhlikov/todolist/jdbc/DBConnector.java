package by.epam.belsut.kdv.todolist.jdbc;

import by.epam.belsut.kdv.todolist.util.PropertyReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * класс для установления соединения с БД
 *
 *
 */
public class DBConnector {

    private static DBConnector instance;
    private static Connection connection;

    /**
     * метод для соединения с БД по параметрам, читаемые из файла connection.properties
     */
    private DBConnector() {
        Properties properties = PropertyReader.getProperties("connection.properties");
        Connection connection = null;
        try {
            Class.forName(properties.getProperty("driver"));
            try {
                connection = DriverManager.getConnection(
                        properties.getProperty("url"),
                        properties.getProperty("username"),
                        properties.getProperty("password")
                );
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        DBConnector.connection = connection;
    }

    /**
     * статический метод, возвращает единственный экземпляр класса, проверяя перед этим не создан ли он
     * (создание объекта при первом вызове метода)
     *
     * @return instance
     */
    public static DBConnector getInstance() {
        if (instance == null) {
            instance = new DBConnector();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
