package org.example.swingdemos.lineplot;

import lombok.Getter;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class LineData {

    String name="";
    List<Double> xData;
    List<Double> yData;
    Color color=Color.BLACK;

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
