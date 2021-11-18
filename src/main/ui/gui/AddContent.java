package ui.gui;

import model.Content;
import model.ListOfContent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddContent extends JFrame implements ActionListener {
    private String name;
    private int year;
    private String genre;
    private String lang;
    private int ratings;
    private String location;

    private JLabel nameLabel = new JLabel();
    private JTextField nameText;

    private JLabel ratingLabel = new JLabel();
    private JTextField ratingText;

    private JLabel yearLabel = new JLabel();
    private JTextField yearText;

    private JLabel genreLabel = new JLabel();
    private JTextField genreText;

    private JLabel langLabel = new JLabel();
    private JTextField langText;

    private JLabel locationLabel = new JLabel();
    private JTextField locationText;

    private ListOfContent loc;

    private JPanel panel;


    public AddContent(ListOfContent loc) {
        this.loc = loc;
        setSize(600, 600);
        setLocationRelativeTo(null);
        panel = new JPanel();

        add(panel);

        panel.setLayout(null);


        getNameLabelAndText();

        getRatingLabelAndText();

        getLocationLabelAndText();

        getYearLabelAndText();

        getGenreLabelAndText();

        getLanguageLabelAndText();

        getButtons();

        setVisible(true);

    }

    private void getButtons() {
        JButton store = new JButton("OK");
        store.setBounds(150,200,200,20);
        store.addActionListener(this);
        panel.add(store);

        JButton backButton = new JButton("Back");
        backButton.setBounds(400,190,200,20);
        backButton.addActionListener(e -> {
            dispose();
        });
        panel.add(backButton);
    }

    private void getLanguageLabelAndText() {
        langLabel = new JLabel("Enter the language of the Content: ");
        langLabel.setBounds(10, 170, 200, 20);
        panel.add(langLabel);

        langText = new JTextField();
        langText.setBounds(310, 170, 200, 20);
        panel.add(langText);
    }

    private void getGenreLabelAndText() {
        genreLabel = new JLabel("Enter the genre of the Content: ");
        genreLabel.setBounds(10, 140, 200, 20);
        panel.add(genreLabel);

        genreText = new JTextField();
        genreText.setBounds(310, 140, 200, 20);
        panel.add(genreText);
    }

    private void getYearLabelAndText() {
        yearLabel = new JLabel("Enter the year of the Content: ");
        yearLabel.setBounds(10, 110, 200, 20);
        panel.add(yearLabel);

        yearText = new JTextField();
        yearText.setBounds(310, 110, 200, 20);
        panel.add(yearText);
    }

    private void getLocationLabelAndText() {
        locationLabel = new JLabel("Enter the Location of the Content: ");
        locationLabel.setBounds(10, 80, 300, 20);
        panel.add(locationLabel);

        locationText = new JTextField();
        locationText.setBounds(310, 80, 200, 20);
        panel.add(locationText);
    }

    private void getRatingLabelAndText() {
        ratingLabel = new JLabel("Enter your rating (out of 5) for the Content: ");
        ratingLabel.setBounds(10, 50, 300, 20);
        panel.add(ratingLabel);

        ratingText = new JTextField();
        ratingText.setBounds(310, 50, 200, 20);
        panel.add(ratingText);
    }

    private void getNameLabelAndText() {
        nameLabel = new JLabel("Enter the name of the Content: ");
        nameLabel.setBounds(10, 20, 200, 20);
        panel.add(nameLabel);

        nameText = new JTextField();
        nameText.setBounds(310, 20, 200, 20);
        panel.add(nameText);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        name = nameText.getText();
        ratings = Integer.parseInt(ratingText.getText());
        genre = genreText.getText();
        year = Integer.parseInt(yearText.getText());
        lang = langText.getText();
        location = locationText.getText();

        Content c = new Content(name, year, genre, lang, ratings, location);
        loc.addToList(c);

        JOptionPane.showMessageDialog(panel,"Content added successfully!");
    }
}
