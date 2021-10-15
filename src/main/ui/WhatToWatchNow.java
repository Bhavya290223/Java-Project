package ui;

import model.Content;
import model.ListOfContent;

import java.util.Scanner;

public class WhatToWatchNow {
    private Content c1;
    private ListOfContent loc = new ListOfContent();
    private Scanner input;

    // EFFECTS: Runs the What To Watch Now application
    public WhatToWatchNow() {
        runApp();
    }

    private void runApp() {
        boolean keepGoing = true;
        String command = "";

        init();
        System.out.println("\nWelcome to the best Streaming Destination!");

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: initializes contents
    private void init() {
        c1 = new Content("G.I. Joe", 1995, "Action", "Eng",
                5, "Netflix");
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tAdd content to your playlist, type add");
        System.out.println("\tContent Based on Year, type y");
        System.out.println("\tContent Based on Genre, type g");
        System.out.println("\tContent Based on Language, type l");
        System.out.println("\tContent Based on Ratings, type r");
        System.out.println("\tContent Based on Location, type lo");
        System.out.println("\tAccess your Playlist, type play");
        System.out.println("\tRemove content to your playlist, type rem");
        System.out.println("\tquit, type q");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("add")) {
            addContentToPlaylist();
        } else if (command.equals("y")) {
            giveContentOnYear();
        } else if (command.equals("g")) {
            giveContentOnGenre();
        } else if (command.equals("l")) {
            giveContentOnLanguage();
        } else if (command.equals("r")) {
            giveContentOnRatings();
        } else if (command.equals("lo")) {
            giveContentOnLocation();

        } else if (command.equals("play")) {
            System.out.println("Here is your list of Contents: ");
            System.out.println(loc.getNames());

        } else if (command.equals("rem")) {
            removeContent();
        } else {
            System.out.println("Selection not valid...");
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

    private void giveContentOnYear() {
        input = new Scanner(System.in);
        int y1;
        System.out.println("Enter year: ");
        y1 = input.nextInt();
        System.out.println("Here is the list of Contents based on this year: ");
        System.out.println(loc.contentbyYear(y1));
    }

    private void giveContentOnGenre() {
        input = new Scanner(System.in);
        String g1;
        System.out.println("Enter Genre: ");
        g1 = input.nextLine();
        System.out.println("Here is the list of Contents based on this genre: ");
        System.out.println(loc.contentbyGenre(g1));
    }

    private void giveContentOnLanguage() {
        input = new Scanner(System.in);
        String l1;
        System.out.println("Enter first three letters of Language: ");
        l1 = input.nextLine();
        System.out.println("Here is the list of Contents based on this language: ");
        System.out.println(loc.contentbyLang(l1));
    }

    private void giveContentOnRatings() {
        input = new Scanner(System.in);
        int r1;
        System.out.println("Enter rating: ");
        r1 = input.nextInt();
        System.out.println("Here is the list of Contents based on this rating: ");
        System.out.println(loc.contentbyRatings(r1));
    }

    private void giveContentOnLocation() {
        input = new Scanner(System.in);
        String lo1;
        System.out.println("Enter Site: ");
        lo1 = input.nextLine();
        System.out.println("Here is the list of Contents on this Site: ");
        System.out.println(loc.contentbySite(lo1));
    }

    private void removeContent() {
        input = new Scanner(System.in);
        String s1;
        System.out.println("Enter name of the Content you wish to remove from the list: ");
        s1 = input.nextLine();
        loc.removeContent(s1);

    }
}
