package com.company;
import java.awt.Color;
import java.util.Random;
import java.awt.Graphics;

public class Obstacle {

    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    private Random random = new Random();

    public static int velY;

    public Obstacle() {
        this.width = this.random.nextInt(20) + 60;
        this.height = this.width;
        this.x = this.random.nextInt(Game.WIDTH - this.width);
        this.y = this.random.nextInt(Game.HEIGHT) - this.random.nextInt(Game.HEIGHT)*3 - Game.HEIGHT;
        this.color = this.makeColor();
    }

    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillRect(this.x, this.y, this.width, this.height);
    }

    private Color makeColor() {
        int r = this.random.nextInt(200) + 30;
        int g = this.random.nextInt(200) + 30;
        int b = this.random.nextInt(200) + 30;
        return new Color(r, g, b);
    }
    public void move() {
        this.y += this.velY;
    }
    public boolean checkPlayer(Player p) {
        boolean value = false;
        // check to the player's left                and                          right
        if (((p.x > this.x) && (p.x < this.x + this.width)) || ((p.x + p.width > this.x) && (p.x < this.x + this.width))) {
            if ((p.y <= this.y + this.height) && (p.y + p.height > this.y)) {
                value = true;
            }
        } else {
            value = false;
        }
        return value;
    }
    public boolean checkScreen() {
        boolean value = false;
        if (this.y > Game.HEIGHT) {
            value = true;
        }
        return value;
    }
}
