package ru.mail.puh2012.film.implfilm;


import ru.mail.puh2012.figure.Figure;
import ru.mail.puh2012.figure.extendfigure.Circle;
import ru.mail.puh2012.film.IFilm;

/**
 * created by puh 21.04.19
 * create class FilmCircle extends class Circle & implements interface IFilm
 */

public class  FilmCircle extends Circle implements IFilm{

public FilmCircle (double radius){
        super(radius);
        }
public FilmCircle (IFilm filmFigure){
        super((Figure)filmFigure);
        }
}