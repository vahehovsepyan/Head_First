import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerCar implements Runnable, KeyListener {
    private int x=125;
    private int y=420;
    private static final int MAX_SPEED=20;
    private static final int MAX_LEFT=85;
    private static final int MAX_RIGHT=163;
    Image playerImage = new ImageIcon("res/player.jpg").getImage();

    static double v=0;
    double dv;
    int s=0;

    int layer1 =0;
    int layer2=-487;


    public void move(){
        v+=dv;
        s+=v;

        if (v<=0){v=0;}
        if (v>=MAX_SPEED){v=MAX_SPEED;}
        if (getX()>=MAX_RIGHT){
            x=MAX_RIGHT;
        }else if (getX()<=MAX_LEFT){
            x=MAX_LEFT;
        }

        if (layer1+v>=487){
            layer1=0;
            layer2=-487;
        }else {
            layer1+=v;
            layer2+=v;
        }
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

    @Override
    public void run() {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key=e.getKeyCode();
        if (key==KeyEvent.VK_UP){
            dv=1;
        }
        if (key==KeyEvent.VK_DOWN){
            dv=-1;
        }
        if(key == KeyEvent.VK_RIGHT){
            x+=(v+4);
        }
        if(key == KeyEvent.VK_LEFT){
            x-=(v+4);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key=e.getKeyCode();
        if (key==KeyEvent.VK_UP || key==KeyEvent.VK_DOWN){
            dv=0;
        }
    }
}
