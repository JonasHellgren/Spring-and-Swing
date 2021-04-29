package org.example.swingdemos.lineplot;

import javax.swing.*;
import java.awt.*;
import java.util.DoubleSummaryStatistics;
//import java.util.LinkedList;

/**
 Multiple subplots can only be located in x-direction, in the horizontal plane

 The lower left corner of a subplot is given by (x0,y0+hSubPlot)
 The upper left corner of a subplot is given by (x0,y0)
 In Java AWT y increases downwards a panel, x increases "as expected" in right direction

 */


public class PanelLinePlot extends JPanel {
    PlotData plotData;
    int nofSubplots;

   public void setData(PlotData plotData) {
       this.plotData=plotData;
       nofSubplots=plotData.getSubPlots().size();
    }

    private void drawPlot(Graphics2D g2d)  {
        int wSubPlot = getWeightSubPlot(nofSubplots);
        int subPlotId=0;
        for (SubPlotData subPlot:plotData.getSubPlots()) {
            int x0=plotData.getW_MARGIN()+subPlotId*(wSubPlot+plotData.getW_MARGIN());
            int y0=plotData.getH_MARGIN_TOP();

            drawSubPlot(subPlot,x0,y0,g2d);
            subPlotId++;
        }
    }

    private int getWeightSubPlot(int nofSubplotsX) {
        //w=2*getW_MARGIN()+nofSubplots*wSubPlot+W_MARGIN*(nofSubplots-1)
          int wSubPlot=(plotData.getW()-plotData.getW_MARGIN()*(2+nofSubplotsX-1))/nofSubplotsX;
        return wSubPlot;
    }

    private int getHeightSubPlot(int nofSubplotsY) {
        //h=2*H_MARGIN+H_MARGIN_TOP+H_MARGIN_BOTTOM
        int hSubPlot=(plotData.getH()-(plotData.getH_MARGIN_TOP()+plotData.getH_MARGIN_BOTTOM()))/nofSubplotsY;
        return hSubPlot;
    }

    private void drawSubPlot(SubPlotData subPlot, int x0, int y0, Graphics2D g2d) {

        ScaleLinear xScale = getXScale(subPlot, x0);
        ScaleLinear yScale = getYScale(subPlot, y0);
        int wSubPlot = getWeightSubPlot(nofSubplots);

        for (LineData lineData : subPlot.getLines()) {
            double[] line1x = lineData.xData.stream().mapToDouble(d -> d).toArray();
            double[] line1y = lineData.yData.stream().mapToDouble(d -> d).toArray();
            g2d.setColor(lineData.getColor());
            g2d.drawPolyline(xScale.calcOut(line1x), yScale.calcOut(line1y), line1x.length);
        }

        g2d.setColor(Color.black);
        g2d.drawLine(x0, plotData.getY_BOTTOM(), x0 + wSubPlot, plotData.getY_BOTTOM());
        g2d.drawLine(x0, plotData.getY_TOP(), x0 + wSubPlot, plotData.getY_TOP());
        g2d.drawLine(x0, plotData.getY_BOTTOM(), x0, plotData.getY_TOP());
        g2d.drawLine(x0 + wSubPlot, plotData.getY_BOTTOM(), x0 + wSubPlot, plotData.getY_TOP());

        int fontSize = g2d.getFont().getSize();
        g2d.drawString(subPlot.getXAxisName(), x0 + wSubPlot / 2, plotData.getY_BOTTOM() + fontSize);
        g2d.drawString(subPlot.getYAxisName(), x0 - plotData.getW_MARGIN()/2, plotData.getY_TOP() - fontSize);

        g2d.drawString(subPlot.getName(), x0+ wSubPlot / 2, plotData.getY_TOP() - fontSize);
        g2d.drawString(String.format(plotData.getFORMAT_AXIS_NUM(),xScale.getD0()), x0, plotData.getY_BOTTOM() + fontSize);
        g2d.drawString(String.format(plotData.getFORMAT_AXIS_NUM(),xScale.getD1()), x0 + wSubPlot , plotData.getY_BOTTOM() + fontSize);
        g2d.drawString(String.format(plotData.getFORMAT_AXIS_NUM(),yScale.getD0()), x0 - plotData.getW_MARGIN()/2, plotData.getY_BOTTOM());
        g2d.drawString(String.format(plotData.getFORMAT_AXIS_NUM(),yScale.getD1()), x0 - plotData.getW_MARGIN()/2, plotData.getY_TOP()+ fontSize);

        int i=1;
        for (LineData lineData : subPlot.getLines()) {
            g2d.setColor(lineData.getColor());
            g2d.drawString(lineData.getName(), x0, fontSize*i);
            i++;
        }

    }

    private ScaleLinear getXScale(SubPlotData subPlot,int x0) {
        int wSubPlot = getWeightSubPlot(nofSubplots);
        Double xMin=Double.MAX_VALUE, xMax=Double.MIN_VALUE;
        if (subPlot.getXMinMax().size() == 2)  {
            xMin=subPlot.getXMinMax().get(0);   xMax=subPlot.getXMinMax().get(1);
        } else {
            for (LineData lineData:subPlot.getLines()) {
                DoubleSummaryStatistics statsX = lineData.xData.stream().mapToDouble(a -> a).summaryStatistics();
                xMin = Math.min(xMin,statsX.getMin());
                xMax = Math.max(xMax,statsX.getMax());
            }
        }
        return new ScaleLinear(xMin, xMax,x0, x0+wSubPlot);
    }

    private ScaleLinear getYScale(SubPlotData subPlot,int y0) {
        int hSubPlot = getHeightSubPlot(1);  //only one plot in y-direction
        Double yMin = Double.MAX_VALUE, yMax = Double.MIN_VALUE;
        if (subPlot.getYMinMax().size() == 2) {
            yMin = subPlot.getYMinMax().get(0);
            yMax = subPlot.getYMinMax().get(1);
        } else {
            for (LineData lineData : subPlot.getLines()) {
                DoubleSummaryStatistics statsY = lineData.yData.stream().mapToDouble(a -> a).summaryStatistics();
                yMin = Math.min(yMin, statsY.getMin());
                yMax = Math.max(yMax, statsY.getMax());
            }
        }

        return new ScaleLinear(yMin, yMax, y0+hSubPlot, y0);
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
