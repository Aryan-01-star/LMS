package service;

import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    /**
     * Creates a new user and adds them to the database.
     *
     * @param user The user to be created.
     * @return true if the user is created successfully, false otherwise.
     */
    public boolean createUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }

        // Validate user fields
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new IllegalArgumentException("User name cannot be null or empty.");
        }

        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("User email cannot be null or empty.");
        }

        if (!user.isValidEmail()) {
            throw new IllegalArgumentException("Invalid email format.");
        }

        try {
            // Simulate the process of adding a user to the database
            boolean success = addUserToDatabase(user);
            if (success) {
                logger.info("User created successfully: " + user.getName());
            } else {
                logger.warn("Failed to create user: " + user.getName());
            }
            return success;
        } catch (Exception e) {
            logger.error("Error adding user to the database: ", e);
            return false;
        }
    }

    /**
     * Placeholder method for database interaction.
     * In a real application, replace this with actual database logic.
     *
     * @param user The user to be added to the database.
     * @return true if the user was added successfully, false otherwise.
     */
    private boolean addUserToDatabase(User user) {
        // Implement database logic here (e.g., Hibernate, JDBC)
        // For now, we return true as if the user was added successfully
        return true;
    }

    /**
     * Main method for testing user creation.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        UserService userService = new UserService();

        // Test case 1: Valid user creation
        User validUser = new User();
        validUser.setName("John Doe");
        validUser.setEmail("john.doe@example.com");
        boolean created = userService.createUser(validUser);
        System.out.println("User created: " + created);

        // Test case 2: Invalid email format
        User invalidEmailUser = new User();
        invalidEmailUser.setName("Jane Doe");
        invalidEmailUser.setEmail("jane.doeexample.com");  // Invalid email format
        created = userService.createUser(invalidEmailUser);
        System.out.println("User created: " + created);

        // Test case 3: Empty user name
        User emptyNameUser = new User();
        emptyNameUser.setName("");  // Empty name
        emptyNameUser.setEmail("valid.email@example.com");
        created = userService.createUser(emptyNameUser);
        System.out.println("User created: " + created);
    }
}
