import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private MainMenuPanel mainMenu;
    public MainWindow() {
        super("GUI Example");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new BackgroundPanel("spaceBackground.jpg"));
        getContentPane().setLayout(new BorderLayout());

        mainMenu = new MainMenuPanel(this);
        add(mainMenu);
        setVisible(true);
    }

    public void startGame() {
        remove(mainMenu);
        mainMenu.setFocusable(false);
        JPanel gamePanel = new GamePanel();
        add(gamePanel);
        repaint();
    }

    public static void main(String[] args) {
        MainWindow window = new MainWindow();
    }
}
