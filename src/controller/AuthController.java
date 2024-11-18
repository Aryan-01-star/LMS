package controller;

import auth.AuthService;
import com.auth0.json.auth.UserInfo;
import javax.swing.JOptionPane;

public class AuthController {
    private AuthService authService;

    public AuthController() {
        this.authService = new AuthService(); // Initialize AuthService
    }

    /**
     * This method is used to handle the authentication of the user with the given token.
     * @param token The authentication token retrieved from Google login.
     */
    public void authenticate(String token) {
        try {
            // Call AuthService to authenticate the user with the provided token
            UserInfo userInfo = authService.authenticateUser(token);
            
            // Handle successful authentication
            String userName = (String) userInfo.getValues().get("name");
            JOptionPane.showMessageDialog(null, "Welcome " + userName);

            // Redirect to a dashboard or another screen
            redirectToDashboard(userInfo);

        } catch (Exception e) {
            // Handle errors, such as invalid tokens or authentication failures
            JOptionPane.showMessageDialog(null, "Authentication failed: " + e.getMessage());
        }
    }

    /**
     * Redirect to the dashboard or home page after successful authentication.
     * @param userInfo Information about the authenticated user.
     */
    private void redirectToDashboard(UserInfo userInfo) {
        // Logic to load the dashboard or main application page
        System.out.println("Redirecting to dashboard for user: " + userInfo.getValues().get("name"));
        // Replace with actual redirection logic, if applicable.
    }

    /**
     * This method can be used for logging out a user by clearing their session.
     */
    public void logout() {
        // Logic for logging out (e.g., clearing session, resetting UI)
        clearSession();
        JOptionPane.showMessageDialog(null, "User logged out.");
    }

    /**
     * Clears the user's session or any stored data.
     */
    private void clearSession() {
        // Clear session or token data, reset application state as needed
        System.out.println("Session cleared.");
    }
}
