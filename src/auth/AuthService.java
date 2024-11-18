package auth;

import com.auth0.client.auth.AuthAPI;
import com.auth0.json.auth.UserInfo;
import com.auth0.net.AuthRequest;

public class AuthService {
    private static final String DOMAIN = "YOUR_AUTH0_DOMAIN"; // Replace with your Auth0 domain
    private static final String CLIENT_ID = "YOUR_CLIENT_ID"; // Replace with your Auth0 client ID
    private static final String CLIENT_SECRET = "YOUR_CLIENT_SECRET"; // Replace with your Auth0 client secret
    private final AuthAPI auth;

    public AuthService() {
        // Initialize the AuthAPI with domain, client ID, and client secret
        auth = new AuthAPI(DOMAIN, CLIENT_ID, CLIENT_SECRET);
    }

    /**
     * Authenticate the user by verifying the provided token.
     * @param token The token to be authenticated.
     * @return UserInfo object with user details if authentication is successful.
     * @throws Exception if authentication fails or an error occurs.
     */
    public UserInfo authenticateUser(String token) throws Exception {
        try {
            // Create an AuthRequest for user info and execute it
            AuthRequest request = auth.userInfo(token);
            return request.execute();
        } catch (Exception e) {
            System.err.println("Authentication failed: " + e.getMessage());
            throw e; // re-throw the exception after logging
        }
    }
}
