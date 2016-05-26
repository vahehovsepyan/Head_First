package am.traffic.cars;

import java.awt.*;

public abstract class Car extends Thread {
    public abstract Image getCarImage();
    public abstract int getX();
    public abstract int getY();
}
