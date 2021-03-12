package org.example.swingdemos.tennis;

import java.awt.*;

public class Racket {

    int x = 0;
    int y = 0;
    int xa = Settings.BALL_SPEED;
    Color color=new Color(0);

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