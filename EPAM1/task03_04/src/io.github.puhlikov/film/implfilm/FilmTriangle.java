package ru.mail.puh2012.film.implfilm;

import ru.mail.puh2012.figure.Figure;
import ru.mail.puh2012.figure.extendfigure.Triangle;
import ru.mail.puh2012.film.IFilm;

/**
 * created by puh 21.04.19
 * create class FilmTriangle extends class Triangle & implements interface IFilm
 */

public class FilmTriangle extends Triangle implements IFilm {

    public FilmTriangle (double sideA){
        super(sideA);
    }
    public FilmTriangle (IFilm filmFigure){
        super((Figure) filmFigure);
    }
}
