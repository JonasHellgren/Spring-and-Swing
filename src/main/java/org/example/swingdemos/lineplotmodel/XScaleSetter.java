package org.example.swingdemos.lineplotmodel;

import org.example.swingdemos.lineplot.LineData;
import org.example.swingdemos.lineplot.LinePlot;
import org.example.swingdemos.lineplot.ScaleLinear;
import org.example.swingdemos.lineplot.SubPlot;

import java.util.DoubleSummaryStatistics;

public class XScaleSetter implements ScaleSetter {

    public XScaleSetter() {
    }

    @Override
    public ScaleLinear setScale(LinePlot linePlot, SubPlot subPlot, int x0, int y0) {
        int wSubPlot = getWeightSubPlot(linePlot);
        double[] xMinMax = initMinMax();
        if (subPlot.getXMinMax().size() == 2) {
            xMinMax[0] = subPlot.getXMinMax().get(0);
            xMinMax[1] = subPlot.getXMinMax().get(1);
        } else {
            for (LineData lineData : subPlot.getLines()) {
                DoubleSummaryStatistics stats = lineData.getXData().stream().mapToDouble(a -> a).summaryStatistics();
                updateMinMaxFromStatistics(xMinMax, stats);
            }
        }
        return new ScaleLinear(xMinMax[0], xMinMax[1], x0, x0 + wSubPlot);
    }

}
