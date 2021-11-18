package org.example.swingdemos.tennis;

import org.example.swingdemos.swingmanylinessomeballs.Ball;
import org.example.swingdemos.swingmanylinessomeballs.Line;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class TennisPanel extends JPanel {
    //Can be seen as view class.

    private final LinkedList<Dot> dots = new LinkedList<>();
    private Racket racket = new Racket(0, 0);
    private TennisBall tennisBall = new TennisBall(0, 0, Settings.BALL_RADIUS, Color.red);

    public void addDot(Dot dot) {
        dots.add(dot);
    }

    public void copyModelStates(GameModel gameModel) {
        racket.copyPos(gameModel.getRacket());
        tennisBall.copyPos(gameModel.getTennisBall());
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);  //cleans the screen
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        for (Dot dot : dots) {
            g.setColor(dot.color);
            g.fillOval(dot.x, dot.y, dot.r, dot.r);
        }

        g.setColor(tennisBall.color);
        g.fillOval(tennisBall.x, Settings.H - tennisBall.y, tennisBall.r, tennisBall.r);

        g.setColor(racket.color);
        g.fillRect(racket.x, Settings.H - racket.y, Settings.racketWidth, Settings.racketHidth);


    }
}
