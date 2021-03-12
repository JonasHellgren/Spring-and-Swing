package org.example.swingdemos.tennis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class GameModel {

    private static final Logger log = LoggerFactory.getLogger(GameModel.class);

    private Racket racket;
    private TennisBall tennisBall;
    TennisPanel panel;
    boolean gameOver=false;

    public GameModel(Racket racket, TennisBall tennisBall, TennisPanel panel) {
        this.racket = racket;
        this.tennisBall = tennisBall;
        this.panel = panel;
    }

    public Racket getRacket() {
        return racket;
    }

    public TennisBall getTennisBall() {
        return tennisBall;
    }

    public void moveBall() {
        if (tennisBall.x + tennisBall.spdx < 0)
            tennisBall.spdx = Settings.BALL_SPEED;
        if (tennisBall.x + tennisBall.spdx  > panel.getWidth() - 2*tennisBall.r)
            tennisBall.spdx = -Settings.BALL_SPEED;
        if (tennisBall.y+ tennisBall.spdy < 0)
            tennisBall.spdy = Settings.BALL_SPEED;
        if (collision()) {
            log.info("collision");
            tennisBall.spdy = -Settings.BALL_SPEED;  }
        if (tennisBall.y  > panel.getHeight() ) {
            log.info("gameOver");
            gameOver = true;
        }
        tennisBall.x  = tennisBall.x  + tennisBall.spdx ;
        tennisBall.y  = tennisBall.y + tennisBall.spdy;
    }


    public void moveRacket(int newSpdX) {
        racket.xa=newSpdX;
        if (racket.x + racket.xa > 0 && racket.x + racket.xa < panel.getWidth()-60)
            racket.x = racket.x + racket.xa;
    }

    private boolean collision() {

        return racket.getBounds().intersects(tennisBall.getBounds());
    }

    public void resetGame() {
        racket.x= Settings.W/2;
        tennisBall.x=Settings.W/2;   tennisBall.y=Settings.H/2;
        gameOver=false;
    }


}
