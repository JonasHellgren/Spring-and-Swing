package org.example.swingdemos.lineplot;

import org.example.swingdemos.lineplot.LinePlotModel;
import org.example.swingdemos.lineplot.ScaleLinear;
import org.example.swingdemos.lineplot.SubPlotModel;

import java.util.DoubleSummaryStatistics;

public interface ScaleSetter {
    ScaleLinear setScale(LinePlotModel linePlotModel, SubPlotModel subPlotModel, int x0, int y0);

    default  int getWeightSubPlot(LinePlotModel linePlotModel) {
        //w=2*getW_MARGIN()+nofSubplots*wSubPlot+W_MARGIN*(nofSubplots-1)
        int nofSubplotsX= linePlotModel.getSubPlotModels().size();
        int wSubPlot = (linePlotModel.getWeight() - linePlotModel.getWMargin() * (2 + nofSubplotsX - 1)) / nofSubplotsX;
        return wSubPlot;
    }

    default int getHeightSubPlot(LinePlotModel linePlotModel, int nofSubplotsY) {
        //h=2*H_MARGIN+H_MARGIN_TOP+H_MARGIN_BOTTOM
        int hSubPlot = (linePlotModel.getHeight() - (linePlotModel.getHMarginTop() + linePlotModel.getHMarginBottom())) / nofSubplotsY;
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
