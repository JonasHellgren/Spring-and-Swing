package org.example.swingdemos.lineplot;

import lombok.Getter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Getter
public class SubPlotModel {
    private static final Logger logger = Logger.getLogger( SubPlotModel.class.getName() );

    String name="";
    String xAxisName="";
    String yAxisName="";
    List<Double> xMinMax;
    List<Double> yMinMax;
    private List<LineDataModel> lines =new ArrayList<>();

    public SubPlotModel(String name) {
        this(name,"","",new ArrayList<>(),new ArrayList<>());
    }

    public SubPlotModel(String name, String xAxisName, String yAxisName) {
        this(name,xAxisName,yAxisName,new ArrayList<>(),new ArrayList<>());
    }

    public SubPlotModel(String name, String xAxisName, String yAxisName, List<Double> xMinMax, List<Double> yMinMax) {
        this.name = name;
        this.xAxisName = xAxisName;
        this.yAxisName = yAxisName;
        this.xMinMax = xMinMax;
        this.yMinMax = yMinMax;
    }

    public void addLine(LineDataModel lineDataModel) {
        lines.add(lineDataModel);
    }

    public String getName() {
        return name;
    }

    public List<LineDataModel> getLines() {
        return lines;
    }

    public boolean replaceLine(String name, LineDataModel newLineDataModel) {

        for (LineDataModel line : lines) {
            if (line.getName().equals(name)) {
                int lineIndex=lines.indexOf(line);
                Color color=lines.get(lineIndex).getColor();
                newLineDataModel.setName(name);
                newLineDataModel.setColor(color);
                lines.set(lineIndex, newLineDataModel);
                 return true;
            }
        }
        logger.warning("no line name found");
        return false;
    }

    public void removeLines() {
        lines.clear();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName() + "{");
        sb.append("nof lines:" + getLines().size());
        if (!getXAxisName().equals(""))
            sb.append(", xAxisName:" + getXAxisName() + ", yAxisName:" + getYAxisName());
        if (getXMinMax().size() == 2)
            sb.append(", (xMin,xMax):(" + getXMinMax().get(0) + "," + getXMinMax().get(1) + ")");
        if (getYMinMax().size() == 2)
            sb.append(", (yMin,yMax):(" + getYMinMax().get(0) + "," + getYMinMax().get(1) + ")");
        sb.append("}");
        return sb.toString();
    }

}
