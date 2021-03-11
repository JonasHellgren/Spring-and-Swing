package org.example.domain.swingapp2modif2;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class PanelComponent extends JPanel {

    private final LinkedList<Line> lines = new LinkedList<Line>();
    private final LinkedList<Ball> balls = new LinkedList<Ball>();

    public void moveBalls() {
        for (Ball ball:balls)
            moveBall(ball);
    }

    public void moveBall(Ball ball) {
        if (ball.x + ball.spdx < 0)
            ball.spdx = 1;
        if (ball.x + ball.spdx  > getWidth() - 30)
            ball.spdx = -1;
        if (ball.y+ ball.spdy < 0)
            ball.spdy = 1;
        if (ball.y + ball.spdy > getHeight() - 30)
            ball.spdy = -1;

        ball.x  = ball.x  + ball.spdx ;
        ball.y  = ball.y + ball.spdy;
    }

    public void clearLines() {
        lines.clear();
        repaint();
    }

    public void addLine(int x1, int x2, int x3, int x4) {
        addLine(x1, x2, x3, x4, Color.black);
    }

    public void addLine(int x1, int x2, int x3, int x4, Color color) {
        lines.add(new Line(x1, x2, x3, x4, color));
        repaint();
    }

    public void addBall(int x, int y, int r) {
        addBall(x,y,r,Color.black);
    }

    public void addBall(int x, int y, int r, Color color) {
        balls.add(new Ball(x,y, r, color));
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        //g.fillOval(x, y, 30, 30);

        for (Ball ball:balls) {
            g.setColor(ball.color);
            g.fillOval(ball.x, ball.y, ball.r, ball.r);
        }

        for (Line line : lines) {
            g.setColor(line.color);
            g.drawLine(line.x1, line.y1, line.x2, line.y2);
        }

    }
}