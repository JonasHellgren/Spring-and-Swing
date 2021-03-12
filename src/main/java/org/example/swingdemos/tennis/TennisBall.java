package org.example.swingdemos.tennis;

import java.awt.*;

public class TennisBall {
    protected int x=0;
    protected int spdx=Settings.BALL_SPEED;
    protected int y=0;
    protected int spdy=Settings.BALL_SPEED;
    protected int r=0;
     Color color=new Color(0);

    public TennisBall(int x, int y, int r, Color color) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.color = color;
    }


    public void copyPos(TennisBall o)  {
        this.x=o.x;     this.y=o.y;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 2*r, 2*r);
    }

}