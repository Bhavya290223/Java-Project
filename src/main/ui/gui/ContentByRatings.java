package ui.gui;

import model.ListOfContent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

// JFrame that filters content by ratings
public class ContentByRatings extends JFrame implements ActionListener {
    private int r1;
    private JTextField ratingsText;
    private JLabel ratingsLabel;
    private JLabel answerLabel;
    private ListOfContent loc;
    private JPanel panel;
    private JList list;
    private JButton ok;
    private JScrollPane jsp;

    //EFFECTS: constructs a panel for displaying "filter according to rating" functionality
    public ContentByRatings(ListOfContent loc) {
        this.loc = loc;
        setSize(800, 800);
        setLocationRelativeTo(null);

        panel = new JPanel();
        add(panel);
        panel.setLayout(null);

        ratingsLabel = new JLabel("Enter ratings: ");
        ratingsLabel.setBounds(0, 10, 400, 20);
        panel.add(ratingsLabel);

        ratingsText = new JTextField();
        ratingsText.setBounds(310, 20, 200, 20);
        panel.add(ratingsText);

        answerLabel = new JLabel();
        answerLabel.setBounds(100, 260, 340, 20);
        panel.add(answerLabel);

        ok = new JButton("OK");
        ok.setBounds(150, 200, 80, 20);
        panel.add(ok);
        ok.addActionListener(this);

        backButton();

        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS : adds Back button with action listener and bound to new panel
    private void backButton() {
        JButton backButton = new JButton("Back");
        backButton.setBounds(250, 200, 80, 20);
        backButton.addActionListener(e -> {
            dispose();
        });
        panel.add(backButton);
    }

    // MODIFIES: this
    // EFFECTS: renders the scroll pane
    @Override
    public void actionPerformed(ActionEvent e) {
        if (jsp != null) {
            jsp.removeAll();
            displayList();
        }

        displayList();
        jsp.revalidate();
    }

    // MODIFIES: this, jsp
    // EFFECTS : displays list by ratings in a new scroll pane with bounds and adds it to panel
    private void displayList() {
        answerLabel.setText("Here is the list of Contents of this rating: ");

        try {
            r1 = Integer.parseInt(ratingsText.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(panel, "Please enter a valid rating!");
        }

        List<String> finalList = loc.contentbyRatings(r1);
        int size = finalList.size();

        String[] names = new String[size];

        for (int i = 0;i < size;i++) {
            names[i] = finalList.get(i);
        }

        list = new JList(names);

        jsp = new JScrollPane(list);
        jsp.setBounds(100,280,300,80);
        panel.add(jsp,list);
    }
}
