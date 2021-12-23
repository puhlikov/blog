package ru.mail.puh2012;


import com.sun.xml.internal.ws.encoding.soap.DeserializationException;
import com.sun.xml.internal.ws.encoding.soap.SerializationException;
import ru.mail.puh2012.Collection.AreaComparator;
import ru.mail.puh2012.Collection.BoxCollection;
import ru.mail.puh2012.Collection.ColorComperator;
import ru.mail.puh2012.Collection.FigureComparator;
// import ru.mail.puh2012.box.Box;
import ru.mail.puh2012.exception.DeSerialException;
import ru.mail.puh2012.figure.Figure;
import ru.mail.puh2012.figure.extendfigure.Circle;
import ru.mail.puh2012.figure.extendfigure.Rectangle;
import ru.mail.puh2012.figure.extendfigure.Triangle;
import ru.mail.puh2012.film.implfilm.FilmCircle;
import ru.mail.puh2012.film.implfilm.FilmRectangle;
import ru.mail.puh2012.film.implfilm.FilmTriangle;
import ru.mail.puh2012.paper.IPaper;
import ru.mail.puh2012.paper.implpaper.PaperCircle;
import ru.mail.puh2012.paper.implpaper.PaperRectangle;
import ru.mail.puh2012.paper.implpaper.PaperTriangle;

import  ru.mail.puh2012.exception.SerialException;

import java.io.Serializable;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel Buhtiyarov
 */

public class Girl implements Serializable {
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

        FilmCircle fc5 = new FilmCircle(25);
        System.out.println("AreaFc1: " + fc5.getArea());
        System.out.println("PerimeterFc1: " + fc5.getPerimeter());

        PaperCircle pc5 = new PaperCircle(70);
        System.out.println("AreaFc1: " + pc5.getArea());
        System.out.println("PerimeterFc1: " + pc5.getPerimeter());
        pc5.setColor(IPaper.Color.BLACK);

        FilmRectangle fr5 = new FilmRectangle(20, 60);
        System.out.println("AreaRectangle1: " + fr5.getArea());
        System.out.println("PerimeterRectangle1: " + fr5.getPerimeter());

        FilmRectangle fr6 = new FilmRectangle(40, 60);
        System.out.println("AreaRectangle1: " + fr5.getArea());
        System.out.println("PerimeterRectangle1: " + fr5.getPerimeter());

        FilmRectangle fr7 = new FilmRectangle(50, 60);
        System.out.println("AreaRectangle1: " + fr5.getArea());
        System.out.println("PerimeterRectangle1: " + fr5.getPerimeter());

        FilmRectangle fr8 = new FilmRectangle(700, 55);
        System.out.println("AreaRectangle1: " + fr5.getArea());
        System.out.println("PerimeterRectangle1: " + fr5.getPerimeter());

        FilmRectangle fr9 = new FilmRectangle(60, 60);
        System.out.println("AreaRectangle1: " + fr5.getArea());
        System.out.println("PerimeterRectangle1: " + fr5.getPerimeter());

        FilmRectangle fr10 = new FilmRectangle(800, 65);
        System.out.println("AreaRectangle1: " + fr5.getArea());
        System.out.println("PerimeterRectangle1: " + fr5.getPerimeter());


        System.out.println("===========Box collection==============");

        BoxCollection boxFigures = new BoxCollection();

        boxFigures.addFigure(fc1);
        boxFigures.addFigure(fr1);
        boxFigures.addFigure(ft1);
        boxFigures.addFigure(pc2);
        boxFigures.addFigure(pr2);
        boxFigures.addFigure(pt2);
        boxFigures.addFigure(fr5);
        boxFigures.addFigure(fr6);
        boxFigures.addFigure(fr7);



        System.out.printf("BoxFigures has %d figures \n", boxFigures.size());

        System.out.println(boxFigures.getBoxFigures());
        System.out.println(boxFigures.toString());

        System.out.println("================removeFigure===================");
        boxFigures.removeFigure(1, fr1);
        System.out.println(boxFigures.toString());

        System.out.println("================getFigureIndex===================");
        System.out.println(boxFigures.getFigureIndex(2));

        System.out.println("================sortFigures=============");

        boxFigures.boxFigures.sort(new FigureComparator());
        System.out.println(boxFigures.toString());

        System.out.println("================sortAreas=============");

        boxFigures.boxFigures.sort(new AreaComparator());
        System.out.println(boxFigures.toString());

        System.out.println("================sortColor=============");

        boxFigures.boxFigures.sort(new ColorComperator());
        System.out.println(boxFigures.toString());

        System.out.println("================setNewCollection=============");

        List<Figure> listFigures = new ArrayList<>();
        listFigures.add(fc5);
        listFigures.add(pc5);
        listFigures.add(fr5);

        System.out.println("*********Collection************");

        System.out.println(boxFigures.toString());

        System.out.println("***********AddCollection***********");

        boxFigures.addCollection(listFigures);

        System.out.println(boxFigures.toString());

        System.out.println("**********************");

        System.out.println(boxFigures.exstractAllFigureByClass(fc5));


        System.out.println("==========TASK03_04===========");

        Connector connector = new Connector();
        try {
            connector.saveToFill(boxFigures );
        } catch (SerialException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("============================");

        try {
            BoxCollection boxCollection2 = (BoxCollection) connector.loadFromFile();
            System.out.println(boxCollection2);
             } catch (DeSerialException e){
            System.out.println(e.getMessage());
        }

    }

}

