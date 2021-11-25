package jfreechart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class BarChartExample extends JFrame {

    private static final long serialVersionUID = 1L;

    public BarChartExample(String appTitle) {
        super(appTitle);

        // Create Dataset
        CategoryDataset dataset = createDataset();

        //Create chart
        JFreeChart chart= ChartFactory.createBarChart(
                "Bar Chart Example", //Chart Title
                "Year", // Category axis
                "Population in Million", // Value axis
                dataset,
                PlotOrientation.VERTICAL,
                true,true,false
        );

        ChartPanel panel=new ChartPanel(chart);
        panel.setBounds(0,0,400,200);
        add(panel);   //setContentPane(panel);

        JPanel bluePanel=new JPanel();
        bluePanel.setBackground(Color.BLUE);
        bluePanel.setBounds(0,200,400,200);
        add(bluePanel);

    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Population in 2005
        dataset.addValue(10, "USA", "2005");
        dataset.addValue(15, "India", "2005");
        dataset.addValue(20, "China", "2005");

        // Population in 2010
        dataset.addValue(15, "USA", "2010");
        dataset.addValue(20, "India", "2010");
        dataset.addValue(25, "China", "2010");

        // Population in 2015
        dataset.addValue(20, "USA", "2015");
        dataset.addValue(25, "India", "2015");
        dataset.addValue(30, "China", "2015");

        dataset.addValue(28, "USA", "2020");
        dataset.addValue(35, "India", "2020");
        dataset.addValue(40, "China", "2020");

        return dataset;
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(()->{
            BarChartExample example=new BarChartExample("Bar Chart Window");
            example.setSize(400, 400);
            example.setLocationRelativeTo(null);
            //example.setLayout(null);   //makes the label to not occupy all frame
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
