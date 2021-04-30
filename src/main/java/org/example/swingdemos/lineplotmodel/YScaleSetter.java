package org.example.swingdemos.lineplotmodel;

import org.example.swingdemos.lineplot.LineData;
import org.example.swingdemos.lineplot.LinePlot;
import org.example.swingdemos.lineplot.ScaleLinear;
import org.example.swingdemos.lineplot.SubPlot;

import java.util.DoubleSummaryStatistics;

public class YScaleSetter implements ScaleSetter{

    @Override
    public ScaleLinear setScale(LinePlot linePlot, SubPlot subPlot, int x0, int y0) {
        int hSubPlot = getHeightSubPlot(linePlot,1);  //only one plot in y-direction
        double[] yMinMax = initMinMax();
        if (subPlot.getXMinMax().size() == 2) {
            yMinMax[0] = subPlot.getYMinMax().get(0);
            yMinMax[1] = subPlot.getYMinMax().get(1);
        } else {
            for (LineData lineData : subPlot.getLines()) {
                DoubleSummaryStatistics stats = lineData.getYData().stream().mapToDouble(a -> a).summaryStatistics();
                updateMinMaxFromStatistics(yMinMax, stats);
            }
        }
        return new ScaleLinear(yMinMax[0], yMinMax[1], y0 + hSubPlot, y0);
    }

}
