package ui;

import javax.swing.*;

public class MainUI extends JFrame {
    public MainUI() {
        setTitle("Library Management System - Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("User Dashboard", new UserDashboardUI());
        tabs.addTab("Admin Dashboard", new AdminDashboardUI());
        add(tabs);
    }
}
