package org.example.swingdemos.lineplot;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SubPlotData {
    String name="";
    String xAxisName="";
    String yAxisName="";
    List<Double> xMinMax;
    List<Double> yMinMax;
    private List<LineData> lines =new ArrayList<>();

    public SubPlotData(String name) {
        this(name,"","",new ArrayList<>(),new ArrayList<>());
    }

    public SubPlotData(String name, String xAxisName,String yAxisName) {
        this(name,xAxisName,yAxisName,new ArrayList<>(),new ArrayList<>());
    }

    public SubPlotData(String name, String xAxisName, String yAxisName, List<Double> xMinMax, List<Double> yMinMax) {
        this.name = name;
        this.xAxisName = xAxisName;
        this.yAxisName = yAxisName;
        this.xMinMax = xMinMax;
        this.yMinMax = yMinMax;
    }

    public void addLine(LineData lineData) {
        lines.add(lineData);
    }

    public String getName() {
        return name;
    }

    public List<LineData> getLines() {
        return lines;
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
