package ui;

import model.Content;
import model.ListOfContent;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class WhatToWatchNowGUI extends JFrame {
    private static final String JSON_STORE = "./data/contentList.json";
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;
    private Content c1;
    private ListOfContent loc = new ListOfContent("MyList");
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JPanel mainPanel;
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



    // EFFECTS: Runs the What To Watch Now application
    public WhatToWatchNowGUI() throws FileNotFoundException {
        super("What To Watch Now");

        setSize(WIDTH, HEIGHT);
        mainPanel = new JPanel();

        add(mainPanel);

        mainPanel.setLayout(null);

//        desktop = new JDesktopPane();
//        desktop.addMouseListener(new DesktopFocusAction());
//        controlPanel = new JInternalFrame("Control Panel", false, false, false, false);
//        controlPanel.setLayout(new BorderLayout());

//        setContentPane(desktop);
//        setTitle("What To Watch Now!");
//        setSize(WIDTH, HEIGHT);

//        controlPanel.pack();
//        controlPanel.setVisible(true);
//        desktop.add(controlPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        centreOnScreen();
//        addButtonPanel();
        setVisible(true);

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        runApp();
    }

    // MODIFIES : this
    // EFFECTS :takes user inputs and process them
    private void runApp() {
        JLabel welcomeLabel = new JLabel("Hello and welcome to the What To Watch Now app");
        welcomeLabel.setBounds(250, 0, 400, 100);

        mainPanel.add(welcomeLabel);

        displayMenu();


//        boolean keepGoing = true;
//        String command = "";
//
//        init();
//        System.out.println("\nWelcome to the best Streaming Destination!");
//
//        while (keepGoing) {
//            displayMenu();
//            command = input.next();
//            command = command.toLowerCase();
//
//            if (command.equals("q")) {
//                keepGoing = false;
//            } else {
//                processCommand(command);
//            }
//        }
//
//        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: initializes contents
//    private void init() {
//        c1 = new Content("G.I. Joe", 1995, "Action", "Eng", 5, "Netflix");
//        input = new Scanner(System.in);
//        input.useDelimiter("\n");
//    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {

        JLabel selectOperation = new JLabel("Please select from the given options:");
        selectOperation.setBounds(0, 100, 400, 25);
        mainPanel.add(selectOperation);


        rb1 = new JRadioButton("Add content to your playlist");
        rb1.setBounds(0, 140, 400, 20);
        mainPanel.add(rb1);

        rb2 = new JRadioButton("Filter Content Based on Year");
        rb2.setBounds(0, 140, 400, 20);
        mainPanel.add(rb2);

        rb3 = new JRadioButton("Filter Content Based on Genre");
        rb3.setBounds(0, 140, 400, 20);
        mainPanel.add(rb3);

        rb4 = new JRadioButton("Filter Content Based on Language");
        rb4.setBounds(0, 140, 400, 20);
        mainPanel.add(rb4);

        rb5 = new JRadioButton("Filter Content Based on Ratings");
        rb5.setBounds(0, 140, 400, 20);
        mainPanel.add(rb5);

        rb6 = new JRadioButton("Filter Content Based on Location");
        rb6.setBounds(0, 140, 400, 20);
        mainPanel.add(rb6);

        rb7 = new JRadioButton("Access your playlist");
        rb7.setBounds(0, 140, 400, 20);
        mainPanel.add(rb7);

        rb8 = new JRadioButton("Remove Content from your playlist");
        rb8.setBounds(0, 140, 400, 20);
        mainPanel.add(rb8);

        rb9 = new JRadioButton("Save list of Contents");
        rb9.setBounds(0, 140, 400, 20);
        mainPanel.add(rb9);

        rb10 = new JRadioButton("Load List of contents form file");
        rb10.setBounds(0, 140, 400, 20);
        mainPanel.add(rb10);

        rb11 = new JRadioButton("Close Application");
        rb11.setBounds(0, 140, 400, 20);
        mainPanel.add(rb11);

        ButtonGroup bg = new ButtonGroup();

        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        bg.add(rb4);
        bg.add(rb5);
        bg.add(rb6);
        bg.add(rb7);
        bg.add(rb8);
        bg.add(rb9);
        bg.add(rb10);
        bg.add(rb11);


        JButton okButton = new JButton("Ok");
        okButton.setBounds(0, 320, 60, 20);
        mainPanel.add(okButton);

        okButton.addActionListener(ae -> {
            processCommand();
        });

    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand() {
        if (rb1.isSelected()) {
            addContentToPlaylist();
        } else if (rb2.isSelected()) {
            giveContentOnYear();
        } else if (rb3.isSelected()) {
            giveContentOnGenre();
        } else if (rb4.isSelected()) {
            giveContentOnLanguage();
        } else if (rb5.isSelected()) {
            giveContentOnRatings();
        } else if (rb6.isSelected()) {
            giveContentOnLocation();

        } else if (rb7.isSelected()) {
            System.out.println("Here is your list of Contents: ");
            //System.out.println(loc.getNames());
            JList loc = new JList();

        } else if (rb8.isSelected()) {
            removeContent();
        } else if (rb9.isSelected()) {
            saveListOfContent();
        } else if (rb10.isSelected()) {
            loadListOfContent();
        }
    }


    // MODIFIES - this
    // EFFECTS - creates a new Content class from user descriptions and adds them to a playlist
    private void addContentToPlaylist() {
        String name;
        int year;
        String genre;
        String lang;
        int ratings;
        String location;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the name of the Content: ");
        name = sc.nextLine();
        System.out.println("Enter the year of the Content: ");
        year = sc.nextInt();
        System.out.println("Enter the genre of the Content: ");
        genre = sc.next();
        System.out.println("Enter your ratings for the Content: ");
        ratings = sc.nextInt();
        System.out.println("Enter the language of the Content: ");
        lang = sc.next();
        System.out.println("Enter the location of the Content: ");
        location = sc.next();
        System.out.println("And, That's It!");

        Content c = new Content(name, year, genre, lang, ratings, location);
        loc.addToList(c);
    }

    //EFFECTS: returns the list of contents of a specific year as per the user entry
    private void giveContentOnYear() {
        input = new Scanner(System.in);
        int y1;
        System.out.println("Enter year: ");
        y1 = input.nextInt();
        System.out.println("Here is the list of Contents based on this year: ");
        System.out.println(loc.contentbyYear(y1));
    }

    //EFFECTS: returns the list of contents of a specific genre as per the user entry
    private void giveContentOnGenre() {
        input = new Scanner(System.in);
        String g1;
        System.out.println("Enter Genre: ");
        g1 = input.nextLine();
        System.out.println("Here is the list of Contents based on this genre: ");
        System.out.println(loc.contentbyGenre(g1));
    }

    //EFFECTS: returns the list of contents of a specific language as per the user entry
    private void giveContentOnLanguage() {
        input = new Scanner(System.in);
        String l1;
        System.out.println("Enter first three letters of Language: ");
        l1 = input.nextLine();
        System.out.println("Here is the list of Contents based on this language: ");
        System.out.println(loc.contentbyLang(l1));
    }

    //EFFECTS: returns the list of contents of a specific rating as per the user entry
    private void giveContentOnRatings() {
        input = new Scanner(System.in);
        int r1;
        System.out.println("Enter rating: ");
        r1 = input.nextInt();
        System.out.println("Here is the list of Contents based on this rating: ");
        System.out.println(loc.contentbyRatings(r1));
    }

    //EFFECTS: returns the list of contents of a specific streaming site as per the user entry
    private void giveContentOnLocation() {
        input = new Scanner(System.in);
        String lo1;
        System.out.println("Enter Site: ");
        lo1 = input.nextLine();
        System.out.println("Here is the list of Contents on this Site: ");
        System.out.println(loc.contentbySite(lo1));
    }

    //MODIFIES: this
    //EFFECTS: removes the Content with the same name as per user entry, from the list of Contents
    private void removeContent() {
        input = new Scanner(System.in);
        String s1;
        System.out.println("Enter name of the Content you wish to remove from the list: ");
        s1 = input.nextLine();
        loc.removeContent(s1);

    }

    // EFFECTS: saves the list of Content to file
    private void saveListOfContent() {
        try {
            jsonWriter.open();
            jsonWriter.write(loc);
            jsonWriter.close();
            System.out.println("Saved " + loc.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads List of Content from file
    private void loadListOfContent() {
        try {
            loc = jsonReader.read();
            System.out.println("Loaded " + loc.getName() + " to " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}
