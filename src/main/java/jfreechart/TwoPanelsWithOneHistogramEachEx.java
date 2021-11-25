package jfreechart;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class TwoPanelsWithOneHistogramEachEx {


    public static void main(String[] args) {

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.RED);

        HistPanel histPanel1 = new HistPanel();
        DefaultCategoryDataset dataset1 = histPanel1.getDataset();
        defineDataset1(dataset1);

        HistPanel histPanel2 = new HistPanel();
        DefaultCategoryDataset dataset2 = histPanel2.getDataset();
        defineDataset2(dataset2);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2,1));
        frame.setSize(750, 750);
        frame.setVisible(true);
        frame.add(histPanel1);
        frame.add(histPanel2);
    }

    private static void defineDataset1(DefaultCategoryDataset dataset) {
        dataset.clear();
        dataset.setValue(46, "Gold medals", "USA");
        dataset.setValue(38, "Gold medals", "China");
        dataset.setValue(29, "Gold medals", "UK");
        dataset.setValue(22, "Gold medals", "Russia");
        dataset.setValue(13, "Gold medals", "South Korea");
        dataset.setValue(11, "Gold medals", "Germany");

    }


    private static void defineDataset2(DefaultCategoryDataset dataset) {
        dataset.clear();
        dataset.setValue(16, "Gold medals", "USA");
        dataset.setValue(18, "Gold medals", "China");
        dataset.setValue(19, "Gold medals", "UK");
        dataset.setValue(12, "Gold medals", "Russia");
        dataset.setValue(33, "Gold medals", "South Korea");
        dataset.setValue(71, "Gold medals", "Germany");

    }

}
