package am.traffic.cars;

import javax.swing.*;
import java.awt.*;

public class Car1 extends Car {

    public Image car1Image ;

    public Car1(){
        setX(632);
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

}
