package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Player {

    public int x;
    public int y;
    public int width = 62;
    public int height = 155;
    private Image image;
    public int dir = 0;

    public Player() {
        this.reset();
        this.image = new ImageIcon(getClass().getResource("racecar.png")).getImage();
    }

    public void draw(Graphics g, ImageObserver imObs) {
        g.drawImage(this.image, this.x, this.y, imObs);
    }

    public void move() {
        if (this.x < 0) {
            this.x = 0;
            this.dir = 0;
        }
        if (this.x + this.width > Game.WIDTH) {
            this.x = Game.WIDTH - this.width;
            this.dir = 0;
        }
        switch (this.dir) {
            case 1:
            case -1:
                this.x += this.dir;
                break;
            case 0:
                break;
        }
    }
    public void reset() {
        this.x = Game.WIDTH/2 - this.width/2;
        this.y = Game.HEIGHT*3/4 - this.height/2;
    }
}
