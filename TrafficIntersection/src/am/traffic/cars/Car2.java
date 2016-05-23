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
}
