import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenuPanel extends JPanel {
    private MainWindow frame;
    private JLabel start;
    public MainMenuPanel(MainWindow frame) {
        setFocusable(true);
        this.frame = frame;
        setLayout(new BorderLayout());


        JLabel title = new JLabel("Pong", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 50));
        title.setBorder(BorderFactory.createEmptyBorder(100,0,0,0));
        title.setForeground(Color.WHITE);
        add(title, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0,0,100,0));
        bottomPanel.setOpaque(false);
        start = new JLabel("Click or press enter to start", SwingConstants.CENTER);
        start.setFont(new Font("Serif", Font.BOLD, 40));
        start.setForeground(Color.WHITE);
        start.setBackground(Color.DARK_GRAY);
        start.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        bottomPanel.add(start);
        add(bottomPanel, BorderLayout.SOUTH);

        addKeyListener(new StartKeyListener());
        start.addMouseListener(new StartMouseListener());
        setOpaque(false);
    }

    private class StartMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            frame.startGame();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            start.setOpaque(true);
            repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            start.setOpaque(false);
            repaint();
        }
    }

    private class StartKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyPressed = e.getKeyCode();
            //System.out.println("Key pressed: "+e.getKeyChar() + " " +e.getKeyCode());
            if (keyPressed == KeyEvent.VK_ENTER) {
                frame.startGame();
            }
        }
    }
}
