import javax.swing.*;
import java.awt.*;

public class Road extends JPanel {
    Image roadImage =new ImageIcon("res/road2.jpg").getImage();

    PlayerCar playerCar = new PlayerCar();

    Image playerImage = new ImageIcon("res/player.jpg").getImage();

    public void paint(Graphics g){
        g = (Graphics2D)g;
        g.drawImage(roadImage,0,0,null);
        g.drawImage(playerImage,playerCar.getX(),playerCar.getY(), null);
    }
}
