package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.company.states.*;
import com.company.states.Menu;

public class Background extends JPanel implements ActionListener {

    private Timer timer;
    private Playing playing;
    private Lose lose;
    private Win win;
    private Menu menu;
    private Options options;

    public static int DIFFICULTY = 1;

    public static int SCORE = 0;

    public static String STATE = "menu";

    public Background() {
        this.setLayout(null);
        this.playing = new Playing();
        this.lose = new Lose();
        this.win = new Win();
        this.menu = new Menu();
        this.options = new Options();
        this.timer = new Timer(5, this);
        this.timer.start();
        this.addKeyListener(new MyKeyListener());
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);

        this.add(this.lose.menu);
        this.lose.disableButton();

        this.add(this.win.menu);
        this.win.disableButton();

        this.add(this.menu.quit);
        this.add(this.menu.options);
        this.add(this.menu.start);

        this.menu.disableButtons();

        this.add(this.options.home);
        this.options.disableButton();

        this.add(this.options.scroller);
        this.add(this.options.list);
        this.options.disableButton();

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //System.out.println(DIFFICULTY);
        if (this.STATE.equals("playing")) {
            this.playing.draw(g, this);

        } else if (this.STATE.equals("lose")) {
            this.lose.draw(g);
            this.lose.enableButton();

        } else if (this.STATE.equals("win")) {
            this.win.draw(g);
            this.win.enableButton();

        } else if (this.STATE.equals("menu")) {
            this.menu.draw(g);
            this.menu.enableButtons();
        } else if (this.STATE.equals("options")) {
            this.options.draw(g);
            this.options.enableButton();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // the updating method of the game
        if (this.STATE.equals("playing")) {
            this.playing.update();
        } else if (this.STATE.equals("lose")) {}
        else if (this.STATE.equals("win")) {}
        else if (this.STATE.equals("menu")) {}

        this.repaint();
    }

    private class MyKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            int c = e.getKeyCode();
            switch (c) {
                case KeyEvent.VK_LEFT:
                    playing.player.dir = -1;
                    break;
                case KeyEvent.VK_RIGHT:
                    playing.player.dir = 1;
                    break;
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {
            int c = e.getKeyCode();
            switch (c) {
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_RIGHT:
                    playing.player.dir = 0;
                    break;
            }
        }
    }
}
