package ui;

import javax.swing.*;
import java.io.FileNotFoundException;

// the main class for running the application
public class Main {
    public static void main(String[] args) {
        displaySplashScreen();

        try {
            new WhatToWatchNowGUI();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }


    // MODIFIES : window
    // EFFECTS: displays an image at center with bounds in a new window for 2 seconds
    private static void displaySplashScreen() {
        JWindow window = new JWindow();
        ImageIcon logo = new ImageIcon("./data/tobs.jpg");
        window.getContentPane().add(
                new JLabel("", logo, SwingConstants.CENTER));
        window.setBounds(0,0, logo.getIconWidth(), logo.getIconHeight());
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        window.setVisible(false);
        window.dispose();
    }
}
