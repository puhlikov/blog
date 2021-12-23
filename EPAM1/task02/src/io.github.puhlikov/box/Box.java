package ru.mail.puh2012.box;

import ru.mail.puh2012.figure.Figure;
import ru.mail.puh2012.figure.extendfigure.Circle;
import ru.mail.puh2012.film.IFilm;

public class Box {
    private final int SIZE;
    private Figure[] figures;

    public Box(int size) {
        this.SIZE = size;
        figures = new Figure[this.SIZE];
    }

    public int getCount() {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (figures[i] != null) {
                count++;
//                count += figures[i].getPerimeter();
            }
        }
        return count;
    }

    public Figure showFigure(int index) {
        return figures[index];
    }

    public Figure getFigure(int index) {
        if (figures[index] != null) {
            Figure figure = figures[index];
            figures[index] = null;
            return figure;
        }
        return null;
    }

    public Figure setFigure(int index, Figure figure) {
        if (figures[index] != null) {
            return figures[index];
        } else {
            figures[index] = figure;
            return figure;
        }
    }


    public Figure replaceFigure(int index, Figure figure) {
        figures[index] = figure;
        return figure;
    }

    public boolean findByFigure(Figure figure) {
        if (figure == null) {
            return false;
        }
        for (Figure figure1 : figures) {
            if (figure1 != null) {
                if (figure.equals(figure1)) {
                    return true;
                }
            }
        }
        return true;
    }

    public void showBox() {
        for (int i = 0; i < figures.length; i++) {
            if (figures[i] != null) {
                int count = i;

                System.out.println(" figure " + count + ": " + figures[i].toString());
            }
        }
    }

    public int getAllArea() {
        int summ = 0;
        for (int i = 0; i < figures.length; i++) {
            if (figures[i] != null) {
                summ += figures[i].getArea();
            }
                    }
        return summ;
    }

    public int getAllPerimeter() {
        int summ = 0;
        for (int i = 0; i < figures.length; i++) {
            if (figures[i] != null) {
                summ += figures[i].getPerimeter();
            }
        }
        return summ;
    }


    public void getCircles() {
        for (int i = 0; i < figures.length; i++) {
            if (figures[i] != null) {
                if (figures[i] instanceof Circle) {
                    System.out.println(figures[i].toString());
                }
            }
        }
    }

    public void getFilmFigures() {
        for (int i = 0; i < figures.length; i++) {
            if (figures[i] != null) {
                if (figures[i] instanceof IFilm) {
                    System.out.println(figures[i].toString());
                }
            }
        }
    }
}
