package org.example.swingdemos.lineplot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class DemoPlotLine {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DemoPlotLine.class)
                .headless(false)  //allow AWT classes to be instantiated
                .web(WebApplicationType.NONE)  //prevents the bundling of Tomcat or other Web components
                .run(args);
    }

    @Autowired
    private FrameLinePlot frame;

    final static int W=1000;
    final static int H=300;  //frame size

    @Bean
    //The runswing() method returns a CommandLineRunner bean that automatically runs the code when
    //the application launches
    public CommandLineRunner runswing() {
        return (args) -> {

            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    frame.setVisible(true);
                    frame.setSize(W, H);
                }
            });

            //add frame
            PanelLinePlot panel = new PanelLinePlot();
            frame.add(panel);
            frame.setSize(W, H);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            //create lines
            //PlotData plotData= LineDataSetter.createPlotDataTwoSubPlots();
            //plotData.setW(W);  plotData.setH(H);
            //panel.setData(plotData);

            //que
            LinkedList<Double> que = new LinkedList<>();
            Random r = new Random();

            PlotData plotData=new PlotData();
            LineData line1=new LineData("A", que,que, Color.blue);
            SubPlot subplotA=new SubPlot("spA","x-axis","y-axis");
            plotData.addSubPlot(subplotA);
            plotData.setW(W);  plotData.setH(H);

            //"game" loop
            while (true) {
                //panel.paint();

                que.add( r.nextDouble());
                if (que.size()>25)
                    que.removeFirst();

                System.out.println("LinkedList:" + que);

                List<Double>  xValues=LineDataSetter.createListWithLinearNumbers(que.size(), 1, que.size());
                line1=new LineData("A", xValues,que, Color.blue);
                subplotA.removeLines();
                subplotA.addLine(line1);

                panel.setData(plotData);
                panel.repaint();


                Thread.sleep(1000);  // tells the processor that the thread which is being run must sleep
            }
        };
    }
}