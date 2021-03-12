package org.example.swingdemos.swingmanylinessomeballs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


//https://kemitix.wordpress.com/2015/03/24/creating-an-awt-or-swing-gui-application-with-spring-boot/
//http://www.edu4java.com/en/game/game3.html

@SpringBootApplication
public class DemoSwingManyLinesSomeBalls {

    final int W=1000; final int H=600;  //frame size

    public static void main(String[] args) {
        new SpringApplicationBuilder(DemoSwingManyLinesSomeBalls.class)
                .headless(false)  //allow AWT classes to be instantiated
                .web(WebApplicationType.NONE)  //prevents the bundling of Tomcat or other Web components
                .run(args);
    }

    @Autowired
    private FrameComponent frame;

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
            PanelComponent panel = new PanelComponent();
            frame.add(panel);  frame.setSize(W, H);    frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //create balls
            panel.addBall(10,10,11);
            panel.addBall(140,30,11,Color.blue);
            panel.addBall(333,333,11,Color.green);

            //create lines
            int x,y,xprev=0,yprev=0;  final Random random = new Random();

            for (int i = 0; i < 100; i++) {
                x=random.nextInt(W);  y=random.nextInt(H);
                panel.addLine(xprev, yprev, x, y, new Color(1));
                xprev=x; yprev=y;
            }

            //"game" loop
            while (true) {
                panel.moveBalls();  //update of the physics of our world
                panel.repaint();  // tell the AWT engine to execute the paint method as soon as possible.
                Thread.sleep(100);  // tells the processor that the thread which is being run must sleep
            }


        };
    }
}

