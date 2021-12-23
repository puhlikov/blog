package ru.mail.puh2012.figure;

import java.io.Serializable;

/**
 * created by puh 17.04.19
 * create abstract class Figure
 */
public abstract class Figure implements Serializable {
    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract double getMinSize();

    @Override
    public String toString(){
        return this.getClass().getSimpleName();
    }

    @Override
    public boolean equals (Object o){
        return getClass()==o.getClass();
    }



}
