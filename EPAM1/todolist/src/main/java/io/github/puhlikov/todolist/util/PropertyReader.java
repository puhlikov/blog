package by.epam.belsut.kdv.todolist.util;

import java.io.IOException;
import java.util.Properties;

/**
 * класс, для чтения данных из файла connection.properties при подключении к БД
 *
 *
 */
public class PropertyReader {

    public static Properties getProperties(String fileName) {

        Properties properties = new Properties();

        try {
            properties.load(
                    PropertyReader.class
                            .getClassLoader()
                            .getResourceAsStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
