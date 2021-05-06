package org.example.swingdemos.lineplot;

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
    LinePlotModel linePlotModel;
    int nofSubplots;

    private ScaleSetter xScaleSetter=new XScaleSetter();
    private ScaleSetter yScaleSetter=new YScaleSetter();

    public void setData(LinePlotModel linePlotModel) {
        this.linePlotModel = linePlotModel;
        nofSubplots = linePlotModel.getSubPlotModels().size();
    }

    public void drawPlot(Graphics2D g2d) {
        int wSubPlot = xScaleSetter.getWeightSubPlot(linePlotModel);
        int subPlotId = 0;
        for (SubPlotModel subPlotModel : linePlotModel.getSubPlotModels()) {
            int x0 = linePlotModel.getWMargin() + subPlotId * (wSubPlot + linePlotModel.getWMargin());
            int y0 = linePlotModel.getHMarginTop();
            drawSubPlot(subPlotModel, x0, y0, g2d);
            subPlotId++;
        }
    }

    private void drawSubPlot(SubPlotModel subPlotModel, int x0, int y0, Graphics2D g2d) {
        ScaleLinear xScale = xScaleSetter.setScale(linePlotModel, subPlotModel,x0,y0);
        ScaleLinear yScale = yScaleSetter.setScale(linePlotModel, subPlotModel,x0,y0);
        int wSubPlot = xScaleSetter.getWeightSubPlot(linePlotModel);
        plotLines(subPlotModel, g2d, xScale, yScale);
        drawPlotBorder(x0, g2d, wSubPlot);
        textLabels(subPlotModel, x0, g2d, xScale, yScale, wSubPlot);
        textLineLegends(subPlotModel, x0, g2d);
    }

    private void textLineLegends(SubPlotModel subPlotModel, int x0, Graphics2D g2d) {
        int i = 1;
        int fontSize = g2d.getFont().getSize();
        for (LineDataModel lineDataModel : subPlotModel.getLines()) {
            g2d.setColor(lineDataModel.getColor());
            g2d.drawString(lineDataModel.getName(), x0, fontSize * i);
            i++;
        }
    }

    private void textLabels(SubPlotModel subPlotModel, int x0, Graphics2D g2d, ScaleLinear xScale, ScaleLinear yScale, int wSubPlot) {
        int fontSize = g2d.getFont().getSize();
        g2d.drawString(subPlotModel.getXAxisName(), x0 + wSubPlot / 2, linePlotModel.getYBottom() + fontSize);
        g2d.drawString(subPlotModel.getYAxisName(), x0 - linePlotModel.getWMargin() / 2, linePlotModel.getYTop() - fontSize);
        g2d.drawString(subPlotModel.getName(), x0 + wSubPlot / 2, linePlotModel.getYTop() - fontSize);
        g2d.drawString(String.format(linePlotModel.getFORMAT_AXIS_NUM(), xScale.getD0()), x0, linePlotModel.getYBottom() + fontSize);
        g2d.drawString(String.format(linePlotModel.getFORMAT_AXIS_NUM(), xScale.getD1()), x0 + wSubPlot, linePlotModel.getYBottom() + fontSize);
        g2d.drawString(String.format(linePlotModel.getFORMAT_AXIS_NUM(), yScale.getD0()), x0 - linePlotModel.getWMargin() / 2, linePlotModel.getYBottom());
        g2d.drawString(String.format(linePlotModel.getFORMAT_AXIS_NUM(), yScale.getD1()), x0 - linePlotModel.getWMargin() / 2, linePlotModel.getYTop() + fontSize);
    }

    private void drawPlotBorder(int x0, Graphics2D g2d, int wSubPlot) {
        g2d.setColor(Color.black);
        g2d.drawLine(x0, linePlotModel.getYBottom(), x0 + wSubPlot, linePlotModel.getYBottom());
        g2d.drawLine(x0, linePlotModel.getYTop(), x0 + wSubPlot, linePlotModel.getYTop());
        g2d.drawLine(x0, linePlotModel.getYBottom(), x0, linePlotModel.getYTop());
        g2d.drawLine(x0 + wSubPlot, linePlotModel.getYBottom(), x0 + wSubPlot, linePlotModel.getYTop());
    }

    private void plotLines(SubPlotModel subPlotModel, Graphics2D g2d, ScaleLinear xScale, ScaleLinear yScale) {
        for (LineDataModel lineDataModel : subPlotModel.getLines()) {
            double[] line1x = lineDataModel.xData.stream().mapToDouble(d -> d).toArray();
            double[] line1y = lineDataModel.yData.stream().mapToDouble(d -> d).toArray();
            g2d.setColor(lineDataModel.getColor());
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
