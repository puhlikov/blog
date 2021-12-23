//package com.epam.training.connection;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import org.apache.log4j.Logger;
//
//public class SqlPoolConnection {
//    private static final Logger LOGGER = Logger.getLogger(String.valueOf(SqlPoolConnection.class));
//
//    private  SqlPoolConnection() {
//    }
//
//    public static Connection getConnection() throws SQLException{
//        LOGGER.info("Connection success");
//        Context ctx;
//        Connection connection = null;
//        try {
//            ctx = new InitialContext();
//            DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/lib-pool");
//            connection = ds.getConnection();
//        } catch (NamingException | SQLException e){
//            LOGGER.error(Arrays.toString(e.getStackTrace()) + ";" + e.getMessage());
//        }
//        return connection;
//    }
//}
