package model;

/**
 * Represents a user with attributes such as ID, name, email, and role.
 */
public class User {
    private int userId;
    private String name;
    private String email;
    private String role;

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Validates the user's email format.
     * @return true if the email is valid, false otherwise.
     */
    public boolean isValidEmail() {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    // Main method for testing
    public static void main(String[] args) {
        User user = new User();
        user.setUserId(1);
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        user.setRole("Admin");

        System.out.println("User Details:");
        System.out.println(user);

        System.out.println("\nIs valid email: " + user.isValidEmail());

        // Test invalid email case
        user.setEmail("invalid-email");
        System.out.println("\nUpdated Email: " + user.getEmail());
        System.out.println("Is valid email: " + user.isValidEmail());
    }
}
