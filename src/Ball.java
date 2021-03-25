import java.awt.*;
import java.util.Random;

public class Ball {
    private int x, y;
    private int radius;
    private int xSpeed, ySpeed;
    private Paddle leftPaddle, rightPaddle;
    public Ball(int x, int y, int radius, Paddle leftPaddle, Paddle rightPaddle) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        setStartingVelocity();
        this.leftPaddle = leftPaddle;
        this.rightPaddle = rightPaddle;
    }

    private void setStartingVelocity() {
        Random rand = new Random();
        xSpeed = rand.nextInt(5) + 3;
        ySpeed = rand.nextInt(5) + 1;
        if (rand.nextBoolean()) {
            xSpeed *= -1;
        }
        if (rand.nextBoolean()) {
            ySpeed *= -1;
        }
    }

    public int getX() {
        return x;
    }

    public int getRadius() {
        return radius;
    }

    public void reset(int x, int y) {
        this.x = x;
        this.y = y;
        setStartingVelocity();
    }

    public void update() {
        this.x += xSpeed;
        this.y += ySpeed;
        checkCollisions();
    }

    private void checkCollisions() {
        if (y + radius >= MainWindow.Height) {
            ySpeed = ySpeed * -1;
        }

        if (y - radius <= 0) {
            ySpeed = ySpeed * -1;
        }

        if (xSpeed > 0 && x + radius >= rightPaddle.getLeftEdge()) {
            if (y + radius >= rightPaddle.getTopEdge() && y - radius <= rightPaddle.getBottomEdge()) {
                xSpeed = xSpeed * -1;
            }
        }

        if (xSpeed < 0 && x - radius <= leftPaddle.getRightEdge()) {
            if (y + radius >= leftPaddle.getTopEdge() && y - radius <= leftPaddle.getBottomEdge()) {
                xSpeed = xSpeed * -1;
            }
        }

    }

    public void paint(Graphics g) {
        int diameter = radius * 2;
        g.setColor(Color.WHITE);
        g.fillOval(x-radius, y-radius, diameter, diameter);
    }
}
