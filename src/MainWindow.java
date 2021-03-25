import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public static int Height;
    public static int Width;

    private MainMenuPanel mainMenu;
    public MainWindow() {
        super("GUI Example");
        Height = 600;
        Width = 1000;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new BackgroundPanel("spaceBackground.jpg"));
        getContentPane().setLayout(new BorderLayout());
        getContentPane().setPreferredSize(new Dimension(Width, Height));
        pack();
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
        gamePanel.requestFocus();
    }

    public static void main(String[] args) {
        MainWindow window = new MainWindow();
    }
}
