import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardPaddleController extends KeyAdapter implements PaddleController {
    private int upKey, downKey;
    private boolean upPressed, downPressed;
    public KeyboardPaddleController(int upKey, int downKey) {
        this.upKey = upKey;
        this.downKey = downKey;
        upPressed = false;
        downPressed = false;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();
        if (key == upKey) {
            upPressed = true;
        }
        if (key == downKey) {
            downPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {
        int key = event.getKeyCode();
        if (key == upKey) {
            upPressed = false;
        }
        if (key == downKey) {
            downPressed = false;
        }
    }

    @Override
    public int getPaddleMovement() {
        if (upPressed) {
            return -10;
        } else if (downPressed) {
            return 10;
        } else {
            return 0;
        }
    }
}
