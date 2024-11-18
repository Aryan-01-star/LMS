package ui;

import javax.swing.*;
import model.User;

public class ProfileUI extends JPanel {
    private User currentUser;
    
    public ProfileUI(User user) {
        this.currentUser = user;
        setupUI();
    }

    private void setupUI() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel nameLabel = new JLabel("Name: " + currentUser.getName());
        JLabel emailLabel = new JLabel("Email: " + currentUser.getEmail());

        JButton editButton = new JButton("Edit Profile");
        editButton.addActionListener(e -> editProfile());

        add(nameLabel);
        add(emailLabel);
        add(editButton);
    }

    private void editProfile() {
        // Open edit profile dialog or screen
    }
}
