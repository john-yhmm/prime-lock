package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class HomeScreen extends JPanel {
    public HomeScreen() {
        setPreferredSize(new Dimension(540, 360));
        setLayout(new BorderLayout());
        createWelcomePanel();
        createActionPanel();
        createButtonPanel();
    }

    private void createWelcomePanel() {
        JPanel welcomePanel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Welcome to PrimeLock!", SwingConstants.CENTER);
        titleLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
        titleLabel.setFont(new Font("Arial",Font.BOLD,20));
        welcomePanel.add(titleLabel, BorderLayout.NORTH);

        JLabel hintLabel = new JLabel("Choose encrypt or decrypt.", SwingConstants.CENTER);
        hintLabel.setForeground(Color.GRAY);
        welcomePanel.add(hintLabel, BorderLayout.SOUTH);

        add(welcomePanel, BorderLayout.NORTH);
    }

    private void createActionPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(new EmptyBorder(60, 0, 60, 0));

        JButton encryptBtn = new JButton("Encrypt");
        encryptBtn.setPreferredSize(new Dimension(150,80));
        encryptBtn.setFont(new Font("Arial",Font.BOLD,18));
        encryptBtn.addActionListener(e -> {
            // go to encrypt form
            MainFrame.removePanel(this);
            MainFrame.addPanel(new EncryptionForm());
            MainFrame.refreshMainPanel();
        });
        JButton decryptBtn = new JButton("Decrypt");
        decryptBtn.setPreferredSize(new Dimension(150,80));
        decryptBtn.setFont(new Font("Arial",Font.BOLD,18));
        decryptBtn.addActionListener(e -> {
            // go to decrypt form
            MainFrame.removePanel(this);
            MainFrame.addPanel(new DecryptionForm());
            MainFrame.refreshMainPanel();
        });

        buttonPanel.add(encryptBtn);
        buttonPanel.add(decryptBtn);
        add(buttonPanel, BorderLayout.CENTER);
    }

    private void createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(new EmptyBorder(10, 0, 40, 0));

        JButton loginButton = new JButton("Logout");
        loginButton.setPreferredSize(new Dimension(100,40));
        loginButton.setFont(new Font("Arial",Font.PLAIN,16));
        loginButton.addActionListener(e -> {
            // logout and back to login screen
            MainFrame.removePanel(this);
            MainFrame.addPanel(new LoginForm());
            MainFrame.refreshMainPanel();
        });

        buttonPanel.add(loginButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
