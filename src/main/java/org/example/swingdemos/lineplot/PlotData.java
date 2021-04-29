package org.example.swingdemos.lineplot;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Getter
@Setter
public class PlotData {

    private static final Logger logger = Logger.getLogger( PlotData.class.getName() );
    private int W=1000;
    private int H=300;  //frame size
    private int W_MARGIN = 100;
    private int H_MARGIN_TOP = 50;
    private int H_MARGIN_BOTTOM = 75;
    private int Y_BOTTOM = H-H_MARGIN_BOTTOM;
    private int Y_TOP = H_MARGIN_TOP;
    private String FORMAT_AXIS_NUM="%.2f";

    private List<SubPlotData> subPlots =new ArrayList<>();

    public PlotData() {
        logger.info("plot data object created");
    }

    public void addSubPlot(SubPlotData subPlot) {
        logger.info("sub plot added");
        subPlots.add(subPlot);
    }

    public List<SubPlotData> getSubPlots() {
        return subPlots;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("Number of sub plots:"+subPlots.size());
        sb.append(System.getProperty("line.separator"));
        for (SubPlotData subPlot:subPlots) {
            sb.append(subPlot.toString());
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }


}
