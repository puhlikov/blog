package ru.mail.puh2012.Collection;

import ru.mail.puh2012.figure.Figure;
import ru.mail.puh2012.figure.Figures;

import java.util.Comparator;

public class AreaComparator implements Comparator<Figure> {

    public int compare(Figure a, Figure b) {
        if(a.getArea() > b.getArea())
                return 1;
        else if(a.getArea() < b.getArea())
            return -1;
        else
            return 0;
    }
}
