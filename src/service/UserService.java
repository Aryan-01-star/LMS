package service;

import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public boolean createUser(User user) {
        if (user == null || user.getName() == null || user.getEmail() == null) {
            throw new IllegalArgumentException("User, name, and email cannot be null.");
        }

        if (!user.getEmail().contains("@")) {
            throw new IllegalArgumentException("Invalid email format.");
        }

        try {
            // Simulated database insertion
            return addUserToDatabase(user);
        } catch (Exception e) {
            logger.error("Error adding user to the database: ", e);
            return false;
        }
    }

    // Placeholder method for database interaction
    private boolean addUserToDatabase(User user) {
        // Implement database logic
        return true;
    }
}
