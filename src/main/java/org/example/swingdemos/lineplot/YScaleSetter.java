package org.example.swingdemos.lineplot;

import java.util.DoubleSummaryStatistics;

public class YScaleSetter implements ScaleSetter{

    @Override
    public ScaleLinear setScale(LinePlotModel linePlotModel, SubPlotModel subPlotModel, int x0, int y0) {
        int hSubPlot = getHeightSubPlot(linePlotModel,1);  //only one plot in y-direction
        double[] yMinMax = initMinMax();
        if (subPlotModel.getXMinMax().size() == 2) {
            yMinMax[0] = subPlotModel.getYMinMax().get(0);
            yMinMax[1] = subPlotModel.getYMinMax().get(1);
        } else {
            for (LineDataModel lineDataModel : subPlotModel.getLines()) {
                DoubleSummaryStatistics stats = lineDataModel.getYData().stream().mapToDouble(a -> a).summaryStatistics();
                updateMinMaxFromStatistics(yMinMax, stats);
            }
        }
        return new ScaleLinear(yMinMax[0], yMinMax[1], y0 + hSubPlot, y0);
    }
}
