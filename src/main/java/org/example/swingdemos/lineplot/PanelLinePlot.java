package org.example.swingdemos.lineplot;

import javax.swing.*;
import java.awt.*;
import java.util.DoubleSummaryStatistics;
//import java.util.LinkedList;

/**
 * Multiple subplots can only be located in x-direction, in the horizontal plane
 * <p>
 * The lower left corner of a subplot is given by (x0,y0+hSubPlot)
 * The upper left corner of a subplot is given by (x0,y0)
 * In Java AWT y increases downwards a panel, x increases "as expected" in right direction
 */


public class PanelLinePlot extends JPanel {
    PlotData plotData;
    int nofSubplots;

    public void setData(PlotData plotData) {
        this.plotData = plotData;
        nofSubplots = plotData.getSubPlots().size();
    }

    public void drawPlot(Graphics2D g2d) {
        int wSubPlot = getWeightSubPlot(nofSubplots);
        int subPlotId = 0;
        for (SubPlot subPlot : plotData.getSubPlots()) {
            int x0 = plotData.getW_MARGIN() + subPlotId * (wSubPlot + plotData.getW_MARGIN());
            int y0 = plotData.getH_MARGIN_TOP();

            drawSubPlot(subPlot, x0, y0, g2d);
            subPlotId++;
        }
    }

    private int getWeightSubPlot(int nofSubplotsX) {
        //w=2*getW_MARGIN()+nofSubplots*wSubPlot+W_MARGIN*(nofSubplots-1)
        int wSubPlot = (plotData.getW() - plotData.getW_MARGIN() * (2 + nofSubplotsX - 1)) / nofSubplotsX;
        return wSubPlot;
    }

    private int getHeightSubPlot(int nofSubplotsY) {
        //h=2*H_MARGIN+H_MARGIN_TOP+H_MARGIN_BOTTOM
        int hSubPlot = (plotData.getH() - (plotData.getH_MARGIN_TOP() + plotData.getH_MARGIN_BOTTOM())) / nofSubplotsY;
        return hSubPlot;
    }

    private void drawSubPlot(SubPlot subPlot, int x0, int y0, Graphics2D g2d) {
        ScaleLinear xScale = getScale(subPlot, x0,y0,true);
        ScaleLinear yScale = getScale(subPlot, x0,y0,false);
        int wSubPlot = getWeightSubPlot(nofSubplots);
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
        g2d.drawString(subPlot.getXAxisName(), x0 + wSubPlot / 2, plotData.getY_BOTTOM() + fontSize);
        g2d.drawString(subPlot.getYAxisName(), x0 - plotData.getW_MARGIN() / 2, plotData.getY_TOP() - fontSize);
        g2d.drawString(subPlot.getName(), x0 + wSubPlot / 2, plotData.getY_TOP() - fontSize);
        g2d.drawString(String.format(plotData.getFORMAT_AXIS_NUM(), xScale.getD0()), x0, plotData.getY_BOTTOM() + fontSize);
        g2d.drawString(String.format(plotData.getFORMAT_AXIS_NUM(), xScale.getD1()), x0 + wSubPlot, plotData.getY_BOTTOM() + fontSize);
        g2d.drawString(String.format(plotData.getFORMAT_AXIS_NUM(), yScale.getD0()), x0 - plotData.getW_MARGIN() / 2, plotData.getY_BOTTOM());
        g2d.drawString(String.format(plotData.getFORMAT_AXIS_NUM(), yScale.getD1()), x0 - plotData.getW_MARGIN() / 2, plotData.getY_TOP() + fontSize);
    }

    private void drawPlotBorder(int x0, Graphics2D g2d, int wSubPlot) {
        g2d.setColor(Color.black);
        g2d.drawLine(x0, plotData.getY_BOTTOM(), x0 + wSubPlot, plotData.getY_BOTTOM());
        g2d.drawLine(x0, plotData.getY_TOP(), x0 + wSubPlot, plotData.getY_TOP());
        g2d.drawLine(x0, plotData.getY_BOTTOM(), x0, plotData.getY_TOP());
        g2d.drawLine(x0 + wSubPlot, plotData.getY_BOTTOM(), x0 + wSubPlot, plotData.getY_TOP());
    }

    private void plotLines(SubPlot subPlot, Graphics2D g2d, ScaleLinear xScale, ScaleLinear yScale) {
        for (LineData lineData : subPlot.getLines()) {
            double[] line1x = lineData.xData.stream().mapToDouble(d -> d).toArray();
            double[] line1y = lineData.yData.stream().mapToDouble(d -> d).toArray();
            g2d.setColor(lineData.getColor());
            g2d.drawPolyline(xScale.calcOut(line1x), yScale.calcOut(line1y), line1x.length);
        }
    }

    private ScaleLinear getScale(SubPlot subPlot, int x0, int y0, boolean isXdata) {
        int wSubPlot = getWeightSubPlot(nofSubplots);
        int hSubPlot = getHeightSubPlot(1);  //only one plot in y-direction
        double[] xMinMax = {Double.MAX_VALUE, Double.MIN_VALUE};

        if (subPlot.getXMinMax().size() == 2) {
            if (isXdata) {
                xMinMax[0] = subPlot.getXMinMax().get(0);
                xMinMax[1] = subPlot.getXMinMax().get(1);
            } else {
                xMinMax[0] = subPlot.getYMinMax().get(0);
                xMinMax[1] = subPlot.getYMinMax().get(1);
            }
        } else {
            xMinMax = setMinMax(subPlot, xMinMax, isXdata);
        }
        if (isXdata)
            return new ScaleLinear(xMinMax[0], xMinMax[1], x0, x0 + wSubPlot);
        else
            return new ScaleLinear(xMinMax[0], xMinMax[1], y0 + hSubPlot, y0);
    }


    private double[] setMinMax(SubPlot subPlot, double[] MinMax, boolean isXdata) {
        DoubleSummaryStatistics stats;
        for (LineData lineData : subPlot.getLines()) {
            if (isXdata)
                stats = lineData.xData.stream().mapToDouble(a -> a).summaryStatistics();
            else
                stats = lineData.yData.stream().mapToDouble(a -> a).summaryStatistics();

            MinMax[0] = Math.min(MinMax[0], stats.getMin());
            MinMax[1] = Math.max(MinMax[1], stats.getMax());
        }
        return MinMax;
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
