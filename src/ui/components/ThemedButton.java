package ui;

import javax.swing.JButton;
import java.awt.Color;

public class ThemedButton extends JButton {
    public ThemedButton(String text) {
        super(text);
        setBackground(Color.BLUE);
        setForeground(Color.WHITE);
    }
}