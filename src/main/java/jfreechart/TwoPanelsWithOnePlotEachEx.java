package jfreechart;

import lombok.SneakyThrows;
import org.jfree.data.xy.XYSeries;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class TwoPanelsWithOnePlotEachEx {

    //@SneakyThrows
    public static void main(String[] args) throws InterruptedException {

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.RED);

        PlotPanel plotPanel1 = new PlotPanel();
        XYSeries series1 = defineDataSeries1();
        plotPanel1.setChartDataFromSeries(series1);

        PlotPanel plotPanel2 = new PlotPanel();
        XYSeries series2 = defineDataSeries2();
        plotPanel2.setChartDataFromSeries(series2);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 1));
        frame.setSize(750, 750);
        frame.setVisible(true);
        frame.add(plotPanel1);
        frame.add(plotPanel2);

        TimeUnit.MILLISECONDS.sleep(5000);
        plotPanel2.setChartDataFromSeries(series1);


    }

    private static XYSeries defineDataSeries1() {
        XYSeries series = new XYSeries("Test");
        series.add(18, 567);
        series.add(20, 612);
        series.add(25, 800);
        series.add(30, 980);
        series.add(40, 1410);
        series.add(50, 2350);
        return series;
    }

    private static XYSeries defineDataSeries2() {
        XYSeries series = new XYSeries("Test");
        series.add(18, 567);
        series.add(20, 1612);
        series.add(25, 800);
        series.add(30, 80);
        series.add(40, 20);
        series.add(50, 70);
        return series;
    }
}
