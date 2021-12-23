package by.epam.belsut.kdv.todolist.jdbc;

import by.epam.belsut.kdv.todolist.util.PropertyReader;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * класс для получение запросов для БД
 *
 *
 */
public class MySQLQuery {

    private static MySQLQuery instance;
    private static Map<String, String> queries;

    /**
     * метод для получения карты запросов из файла mysql_query.properties
     */
    private MySQLQuery() {
        Properties properties = PropertyReader.getProperties("sql/mysql_query.properties");
        Map<String, String> map = new HashMap<>();
        for (Map.Entry<Object, Object
                > entry : properties.entrySet()) {
            map.put((String) entry.getKey(), (String) entry.getValue());
        }
        queries = map;
    }

    /**
     * статический метод, возвращает единственный экземпляр класса, проверяя перед этим не создан ли он
     *
     * @return instance
     */
    public static MySQLQuery getInstance() {
        if (instance == null) {
            instance = new MySQLQuery();
        }
        return instance;
    }

    /**
     * получение запроса к БД по ключу
     *
     * @param key ключ по которому будет необходимый запрос к БД
     * @return запрос для БД
     */
    public String getQuery(String key) {
        return queries.get(key);
    }
}
