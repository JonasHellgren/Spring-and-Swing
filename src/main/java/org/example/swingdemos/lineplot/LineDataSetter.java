package org.example.swingdemos.lineplot;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LineDataSetter {



    static public PlotData createPlotDataTwoSubPlots () {
        PlotData plotData=new PlotData();
        LineData line1=new LineData("A", Arrays.asList(1.0,2.0,3.0,4.0),Arrays.asList(10d,20d,20d,20d), Color.blue);
        LineData line2=new LineData("B", Arrays.asList(1.0,2.0,3.0,4.0),Arrays.asList(40d,60d,60d,80d), Color.green);
        SubPlotData subplotA=new SubPlotData("spA","x-axis","y-axis",Arrays.asList(0d,5d),Arrays.asList(0d,150d));
        subplotA.addLine(line1);  subplotA.addLine(line2);
        plotData.addSubPlot(subplotA);
        SubPlotData subplotB=new SubPlotData("spB");
        subplotB.addLine(line1);  subplotB.addLine(line2);
        plotData.addSubPlot(subplotB);
        return plotData;
    }

     static public PlotData createPlotDataRandomOneSubplot () {
         PlotData plotData=new PlotData();
         int nofNum=100;
         double rangeMin=0; double  rangeMax=10;
         LineData line1=new LineData("A", createListWithLinearNumbers(nofNum, 0,  nofNum),createListWithRandomNumber(nofNum, rangeMin,  rangeMax), Color.blue);
         LineData line2=new LineData("B", createListWithLinearNumbers(nofNum, 0,  nofNum),createListWithRandomNumber(nofNum, rangeMin,  rangeMax), Color.green);
         SubPlotData subplotA=new SubPlotData("spA","x-axis","y-axis");
         subplotA.addLine(line1);  subplotA.addLine(line2);
         plotData.addSubPlot(subplotA);
         return plotData;
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

    static public List<Double> createListWithLinearNumbers(int nofNum, double rangeMin, double rangeMax)  {
        List<Double> numList=new ArrayList<>();
        for (int i = 0; i < nofNum; i++) {
            Double value = rangeMin + (rangeMax - rangeMin) * i/nofNum;
            numList.add(value);
        }
        return numList;
    };




}
