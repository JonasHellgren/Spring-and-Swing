package org.example.swingdemos.runplots;

import org.example.swingdemos.lineplot.FrameLinePlot;
import org.example.swingdemos.lineplot.LinePlotModel;
import org.example.swingdemos.lineplot.PanelLinePlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.awt.*;

@SpringBootApplication(scanBasePackages = {"org.example.swingdemos.lineplot"})
public class RunShow1SubplotRandomData {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RunShow1SubplotRandomData.class)
                .headless(false)  //allow AWT classes to be instantiated
                .web(WebApplicationType.NONE)  //prevents the bundling of Tomcat or other Web components
                .run(args);
    }

    @Autowired
    private FrameLinePlot frame;

    final static int W = 1000;
    final static int H = 300;  //frame size

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
            LinePlotModel plotData = LineDataSetter.createPlotDataRandomOneSubplot();
            plotData.setWeight(W);
            plotData.setHeight(H);
            panel.setData(plotData);

            //"game" loop
            while (true) {
            }

        };
    }
}
