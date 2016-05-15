import am.traffic.cars.Car;
import am.traffic.cars.Car1;
import am.traffic.cars.Car2;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyFrame extends Thread {
    JPanel mainPanel;
    Car1 car1 = new Car1();
    Car2 car2 = new Car2();
    public static void main(String[] args) throws IOException {
        new MyFrame().go();
    }

    @Override
    public void run(){
        
    }

    public void go() throws IOException {
        JFrame frame = new JFrame();
        mainPanel = new JPanelWithBackground("Images/perekrestok.jpg");
        mainPanel.setLayout(null);

        mainPanel.add(car2.getCar2());
        mainPanel.add(car1.getCar1());

        frame.getContentPane().add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(632,410);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        for (int i = 0; true; i++) {
            car1.move();
            car2.move();
            mainPanel.repaint();
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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
            super.paintComponent(g);
            g.drawImage(backgroundImage,0, 0, this);
            car1.car1.setBounds(car1.getX(),car1.getY(),100,50);
            car2.car2.setBounds(car2.getX(),car2.getY(),100,50);
        }
    }
}
