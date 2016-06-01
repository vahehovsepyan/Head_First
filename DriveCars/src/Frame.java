import javax.swing.*;

public class Frame {

    public static void main(String[] args) {
        JFrame jFame = new JFrame("DriveCars");
        jFame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFame.setSize(270,510);
        jFame.add(new Road());
        jFame.setVisible(true);
    }
}
