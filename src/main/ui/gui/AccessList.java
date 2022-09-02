package ui.gui;

import model.Content;
import model.ListOfContent;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

// JFrame that gives a list in a scroll pane
public class AccessList extends JFrame implements ListSelectionListener {
    private JPanel accessPanel;
    private ListOfContent loc;
    private JLabel nameLabel;
    private JLabel yearLabel;
    private JLabel ratingLabel;
    private JLabel genreLabel;
    private JLabel locationLabel;
    private JLabel langLabel;
    private JList list;

    //EFFECTS: constructs a new frame to print list of Contents in a scroll pane
    public AccessList(ListOfContent loc) {
        this.loc = loc;
        setSize(800, 600);
        setLocationRelativeTo(null);
        accessPanel = new JPanel();

        add(accessPanel);

        addLabels();

        accessPanel.setLayout(null);

        String[] listr = new String[loc.getList().size()];

        for (int i = 0; i < loc.getList().size(); i++) {
            listr[i] = loc.getNames().get(i);
        }
        
        list = new JList(listr);
        
        list.addListSelectionListener(this);
        
        JScrollPane jsp = new JScrollPane(list);
        jsp.setBounds(20, 40, 300, 80);
        accessPanel.add(jsp, list);
        
        backButton();
        
        setVisible(true);
    }

    //MODIFIES: this
    //EFFECTS: generates the "back" button with bounds and action
    private void backButton() {
        JButton back = new JButton("Back");
        back.setBounds(20, 150, 80,20);
        back.addActionListener(e -> {
            dispose();
        });
        accessPanel.add(back);
    }

    //MODIFIES: this
    //EFFECTS: adds labels to the panel which show the name, ratings, language, location, year and genre
    private void addLabels() {
        nameLabel = new JLabel();
        nameLabel.setBounds(20, 180, 150, 20);

        yearLabel = new JLabel();
        yearLabel.setBounds(20, 210, 150, 20);

        ratingLabel = new JLabel();
        ratingLabel.setBounds(20, 240, 150, 20);

        langLabel = new JLabel();
        langLabel.setBounds(20, 270, 150, 20);

        locationLabel = new JLabel();
        locationLabel.setBounds(20, 300, 150, 20);

        genreLabel = new JLabel();
        genreLabel.setBounds(20, 330, 150, 20);

        accessPanel.add(nameLabel);
        accessPanel.add(yearLabel);
        accessPanel.add(ratingLabel);
        accessPanel.add(genreLabel);
        accessPanel.add(langLabel);
        accessPanel.add(locationLabel);

    }

    //MODIFIES: this
    //EFFECTS: displays the fields of the selected Content
    @Override
    public void valueChanged(ListSelectionEvent e) {
        String name = (String) list.getSelectedValue();
        for (Content c : loc.getList()) {
            if (c.getName().equals(name)) {

                nameLabel.setText("Name: " + c.getName());
                yearLabel.setText("Year: " + c.getYear());
                ratingLabel.setText("Ratings: " + c.getRatings());
                genreLabel.setText("Genre: " + c.getGenre());
                langLabel.setText("Language: " + c.getLanguage());
                locationLabel.setText("Location: " + c.getLocation());
            }
        }
    }
}
