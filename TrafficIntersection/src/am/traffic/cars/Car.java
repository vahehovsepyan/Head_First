package am.traffic.cars;

import javax.swing.*;
import java.awt.*;

public abstract class Car {
    public int x,y;
    public int height, width;


    public abstract void move();

    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
        this.y = y;
    }

    void setHeight(int height) {
        this.height = height;
    }

    void setWidth(int width) {
        this.width = width;
    }

    public abstract Image getCarImage() ;


    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getHeight(){
        return height;
    }
    public int getWidth(){
        return width;
    }
}
