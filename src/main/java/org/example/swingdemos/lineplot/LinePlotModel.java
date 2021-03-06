package org.example.swingdemos.lineplot;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Getter
@Setter
public class LinePlotModel {

    private static final Logger logger = Logger.getLogger( LinePlotModel.class.getName() );
    private int weight =1000;
    private int height =300;  //frame size
    private int wMargin = 100;
    private int hMarginTop = 50;
    private int hMarginBottom = 75;
    private int yBottom = height - hMarginBottom;
    private int yTop = hMarginTop;
    private String FORMAT_AXIS_NUM="%.2f";

    private List<SubPlotModel> subPlotModels =new ArrayList<>();

    public LinePlotModel() {
        logger.info("plot data object created");
    }

    public void addSubPlot(SubPlotModel subPlotModel) {
        logger.info("sub plot added");
        subPlotModels.add(subPlotModel);
    }

    public List<SubPlotModel> getSubPlotModels() {
        return subPlotModels;
    }

    static public List<Double> createLinearList(int nofNum, double rangeMin, double rangeMax)  {
        List<Double> numList=new ArrayList<>();
        if (nofNum==1)
            numList.add(rangeMin);
        else {
            for (int i = 0; i < nofNum; i++) {
                Double value = rangeMin + (rangeMax - rangeMin) * i / (nofNum - 1);
                numList.add(value);
            }
        }
        return numList;
    };

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("Number of sub plots:"+ subPlotModels.size());
        sb.append(System.getProperty("line.separator"));
        for (SubPlotModel subPlotModel : subPlotModels) {
            sb.append(subPlotModel.toString());
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }


}
