package auth;

import com.auth0.client.auth.AuthAPI;
import com.auth0.json.auth.UserInfo;
import com.auth0.net.AuthRequest;

public class AuthService {
    private static final String DOMAIN = "YOUR_AUTH0_DOMAIN";
    private static final String CLIENT_ID = "YOUR_CLIENT_ID";
    private static final String CLIENT_SECRET = "YOUR_CLIENT_SECRET";
    private final AuthAPI auth;

    public AuthService() {
        auth = new AuthAPI(DOMAIN, CLIENT_ID, CLIENT_SECRET);
    }

    public UserInfo authenticateUser(String token) throws Exception {
        AuthRequest request = auth.userInfo(token);
        return request.execute();
    }
}
