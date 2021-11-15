package ui;

import java.io.FileNotFoundException;

// the main class for running the application
public class Main {
    public static void main(String[] args) {
        try {
            new WhatToWatchNowGUI();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}
