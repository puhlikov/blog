package ru.mail.puh2012.film.implfilm;

import ru.mail.puh2012.figure.Figure;
import ru.mail.puh2012.figure.extendfigure.Rectangle;
import ru.mail.puh2012.film.IFilm;

/**
 * created by puh 21.04.19
 * create class FilmRectangle extends class Rectangle & implements interface IFilm
 */

public class FilmRectangle extends Rectangle implements IFilm {

    public FilmRectangle (double width, double heigth){
        super(width, heigth);
    }
    public FilmRectangle (IFilm filmFigure){
        super((Figure) filmFigure);
    }
 }
