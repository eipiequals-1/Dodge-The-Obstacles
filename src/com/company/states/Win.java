package com.company.states;

import com.company.Background;
import com.company.Game;

import java.awt.*;

public class Win extends Lose {

    public Win() {
        super();
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("uroob", Font.ITALIC, 50));
        FontMetrics metrics = g.getFontMetrics(g.getFont());
        String writing = "SCORE: " + Background.SCORE;
        String uWin = "YOU WIN!";
        g.drawString(uWin, Game.WIDTH/2 - metrics.stringWidth(uWin)/2, Game.HEIGHT/2 - 60);
        g.drawString(writing, Game.WIDTH/2 - metrics.stringWidth(writing)/2, Game.HEIGHT/2);
    }
}
