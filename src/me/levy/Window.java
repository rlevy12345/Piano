package me.levy;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window() {
        setTitle("Sheet Music Program");
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setResizable(false);

        add(new Sheet());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Window win = new Window();
            }
        });
    }
}