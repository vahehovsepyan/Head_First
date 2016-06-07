import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EnemyCar extends Thread{
    private int x=125;
    private int y=100;
    Image enemyImage = new ImageIcon("res/enemy.jpg").getImage();



    public EnemyCar(int x, int y){
        this.x=x;
        this.y=y;
    }

    public void move(){
        y+=(1+PlayerCar.v/5);
    }

    @Override
    public void run() {
        while (true){
            move();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
