package com.company;
import javax.swing.*;

public class Game {

    public static final int WIDTH = 800, HEIGHT = 600;

    private Background background;
    private String title;
    private JFrame frame;

    public Game() {}

    public void go() {
        this.title = "ROADKILL";
        this.frame = new JFrame(this.title);

        this.background = new Background();
        this.frame.getContentPane().add(this.background);

        this.frame.setSize(WIDTH, HEIGHT);
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo(null);

    }
}
