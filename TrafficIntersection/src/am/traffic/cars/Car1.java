package am.traffic.cars;

import am.traffic.light.*;

import javax.swing.*;
import java.awt.*;

public class Car1 extends Car {
    public Image car1Image ;


    public Car1(){
        setX(1300);
        setY(130);
        setHeight(50);
        setWidth(100);
        car1Image = new ImageIcon("Images/car1.jpg").getImage();
    }

    @Override
    public void move() {
        x-=1;
        setX(x);
    }

    @Override
    public Image getCarImage() {
        return car1Image;
    }

    @Override
    public void run() {
        for (;true;){

            if (isStop){

            }else {
                move();
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stoping() {
            isStop=true;

    }

    @Override
    public void going() {
        isStop=false;
    }

    public void lightControl(){
        if (getX()==730 && !TrafficLight1.isGreen){
            isStop=true;
           // checkCars.checkCars(this);
        }else isStop=false;

    }
}