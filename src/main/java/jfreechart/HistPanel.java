package jfreechart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class HistPanel extends JPanel {

    private final int MARGIN=15;
    private final Color BACKGROUND_COLOR=Color.GRAY;
    CategoryDataset dataset;

    public HistPanel() {
        this.dataset = new DefaultCategoryDataset();
        addChart(this.dataset);
    }

    public void addChart(CategoryDataset dataset) {
        JFreeChart ch = createChart(dataset);
        ChartPanel cp = new ChartPanel(ch);
        cp.setBorder(BorderFactory.createEmptyBorder(MARGIN, MARGIN, MARGIN, MARGIN));
        cp.setBackground(BACKGROUND_COLOR);
        add(cp);
    }


    public DefaultCategoryDataset getDataset() {
        return (DefaultCategoryDataset) dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {

        JFreeChart barChart = ChartFactory.createBarChart(
                "Olympic gold medals in London",
                "year",
                "Gold medals",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        return barChart;
    }



}