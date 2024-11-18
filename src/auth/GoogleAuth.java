package auth;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Desktop;
import java.net.URI;
import com.auth0.json.auth.UserInfo;

public class GoogleAuth extends JButton {
    private AuthService authService;
    private static final String GOOGLE_AUTH_URL = "https://YOUR_AUTH0_DOMAIN/authorize?client_id=YOUR_CLIENT_ID&response_type=token&redirect_uri=YOUR_REDIRECT_URI&connection=google-oauth2"; 

    public GoogleAuth(AuthService authService) {
        super("Login with Google");
        this.authService = authService;
        addActionListener(e -> loginWithGoogle());
    }

    private void loginWithGoogle() {
        try {
            // Open the Google authentication URL in the user's default browser
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(GOOGLE_AUTH_URL));
            } else {
                throw new UnsupportedOperationException("Desktop is not supported on this system.");
            }
            // After successful login, the user will be redirected to YOUR_REDIRECT_URI with an access token.
            // You'll need to capture and parse this token from the redirect URI in a real-world application.

            // Example: Simulating token retrieval and authentication
            String token = JOptionPane.showInputDialog("Enter the access token:"); // For simplicity, ask for the token manually.
            if (token != null && !token.isEmpty()) {
                UserInfo userInfo = authService.authenticateUser(token);
                JOptionPane.showMessageDialog(null, "Welcome, " + userInfo.getValues().get("name"));
            } else {
                JOptionPane.showMessageDialog(null, "No token provided.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Authentication failed: " + e.getMessage());
        }
    }
}
