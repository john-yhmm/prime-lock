package gui;

import encryption.EncryptionEngine;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

public class DecryptionForm extends JPanel {
    private JTextField encryptedCode;
    private int a = 0, b = 0, c = 0;

    public DecryptionForm() {
        setPreferredSize(new Dimension(540, 360));
        setLayout(new BorderLayout());
        createInputPanel();
        createButtonPanel();
    }

    private void createInputPanel() {
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBorder(new EmptyBorder(40, 120, 0, 120));

        JLabel hintLabel = new JLabel("Enter code to decrypt", SwingConstants.CENTER);
        hintLabel.setBorder(new EmptyBorder(0, 0, 20, 0));
        hintLabel.setForeground(Color.GRAY);
        inputPanel.add(hintLabel, BorderLayout.NORTH);

        encryptedCode = new JTextField(20);
        encryptedCode.setBorder(new EmptyBorder(10, 0, 10, 0));
        inputPanel.add(encryptedCode, BorderLayout.CENTER);

        inputPanel.add(createConfigPanel(), BorderLayout.SOUTH);

        add(inputPanel, BorderLayout.NORTH);
    }

    private JPanel createConfigPanel() {
        JPanel configPanel = new JPanel(new GridLayout(3, 3, 20, 0));
        configPanel.setBorder(new EmptyBorder(10, 0, 0, 0));

        JLabel labelA = new JLabel(String.valueOf(a), SwingConstants.CENTER);
        JLabel labelB = new JLabel(String.valueOf(b), SwingConstants.CENTER);
        JLabel labelC = new JLabel(String.valueOf(c), SwingConstants.CENTER);

        JButton plusBtnA = new JButton("+");
        plusBtnA.addActionListener(_ -> {
            if (a < 9)
                a++;
            labelA.setText(String.valueOf(a));
            MainFrame.refreshMainPanel();
        });
        JButton minusBtnA = new JButton("-");
        minusBtnA.addActionListener(_ -> {
            if (a > 0)
                a--;
            labelA.setText(String.valueOf(a));
            MainFrame.refreshMainPanel();
        });

        JButton plusBtnB = new JButton("+");
        plusBtnB.addActionListener(_ -> {
            if (b < 9)
                b++;
            labelB.setText(String.valueOf(b));
            MainFrame.refreshMainPanel();
        });
        JButton minusBtnB = new JButton("-");
        minusBtnB.addActionListener(_ -> {
            if (b > 0)
                b--;
            labelB.setText(String.valueOf(b));
            MainFrame.refreshMainPanel();
        });

        JButton plusBtnC = new JButton("+");
        plusBtnC.addActionListener(_ -> {
            if (c < 9)
                c++;
            labelC.setText(String.valueOf(c));
            MainFrame.refreshMainPanel();
        });
        JButton minusBtnC = new JButton("-");
        minusBtnC.addActionListener(_ -> {
            if (c > 0)
                c--;
            labelC.setText(String.valueOf(c));
            MainFrame.refreshMainPanel();
        });

        configPanel.add(plusBtnA);
        configPanel.add(plusBtnB);
        configPanel.add(plusBtnC);
        configPanel.add(labelA);
        configPanel.add(labelB);
        configPanel.add(labelC);
        configPanel.add(minusBtnA);
        configPanel.add(minusBtnB);
        configPanel.add(minusBtnC);
        return configPanel;
    }

    private void createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(new EmptyBorder(10, 0, 80, 0));

        JButton decryptBtn = new JButton("Decrypt");
        decryptBtn.setPreferredSize(new Dimension(100, 40));
        decryptBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        decryptBtn.addActionListener(e -> {
            // show decrypted text
            String encrypted = encryptedCode.getText();
            String decryptedText = EncryptionEngine.decrypt(encrypted, a, b, c);
            new DisplayFrame(decryptedText);

            // go back to home
            MainFrame.removePanel(this);
            MainFrame.addPanel(new HomeScreen());
            MainFrame.refreshMainPanel();
        });

        buttonPanel.add(decryptBtn);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
