package ui;

import javax.swing.*;
import java.awt.*;
import auth.AuthService;
import auth.GoogleAuth;

public class LoginUI extends JFrame {
    private AuthService authService;

    public LoginUI() {
        this.authService = new AuthService();
        setupUI();
    }

    private void setupUI() {
        setTitle("Library Management System - Login");
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        // Logo and Title
        JLabel logo = new JLabel(new ImageIcon("assets/logo.png"));
        panel.add(logo);

        JLabel titleLabel = new JLabel("Welcome to the Library System", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(titleLabel);

        // User Input Fields
        JTextField emailField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);

        // Google Login
        GoogleAuth googleAuth = new GoogleAuth(authService);
        panel.add(googleAuth);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            if (validateInput(email, password)) {
                // Call login method
                authService.login(email, password);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid email or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(loginButton);

        add(panel);
        setVisible(true);
    }

    private boolean validateInput(String email, String password) {
        return email != null && !email.trim().isEmpty() && password != null && !password.trim().isEmpty();
    }
}