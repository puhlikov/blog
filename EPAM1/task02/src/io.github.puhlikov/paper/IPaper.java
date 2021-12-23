package ru.mail.puh2012.paper;

import java.sql.SQLOutput;

/**
 * created by puh 23.04.19
 * create  interface IPaper
 */

public interface IPaper {
    enum Color {
        RED, YELLOW, BLACK;
    }

    class Painted {
        private Color color;

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            if (this.color == null) {
                this.color = color;

            }
            else{
                System.out.println("figure is painted");
            }
        }
    }

    Color getColor();

    void setColor(Color color);

    Painted getPainted();


}
