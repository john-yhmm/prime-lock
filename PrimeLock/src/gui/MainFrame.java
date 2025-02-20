package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    private static final JPanel MAIN_PANEL = new JPanel();

    public MainFrame() {
        setTitle("Prime Lock");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        MAIN_PANEL.add(new LoginForm());

        setContentPane(MAIN_PANEL);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void addPanel(JPanel p) {
        MAIN_PANEL.add(p);
    }

    public static void removePanel(JPanel p) {
        MAIN_PANEL.remove(p);
    }

    public static void refreshMainPanel() {
        MAIN_PANEL.revalidate();
        MAIN_PANEL.repaint();
    }

}
