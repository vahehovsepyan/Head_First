package am.traffic.cars;


import java.awt.*;

public abstract class Car extends Thread {
    public int x,y;
    public int height, width;
    public   boolean isStop;


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

    public abstract void run();

    public abstract void stoping();
    public abstract void going();


    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

}
