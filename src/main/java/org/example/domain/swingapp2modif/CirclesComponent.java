package org.example.domain.swingapp2modif;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class CirclesComponent extends JComponent {

    private final LinkedList<Circle> circles = new LinkedList<Circle>();

    //inner class
    private static class Circle {
        final int x1;
        final int y1;
        final int r;
        final Color color;

        public Circle(int x1, int y1, int r, Color color) {
            this.x1 = x1;
            this.y1 = y1;
            this.r = r;
            this.color = color;
        }
    }

    public void addCircle(int x1, int x2, int r) {
        addCircle(x1, x2, r, Color.black);
    }

    public void addCircle(int x1, int x2, int r, Color color) {
        circles.add(new Circle(x1, x2, r, color));
        repaint();
    }

    public void clearLines() {
        circles.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Circle circle : circles) {
            g.setColor(circle.color);
            g.drawOval(circle.x1, circle.y1, circle.r, circle.r);
        }
    }
}