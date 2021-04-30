package org.example.swingdemos.lineplot;

import org.example.swingdemos.lineplotmodel.ScaleSetter;
import org.example.swingdemos.lineplotmodel.XScaleSetter;
import org.example.swingdemos.lineplotmodel.YScaleSetter;

import javax.swing.*;
import java.awt.*;
//import java.util.LinkedList;

/**
 * Multiple subplots can only be stacked in x-direction, in the horizontal plane
 * The lower left corner of a subplot is given by (x0,y0+hSubPlot)
 * The upper left corner of a subplot is given by (x0,y0)
 * In Java AWT y increases downwards a panel, x increases "as expected" in right direction
 */


public class PanelLinePlot extends JPanel {
    LinePlot linePlot;
    int nofSubplots;

    private ScaleSetter xScaleSetter=new XScaleSetter();
    private ScaleSetter yScaleSetter=new YScaleSetter();

    public void setData(LinePlot linePlot) {
        this.linePlot = linePlot;
        nofSubplots = linePlot.getSubPlots().size();
    }

    public void drawPlot(Graphics2D g2d) {
        int wSubPlot = xScaleSetter.getWeightSubPlot(linePlot);
        int subPlotId = 0;
        for (SubPlot subPlot : linePlot.getSubPlots()) {
            int x0 = linePlot.getWMargin() + subPlotId * (wSubPlot + linePlot.getWMargin());
            int y0 = linePlot.getHMarginTop();
            drawSubPlot(subPlot, x0, y0, g2d);
            subPlotId++;
        }
    }

    private void drawSubPlot(SubPlot subPlot, int x0, int y0, Graphics2D g2d) {
        ScaleLinear xScale = xScaleSetter.setScale(linePlot,subPlot,x0,y0);
        ScaleLinear yScale = yScaleSetter.setScale(linePlot,subPlot,x0,y0);
        int wSubPlot = xScaleSetter.getWeightSubPlot(linePlot);
        plotLines(subPlot, g2d, xScale, yScale);
        drawPlotBorder(x0, g2d, wSubPlot);
        textLabels(subPlot, x0, g2d, xScale, yScale, wSubPlot);
        textLineLegends(subPlot, x0, g2d);
    }

    private void textLineLegends(SubPlot subPlot, int x0, Graphics2D g2d) {
        int i = 1;
        int fontSize = g2d.getFont().getSize();
        for (LineData lineData : subPlot.getLines()) {
            g2d.setColor(lineData.getColor());
            g2d.drawString(lineData.getName(), x0, fontSize * i);
            i++;
        }
    }

    private void textLabels(SubPlot subPlot, int x0, Graphics2D g2d, ScaleLinear xScale, ScaleLinear yScale, int wSubPlot) {
        int fontSize = g2d.getFont().getSize();
        g2d.drawString(subPlot.getXAxisName(), x0 + wSubPlot / 2, linePlot.getYBottom() + fontSize);
        g2d.drawString(subPlot.getYAxisName(), x0 - linePlot.getWMargin() / 2, linePlot.getYTop() - fontSize);
        g2d.drawString(subPlot.getName(), x0 + wSubPlot / 2, linePlot.getYTop() - fontSize);
        g2d.drawString(String.format(linePlot.getFORMAT_AXIS_NUM(), xScale.getD0()), x0, linePlot.getYBottom() + fontSize);
        g2d.drawString(String.format(linePlot.getFORMAT_AXIS_NUM(), xScale.getD1()), x0 + wSubPlot, linePlot.getYBottom() + fontSize);
        g2d.drawString(String.format(linePlot.getFORMAT_AXIS_NUM(), yScale.getD0()), x0 - linePlot.getWMargin() / 2, linePlot.getYBottom());
        g2d.drawString(String.format(linePlot.getFORMAT_AXIS_NUM(), yScale.getD1()), x0 - linePlot.getWMargin() / 2, linePlot.getYTop() + fontSize);
    }

    private void drawPlotBorder(int x0, Graphics2D g2d, int wSubPlot) {
        g2d.setColor(Color.black);
        g2d.drawLine(x0, linePlot.getYBottom(), x0 + wSubPlot, linePlot.getYBottom());
        g2d.drawLine(x0, linePlot.getYTop(), x0 + wSubPlot, linePlot.getYTop());
        g2d.drawLine(x0, linePlot.getYBottom(), x0, linePlot.getYTop());
        g2d.drawLine(x0 + wSubPlot, linePlot.getYBottom(), x0 + wSubPlot, linePlot.getYTop());
    }

    private void plotLines(SubPlot subPlot, Graphics2D g2d, ScaleLinear xScale, ScaleLinear yScale) {
        for (LineData lineData : subPlot.getLines()) {
            double[] line1x = lineData.xData.stream().mapToDouble(d -> d).toArray();
            double[] line1y = lineData.yData.stream().mapToDouble(d -> d).toArray();
            g2d.setColor(lineData.getColor());
            g2d.drawPolyline(xScale.calcOut(line1x), yScale.calcOut(line1y), line1x.length);
        }
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);  //cleans the screen
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        drawPlot(g2d);

    }
}
