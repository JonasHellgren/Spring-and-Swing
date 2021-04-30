package org.example.swingdemos.lineplotmodel;

import org.example.swingdemos.lineplot.LinePlot;
import org.example.swingdemos.lineplot.ScaleLinear;
import org.example.swingdemos.lineplot.SubPlot;

import java.util.DoubleSummaryStatistics;

public interface ScaleSetter {
    ScaleLinear setScale(LinePlot linePlot, SubPlot subPlot, int x0, int y0);

    default  int getWeightSubPlot(LinePlot linePlot) {
        //w=2*getW_MARGIN()+nofSubplots*wSubPlot+W_MARGIN*(nofSubplots-1)
        int nofSubplotsX= linePlot.getSubPlots().size();
        int wSubPlot = (linePlot.getWeight() - linePlot.getWMargin() * (2 + nofSubplotsX - 1)) / nofSubplotsX;
        return wSubPlot;
    }

    default int getHeightSubPlot(LinePlot linePlot, int nofSubplotsY) {
        //h=2*H_MARGIN+H_MARGIN_TOP+H_MARGIN_BOTTOM
        int hSubPlot = (linePlot.getHeight() - (linePlot.getHMarginTop() + linePlot.getHMarginBottom())) / nofSubplotsY;
        return hSubPlot;
    }


    default  double[] updateMinMaxFromStatistics(double[] minMax, DoubleSummaryStatistics stats) {
        minMax[0] = Math.min(minMax[0], stats.getMin());
        minMax[1] = Math.max(minMax[1], stats.getMax());
        return minMax;
    }

    default double[] initMinMax() {
        double[] minMax = {Double.MAX_VALUE, Double.MIN_VALUE};
        return minMax;
    }

}
