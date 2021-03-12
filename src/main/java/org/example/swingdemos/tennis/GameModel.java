package org.example.swingdemos.tennis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameModel {
    //Describes physics. A virtual world.

    private static final Logger log = LoggerFactory.getLogger(GameModel.class);

    private Racket racket;
    private TennisBall tennisBall;
    boolean gameOver=false;

    public GameModel(Racket racket, TennisBall tennisBall) {
        this.racket = racket;
        this.tennisBall = tennisBall;
    }

    public Racket getRacket() {
        return racket;
    }

    public TennisBall getTennisBall() {
        return tennisBall;
    }

    public void moveBall() {
        //Updates ball states
        if (tennisBall.x  < 0)
            tennisBall.spdx = Settings.BALL_SPEED;
        if (tennisBall.x   > Settings.W - 2*tennisBall.r)
            tennisBall.spdx = -Settings.BALL_SPEED;
        if (tennisBall.y > Settings.H)
            tennisBall.spdy = -Settings.BALL_SPEED;
        if (collision()) {
            log.info("collision");
            tennisBall.spdy = Settings.BALL_SPEED;  }
        if (tennisBall.y  < 0) {
            log.info("gameOver");
            gameOver = true;
        }
        tennisBall.x  = tennisBall.x  + tennisBall.spdx ;
        tennisBall.y  = tennisBall.y + tennisBall.spdy;
    }


    public void moveRacket(int newSpdX) {
        //Updates racket states
        racket.spdX =newSpdX;
        if (racket.x + racket.spdX > 0 && racket.x + racket.spdX < Settings.W)
            racket.x = racket.x + racket.spdX;
    }

    private boolean collision() {
    //Returns true if racket and ball collides
        return racket.getBounds().intersects(tennisBall.getBounds());
    }

    public void resetGame() {
        racket.x= Settings.W/2;
        tennisBall.x=Settings.W/2;   tennisBall.y=Settings.H/2;
        gameOver=false;
    }


}
