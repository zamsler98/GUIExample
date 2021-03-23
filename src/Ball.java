import java.awt.*;

public class Ball {
    private int x, y;
    private int radius;
    public Ball(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void paint(Graphics g) {
        int diameter = radius * 2;
        g.setColor(Color.WHITE);
        g.fillOval(x-radius, y-radius, diameter, diameter);
    }
}
