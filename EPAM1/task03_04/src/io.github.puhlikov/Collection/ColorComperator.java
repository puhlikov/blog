package ru.mail.puh2012.Collection;

import ru.mail.puh2012.figure.Figure;
import ru.mail.puh2012.film.IFilm;
import ru.mail.puh2012.paper.IPaper;

import java.util.Comparator;

public class ColorComperator implements Comparator<Figure> {

    @Override
    public int compare(Figure a, Figure b) {
        if (a instanceof IFilm) {
            return -1;
        } else if (b instanceof IFilm) {
            return 0;
        } else {
            String color1 = toStringColor(((IPaper) a).getColor());
            String color2 = toStringColor(((IPaper) b).getColor());
            return color1.compareTo(color2);
        }
    }

    public String toStringColor(IPaper.Color color){
        if (color == null) {
            return "1";
        }
            return color.toString();
    }
}
