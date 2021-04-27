package org.example.swingdemos.lineplot;

import org.example.swingdemos.swingmanylinessomeballs.FrameComponent;
import org.example.swingdemos.swingmanylinessomeballs.PanelComponent;
import org.example.swingdemos.tennis.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.awt.*;
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

    @Bean
    //The runswing() method returns a CommandLineRunner bean that automatically runs the code when
    //the application launches
    public CommandLineRunner runswing() {
        return (args) -> {

            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    frame.setVisible(true);
                    frame.setSize(LinePlotSettings.W, LinePlotSettings.H);
                }
            });

            //add frame
            PanelLinePlot panel = new PanelLinePlot();
            frame.add(panel);
            frame.setSize(LinePlotSettings.W, LinePlotSettings.H);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            /*
            //create lines
            int x, y, xprev = 0, yprev = 0;
            final Random random = new Random();

            for (int i = 0; i < 100; i++) {
                x = random.nextInt(LinePlotSettings.W);
                y = random.nextInt(LinePlotSettings.H);
                panel.addLine(xprev, yprev, x, y, new Color(1));
                xprev = x;
                yprev = y;
            } */

            //"game" loop
            while (true) {
                //panel.paint();
                Thread.sleep(100);  // tells the processor that the thread which is being run must sleep
            }

        };
    }
}