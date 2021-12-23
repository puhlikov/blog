package com.epam.training.part1.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public class PlantHandler implements InvocationHandler {

    private static final Logger LOGGER = Logger.getLogger(PlantHandler.class.getName());

    private Object object;

    public PlantHandler(Object object){
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.getName().startsWith("Received")){
            return 0;
        }
        LOGGER.info(String.format("PlantHandler invoke " + method.getName()));
        return method.invoke(object, args);
    }
}
