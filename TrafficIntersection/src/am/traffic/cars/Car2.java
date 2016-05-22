package am.traffic.cars;

import am.traffic.light.*;

import javax.swing.*;
import java.awt.*;

public class Car2 extends Car {

    public Image car2Image ;
    public Car2(){
        setX(-100);
        setY(230);
        setHeight(50);
        setWidth(100);
        car2Image = new ImageIcon("Images/car2.jpg").getImage();
    }


    @Override
    public void move() {
        x+=1;
        setX(x);
    }

    @Override
    public Image getCarImage() {
        return car2Image;
    }

    @Override
    public void run() {
        for (;true;){

            if (getX()==400 && !TrafficLight2.isGreen){
                System.out.println(TrafficLight2.isGreen);
            }else {
                System.out.println(TrafficLight2.isGreen);
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
