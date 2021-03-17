package com.company.states;

import com.company.Background;
import com.company.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {

    public JButton start;
    public JButton options;
    public JButton quit;

    public Menu() {
        this.start = new JButton("START");
        this.start.addActionListener(new MyStartListener());
        this.start.setBounds(Game.WIDTH/2 - 50, Game.HEIGHT/2 + 10, 100, 40);
        this.start.setBackground(Color.GREEN);

        this.options = new JButton("OPTIONS");
        this.options.addActionListener(new MyOptionsListener());
        this.options.setBounds(Game.WIDTH/2 - 50, Game.HEIGHT/2 + 70, 100, 40);
        this.options.setBackground(Color.CYAN);

        this.quit = new JButton("QUIT");
        this.quit.addActionListener(new MyQuitListener());
        this.quit.setBounds(Game.WIDTH/2 - 50, Game.HEIGHT/2 + 130, 100, 40);
        this.quit.setBackground(Color.RED);
    }
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        this.displayMessage(g);
    }
    private void displayMessage(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("uroob", Font.BOLD, 60));
        FontMetrics metrics = g.getFontMetrics(g.getFont());
        String title = "ROADKILL";
        g.drawString(title, Game.WIDTH/2 - metrics.stringWidth(title)/2, Game.HEIGHT/2 - 80);
        g.setColor(Color.MAGENTA);
        g.setFont(new Font("uroob", Font.ITALIC, 35));
        FontMetrics metrics2 = g.getFontMetrics(g.getFont());
        String message = "BE CAREFUL, YOU MIGHT LOSE YOUR PERMIT!";
        g.drawString(message, Game.WIDTH/2 - metrics2.stringWidth(message)/2, Game.HEIGHT/2 - 40);
    }
    public void enableButtons() {
        this.start.setEnabled(true);
        this.start.setVisible(true);

        this.quit.setEnabled(true);
        this.quit.setVisible(true);

        this.options.setEnabled(true);
        this.options.setVisible(true);
    }
    public void disableButtons() {
        this.start.setEnabled(false);
        this.start.setVisible(false);

        this.quit.setEnabled(false);
        this.quit.setVisible(false);

        this.options.setEnabled(false);
        this.options.setVisible(false);
    }

    private class MyStartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Background.STATE = "playing";
            Background.SCORE = 0;
            disableButtons();
        }
    }
    private class MyOptionsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Background.STATE = "options";
            disableButtons();
        }
    }
    private class MyQuitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
