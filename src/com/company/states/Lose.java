package com.company.states;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import com.company.Background;
import com.company.Game;

public class Lose {

    public JButton menu;

    public Lose() {
        this.menu = new JButton("MENU");
        this.menu.addActionListener(new MyMenuListener());
        this.menu.setBounds(Game.WIDTH/2 - 55, Game.HEIGHT - 100, 110, 60);
        this.menu.setBackground(Color.CYAN);

    }
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        this.displayMessage(g);

    }
    private void displayMessage(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("uroob", Font.ITALIC, 50));
        FontMetrics metrics = g.getFontMetrics(g.getFont());
        String writing = "SCORE: " + Background.SCORE;
        String uLose = "You crashed";
        g.drawString(uLose, Game.WIDTH/2 - metrics.stringWidth(uLose)/2, Game.HEIGHT/2 - 60);
        g.drawString(writing, Game.WIDTH/2 - metrics.stringWidth(writing)/2, Game.HEIGHT/2);
    }

    public void enableButton() {
        this.menu.setEnabled(true);
        this.menu.setVisible(true);
    }
    public void disableButton() {
        this.menu.setEnabled(false);
        this.menu.setVisible(false);
    }
    private class MyMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Background.STATE = "menu";
            //Background.SCORE = 0;
            disableButton();
        }
    }
}
