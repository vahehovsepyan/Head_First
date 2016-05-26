package am.traffic.cars;

import am.traffic.light.*;

import javax.swing.*;
import java.awt.*;

public class Car2 extends Car {
    public Image car1Image ;
    int x, y;
    private boolean isStop;
    private static int lightX=340;

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }


    public void setY(int y) {
        this.y = y;
    }
    public Car2(){
        setX(-200);
        setY(230);
        car1Image = new ImageIcon("Images/car2.jpg").getImage();
    }


    public void move() {
        x+=1;
        setX(x);
    }


    public Image getCarImage() {
        return car1Image;
    }

    @Override
    public void run() {
        for (;true;){

            if (TrafficLight1.isGreen){
                going();
            }
            if (!TrafficLight1.isGreen){
                if (checkCar(this))
                    stoping();
                if (getX()>340){
                    move();
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (isStop){
                continue;
            }else move();

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized boolean checkCar(Car car) {
        boolean t=false;
        for (int i = 0; i < 10; i++) {
            if (lightX==car.getX()) {
                t = true;
                lightX -= 95;
            }

        }
        return t;
    }

    public void stoping() {
        isStop=true;

    }

    public void going() {
        isStop=false;
    }


}