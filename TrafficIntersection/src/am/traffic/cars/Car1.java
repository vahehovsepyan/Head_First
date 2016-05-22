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

            if (getX()==730 && !TrafficLight1.isGreen){
                System.out.println(TrafficLight1.isGreen);
            }else {
                System.out.println(TrafficLight1.isGreen);
                try {
                    this.sleep(30);
                    move();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
