package ui;

import java.io.FileNotFoundException;

// the main class for running the application
public class Main {
    public static void main(String[] args) {
        try {
            new WhatToWatchNow();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}
