package ui;

import model.ListOfContent;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.gui.*;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class WhatToWatchNowGUI extends JFrame {
    private static final String JSON_STORE = "./data/contentList.json";
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;
    private ListOfContent loc = new ListOfContent("MyList");
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JPanel main;
    private JRadioButton rb1;
    private JRadioButton rb2;
    private JRadioButton rb3;
    private JRadioButton rb4;
    private JRadioButton rb5;
    private JRadioButton rb6;
    private JRadioButton rb7;
    private JRadioButton rb8;
    private JRadioButton rb9;
    private JRadioButton rb10;
    private JRadioButton rb11;
    private ButtonGroup bg;
    private Font f1;
    private Font f2;
    private Font f3;
    private Font f4;

    // EFFECTS: Runs the What To Watch Now application
    public WhatToWatchNowGUI() throws FileNotFoundException {
        super("What To Watch Now");

        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        main = new JPanel();

        add(main);

        main.setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //setResizable(false);

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        f1 = new Font(Font.SERIF, Font.PLAIN,  20);
        f2 = new Font(Font.SANS_SERIF,  Font.BOLD, 20);
        f3 = new Font(Font.DIALOG,  Font.BOLD, 25);
        f4 = new Font(Font.DIALOG_INPUT,Font.BOLD + Font.ITALIC,25);

        runApp();
        setVisible(true);
    }

    // MODIFIES : this
    // EFFECTS :takes user inputs and process them
    private void runApp() {
        JLabel welcomeLabel = new JLabel("Hello and welcome to the What To Watch Now app");
        welcomeLabel.setBounds(100, 0, 800, 100);
        welcomeLabel.setFont(f4);

        main.add(welcomeLabel);
        centreOnScreen();

        displayOptions();
    }

    /**
     * Helper to centre main application window on desktop
     */
    private void centreOnScreen() {
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        setLocation((width - getWidth()) / 2, (height - getHeight()) / 2);
    }

    // MODIFIES : main, bg, this
    // EFFECTS: displays menu of options to user
    private void displayOptions() {

        JLabel selectOperation = new JLabel("Please select from the given options:");
        selectOperation.setBounds(0, 100, 400, 25);
        main.add(selectOperation);
        selectOperation.setFont(f2);

        bg = new ButtonGroup();
        
        generateAdd();
        
        generateYear();
        
        generateLocation();
        
        generateLanguage();
        
        generateGenre();
        
        generateRatings();
        
        generateAccess();
        
        generateRemove();
        
        generateSave();
        
        generateLoad();
        
        generateClose();

        JButton okButton = new JButton("Ok");
        okButton.setBounds(10, 380, 60, 40);
        main.add(okButton);


        okButton.addActionListener(ae -> {
            processCommand();
        });

        setVisible(true);
    }

    // MODIFIES : main, this
    // EFFECTS : generates close button with font and bounds. Adds button to panel and buttongroup
    private void generateClose() {
        rb11 = new JRadioButton("Close Application");
        rb11.setFont(f1);
        rb11.setBounds(0, 340, 400, 20);
        main.add(rb11);
        bg.add(rb11);
    }

    // MODIFIES : main, this
    // EFFECTS : generates load button with font and bounds. Adds button to panel and buttongroup
    private void generateLoad() {
        rb10 = new JRadioButton("Load List of Contents from file");
        rb10.setFont(f1);
        rb10.setBounds(0, 320, 400, 20);
        main.add(rb10);
        bg.add(rb10);
    }

    // MODIFIES : main, this
    // EFFECTS : generates save button with font and bounds. Adds button to panel and buttongroup
    private void generateSave() {
        rb9 = new JRadioButton("Save list of Content");
        rb9.setFont(f1);
        rb9.setBounds(0, 300, 400, 20);
        main.add(rb9);
        bg.add(rb9);
    }

    // MODIFIES : main, this
    // EFFECTS : generates remove button with font and bounds. Adds button to panel and buttongroup
    private void generateRemove() {
        rb8 = new JRadioButton("Remove Content from your playlist");
        rb8.setFont(f1);
        rb8.setBounds(0, 280, 400, 20);
        main.add(rb8);
        bg.add(rb8);
    }

    // MODIFIES : main, this
    // EFFECTS : generates AccessList button with font and bounds. Adds button to panel and buttongroup
    private void generateAccess() {
        rb7 = new JRadioButton("Access your playlist");
        rb7.setFont(f1);
        rb7.setBounds(0, 260, 400, 20);
        main.add(rb7);
        bg.add(rb7);
    }

    // MODIFIES : main, this
    // EFFECTS : generates ratings button with font and bounds. Adds button to panel and buttongroup
    private void generateRatings() {
        rb6 = new JRadioButton("Filter Content Based on Location");
        rb6.setFont(f1);
        rb6.setBounds(0, 240, 400, 20);
        main.add(rb6);
        bg.add(rb6);
    }

    // MODIFIES : main, this
    // EFFECTS : generates genre button with font and bounds. Adds button to panel and buttongroup
    private void generateGenre() {
        rb5 = new JRadioButton("Filter Content Based on Ratings");
        rb5.setFont(f1);
        rb5.setBounds(0, 220, 400, 20);
        main.add(rb5);
        bg.add(rb5);
    }

    // MODIFIES : main, this
    // EFFECTS : generates language button with font and bounds. Adds button to panel and buttongroup
    private void generateLanguage() {
        rb4 = new JRadioButton("Filter Content Based on Language");
        rb4.setFont(f1);
        rb4.setBounds(0, 200, 400, 20);
        main.add(rb4);
        bg.add(rb4);
    }

    // MODIFIES : main, this
    // EFFECTS : generates location button with font and bounds. Adds button to panel and buttongroup
    private void generateLocation() {
        rb3 = new JRadioButton("Filter Content Based on Genre");
        rb3.setFont(f1);
        rb3.setBounds(0, 180, 400, 20);
        main.add(rb3);
        bg.add(rb3);
    }

    // MODIFIES : main, this
    // EFFECTS : generates year button with font and bounds. Adds button to panel and buttongroup
    private void generateYear() {
        rb2 = new JRadioButton("Filter Content Based on Year");
        rb2.setFont(f1);
        rb2.setBounds(0, 160, 400, 20);
        main.add(rb2);
        bg.add(rb2);
    }

    // MODIFIES : main, this
    // EFFECTS : generates add button with font and bounds. Adds button to panel and buttongroup
    private void generateAdd() {
        rb1 = new JRadioButton("Add Content to your list");
        rb1.setFont(f1);
        rb1.setBounds(0, 140, 400, 20);
        main.add(rb1);
        bg.add(rb1);
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
            new ContentByLanguage(loc);
        } else if (rb5.isSelected()) {
            new ContentByRatings(loc);
        } else if (rb6.isSelected()) {
            new ContentByLocation(loc);
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

    // MODIFIES : main
    // EFFECTS :  returns a Yes or no dialog box, that terminates the app on "Yes"
    private void exit() {
        if (rb11.isSelected()) {
            if (0 == JOptionPane.showConfirmDialog(main,
                    "Are you sure?", "Confirm exit", JOptionPane.YES_NO_OPTION)) {
                System.exit(0);
            }
        }
    }


    //MODIFIES: this
    //EFFECTS: removes the Content with the same name as per user entry, from the list of Contents
    private void removeContent() {
        String s1;
        s1 = JOptionPane.showInputDialog(main,
                "Enter name of the Content you wish to remove from the list: ");

        if (!Objects.equals(s1, null)) {
            loc.removeContent(s1);
            JOptionPane.showMessageDialog(main, "Content removed Successfully!");
        }
    }

    // EFFECTS: saves the list of Content to file
    private void saveListOfContent() {
        try {
            jsonWriter.open();
            jsonWriter.write(loc);
            jsonWriter.close();
            JOptionPane.showMessageDialog(main, "Saved " + loc.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(main, "Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads List of Content from file
    private void loadListOfContent() {
        try {
            loc = jsonReader.read();
            JOptionPane.showMessageDialog(main, "Loaded " + loc.getName() + " to " + JSON_STORE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(main, "Unable to read from file: " + JSON_STORE);
        }
    }
}
