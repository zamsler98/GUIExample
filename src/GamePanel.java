import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private Ball ball;
    public GamePanel() {
        setSize(1000,600);
        ball = new Ball(1000/2, 600/2, 10);
        setOpaque(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.paint(g);
    }
}
