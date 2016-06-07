import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Road extends JPanel implements ActionListener,Runnable {

    Timer mainTimer = new Timer(20,this);
    Image roadImage =new ImageIcon("res/road2.jpg").getImage();

    Thread enemy = new Thread(this);

    PlayerCar playerCar = new PlayerCar();
    
    ArrayList<EnemyCar> enemyCarList = new ArrayList<>();

    public void addEnemyCars(){
        int carCount= (int) (Math.random()*3+3);
        int distance;
        int allDist=0;
        int randomX;
        for (int i = 0; i < carCount; i++) {
            distance= (int)(Math.random()*100+200);
            randomX= (int) (Math.random()*82+85);
            allDist+=distance;
            enemyCarList.add(new EnemyCar(randomX,-100-allDist));
            System.out.println(i);
        }
    }

    public void goCar(){
        for (int i = 0; i < enemyCarList.size(); i++) {
            enemyCarList.get(i).start();
            try {
                Thread.sleep((long) (Math.random()*10+20));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Road(){
        mainTimer.start();
        addEnemyCars();
        goCar();
        enemy.start();
        addKeyListener(new MyKeyEvent());
        setFocusable(true);


    }



    public void paint(Graphics g){
        g = (Graphics2D)g;

        g.drawImage(roadImage,0,playerCar.layer1,null);
        g.drawImage(roadImage,0,playerCar.layer2,null);
        g.drawImage(playerCar.playerImage,playerCar.getX(),playerCar.getY(), null);
        Iterator<EnemyCar> iter = enemyCarList.iterator();
        while (iter.hasNext()){
            EnemyCar c = iter.next();
            g.drawImage(c.enemyImage,c.getX(),c.getY(),null);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        playerCar.move();
        repaint();
    }

    @Override
    public void run() {
        int distance;
        int randomX;
        while (true){
            Iterator<EnemyCar> iter = enemyCarList.iterator();
            EnemyCar car = iter.next();
            if (car.getY()>600){
                iter.remove();
                distance= (int)(Math.random()*25+150);
                randomX= (int) (Math.random()*82+85);
                enemyCarList.add(new EnemyCar(randomX,-150-distance));
                enemyCarList.get(enemyCarList.size()-1).start();
            }

        }
    }


    private class MyKeyEvent extends KeyAdapter{
         @Override
         public void keyPressed(KeyEvent e) {
             playerCar.keyPressed(e);
         }

         @Override
         public void keyReleased(KeyEvent e) {
             playerCar.keyReleased(e);
         }
     }
}
