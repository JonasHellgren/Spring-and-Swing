package org.example.swingdemos.tennis;

import javax.swing.*;
import java.awt.*;

public class TennisPanel extends JPanel {



    private Racket racket = new Racket(0,0);
    private TennisBall tennisBall  = new TennisBall(0,0,Settings.BALL_RADIUS,Color.red);


    public TennisBall getTennisBall() {
        return tennisBall;
    }

    public void copyModelStates(GameModel gameModel)  {
        racket.copyPos(gameModel.getRacket());
        tennisBall.copyPos(gameModel.getTennisBall());
    }



    @Override
    public void paint(Graphics g) {
        super.paint(g);  //cleans the screen
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);


            g.setColor(tennisBall.color);
            g.fillOval(tennisBall.x, tennisBall.y, tennisBall.r, tennisBall.r);

            g.setColor(racket.color);
            g.fillRect(racket.x, racket.y, Settings.racketWidth, Settings.racketHidth);
        }

    }
