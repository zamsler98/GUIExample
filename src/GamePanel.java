import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {
    private Ball ball;
    private Paddle leftPaddle, rightPaddle;
    public GamePanel() {
        setFocusable(true);
        setSize(1000,600);

        setOpaque(false);
        Timer timer = new Timer(16, new TimerListener());
        timer.start();
        KeyboardPaddleController leftController = new KeyboardPaddleController(KeyEvent.VK_W, KeyEvent.VK_S);
        KeyboardPaddleController rightController = new KeyboardPaddleController(KeyEvent.VK_UP, KeyEvent.VK_DOWN);
        addKeyListener(leftController);
        addKeyListener(rightController);
        leftPaddle = new Paddle(10,100,new Dimension(10,100), leftController);
        rightPaddle = new Paddle(980,100,new Dimension(10,100), rightController);
        ball = new Ball(1000/2, 600/2, 10, leftPaddle, rightPaddle);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.paint(g);
        leftPaddle.paint(g);
        rightPaddle.paint(g);
    }

    private void update() {
        ball.update();
        leftPaddle.update();
        rightPaddle.update();

        if (ball.getX() + ball.getRadius() >= MainWindow.Width) {
            System.out.println("Left Player Wins");
            ball.reset(1000/2, 600/2);
        }
        if (ball.getX() - ball.getRadius() <= 0) {
            System.out.println("Right Player Wins");
            ball.reset(1000/2, 600/2);
        }
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            update();
            repaint();
        }
    }
}
