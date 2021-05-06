package org.example.swingdemos.runplots;

import org.example.swingdemos.lineplot.*;
import org.example.swingdemos.lineplotutilz.IntervalEstimate;
import org.example.swingdemos.lineplotutilz.QueList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;


@SpringBootApplication(scanBasePackages = {"org.example.swingdemos.lineplot"})
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

            //que
            //LinkedList<Double> que = new LinkedList<>();
            QueList que1=new QueList(20);
            QueList que2=new QueList(20);
            QueList que3=new QueList(20);
            QueList que4=new QueList(20);
            IntervalEstimate intervalEstimate =new IntervalEstimate();

            LinePlotModel linePlotModel =new LinePlotModel();
            SubPlotModel subplotA=new SubPlotModel("spA","x-axis","y-axis");
            LineDataModel line1=new LineDataModel("min", Arrays.asList(0d,1d),Arrays.asList(0d,1d), Color.lightGray);
            LineDataModel line2=new LineDataModel("max", Arrays.asList(0d,1d),Arrays.asList(0d,1d), Color.darkGray);
            LineDataModel line3=new LineDataModel("high", Arrays.asList(0d,1d),Arrays.asList(0d,1d), Color.orange);
            LineDataModel line4=new LineDataModel("low", Arrays.asList(0d,1d),Arrays.asList(0d,1d), Color.yellow);
            subplotA.addLine(line1);  subplotA.addLine(line2); subplotA.addLine(line3);  subplotA.addLine(line4);
            linePlotModel.addSubPlot(subplotA);
            linePlotModel.setWeight(W);  linePlotModel.setHeight(H);

            //"game" loop
            while (true) {

                //generate random number
                 List<Double> randomNums=new ArrayList<>();
                double lowLim = 1D;      double highLim = 100D;           int nofNum=10;
                for (int i = 0; i < nofNum; i++)
                    randomNums.add(lowLim + new Random().nextDouble() * (highLim - lowLim));

                System.out.println(randomNums);

                DoubleSummaryStatistics stats = randomNums.stream().mapToDouble(a -> a).summaryStatistics();
                System.out.println("min:"+stats.getMin()+", max:"+stats.getMax()+", max:"+stats.getAverage());
                List<Double> confInt= intervalEstimate.calc(randomNums,69);


                que1.pushNumber(stats.getMin());
                que2.pushNumber(stats.getMax());
                que3.pushNumber(confInt.get(1));
                que4.pushNumber(confInt.get(0));



                subplotA.replaceLine("min",new LineDataModel(que1.getNumbersInQue()));
                subplotA.replaceLine("max",new LineDataModel(que2.getNumbersInQue()));
                subplotA.replaceLine("high",new LineDataModel(que3.getNumbersInQue()));
                subplotA.replaceLine("low",new LineDataModel(que4.getNumbersInQue()));
                panel.setData(linePlotModel);
                panel.repaint();


                Thread.sleep(5000);  // tells the processor that the thread which is being run must sleep
            }
        };
    }
}