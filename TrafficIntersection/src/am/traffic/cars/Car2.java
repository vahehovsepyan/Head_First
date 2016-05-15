package am.traffic.cars;

import javax.swing.*;

public class Car2 extends Car {

    public JLabel car2 ;
    public Car2(){
        setX(0);
        setY(230);
        setHeight(50);
        setWidth(100);
        car2 = new JLabel(new ImageIcon("/home/vahe/IdeaProjects/TrafficIntersection/Images/car2.jpg"));

    }

    public JLabel getCar2() {
        return car2;
    }

    @Override
    public void move() {
        x+=5;
        setX(x);
    }
}
