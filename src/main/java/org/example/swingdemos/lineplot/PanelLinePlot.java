package org.example.swingdemos.lineplot;

import org.example.swingdemos.swingmanylinessomeballs.Ball;
import org.example.swingdemos.swingmanylinessomeballs.Line;

import javax.swing.*;
import java.awt.*;
//import java.util.LinkedList;

public class PanelLinePlot extends JPanel {
    //private  int[] line1x = new int[];

    ScaleLinear xScale=new ScaleLinear(0,100,0, LinePlotSettings.W/2);
    ScaleLinear yScale=new ScaleLinear(0,50, LinePlotSettings.H,0);


    // public void addLine(int x1, int x2, int x3, int x4, Color color) {
    //    lines.add(new Line(x1, x2, x3, x4, color));
   // }


    @Override
    public void paint(Graphics g) {
        super.paint(g);  //cleans the screen
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        double[] line1x = {10, 20 ,30,40,50,60,70,80};
        double[] line1y = {10, 10 ,30,30,30,30,30,30};

       g2d.setColor(Color.black);

       g2d.drawPolyline(xScale.calcOut(line1x),yScale.calcOut(line1y),line1x.length);

    }
}
