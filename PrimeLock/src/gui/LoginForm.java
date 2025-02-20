package gui;

import authentication.Authenticator;
import authentication.AuthenticatorImpl;
import authentication.Employee;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

public class LoginForm extends JPanel {
    private final Authenticator auth = new AuthenticatorImpl();
    private JTextField nationalId;
    private JTextField passportNo;
    private JTextField employeeId;
    private JPasswordField password;

    public LoginForm() {
        setPreferredSize(new Dimension(540, 340));
        setLayout(new BorderLayout());
        createTitlePanel();
        createInputPanel();
        createButtonPanel();
    }

    private void createTitlePanel() {
        JPanel titlePanel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Login to continue!", SwingConstants.CENTER);
        titleLabel.setBorder(new EmptyBorder(10, 0, 10, 0));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titlePanel.add(titleLabel, BorderLayout.NORTH);

        JLabel hintLabel = new JLabel("Enter national ID or passport No.", SwingConstants.CENTER);
        hintLabel.setForeground(Color.GRAY);
        titlePanel.add(hintLabel, BorderLayout.CENTER);

        add(titlePanel, BorderLayout.NORTH);
    }

    private void createInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(new EmptyBorder(10, 50, 10, 50));

        nationalId = new JTextField(20);
        passportNo = new JTextField(20);
        employeeId = new JTextField(20);
        password = new JPasswordField(20);

        inputPanel.add(new JLabel("National ID:"));
        inputPanel.add(nationalId);
        inputPanel.add(new JLabel("Passport No:"));
        inputPanel.add(passportNo);
        inputPanel.add(new JLabel("Employee ID:"));
        inputPanel.add(employeeId);
        inputPanel.add(new JLabel("Password:"));
        inputPanel.add(password);

        add(inputPanel, BorderLayout.CENTER);
    }

    private void createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(100, 40));
        loginButton.setFont(new Font("Arial", Font.PLAIN, 16));
        loginButton.addActionListener(_ -> {
            // ger user obj on submit
            String psw = String.valueOf(password.getPassword());
            Employee emp = new Employee(nationalId.getText(), passportNo.getText(), employeeId.getText(), psw);

            if (auth.login(emp)) {
                MainFrame.removePanel(this);
                MainFrame.addPanel(new HomeScreen());
                MainFrame.refreshMainPanel();
            } else {
                nationalId.setText("");
                passportNo.setText("");
                employeeId.setText("");
                password.setText("");
            }
        });

        buttonPanel.add(loginButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
