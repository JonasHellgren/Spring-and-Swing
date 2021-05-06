package org.example.swingdemos.runplots;

import org.example.swingdemos.lineplot.LineDataModel;
import org.example.swingdemos.lineplot.LinePlotModel;
import org.example.swingdemos.lineplot.SubPlotModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LineDataSetter {

    static public LinePlotModel createPlotDataTwoSubPlots () {
        LinePlotModel linePlotModel =new LinePlotModel();
        LineDataModel line1=new LineDataModel("A", Arrays.asList(1.0,2.0,3.0,4.0),Arrays.asList(10d,20d,20d,20d), Color.blue);
        LineDataModel line2=new LineDataModel("B", Arrays.asList(1.0,2.0,3.0,4.0),Arrays.asList(40d,60d,60d,80d), Color.green);
        SubPlotModel subplotA=new SubPlotModel("spA","x-axis","y-axis",Arrays.asList(0d,5d),Arrays.asList(0d,150d));
        subplotA.addLine(line1);  subplotA.addLine(line2);
        linePlotModel.addSubPlot(subplotA);
        SubPlotModel subplotB=new SubPlotModel("spB");
        subplotB.addLine(line1);  subplotB.addLine(line2);
        linePlotModel.addSubPlot(subplotB);
        return linePlotModel;
    }

     static public LinePlotModel createPlotDataRandomOneSubplot () {
         LinePlotModel linePlotModel =new LinePlotModel();
         int nofNum=100;
         double rangeMin=0; double  rangeMax=10;
         LineDataModel line1=new LineDataModel("A", LinePlotModel.createLinearList(nofNum, 0,  nofNum),createListWithRandomNumber(nofNum, rangeMin,  rangeMax), Color.blue);
         LineDataModel line2=new LineDataModel("B", LinePlotModel.createLinearList(nofNum, 0,  nofNum),createListWithRandomNumber(nofNum, rangeMin,  rangeMax), Color.green);
         SubPlotModel subplotA=new SubPlotModel("spA","x-axis","y-axis");
         subplotA.addLine(line1);  subplotA.addLine(line2);
         linePlotModel.addSubPlot(subplotA);
         return linePlotModel;
     }

    static public List<Double> createListWithRandomNumber(int nofNum, double rangeMin, double rangeMax)  {
        List<Double> numList=new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < nofNum; i++) {
            double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
            numList.add(randomValue);
        }
    return numList;
    };




}
