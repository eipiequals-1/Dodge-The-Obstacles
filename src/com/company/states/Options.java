package com.company.states;

import com.company.Background;
import com.company.Game;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Options {

    public JButton home;
    private final String[] difficulties = {"beginner", "normal", "expert"};
    public JList list = new JList(difficulties);
    public JScrollPane scroller = new JScrollPane(list);

    public Options() {
        this.home = new JButton("HOME");
        this.home.addActionListener(new MyMenuListener());
        this.home.setBounds(Game.WIDTH - 110, 10, 100, 55);
        this.home.setBackground(new Color(217, 217, 61));
        this.scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.list.setVisibleRowCount(3);
        this.list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.list.addListSelectionListener(new MyListSelectedListener());
        this.list.setBounds(Game.WIDTH/2 - 55, Game.HEIGHT/2 + 60, 110, 150);
        this.list.setBackground(new Color(109, 207, 224));
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        this.displayMessage(g);
    }
    private void displayMessage(Graphics g) {
        g.setColor(new Color(110, 115, 211));
        g.setFont(new Font("uroob", Font.BOLD, 50));
        FontMetrics metrics = g.getFontMetrics(g.getFont());
        String writing = "Please select a difficulty:";
        g.drawString(writing, Game.WIDTH/2 - metrics.stringWidth(writing)/2, Game.HEIGHT/2 - 60);
    }
    public void enableButton() {
        this.home.setEnabled(true);
        this.home.setVisible(true);
        this.list.setEnabled(true);
        this.list.setVisible(true);
    }
    public void disableButton() {
        this.home.setVisible(false);
        this.home.setEnabled(false);
        this.list.setEnabled(false);
        this.list.setVisible(false);
    }

    private class MyMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Background.STATE = "menu";
            disableButton();
        }
    }
    private class MyListSelectedListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent lse) {
            if (!lse.getValueIsAdjusting()) {
                String selection = (String) list.getSelectedValue();
                switch (selection) {
                    case "beginner":
                        Background.DIFFICULTY = 1;
                        break;
                    case "normal":
                        Background.DIFFICULTY = 2;
                        break;
                    case "expert":
                        Background.DIFFICULTY = 3;
                        break;
                }
            }
        }
    }
}
