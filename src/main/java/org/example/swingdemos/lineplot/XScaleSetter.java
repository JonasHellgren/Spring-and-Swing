package org.example.swingdemos.lineplot;

import java.util.DoubleSummaryStatistics;

public class XScaleSetter implements ScaleSetter {

    public XScaleSetter() {
    }

    @Override
    public ScaleLinear setScale(LinePlotModel linePlotModel, SubPlotModel subPlotModel, int x0, int y0) {
        int wSubPlot = getWeightSubPlot(linePlotModel);
        double[] xMinMax = initMinMax();
        if (subPlotModel.getXMinMax().size() == 2) {
            xMinMax[0] = subPlotModel.getXMinMax().get(0);
            xMinMax[1] = subPlotModel.getXMinMax().get(1);
        } else {
            for (LineDataModel lineDataModel : subPlotModel.getLines()) {
                DoubleSummaryStatistics stats = lineDataModel.getXData().stream().mapToDouble(a -> a).summaryStatistics();
                updateMinMaxFromStatistics(xMinMax, stats);
            }
        }
        return new ScaleLinear(xMinMax[0], xMinMax[1], x0, x0 + wSubPlot);
    }

}
