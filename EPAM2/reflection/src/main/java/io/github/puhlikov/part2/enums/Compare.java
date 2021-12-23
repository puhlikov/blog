package com.epam.training.part2.enums;

import java.lang.reflect.Field;

public enum Compare {

    REFERENCE
            {

        @Override
        public boolean compareBy (Object object1, Object object2, Field field) throws IllegalAccessException{
            return field.get(object1).equals(field.get(object2));
        }

        @Override
        public  String toString(){
            return this.name().toLowerCase();
        }
    },

    VALUE
            {

        @Override
        public boolean compareBy(Object object1, Object object2, Field field) throws IllegalAccessException {
            return field.get(object1) == field.get(object2);
        }

        @Override
        public String toString(){
            return  this.name().toLowerCase();
        }
    };

    public abstract boolean compareBy (Object object1, Object object2, Field field) throws IllegalAccessException;
}
