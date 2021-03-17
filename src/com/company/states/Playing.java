package com.company.states;
import java.awt.*;
import java.util.ArrayList;
import java.awt.image.ImageObserver;

import com.company.HighScore;

import com.company.*;

public class Playing {

    public Player player;
    private ArrayList<Obstacle> obstacles;

    public Playing() {
        this.player = new Player();
        this.setObstacles();
    }
    public void draw(Graphics g, ImageObserver imObs) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        g.setColor(Color.BLACK);
        g.drawLine(Game.WIDTH/2, 0, Game.WIDTH/2, Game.HEIGHT);
        this.player.draw(g, imObs);
        for (Obstacle e: this.obstacles) {
            e.draw(g);
        }
        this.displayScore(g);
        this.displayHighScore(g);
    }
    public void update() {
        this.player.move();
        Obstacle.velY = Background.SCORE/35 + Background.DIFFICULTY;
        for (int i = 0; i < this.obstacles.size(); i++) {
            Obstacle ob = this.obstacles.get(i);
            ob.move();
            if (ob.checkPlayer(this.player)) {
                this.reset();
                HighScore.writeFile("" + Background.SCORE);
                Background.STATE = "lose";
            }
            if (ob.checkScreen()) {
                this.obstacles.remove(ob);
                Background.SCORE += 1;
                this.obstacles.add(new Obstacle());
            }
        }
        if (Background.SCORE > 100) {
            Background.STATE = "win";
            HighScore.writeFile("" + Background.SCORE);
        }
    }
    private void setObstacles() {
        this.obstacles = new ArrayList<Obstacle>();
        for (int i = 0; i < 5; i++) {
            this.obstacles.add(new Obstacle());
        }
    }
    private void displayScore(Graphics g) {
        g.setColor(Color.ORANGE);
        g.setFont(new Font("uroob", Font.PLAIN, 30));
        String writing = "DODGED: " + Background.SCORE;
        g.drawString(writing, 10, 40);
    }
    private void displayHighScore(Graphics g) {
        g.setColor(new Color(5, 55, 34));
        g.setFont(new Font("uroob", Font.PLAIN, 30));
        FontMetrics metrics = g.getFontMetrics(g.getFont());
        String highScore = "High Score: " + HighScore.getMax();
        g.drawString(highScore, Game.WIDTH - 10 - metrics.stringWidth(highScore), 30);

    }
    private void reset() {
        this.obstacles.clear();
        this.setObstacles();
        this.player.reset();
    }

}
