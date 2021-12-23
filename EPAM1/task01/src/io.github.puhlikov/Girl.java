package ru.mail.puh2012;


import ru.mail.puh2012.box.Box;
import ru.mail.puh2012.film.implfilm.FilmCircle;
import ru.mail.puh2012.film.implfilm.FilmRectangle;
import ru.mail.puh2012.film.implfilm.FilmTriangle;
import ru.mail.puh2012.paper.IPaper;
import ru.mail.puh2012.paper.implpaper.PaperCircle;
import ru.mail.puh2012.paper.implpaper.PaperRectangle;
import ru.mail.puh2012.paper.implpaper.PaperTriangle;


public class Girl {
    public static void main(String[] args) {

        FilmCircle fc1 = new FilmCircle(30);
        System.out.println("AreaFc1: " + fc1.getArea());
        System.out.println("PerimeterFc1: " + fc1.getPerimeter());

        FilmCircle fc2 = new FilmCircle(fc1);
        System.out.println("AreaFc1: " + fc2.getArea());
        System.out.println("PerimeterFc1: " + fc2.getPerimeter());

        FilmCircle fc3 = new FilmCircle(30);
        System.out.println("AreaFc1: " + fc3.getArea());
        System.out.println("PerimeterFc1: " + fc3.getPerimeter());

        FilmRectangle fr1 = new FilmRectangle(50, 20);
        System.out.println("AreaRectangle1: " + fr1.getArea());
        System.out.println("PerimeterRectangle1: " + fr1.getPerimeter());

        FilmTriangle ft1 = new FilmTriangle(20);
        System.out.println("AreaTriangle1: " + ft1.getArea());
        System.out.println("PerimeterTriangle1: " + ft1.getPerimeter());

        PaperCircle pc2 = new PaperCircle(40);
        System.out.println("AreaFc1: " + pc2.getArea());
        System.out.println("PerimeterFc1: " + pc2.getPerimeter());
        pc2.setColor(IPaper.Color.RED);

        PaperRectangle pr2 = new PaperRectangle(70, 10);
        System.out.println("AreaRectangle1: " + pr2.getArea());
        System.out.println("PerimeterRectangle1: " + pr2.getPerimeter());
        pr2.setColor(IPaper.Color.YELLOW);
        System.out.println("=======painted the second time=====");
        pr2.setColor(IPaper.Color.RED);

        PaperTriangle pt2 = new PaperTriangle(80);
        System.out.println("AreaTriangle1: " + pt2.getArea());
        System.out.println("PerimeterTriangle1: " + pt2.getPerimeter());

        Box box = new Box(20);
        System.out.println(box);

        System.out.println("==== set figures ====");
        box.setFigure(0, fc2);
        box.setFigure(1, pc2);
        box.setFigure(2, fr1);
        box.setFigure(3, pr2);
        box.setFigure(4, ft1);
        box.setFigure(5, pt2);
        box.showBox();

        System.out.println("======show figure=====");

        System.out.println(box.showFigure(3).toString());

        System.out.println("======get figure=====");

        System.out.println(box.getFigure(3).toString());
        System.out.println("========================");
        box.showBox();
        System.out.println("=========================");

        System.out.println("===========findByFigure==============");

        System.out.println(box.findByFigure(fc3));

        System.out.println("===========figure in box==============");

        System.out.println("in box = " + box.getCount());

        System.out.println("===========AllArea==============");

        System.out.println ("summAllArea = " + box.getAllArea());

        System.out.println("===========AllPerimeter==============");

        System.out.println ("summAllPerimeter = " + box.getAllPerimeter());

        System.out.println("===========AllCircles==============");

        box.getCircles();

        System.out.println("===========AllFilmFigures==============");

        box.getFilmFigures();

        System.out.println("===========The End==============");
    }
}