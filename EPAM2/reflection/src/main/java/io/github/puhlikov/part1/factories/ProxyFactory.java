package com.epam.training.part1.factories;

import com.epam.training.part1.annotations.Proxy;
import com.epam.training.part1.interfaces.Plants;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;

public class ProxyFactory {
    private static final Logger LOGGER = Logger.getLogger(ProxyFactory.class.getName());

    private ProxyFactory(){}

    public static Object getInstanceOf(final Class aClass) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        if (aClass.isAnnotationPresent(Proxy.class)){
            Proxy proxy = (Proxy) aClass.getAnnotation(Proxy.class);
            Class aClass1 = proxy.invocationHandler();

            Constructor constructor = aClass1.getConstructor(Object.class);
            InvocationHandler invocationHandler = (InvocationHandler) constructor.newInstance(aClass.newInstance());
            return (Plants)java.lang.reflect.Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), invocationHandler);
        } else {
            return aClass.newInstance();
        }
    }
}
