package gui;

import javax.swing.JFrame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class OffFocusDisposer implements WindowFocusListener {

    private final JFrame frame;

    public OffFocusDisposer(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {

    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        frame.dispose();
    }

}
