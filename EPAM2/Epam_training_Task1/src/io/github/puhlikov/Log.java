//package com.epam.training;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.ServletRegistration;
//import java.util.Map;
//import java.util.logging.Logger;
//
//public class Log implements ServletContextListener {
//
//        @Override
//        public void contextInitialized(ServletContextEvent servletContextEvent) {
//            Logger log =  Logger.getLogger("log");
//            ServletContext servletContext = servletContextEvent.getServletContext();
//            log.info("Name:" + servletContext.getServletContextName());
//            Map<String, ? extends ServletRegistration> servletRegistrations = servletContext.getServletRegistrations();
//            for (String key : servletRegistrations.keySet()) {
//                ServletRegistration servletRegistration = servletRegistrations.get(key);
//                log.info("Servlet: " + servletRegistration.getName()
//                        + "  url servlet: " + servletRegistration.getMappings());
//            }
//        }
//
//        @Override
//        public void contextDestroyed(ServletContextEvent servletContextEvent) {
//
//        }
//    }
//
