import am.traffic.cars.Car;
import am.traffic.cars.Car1;
import am.traffic.cars.Car2;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class MyFrame extends Thread implements ActionListener {
    static MyFrame f = new MyFrame();
    Timer mainTimer = new Timer(20,this);
    JPanel mainPanel;
    ArrayList<Car> carList = new ArrayList<>();

    private ArrayList<Car> createCars(){
        for (int i = 0; i < 3; i++) {
            carList.add(new Car1());
            carList.add(new Car2());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return carList;
    }

    public static void main(String[] args) throws IOException {
        f.start();
        f.go();

    }

    @Override
    public void run(){
        f.createCars();
    }

    public void go() throws IOException {
        JFrame frame = new JFrame();
        mainPanel = new JPanelWithBackground("Images/perekrestok.jpg");
        mainPanel.setLayout(null);
        frame.getContentPane().add(mainPanel);
        mainTimer.start();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(632,410);
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
            Iterator<Car> iter1 = carList.iterator();
            while (iter1.hasNext()){
                Car c = iter1.next();
                c.move();
                if (c.getX()==400) continue;
                g.drawImage(c.getCarImage(),c.getX(),c.getY(),null);
            }

        }
    }
}