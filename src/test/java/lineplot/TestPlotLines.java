package lineplot;

import org.example.swingdemos.runplots.LineDataSetter;
import org.example.swingdemos.lineplot.LinePlotModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

public class TestPlotLines {

    private static final Logger logger = Logger.getLogger( TestPlotLines.class.getName() );

    LinePlotModel linePlotModel;

    @BeforeEach
    public void arrange() {

        linePlotModel = LineDataSetter.createPlotDataTwoSubPlots();
    }

    @Test //@Ignore
    public void showPlotInfo() {
        System.out.println(linePlotModel);
    }

    @Test //@Ignore
    public void showPlotData() {
        System.out.println(linePlotModel.getSubPlotModels().get(0).getLines().get(0).getXData());
        System.out.println(linePlotModel.getSubPlotModels().get(0).getLines().get(0).getYData());
    }



}
