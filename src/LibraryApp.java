package main;

import javax.swing.*;
import com.formdev.flatlaf.FlatLightLaf;

public class LibraryApp {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> new LoginUI());
    }
}