package am.traffic.cars;

import javax.swing.*;

public class Car1 extends Car {

    public JLabel car1 ;

    public Car1(){
        setX(532);
        setY(130);
        setHeight(50);
        setWidth(100);
        car1 = new JLabel(new ImageIcon("/home/vahe/IdeaProjects/TrafficIntersection/Images/car1.jpg"));
    }

    public JLabel getCar1() {
        return car1;
    }

    @Override
    public void move() {
        x-=5;
        setX(x);
    }
}
