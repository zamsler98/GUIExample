import java.awt.*;

public class Paddle {
    private int x, y;
    private Dimension size;
    private PaddleController controller;
    public Paddle(int x, int y, Dimension size, PaddleController controller) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.controller = controller;
    }

    public int getTopEdge() {
        return y;
    }

    public int getBottomEdge() {
        return y + size.height;
    }

    public int getLeftEdge() {
        return x;
    }

    public int getRightEdge() {
        return x + size.width;
    }

    public void update() {
        y += controller.getPaddleMovement();
        if (y < 0) {
            y = 0;
        }
        if (y + size.height > MainWindow.Height) {
            y = MainWindow.Height - size.height;
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, size.width, size.height);
    }
}
