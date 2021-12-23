package ru.mail.puh2012.Collection;

import ru.mail.puh2012.figure.Figure;
import ru.mail.puh2012.figure.Figures;

import java.util.Comparator;

public class FigureComparator implements Comparator<Figure>{

    @Override
    public int compare(Figure a, Figure b) {
        String a1 = a.
                getClass().
                getSuperclass().
                getSimpleName().
                toUpperCase();

        String b1 = b.
                getClass().
                getSuperclass().
                getSimpleName().
                toUpperCase();

        int a2 = Figures.valueOf(a1).ordinal();
        int b2 = Figures.valueOf(b1).ordinal();
        int result = a2 - b2;


        return result;
    }

}