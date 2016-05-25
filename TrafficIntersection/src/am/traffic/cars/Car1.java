package am.traffic.cars;

import am.traffic.light.*;

import javax.swing.*;
import java.awt.*;

public class Car1 extends Car {
    public Image car1Image ;
    int x, y;
    public static boolean isStop;

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }

    @Override
    public boolean checkCar(Car car) {
        boolean t=false;
        int lightX=730;
        for (int i = 0; i < 10; i++) {
            if (lightX+100==car.getX()){
                t=true;
            }
            lightX+=100;
        }
        return t;
    }

    public void setY(int y) {
        this.y = y;
    }
    public Car1(){
        setX(1300);
        setY(130);
        car1Image = new ImageIcon("Images/car1.jpg").getImage();
    }


    public void move() {
        x-=1;
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
                if (getX()==730)
                    stoping();
                
                if (getX()<730 ){
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

    public void stoping() {
        isStop=true;

    }

    public void going() {
        isStop=false;
    }


}