package ru.mail.puh2012.figure.extendfigure;

import ru.mail.puh2012.figure.Figure;

import java.io.Serializable;
import java.util.Objects;

/**
 * created by puh 18.04.19
 * create abstract class Rectangle extends Figure
 */

public abstract class Rectangle extends Figure implements Serializable {
    private double width;
    private double heigth;

    public Rectangle(double width, double heigth) {
        this.width = width;
        this.heigth = heigth;
    }
    public Rectangle(Figure figure){
        this.width = figure.getMinSize()/2;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeigth() {
        return heigth;
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

    @Override
    public double getArea() {
        return (heigth * width);
    }

    @Override
    public double getPerimeter() {
        return ((heigth * width) * 2);
    }

    @Override
    public String toString() {
        return super.toString() + ":widht=" + width + ":height=" + heigth;
    }
    @Override
    public  double getMinSize(){
        return Math.min(width,heigth);
    }

    @Override
    public boolean equals (Object o){
        if (this==o) return  true;
        if (!super.equals(o)) return false;
        Rectangle rectangle=(Rectangle) o;
        return Double.compare(rectangle.heigth, heigth)==0 && Double.compare(rectangle.width, width)==0;
    }
    @Override
    public int hashCode(){
        return Objects.hash (heigth,width);
    }
}