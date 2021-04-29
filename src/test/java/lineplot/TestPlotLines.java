package lineplot;

import org.example.swingdemos.lineplot.LineData;
import org.example.swingdemos.lineplot.LineDataSetter;
import org.example.swingdemos.lineplot.PlotData;
import org.example.swingdemos.lineplot.SubPlotData;
import org.junit.Ignore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.logging.Logger;

public class TestPlotLines {

    private static final Logger logger = Logger.getLogger( TestPlotLines.class.getName() );

    PlotData plotData;

    @BeforeEach
    public void arrange() {

        plotData= LineDataSetter.createPlotDataTwoSubPlots();
    }

    @Test //@Ignore
    public void showPlotInfo() {
        System.out.println(plotData);
    }

    @Test //@Ignore
    public void showPlotData() {
        System.out.println(plotData.getSubPlots().get(0).getLines().get(0).getXData());
        System.out.println(plotData.getSubPlots().get(0).getLines().get(0).getYData());
    }



}
