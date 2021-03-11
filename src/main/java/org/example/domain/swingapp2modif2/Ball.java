package org.example.domain.swingapp2modif2;

import java.awt.*;

public class Ball {
     int x=0;
     int spdx=1;
     int y=0;
     int spdy=1;
     int r=0;
     Color color=new Color(0);

    public Ball(int x, int y, int r, Color color) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.color = color;
    }
}