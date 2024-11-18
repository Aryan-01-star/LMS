package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class NotificationController {

    // Inner class to represent a Notification
    public static class Notification {
        private int id;
        private String message;

        public Notification(int id, String message) {
            this.id = id;
            this.message = message;
        }

        public int getId() {
            return id;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public String toString() {
            return "Notification [ID=" + id + ", Message=" + message + "]";
        }
    }

    private List<Notification> notifications;
    private int nextId;

    public NotificationController() {
        this.notifications = new ArrayList<>();
        this.nextId = 1;
    }

    /**
     * Creates a new notification.
     * @param message The notification message.
     */
    public void createNotification(String message) {
        Notification notification = new Notification(nextId++, message);
        notifications.add(notification);
        JOptionPane.showMessageDialog(null, "Notification added: " + notification);
    }

    /**
     * Lists all notifications.
     */
    public void listNotifications() {
        if (notifications.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No notifications available.");
        } else {
            StringBuilder notificationList = new StringBuilder("Notifications:\n");
            for (Notification notification : notifications) {
                notificationList.append(notification).append("\n");
            }
            JOptionPane.showMessageDialog(null, notificationList.toString());
        }
    }

    /**
     * Deletes a notification by its ID.
     * @param id The ID of the notification to delete.
     */
    public void deleteNotification(int id) {
        if (notifications.removeIf(n -> n.getId() == id)) {
            JOptionPane.showMessageDialog(null, "Notification with ID " + id + " deleted.");
        } else {
            JOptionPane.showMessageDialog(null, "Notification not found with ID: " + id);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        NotificationController controller = new NotificationController();
        controller.createNotification("System update available.");
        controller.createNotification("Your order has been shipped.");
        controller.listNotifications();
        controller.deleteNotification(1);
        controller.listNotifications();
    }
}
