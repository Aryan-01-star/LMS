package auth;

import javax.swing.JButton;

public class GoogleAuth extends JButton {
    private AuthService authService;

    public GoogleAuth(AuthService authService) {
        super("Login with Google");
        this.authService = authService;
        addActionListener(e -> loginWithGoogle());
    }

    private void loginWithGoogle() {
        // Logic for Google login
        // Handle success and failure cases
    }
}