package ui.gui;

import model.ListOfContent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ContentByGenre extends JFrame implements ActionListener {
    private String g1;
    private JTextField genreText;
    private JLabel genreLabel;
    private JLabel answerLabel;
    private ListOfContent loc;
    private JPanel panel;
    private JList list;
    private JButton ok;
    private JScrollPane jsp;


    public ContentByGenre(ListOfContent loc) {
        this.loc = loc;
        setSize(800, 800);
        setLocationRelativeTo(null);

        panel = new JPanel();
        add(panel);
        panel.setLayout(null);

        genreLabel = new JLabel("Enter genre: ");
        genreLabel.setBounds(0, 10, 400, 20);
        panel.add(genreLabel);

        genreText = new JTextField();
        genreText.setBounds(310, 20, 200, 20);
        panel.add(genreText);

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

    // MODIFIES: this, main
    // EFFECTS : adds Back button with action listener and bound to new panel
    private void backButton() {
        JButton backButton = new JButton("Back");
        backButton.setBounds(250, 200, 80, 20);
        backButton.addActionListener(e -> {
            dispose();
        });
        panel.add(backButton);
    }

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
    // EFFECTS : displays list by genre in a new scroll pane with bounds and adds it to panel
    private void displayList() {
        answerLabel.setText("Here is the list of Contents of this genre: ");

        g1 = genreText.getText();

        List<String> finalList = loc.contentbyGenre(g1);
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
