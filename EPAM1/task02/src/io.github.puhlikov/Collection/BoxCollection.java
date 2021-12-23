package ru.mail.puh2012.Collection;


import ru.mail.puh2012.figure.Figure;
import ru.mail.puh2012.figure.extendfigure.Circle;
import ru.mail.puh2012.figure.extendfigure.Rectangle;
import ru.mail.puh2012.figure.extendfigure.Triangle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class BoxCollection {
    public List<Figure> boxFigures = new ArrayList<>();

    public void addFigure(Figure figure) {
        if (figure != null && !boxFigures.contains(figure)) {
            boxFigures.add(figure);
        }
    }

    public int size() {
        int x = boxFigures.size();
        return x;
    }

    public void setBoxFigures(List<Figure> boxFigures) {
        this.boxFigures = boxFigures;
    }

    public List<Figure> getBoxFigures() {
        return boxFigures;
    }


    public void removeFigure(int i, Figure figure) {
        boxFigures.remove(figure);

    }

    public Figure getFigureIndex(int i) {
        return boxFigures.get(i);
    }

    public void addCollection(List<Figure> figures) {
        for (Figure figure : figures) {
            if (figure != null && !boxFigures.contains(figure)) {
                addFigure(figure);
            }
        }
    }


    public List<Figure> exstractAllFigureByClass(Figure figure) {
        List<Figure> list = new ArrayList<>();
        Class aClass = figure.getClass().getSuperclass();
        Iterator<Figure> iterator = boxFigures.iterator();
        while (iterator.hasNext()) {
            Figure shape = iterator.next();
            if (aClass.isInstance(shape)) {
                list.add(shape);
                iterator.remove();

            }

        }


        return list;
    }

    @Override
    public String toString() {
        String figure = "";
        for (Figure boxFigure : boxFigures){
            figure = figure + boxFigure + "\n";
        }
                return figure;
    }

}


















