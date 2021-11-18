package ui;

import model.Content;
import model.ListOfContent;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.gui.*;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class WhatToWatchNowGUI extends JFrame {
    private static final String JSON_STORE = "./data/contentList.json";
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    private ListOfContent loc = new ListOfContent("MyList");
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JPanel mainPanel;
    private JRadioButton rb1 = new JRadioButton();
    private JRadioButton rb2 = new JRadioButton();
    private JRadioButton rb3 = new JRadioButton();
    private JRadioButton rb4 = new JRadioButton();
    private JRadioButton rb5 = new JRadioButton();
    private JRadioButton rb6 = new JRadioButton();
    private JRadioButton rb7 = new JRadioButton();
    private JRadioButton rb8 = new JRadioButton();
    private JRadioButton rb9 = new JRadioButton();
    private JRadioButton rb10 = new JRadioButton();
    private JRadioButton rb11 = new JRadioButton();
    private List<JRadioButton> radioList;
    private String s1 = "Add Content to your list";
    private String s2 = "Filter Content Based on Year";
    private String s3 = "Filter Content Based on Genre";
    private String s4 = "Filter Content Based on Language";
    private String s5 = "Filter Content Based on Ratings";
    private String s6 = "Filter Content Based on Location";
    private String s7 = "Access your playlist";
    private String s8 = "Remove Content from your playlist";
    private String s9 = "Save list of Content";
    private String s10 = "Load List of Contents from file";
    private String s11 = "Close Application";
    private List<String> strings;


    // EFFECTS: Runs the What To Watch Now application
    public WhatToWatchNowGUI() throws FileNotFoundException {
        super("What To Watch Now");

        strings = new ArrayList<>();
        radioList = new ArrayList<>();
        radioList.add(rb1);
        radioList.add(rb2);
        radioList.add(rb3);
        radioList.add(rb4);
        radioList.add(rb5);
        radioList.add(rb6);
        radioList.add(rb7);
        radioList.add(rb8);
        radioList.add(rb9);
        radioList.add(rb10);
        radioList.add(rb11);


        setSize(WIDTH, HEIGHT);
        mainPanel = new JPanel();

        add(mainPanel);

        mainPanel.setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        runApp();
    }

    // MODIFIES : this
    // EFFECTS :takes user inputs and process them
    private void runApp() {
        strings.add(s1);
        strings.add(s2);
        strings.add(s3);
        strings.add(s4);
        strings.add(s5);
        strings.add(s6);
        strings.add(s7);
        strings.add(s8);
        strings.add(s9);
        strings.add(s10);
        strings.add(s11);

        JLabel welcomeLabel = new JLabel("Hello and welcome to the What To Watch Now app");
        welcomeLabel.setBounds(250, 0, 400, 100);

        mainPanel.add(welcomeLabel);
        centreOnScreen();

        displayMenu();
    }

    /**
     * Helper to centre main application window on desktop
     */
    private void centreOnScreen() {
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        setLocation((width - getWidth()) / 2, (height - getHeight()) / 2);
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {

        JLabel selectOperation = new JLabel("Please select from the given options:");
        selectOperation.setBounds(0, 100, 400, 25);
        mainPanel.add(selectOperation);

        ButtonGroup bg = new ButtonGroup();

        for (int i = 0, j = 140; i <= 11 && j <= 340; i++, j += 20) {

            radioList.get(i).setText(strings.get(i));
            radioList.get(i).setBounds(0, j, 400, 20);
            mainPanel.add(radioList.get(i));
            bg.add(radioList.get(i));
        }

        JButton okButton = new JButton("Ok");
        okButton.setBounds(10, 380, 60, 20);
        mainPanel.add(okButton);

        okButton.addActionListener(ae -> {
            processCommand();
        });


    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand() {
        if (rb1.isSelected()) {
            new AddContent(loc);
        } else if (rb2.isSelected()) {
            new ContentByYear(loc);
        } else if (rb3.isSelected()) {
            new ContentByGenre(loc);
        } else if (rb4.isSelected()) {
            new ContentByLanguage(loc);;
        } else if (rb5.isSelected()) {
            new ContentByRatings(loc);;
        } else if (rb6.isSelected()) {
            new ContentByLocation(loc);;
        } else if (rb7.isSelected()) {
            new AccessList(loc);
        } else if (rb8.isSelected()) {
            removeContent();
        } else if (rb9.isSelected()) {
            saveListOfContent();
        } else if (rb10.isSelected()) {
            loadListOfContent();
        } else {
            exit();
        }
    }

    private void exit() {
        if (rb11.isSelected()) {
            if (0 == JOptionPane.showConfirmDialog(mainPanel,
                    "Are you sure?", "Confirm exit", JOptionPane.YES_NO_OPTION)) {
                System.exit(0);
            }
        }
    }


    //MODIFIES: this
    //EFFECTS: removes the Content with the same name as per user entry, from the list of Contents
    private void removeContent() {
        String s1;
        s1 = JOptionPane.showInputDialog(mainPanel,
                "Enter name of the Content you wish to remove from the list: ");

        if (!Objects.equals(s1, null)) {
            loc.removeContent(s1);
            JOptionPane.showMessageDialog(mainPanel, "Content removed Successfully!");
        }
    }

    // EFFECTS: saves the list of Content to file
    private void saveListOfContent() {
        try {
            jsonWriter.open();
            jsonWriter.write(loc);
            jsonWriter.close();
            JOptionPane.showMessageDialog(mainPanel, "Saved " + loc.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(mainPanel, "Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads List of Content from file
    private void loadListOfContent() {
        try {
            loc = jsonReader.read();
            JOptionPane.showMessageDialog(mainPanel, "Loaded " + loc.getName() + " to " + JSON_STORE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(mainPanel, "Unable to read from file: " + JSON_STORE);
        }
    }
}
