package org.example.swingdemos.lineplot;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class LineData {

    String name="";
    List<Double> xData;
    List<Double> yData;
    Color color=Color.BLACK;

    public LineData(String name,List<Double> yData,Color color) {
        this.color = color;
        this.name = name;
        this.xData = LinePlot.createLinearList(yData.size(),1,yData.size());
        this.yData = yData;
    }

    public LineData(List<Double> yData) {
        this.xData = LinePlot.createLinearList(yData.size(),1,yData.size());
        this.yData = yData;
    }

    public LineData(List<Double> xData, List<Double> yData) {
        this.xData = xData;
        this.yData = yData;
    }

    public LineData(String name, List<Double> xData, List<Double> yData,Color color) {
        this.color = color;
        this.name = name;
        this.xData = xData;
        this.yData = yData;
    }



}
