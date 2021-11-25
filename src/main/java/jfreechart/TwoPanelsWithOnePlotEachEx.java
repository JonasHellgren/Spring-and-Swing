package jfreechart;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class TwoPanelsWithOnePlotEachEx {

    public static void main(String[] args) {

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.RED);

        PlotPanel plotPanel1 = new PlotPanel();
        defineDataset1(plotPanel1.getCh());

        PlotPanel plotPanel2 = new PlotPanel();
        XYDataset dataset2 = plotPanel2.getDataset();
        //defineDataset2(plotPanel2.getCh());

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2,1));
        frame.setSize(750, 750);
        frame.setVisible(true);
        frame.add(plotPanel1);
        frame.add(plotPanel2);
    }

    private static void defineDataset1(JFreeChart chart) {
        //var series = dataset.getSeries();
        XYSeries series = new XYSeries("Test");
        series.add(18, 567);
        series.add(20, 612);
        series.add(25, 800);
        series.add(30, 980);
        series.add(40, 1410);
        series.add(50, 2350);

        XYDataset dataset = new XYSeriesCollection(series);
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setDataset(dataset);

    }
/*

    private static void defineDataset2(XYDataset dataset) {
        dataset.clear();
        dataset.setValue(16, "Gold medals", "USA");
        dataset.setValue(18, "Gold medals", "China");
        dataset.setValue(19, "Gold medals", "UK");
        dataset.setValue(12, "Gold medals", "Russia");
        dataset.setValue(33, "Gold medals", "South Korea");
        dataset.setValue(71, "Gold medals", "Germany");

    }
*/
}
