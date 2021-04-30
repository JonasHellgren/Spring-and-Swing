package org.example.swingdemos.lineplot;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LineDataSetter {

    static public LinePlot createPlotDataTwoSubPlots () {
        LinePlot linePlot =new LinePlot();
        LineData line1=new LineData("A", Arrays.asList(1.0,2.0,3.0,4.0),Arrays.asList(10d,20d,20d,20d), Color.blue);
        LineData line2=new LineData("B", Arrays.asList(1.0,2.0,3.0,4.0),Arrays.asList(40d,60d,60d,80d), Color.green);
        SubPlot subplotA=new SubPlot("spA","x-axis","y-axis",Arrays.asList(0d,5d),Arrays.asList(0d,150d));
        subplotA.addLine(line1);  subplotA.addLine(line2);
        linePlot.addSubPlot(subplotA);
        SubPlot subplotB=new SubPlot("spB");
        subplotB.addLine(line1);  subplotB.addLine(line2);
        linePlot.addSubPlot(subplotB);
        return linePlot;
    }

     static public LinePlot createPlotDataRandomOneSubplot () {
         LinePlot linePlot =new LinePlot();
         int nofNum=100;
         double rangeMin=0; double  rangeMax=10;
         LineData line1=new LineData("A", LinePlot.createLinearList(nofNum, 0,  nofNum),createListWithRandomNumber(nofNum, rangeMin,  rangeMax), Color.blue);
         LineData line2=new LineData("B", LinePlot.createLinearList(nofNum, 0,  nofNum),createListWithRandomNumber(nofNum, rangeMin,  rangeMax), Color.green);
         SubPlot subplotA=new SubPlot("spA","x-axis","y-axis");
         subplotA.addLine(line1);  subplotA.addLine(line2);
         linePlot.addSubPlot(subplotA);
         return linePlot;
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
