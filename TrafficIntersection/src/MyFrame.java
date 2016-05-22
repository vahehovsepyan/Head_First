import am.traffic.cars.*;
import am.traffic.light.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class MyFrame extends Thread implements ActionListener {
    static MyFrame f = new MyFrame();
    static TrafficLight tLight;
    Timer mainTimer = new Timer(20,this);
    JPanel mainPanel;

   // Car car1 = new Car1();
    static ArrayList<Car> carList = new ArrayList<>();

    private ArrayList<Car> createCar1(){
        for (int i = 0; i < 3; i++) {
            carList.add(new Car1());
        }
        return carList;
    }
    private ArrayList<Car> createCar2(){
        for (int i = 0; i < 3; i++) {
            carList.add(new Car2());
        }
        return carList;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        tLight = new TrafficLight1();
        tLight.start();
        Thread.sleep(50);
        f.createCar1();
        f.createCar2();
        Thread.sleep(100);
        f.go();
        f.goCar(carList);

    }
    public void goCar(ArrayList<Car> cars) throws InterruptedException {

        Iterator<Car> iter = cars.iterator();
        while (iter.hasNext()){
            Car c = iter.next();
            c.start();
            Thread.sleep(3000);
        }
    }


    public void go() throws IOException {
        JFrame frame = new JFrame();
        mainPanel = new JPanelWithBackground("Images/perekrestok.jpg");
        mainPanel.setLayout(null);
        frame.getContentPane().add(mainPanel);
        mainTimer.start();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1250,400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainPanel.repaint();
    }

    private class JPanelWithBackground extends JPanel {
        private Image backgroundImage;

        // Some code to initialize the background image.
        // Here, we use the constructor to load the image. This
        // can vary depending on the use case of the panel.
        public JPanelWithBackground(String fileName) throws IOException {
            backgroundImage = ImageIO.read(new File(fileName));
        }

        public void paintComponent(Graphics g) {
           // super.paintComponent(g);
            g.drawImage(backgroundImage,0, 0, null);
            //g.drawImage(car1.getCarImage(), car1.getX(),car1.getY(),null);
            if (TrafficLight1.isGreen){
                g.setColor(Color.green);
                g.fillOval(720,85,10,10);
                g.fillOval(400,300,10,10);
            }else if (!TrafficLight1.isGreen && !TrafficLight1.isRed){
                g.setColor(Color.yellow);
                g.fillOval(720,80,10,10);
                g.fillOval(400,305,10,10);
            }else  if (TrafficLight1.isRed){
                g.setColor(Color.red);
                g.fillOval(720,75,10,10);
                g.fillOval(400,315,10,10);
            }
            /*
            * if (!TrafficLight2.isGreen && !TrafficLight2.isRed){
                g.setColor(Color.yellow);
                g.fillOval(720,80,10,10);
            }else if (TrafficLight2.isGreen){
                g.setColor(Color.green);
                g.fillOval(720,85,10,10);
            }else if (TrafficLight2.isRed){
                g.setColor(Color.red);
                g.fillOval(720,75,10,10);
            }*/
            Iterator<Car> iter1 = carList.iterator();
            while (iter1.hasNext()){
                Car c = iter1.next();
                g.drawImage(c.getCarImage(),c.getX(),c.getY(),null);
            }

        }
    }
}