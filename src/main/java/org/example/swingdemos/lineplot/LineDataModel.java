package org.example.swingdemos.lineplot;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.awt.*;
import java.util.List;

@Getter
@Setter
@ToString
public class LineDataModel {

    String name;
    List<Double> xData;
    List<Double> yData;
    Color color;

    final String  DEFAULT_NAME="";
    final Color  DEFAULT_COLOR=Color.BLACK;

    public LineDataModel(String name, List<Double> yData, Color color) {
        this(name, LinePlotModel.createLinearList(yData.size(),1,yData.size()),
                yData,color);
    }

    public LineDataModel(List<Double> yData) {
        this("", LinePlotModel.createLinearList(yData.size(),1,yData.size()),
                yData,Color.BLACK);
        this.name=DEFAULT_NAME;  this.color=DEFAULT_COLOR;
    }

    public LineDataModel(List<Double> xData, List<Double> yData) {
        this("",xData, yData,Color.BLACK);
        this.name=DEFAULT_NAME;  this.color=DEFAULT_COLOR;
    }

    public LineDataModel(String name, List<Double> xData, List<Double> yData, Color color) {
        this.color = color;
        this.name = name;
        this.xData = xData;
        this.yData = yData;
    }



}
