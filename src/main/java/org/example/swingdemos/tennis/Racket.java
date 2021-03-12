package org.example.swingdemos.tennis;

import java.awt.*;

public class Racket {

    protected int x = 0;
    protected int y = 0;
    protected int spdX = Settings.BALL_SPEED;
    protected Color color=new Color(0);

    public Racket(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void copyPos(Racket o)  {
        this.x=o.x;  this.y=o.y;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, Settings.racketWidth, Settings.racketHidth);
    }


}