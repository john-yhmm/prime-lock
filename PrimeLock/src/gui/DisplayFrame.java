package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class DisplayFrame extends JFrame {
    DisplayFrame(String code) {
        setSize(480, 100);

        JLabel label = new JLabel(code, SwingConstants.CENTER);
        label.setFont(new Font("Courier New", Font.PLAIN, 22));

        add(label);

        addWindowFocusListener(new OffFocusDisposer(this));
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }
}
