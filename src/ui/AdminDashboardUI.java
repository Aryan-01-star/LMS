package ui;

import javax.swing.*;
import service.BookService;

public class AdminDashboardUI extends JPanel {
    private BookService bookService;

    public AdminDashboardUI() {
        this.bookService = new BookService();
        setupUI();
    }

    private void setupUI() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JLabel title = new JLabel("Admin Dashboard");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title);

        JPanel statsPanel = new JPanel();
        statsPanel.add(new JLabel("Total Books: " + bookService.getAllBooks().size()));
        
        // More stats like active users, borrowed books, etc.
        add(statsPanel);
    }
}
