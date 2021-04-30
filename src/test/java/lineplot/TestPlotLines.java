package lineplot;

import org.example.swingdemos.lineplot.LineDataSetter;
import org.example.swingdemos.lineplot.LinePlot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

public class TestPlotLines {

    private static final Logger logger = Logger.getLogger( TestPlotLines.class.getName() );

    LinePlot linePlot;

    @BeforeEach
    public void arrange() {

        linePlot = LineDataSetter.createPlotDataTwoSubPlots();
    }

    @Test //@Ignore
    public void showPlotInfo() {
        System.out.println(linePlot);
    }

    @Test //@Ignore
    public void showPlotData() {
        System.out.println(linePlot.getSubPlots().get(0).getLines().get(0).getXData());
        System.out.println(linePlot.getSubPlots().get(0).getLines().get(0).getYData());
    }



}
